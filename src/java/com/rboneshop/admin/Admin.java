package com.rboneshop.admin;

public class Admin {

    int adminid;
    String username;
    String password;

    public Admin() {

        adminid = 0;
        username = new String();
        password = new String();
    }

    public Admin(int adminid, String username, String password) {
        this.adminid = adminid;
        this.username = username;
        this.password = password;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
