package com.rboneshop.order;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MasterOrderList extends HttpServlet {

    protected ArrayList<MasterOrder> items;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String method = request.getParameter("method");
        HttpSession httpSession = request.getSession(true);
        RequestDispatcher dispatcher = null;
        double total = 0, grant = 0;
        int opt = 0;
        int size = 0;
        double total1 = 0;
        opt = Integer.parseInt(request.getParameter("opt"));
        int qty = 1;
        try {
            if (method.equals("add")) {
                MasterOrder bn = new MasterOrder();
                int ic = Integer.parseInt(request.getParameter("pid"));
                bn.setPid(ic);
                bn.setItemname(request.getParameter("itemname"));
                bn.setQty(qty);
                double pri = Double.parseDouble(request.getParameter("price"));
                bn.setPrice(pri);
                bn.setSubtotal(pri);
                int qty1 = 0;
                if (items == null) {
                    items = new ArrayList<MasterOrder>();
                }
                boolean currIndex = items.isEmpty();
                if (currIndex) {
                    items.add(bn);
                    System.out.println("items" + items);
                    httpSession.setAttribute("items", items);

                } else {
                    Boolean itemExists = false;
                    for (Iterator it = items.iterator(); it.hasNext();) {
                        Object o = it.next();
                        MasterOrder shop = (MasterOrder) o;
                        if (shop.getPid() == bn.getPid()) {
                            int qt = shop.getQty();
                            double pr = shop.getPrice();
                            qty1 = 1 + qt;
                            total = qty1 * pr;
                            shop.setQty(qty1);
                            shop.setSubtotal(total);
                            itemExists = true;
                        }

                    }
                    if (!itemExists) {
                        items.add(bn);
                        httpSession.setAttribute("items", items);
                    }
                }
                ArrayList al = (ArrayList) httpSession.getAttribute("items");
                Iterator itr = al.iterator();
                size = al.size();
                while (itr.hasNext()) {
                    MasterOrder scbn = (MasterOrder) itr.next();
                    double price = 0;
                    price = scbn.getPrice() * scbn.getQty();
                    total1 = total1 + price;
                }
                httpSession.setAttribute("size", size);
                httpSession.setAttribute("grant", total1);
                httpSession.setAttribute("pid", ic);
                httpSession.setAttribute("price", pri);
                httpSession.setAttribute("qty", qty1);
            } else if (method.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("pid"));
                System.out.println("id delete" + id);
                for (Iterator it = items.iterator(); it.hasNext();) {
                    Object o = it.next();
                    MasterOrder shop = (MasterOrder) o;
                    if (shop.getPid() == id) {
                        items.remove(o);
                    }
                }
                httpSession.setAttribute("items", items);
                httpSession.setAttribute("size", size);
                httpSession.setAttribute("grant", total1);
                dispatcher = request.getRequestDispatcher("/pages/customer/AddToCart.jsp");
                out.print("<span style='color: RED'>Item Deleted</span>");
            } else if (method.equals("update")) {
                int id = Integer.parseInt(request.getParameter("pid"));
                int qty1 = Integer.parseInt(request.getParameter("qty"));
                ArrayList<MasterOrder> newItem = new ArrayList<MasterOrder>();
                for (Iterator it = items.iterator(); it.hasNext();) {
                    Object o = it.next();
                    MasterOrder shop = (MasterOrder) o;
                    if (shop.getPid() == id) {
                        shop.setQty(qty1);
                    }
                    newItem.add(shop);
                }

                System.out.println("qty  " + request.getParameter("qty"));
                out.print("<span style='color: green'>Quantity Changed</span>");
            }
            if (opt == 1) {
                dispatcher = request.getRequestDispatcher("/pages/customer/BuyNow.jsp");

            } else {

                dispatcher = request.getRequestDispatcher("/pages/customer/AddToCart.jsp");
            }

            dispatcher.forward(request, response);

        } finally {
            out.close();


        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";


    }// </editor-fold>
}
