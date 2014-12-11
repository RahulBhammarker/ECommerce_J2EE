package com.rboneshop.product;

import com.rboneshop.ConnectionPool;
import com.rboneshop.category.Category;
import com.rboneshop.category.CategoryDao;
import java.sql.*;
import java.util.ArrayList;

public class ProductDao {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(Product bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Insert into product (categoryid ,price ,make ,remarks ,photo ,supplierid ,modelno,stockinhand) values(?,?,?,?,?,?,?,?)";
            System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getCategoryid());
            pstmt.setDouble(2, bean.getPrice());
            pstmt.setString(3, bean.getMake());
            pstmt.setString(4, bean.getRemarks());
            pstmt.setString(5, bean.getPhoto());
            pstmt.setInt(6, bean.getSupplierid());
            pstmt.setString(7, bean.getModelno());
            pstmt.setInt(8, bean.getStockinhand());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(Product bean) {
        try {

            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "Update product set categoryid=?,price=?,make=?,remarks=?,photo=?,supplierid=?,modelno=?, stockinhand=? where productid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, bean.getCategoryid());
            pstmt.setDouble(2, bean.getPrice());
            pstmt.setString(3, bean.getMake());
            pstmt.setString(4, bean.getRemarks());
            pstmt.setString(5, bean.getPhoto());
            pstmt.setInt(6, bean.getSupplierid());
            pstmt.setString(7, bean.getModelno());
            pstmt.setInt(8, bean.getStockinhand());
            pstmt.setInt(9, bean.getProductid());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit1(int pid, int q) {
        try {
            Product p1 = find(pid);
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            int stock = p1.getStockinhand() - q;
            String sql = "Update product set stockinhand=" + stock + " where productid = " + pid;
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            String sql = "delete from product where productid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Product> findAll() {
        ArrayList<Product> al = new ArrayList<Product>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from product";
            System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product bean = new Product();
                CategoryDao cd = new CategoryDao();
                Category c = cd.find(rs.getInt("categoryid"));
                bean.setProductid(rs.getInt("productid"));
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setPrice(rs.getDouble("price"));
                bean.setMake(rs.getString("make"));
                bean.setRemarks(rs.getString("remarks"));
                bean.setPhoto(rs.getString("photo"));
                bean.setSupplierid(rs.getInt("supplierid"));
                bean.setModelno(rs.getString("modelno"));
                bean.setStockinhand(rs.getInt("stockinhand"));
                bean.setCategoryname(c.getJcatname());
                al.add(bean);
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public ArrayList<ReportBean> findAllProductsLeft() {
        ArrayList<ReportBean> al = new ArrayList<ReportBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select j.jcatname as name,p.stockinhand as units,p.modelno as model from product p,jcategory j where j.jcatid=p.categoryid order by j.jcatid ";
            System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ReportBean bean = new ReportBean();
                bean.setCategoryname(rs.getString("name"));
                bean.setModelno(rs.getString("model"));
                bean.setUnits(rs.getInt("units"));
                al.add(bean);
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception hai " + e);
        }
        return al;
    }

    public ArrayList<ReportBean> findAllProductsSold(String fromdate, String todate) {
        ArrayList<ReportBean> al = new ArrayList<ReportBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select j.jcatname as name,p.modelno as model,sum(od.units) as units from jcategory j, product p, orderdetails od,orders o where od.productid=p.productid and p.categoryid=j.jcatid  and o.ordedatetime between '" + fromdate + "' and '" + todate + "' and o.orderid=od.oid group by p.productid order by j.jcatid";
            System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ReportBean bean = new ReportBean();
                bean.setCategoryname(rs.getString("name"));
                bean.setModelno(rs.getString("model"));
                bean.setUnits(rs.getInt("units"));
                al.add(bean);
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public ArrayList<Product> findAll1(int id) {
        ArrayList<Product> al = new ArrayList<Product>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from product where categoryid=" + id;
            System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product bean = new Product();
                bean.setProductid(rs.getInt("productid"));
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setPrice(rs.getDouble("price"));
                bean.setMake(rs.getString("make"));
                bean.setRemarks(rs.getString("remarks"));
                bean.setPhoto(rs.getString("photo"));
                bean.setSupplierid(rs.getInt("supplierid"));
                bean.setModelno(rs.getString("modelno"));
                bean.setStockinhand(rs.getInt("stockinhand"));
                al.add(bean);
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public Product searchbymodelnno(String id) {
        Product bean = new Product();

        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from product where modelno='" + id + "'";
            System.out.println("sql" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                bean.setProductid(rs.getInt("productid"));
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setPrice(rs.getDouble("price"));
                bean.setMake(rs.getString("make"));
                bean.setRemarks(rs.getString("remarks"));
                bean.setPhoto(rs.getString("photo"));
                bean.setSupplierid(rs.getInt("supplierid"));
                bean.setModelno(rs.getString("modelno"));
                bean.setStockinhand(rs.getInt("stockinhand"));
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return bean;
    }

    public Product find(int id) {
        Product bean = new Product();

        int catId = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from product where productid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setProductid(rs.getInt("productid"));
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setPrice(rs.getDouble("price"));
                bean.setMake(rs.getString("make"));
                bean.setRemarks(rs.getString("remarks"));
                bean.setPhoto(rs.getString("photo"));
                bean.setSupplierid(rs.getInt("supplierid"));
                bean.setModelno(rs.getString("modelno"));
                bean.setStockinhand(rs.getInt("stockinhand"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }
}
