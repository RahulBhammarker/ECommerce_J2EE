package com.rboneshop.supplier;

import com.rboneshop.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

public class SupplierDao {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(Supplier bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into supplier (suppcompany ,contactperson ,address ,phone ,mobile ,email ,webaddress )  values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getSuppcompany());
            pstmt.setString(2, bean.getContactperson());
            pstmt.setString(3, bean.getAddress());
            pstmt.setString(4, bean.getPhone());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setString(7, bean.getWebaddress());

            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(Supplier bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update supplier set suppcompany=?,contactperson=?,address=?,phone=?,mobile=?,email=?,webaddress=? where suppid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bean.getSuppcompany());
            pstmt.setString(2, bean.getContactperson());
            pstmt.setString(3, bean.getAddress());
            pstmt.setString(4, bean.getPhone());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setString(7, bean.getWebaddress());
            pstmt.setInt(8, bean.getSuppid());
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
            String sql = "delete from supplier where suppid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Supplier> findAll() {
        ArrayList<Supplier> al = new ArrayList<Supplier>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from supplier";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Supplier bean = new Supplier();
                bean.setSuppid(rs.getInt("suppid"));
                bean.setSuppcompany(rs.getString("suppcompany"));
                bean.setContactperson(rs.getString("contactperson"));
                bean.setAddress(rs.getString("address"));
                bean.setPhone(rs.getString("phone"));
                bean.setMobile(rs.getString("mobile"));
                bean.setEmail(rs.getString("email"));
                bean.setWebaddress(rs.getString("webaddress"));
                al.add(bean);
            }

            c.putConnection(conn);




        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public Supplier find(int id) {
        Supplier bean = new Supplier();

        int catId = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from supplier where suppid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setSuppid(rs.getInt("suppid"));
                bean.setSuppcompany(rs.getString("suppcompany"));
                bean.setContactperson(rs.getString("contactperson"));
                bean.setAddress(rs.getString("address"));
                bean.setPhone(rs.getString("phone"));
                bean.setMobile(rs.getString("mobile"));
                bean.setEmail(rs.getString("email"));
                bean.setWebaddress(rs.getString("webaddress"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }

    public String getOptions() {
        String rows = new String();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select suppid,suppcompany  from supplier ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rows += " <option value=" + rs.getInt(1) + "> " + "  " + rs.getString(2) + "\n";
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rows;
    }
}
