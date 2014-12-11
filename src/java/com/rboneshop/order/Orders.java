package com.rboneshop.order;

public class Orders {

    int ordid;
    String oddatetime;
    int customerid;
    double oamt;
    String paydetail;

    public Orders() {

        ordid = 0;
        oddatetime = new String();
        customerid = 0;
        oamt = 0;
        paydetail = new String();
    }

    public Orders(int ordid, String oddatetime, int customerid, double oamt, String paydetail) {
        this.ordid = ordid;
        this.oddatetime = oddatetime;
        this.customerid = customerid;
        this.oamt = oamt;
        this.paydetail = paydetail;
    }

    public Orders(String oddatetime, int customerid, double oamt, String paydetail) {
        this.oddatetime = oddatetime;
        this.customerid = customerid;
        this.oamt = oamt;
        this.paydetail = paydetail;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public double getOamt() {
        return oamt;
    }

    public void setOamt(double oamt) {
        this.oamt = oamt;
    }

    public String getOddatetime() {
        return oddatetime;
    }

    public void setOddatetime(String oddatetime) {
        this.oddatetime = oddatetime;
    }

    public int getOrdid() {
        return ordid;
    }

    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }

    public String getPaydetail() {
        return paydetail;
    }

    public void setPaydetail(String paydetail) {
        this.paydetail = paydetail;
    }
}
