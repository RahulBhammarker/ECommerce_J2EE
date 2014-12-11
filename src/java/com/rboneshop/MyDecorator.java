package com.rboneshop;

import com.rboneshop.product.Product;
import com.rboneshop.category.Category;
import com.rboneshop.customer.Customer;
import com.rboneshop.order.MasterOrder;
import com.rboneshop.supplier.Supplier;

import org.displaytag.decorator.TableDecorator;

public class MyDecorator extends TableDecorator {

    String a = "Edit";
    String a1 = "Delete";

    public String getCedit() {
        Category cd = (Category) getCurrentRowObject();
        String id = "<a href=\"/RBOneShop/CategoryList?method=fetch&id=" + cd.getJcatid() + "\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;Edit</a>";
        return id;
    }

    public String getCdelete() {
        Category cd = (Category) getCurrentRowObject();
    
        String id = "<a onClick=\"aaa("+cd.getJcatid()+");\"><span class=\"glyphicon glyphicon-remove-sign\"></span>&nbsp;Delete</a>";
        return id;
    }
    public String getPview() {
        Product cd = (Product) getCurrentRowObject();
        String id = "<a href=\"/RBOneShop/ProductList?method=fetch1&id=" + cd.getProductid() + "\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;View</a>";
        return id;
    }
     public String getPedit() {
        Product cd = (Product) getCurrentRowObject();
        String id = "<a href=\"/RBOneShop/ProductList?method=fetch&id=" + cd.getProductid() + "\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;Edit</a>";
        return id;
    }

    public String getPdelete() {
        Product cd = (Product) getCurrentRowObject();
        String id = "<a onClick=\"aaa("+cd.getProductid()+");\"><span class=\"glyphicon glyphicon-remove-sign\"></span>&nbsp;Delete</a>";
        return id;
    }

    

    public String getCustedit() {
      Customer cd = (Customer) getCurrentRowObject();
        String id = "<a href=\"/RBOneShop/CustomerList?method=fetch&id=" + cd.getCustomerid() + "\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;Edit</a>";
        return id;
    }

    public String getCustdelete() {
          Customer cd = (Customer) getCurrentRowObject();
        String id = "<a onClick=\"aaa(" + cd.getCustomerid()+ ");\"><span class=\"glyphicon glyphicon-remove-sign\"></span>&nbsp;Delete</a>";
        return id;
    }
    public String getSedit() {
      Supplier cd = (Supplier) getCurrentRowObject();
        String id = "<a href=\"/RBOneShop/SupplierList?method=fetch&id=" + cd.getSuppid() + "\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;Edit</a>";
        return id;
    }

    public String getSdelete() {
      Supplier cd = (Supplier) getCurrentRowObject();
        String id = "<a onClick=\"aaa(" + cd.getSuppid()+ ");\"><span class=\"glyphicon glyphicon-remove-sign\"></span>&nbsp;Delete</a>";
        return id;
    }

   
}

