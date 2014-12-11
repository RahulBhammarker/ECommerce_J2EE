/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rboneshop.product;

/**
 *
 * @author rboneshop
 */
public class ReportBean {

    int units;
    String categoryname;
    String modelno;
    String categorysms;
    String name;
    String date;
    float amount;
    String address;
    String mobile;
    float goldwt;
    float silverwt;
    float diamondwt;

    public ReportBean() {
    }

    public ReportBean(int units, String categoryname, String modelno, String categorysms, String name, String date, float amount, String address, String mobile, float goldwt, float silverwt, float diamondwt) {
        this.units = units;
        this.categoryname = categoryname;
        this.modelno = modelno;
        this.categorysms = categorysms;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.address = address;
        this.mobile = mobile;
        this.goldwt = goldwt;
        this.silverwt = silverwt;
        this.diamondwt = diamondwt;
    }
    

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getCategorysms() {
        return categorysms;
    }

    public void setCategorysms(String categorysms) {
        this.categorysms = categorysms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public float getDiamondwt() {
        return diamondwt;
    }

    public void setDiamondwt(float diamondwt) {
        this.diamondwt = diamondwt;
    }

    public float getGoldwt() {
        return goldwt;
    }

    public void setGoldwt(float goldwt) {
        this.goldwt = goldwt;
    }

    public float getSilverwt() {
        return silverwt;
    }

    public void setSilverwt(float silverwt) {
        this.silverwt = silverwt;
    }
    
}
