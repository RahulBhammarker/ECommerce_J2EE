package com.rboneshop.admin;

    import com.rboneshop.ConnectionPool;
    import java.sql.*;
    import java.util.ArrayList;
    import javax.servlet.http.HttpSession;

public class AdminDao {

        ConnectionPool c = null;
        Connection conn = null;

        public void create(Admin bean) {
            try {
                if (c == null) {
                    c = ConnectionPool.getInstance();
                    c.initialize();
                }
                conn = c.getConnection();
                String sql = "Insert into admin (username,password)  values(?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, bean.getUsername());
                pstmt.setString(2, bean.getPassword());
                pstmt.executeUpdate();
                c.putConnection(conn);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void edit(Admin bean) {
            try {

                if (c == null) {
                    c = ConnectionPool.getInstance();
                    c.initialize();
                }
                conn = c.getConnection();
                String sql = "Update admin set username=?,password=? where adminid = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, bean.getUsername());
                pstmt.setString(2, bean.getPassword());
                pstmt.setInt(3, bean.getAdminid());
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
            String sql = "delete from admin where adminid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Admin> findAll() {
        ArrayList<Admin> al = new ArrayList<Admin>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from admin";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Admin bean = new Admin();
                bean.setAdminid(rs.getInt("adminid"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                al.add(bean);
            }
            c.putConnection(conn);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

     public Admin find(int id) {
        Admin bean = new Admin();
      
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from admin where adminid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setAdminid(rs.getInt("adminid"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }
     
     public Admin findByName(String username) {
        Admin bean = new Admin();
      
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from admin where username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setAdminid(rs.getInt("adminid"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);

        }
        return bean;
    }
}
