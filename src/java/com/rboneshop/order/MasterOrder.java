

package com.rboneshop.order;


public class MasterOrder {



private String itemname;
private double price,subtotal;
private  int pid,qty;


    public MasterOrder() {
    }

    public MasterOrder(String itemname, double price,int pid,int qty,double subtotal) {
        this.itemname = itemname;
        this.price = price;
        this.pid=pid;
        this.qty=qty;
        this.subtotal=subtotal;

    }

    public double getPrice() {
        return price;
    }



    public String getItemname() {
        return itemname;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    

}
