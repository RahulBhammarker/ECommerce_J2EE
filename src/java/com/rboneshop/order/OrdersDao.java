package com.rboneshop.order;

import com.rboneshop.ConnectionPool;
import com.rboneshop.orderdetails.OrderDetails;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrdersDao {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(Orders bean, int id, double amt) {
        try {
            java.util.Date date = new java.util.Date();
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into orders (ordedatetime,customerid,oamount,paymentdetails)  values(?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            System.out.println("date " + date1);
            pstmt.setDate(1, date1);
            pstmt.setInt(2, id);
            pstmt.setDouble(3, amt);
            pstmt.setString(4, "Y");
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("" + ex);
        }
    }

    
    public void edit(Orders bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update orders set ordedatetime=?,customerid=?,oamount=?,paymentdetails=? where orderid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bean.getOddatetime());
            pstmt.setInt(2, bean.getCustomerid());
            pstmt.setDouble(3, bean.getOamt());
            pstmt.setString(4, bean.getPaydetail());
            pstmt.setInt(5, bean.getOrdid());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void remove(int id) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "delete from orders where orderid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Orders> findAll() {
        ArrayList<Orders> al = new ArrayList<Orders>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from orders";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Orders bean = new Orders();
                bean.setOrdid(rs.getInt("orderid"));
                bean.setOddatetime(rs.getString("ordedatetime"));
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setOamt(rs.getDouble("oamount"));
                bean.setPaydetail(rs.getString("paymentdetails"));
                al.add(bean);
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public Orders find(int id) {
        Orders bean = new Orders();

        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from orders where orderid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setOrdid(rs.getInt("orderid"));
                bean.setOddatetime(rs.getString("ordedatetime"));
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setOamt(rs.getDouble("oamount"));
                bean.setPaydetail(rs.getString("paymentdetails"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }


    public int getMaxid() {

        int count = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select max(orderid) from orders;";
            System.out.println("aaaaa" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return count;
    }
    public static String convertDate(String date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String convertedDate = new String();

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        try {

            d = df.parse(date);
            convertedDate = df1.format(d);
        } catch (ParseException ex) {
        }
        return convertedDate;
    }

    public static String convertDate1(String date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String convertedDate = new String();

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        try {

            d = df1.parse(date);
            convertedDate = df.format(d);
        } catch (ParseException ex) {
        }
        return convertedDate;
    }

}
