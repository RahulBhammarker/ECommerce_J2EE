/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rboneshop.customer;


public class Customer {

    int customerid;
    String cusername;
    String cpassword;
    String name;
    String address;
    String mobile;
    String email;

    public Customer() {

        customerid=0;
        cusername=new String();
        cpassword=new String();
        name=new String();
        address=new String();
        mobile=new String();
        email=new String();

    }

    public Customer(int customerid, String cusername, String cpassword, String name, String address, String mobile, String email) {
        this.customerid = customerid;
        this.cusername = cusername;
        this.cpassword = cpassword;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public Customer(String cusername, String cpassword, String name, String address, String mobile, String email) {
        this.cusername = cusername;
        this.cpassword = cpassword;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
