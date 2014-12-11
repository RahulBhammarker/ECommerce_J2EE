package com.rboneshop.category;

public class Category {

    int jcatid;
    String jcatname;
    String jcatdetails;

    public Category() {
        jcatid = 0;
        jcatname = new String();
        jcatdetails = new String();
    }

    public Category(int jcatid, String jcatname, String jcatdetails) {
        this.jcatid = jcatid;
        this.jcatname = jcatname;
        this.jcatdetails = jcatdetails;
    }

    public String getJcatdetails() {
        return jcatdetails;
    }

    public void setJcatdetails(String jcatdetails) {
        this.jcatdetails = jcatdetails;
    }

    public int getJcatid() {
        return jcatid;
    }

    public void setJcatid(int jcatid) {
        this.jcatid = jcatid;
    }

    public String getJcatname() {
        return jcatname;
    }

    public void setJcatname(String jcatname) {
        this.jcatname = jcatname;
    }
}
