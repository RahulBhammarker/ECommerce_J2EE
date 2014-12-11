package com.rboneshop.order;


import com.rboneshop.product.*;
import com.rboneshop.orderdetails.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrdersList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Orders o = new Orders();
            OrdersDao od = new OrdersDao();
            OrderDetails or = new OrderDetails();
            OrderDetailsDao odr = new OrderDetailsDao();
            ProductDao p = new ProductDao();
            int id = 0;
            RequestDispatcher dispatcher = null;
            HttpSession httpSession = request.getSession();
            String orddt = request.getParameter("oddatetime");
            String ordid = request.getParameter("ordid");
            int customerid = (Integer) httpSession.getAttribute("customerid");

            double amt = (Double) httpSession.getAttribute("grant");
            int qty = (Integer) httpSession.getAttribute("qty");
            int pid = (Integer) httpSession.getAttribute("pid");
            System.out.println("ccccccccc" + amt);
            String paydetail = request.getParameter("paydetail");
            String unit = request.getParameter("units");
            String disc = request.getParameter("discoff");
            String opn = request.getParameter("opn");
            String method = request.getParameter("method");

            if (method == null) {
                if (paydetail != null && unit != null && disc != null) {
                    o.setOrdid(Integer.parseInt(ordid));
                    o.setOddatetime(orddt);
                    o.setOamt(amt);
                    o.setPaydetail(paydetail);
                }

                if (opn != null) {
                    if (opn.equals("add")) {
                        od.create(o, customerid, amt);
                        int oid = od.getMaxid();
                        ArrayList al = (ArrayList) httpSession.getAttribute("items");
                        Iterator itr = al.iterator();
                        while (itr.hasNext()) {
                            MasterOrder scbn = (MasterOrder) itr.next();
                            or.setOid(oid);
                            or.setProductid(scbn.getPid());
                            or.setUnits(scbn.getQty());
                            or.setPrice(scbn.getPrice());
                            odr.create(or);
                            p.edit1(scbn.getPid(),scbn.getQty());
                        }

                        odr.create(or);
                    } else if (opn.equals("update")) {
                        id = Integer.parseInt(request.getParameter("ordid"));
                        o.setOrdid(id);
                        od.edit(o);
                    } else if (opn.equals("delete")) {
                        id = Integer.parseInt(request.getParameter("ordid"));
                        o.setOrdid(id);
                        od.remove(id);
                    }
                    ArrayList list = od.findAll();
                    httpSession.setAttribute("orddetails", list);
                    dispatcher = request.getRequestDispatcher("/pages/customer/Print.jsp");
                } else {
                    id = Integer.parseInt(request.getParameter("id"));
                    o = od.find(id);
                    httpSession.setAttribute("ord", o);
                    dispatcher = request.getRequestDispatcher("/pages/admin/orders/OrdersUpdate.jsp");
                }
                dispatcher.forward(request, response);

            }
        } finally {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
