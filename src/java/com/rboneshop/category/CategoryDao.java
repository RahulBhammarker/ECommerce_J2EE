package com.rboneshop.category;

import com.rboneshop.product.ReportBean;
import com.rboneshop.ConnectionPool;
import com.rboneshop.category.Category;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class CategoryDao {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(Category bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into jcategory (jcatname ,jcatdetails )  values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getJcatname());
            pstmt.setString(2, bean.getJcatdetails());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(Category bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update jcategory set jcatname=?,jcatdetails=? where jcatid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bean.getJcatname());
            pstmt.setString(2, bean.getJcatdetails());
            pstmt.setInt(3, bean.getJcatid());
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
            String sql = "delete from jcategory where jcatid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Category> findAll() {
        ArrayList<Category> al = new ArrayList<Category>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select jcatid,jcatname,jcatdetails from jcategory";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Category bean = new Category();
                bean.setJcatid(rs.getInt("jcatid"));
                bean.setJcatname(rs.getString("jcatname"));
                bean.setJcatdetails(rs.getString("jcatdetails"));
                al.add(bean);
            }

            c.putConnection(conn);




        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public Category find(int id) {
        Category bean = new Category();

        int catId = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from jcategory where jcatid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setJcatid(rs.getInt("jcatid"));
                bean.setJcatname(rs.getString("jcatname"));
                bean.setJcatdetails(rs.getString("jcatdetails"));
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
            String sql = "select jcatid,jcatname  from jcategory ";
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

    public int min() {
        int a = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select min(jcatid) from jcategory";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            a = rs.getInt(1);
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return a;
    }
    public ArrayList<ReportBean> findCategoryWiseSales(String fromdate,String todate) {
        ArrayList<ReportBean> al = new ArrayList<ReportBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select sum(od.oamount) as amount,sum(o.units) as units, j.jcatname as category from jcategory j,orderdetails o,product p,orders od where p.categoryid=j.jcatid and p.productid=o.productid and od.ordedatetime between '"+fromdate+"' and '"+todate+"' group by j.jcatid order by units";
            System.out.println("catwise"+sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ReportBean bean = new ReportBean();
                bean.setAmount(rs.getFloat("amount"));
                bean.setCategoryname(rs.getString("category"));
                bean.setUnits(rs.getInt("units"));
                al.add(bean);
            }

            c.putConnection(conn);




        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }
   /*
    //Just for testing purpose
    public static void main(String[] args) {
        Category cb = new Category();
        CategoryDao cd = new CategoryDao();
        cb.jcatid = 1;
        cb.jcatname = "first";
        cb.jcatdetails = "item";
        cd.create(cb);
        
    }
    */
}
