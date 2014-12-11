package com.rboneshop.orderdetails;

import com.rboneshop.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class OrderDetailsDao {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(OrderDetails bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into orderdetails (oid,productid,units,price,discoffered)  values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getOid());
            pstmt.setInt(2, bean.getProductid());
            pstmt.setInt(3, bean.getUnits());
            pstmt.setDouble(4, bean.getPrice());
            pstmt.setInt(5, bean.getDiscoff());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(OrderDetails bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update orderdetails set oid=?,productid=?,units=?,price=?,discoffered=?  where odid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, bean.getOid());
            pstmt.setInt(2, bean.getProductid());
            pstmt.setInt(3, bean.getUnits());
            pstmt.setDouble(4, bean.getPrice());
            pstmt.setInt(5, bean.getDiscoff());
            pstmt.setInt(6, bean.getOdid());
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
            String sql = "delete from orderdetails where odid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<OrderDetails> findAll() {
        ArrayList<OrderDetails> al = new ArrayList<OrderDetails>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from orderdetails";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderDetails bean = new OrderDetails();
                bean.setOdid(rs.getInt("odid"));
                bean.setOid(rs.getInt("oid"));
                bean.setProductid(rs.getInt("productid"));
                bean.setUnits(rs.getInt("units"));
                bean.setPrice(rs.getDouble("price"));
                bean.setDiscoff(rs.getInt("discoffered"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public OrderDetails find(int id) {
        OrderDetails bean = new OrderDetails();

        int catId = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from OrderDetails where odid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setOdid(rs.getInt("odid"));
                bean.setOid(rs.getInt("oid"));
                bean.setProductid(rs.getInt("productid"));
                bean.setUnits(rs.getInt("units"));
                bean.setPrice(rs.getDouble("price"));
                bean.setDiscoff(rs.getInt("discoffered"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }
}
