package com.rboneshop.supplier;

public class Supplier {

    int suppid;
    String suppcompany;
    String contactperson;
    String address;
    String phone;
    String mobile;
    String email;
    String webaddress;

    public Supplier() {
        suppid = 0;
        suppcompany = new String();
        contactperson = new String();
        address = new String();
        phone = new String();
        mobile = new String();
        email = new String();
        webaddress = new String();
    }

    public Supplier(int suppid, String suppcompany, String contactperson, String address, String phone, String mobile, String email, String webaddress) {
        this.suppid = suppid;
        this.suppcompany = suppcompany;
        this.contactperson = contactperson;
        this.address = address;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.webaddress = webaddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSuppcompany() {
        return suppcompany;
    }

    public void setSuppcompany(String suppcompany) {
        this.suppcompany = suppcompany;
    }

    public int getSuppid() {
        return suppid;
    }

    public void setSuppid(int suppid) {
        this.suppid = suppid;
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }
}
