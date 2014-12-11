package com.rboneshop.product;


public class Product {

    int productid;
    int categoryid;
    double price;
    String make;
    String remarks;
    String photo;
    int supplierid;
    String modelno;
    int stockinhand;
    String categoryname;

    public Product() {
    }

    public Product(int productid, int categoryid, double price, String make, String remarks, String photo, int supplierid, String modelno, int stockinhand) {
        this.productid = productid;
        this.categoryid = categoryid;
        this.price = price;
        this.make = make;
        this.remarks = remarks;
        this.photo = photo;
        this.supplierid = supplierid;
        this.modelno = modelno;
        this.stockinhand = stockinhand;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getmodelno() {
        return modelno;
    }

    public void setmodelno(String modelno) {
        this.modelno = modelno;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public int getStockinhand() {
        return stockinhand;
    }

    public void setStockinhand(int stockinhand) {
        this.stockinhand = stockinhand;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

}
