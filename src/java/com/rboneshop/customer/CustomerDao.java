package com.rboneshop.customer;

import com.rboneshop.product.ReportBean;
import com.rboneshop.ConnectionPool;
import com.rboneshop.order.OrdersDao;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class CustomerDao {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(Customer bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into customers (cusername,cpassword,name,address,mobile,email)  values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getCusername());
            pstmt.setString(2, bean.getCpassword());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getAddress());
            pstmt.setString(5, bean.mobile);
            pstmt.setString(6, bean.email);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(Customer bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update customers set cusername=?,cpassword=?,name=?,address=?,mobile=?,email=? where customerid=?";
            System.out.println("aaaaa" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bean.getCusername());
            pstmt.setString(2, bean.getCpassword());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setInt(7, bean.getCustomerid());
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
            String sql = "delete from customers where customerid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Customer> findAll() {
        ArrayList<Customer> al = new ArrayList<Customer>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from customers";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer bean = new Customer();
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setCusername(rs.getString("cusername"));
                bean.setCpassword(rs.getString("cpassword"));
                bean.setName(rs.getString("name"));
                bean.setAddress(rs.getString("address"));
                bean.setMobile(rs.getString("mobile"));
                bean.setEmail(rs.getString("email"));
                al.add(bean);
            }

            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public ArrayList<Customer> findAll(String a) {
        ArrayList<Customer> al = new ArrayList<Customer>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from customers where name like '" + a + "%'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer bean = new Customer();
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setCusername(rs.getString("cusername"));
                bean.setCpassword(rs.getString("cpassword"));
                bean.setName(rs.getString("name"));
                bean.setAddress(rs.getString("address"));
                bean.setMobile(rs.getString("mobile"));
                bean.setEmail(rs.getString("email"));
                al.add(bean);
            }

            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public Customer find(int id) {
        Customer bean = new Customer();

        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from customers where customerid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setCusername(rs.getString("cusername"));
                bean.setCpassword(rs.getString("cpassword"));
                bean.setName(rs.getString("name"));
                bean.setAddress(rs.getString("address"));
                bean.setMobile(rs.getString("mobile"));
                bean.setEmail(rs.getString("email"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }

    public Customer check(String un, String pw) {
        Customer bean = new Customer();
        int count = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "SELECT * FROM customers where cusername='" + un + "' and cpassword='" + pw + "'";
            System.out.println("bbbbb" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                bean.setCustomerid(rs.getInt("customerid"));
                bean.setCusername(rs.getString("cusername"));
                bean.setCpassword(rs.getString("cpassword"));
                bean.setName(rs.getString("name"));
                bean.setAddress(rs.getString("address"));
                bean.setMobile(rs.getString("mobile"));
                bean.setEmail(rs.getString("email"));

            }

            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return bean;
    }

    public int check1(String un, String pw) {

        int count = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "SELECT count(*) FROM customers where cusername='" + un + "' and cpassword='" + pw + "'";
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
    public ArrayList<ReportBean> findAllCustomersOrders(String fromdate,String todate) {
        ArrayList<ReportBean> al = new ArrayList<ReportBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select c.name as name,c.address as address,c.mobile as mobile,o.ordedatetime as datetime,o.oamount as amount from orders o,customers c where c.customerid=o.customerid and o.ordedatetime between '"+fromdate+"' and '"+todate+"' order by c.customerid;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ReportBean bean=new ReportBean();
                bean.setName(rs.getString("name"));
                bean.setAddress(rs.getString("address"));
                bean.setMobile(rs.getString("mobile"));
                bean.setDate(OrdersDao.convertDate1(rs.getString("datetime")));
                bean.setAmount(rs.getFloat("amount"));
                al.add(bean);
            }

            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

}
