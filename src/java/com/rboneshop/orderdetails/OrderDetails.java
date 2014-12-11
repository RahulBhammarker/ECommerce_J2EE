package com.rboneshop.orderdetails;

public class OrderDetails {

    int odid;
    int oid;
    int productid;
    int units;
    double price;
    int discoff;

    public OrderDetails() {

        odid = 0;
        oid = 0;
        productid = 0;
        units = 0;
        price = 0;
        discoff = 0;
    }

    public OrderDetails(int odid, int oid, int productid, int units, double price, int discoff) {
        this.odid = odid;
        this.oid = oid;
        this.productid = productid;
        this.units = units;
        this.price = price;
        this.discoff = discoff;
    }

    public OrderDetails(int oid, int productid, int units, double price, int discoff) {
        this.oid = oid;
        this.productid = productid;
        this.units = units;
        this.price = price;
        this.discoff = discoff;
    }

    public int getDiscoff() {
        return discoff;
    }

    public void setDiscoff(int discoff) {
        this.discoff = discoff;
    }

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
