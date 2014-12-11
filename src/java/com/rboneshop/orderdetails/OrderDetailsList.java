

package com.rboneshop.orderdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OrderDetailsList extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

                OrderDetails o = new OrderDetails();
                OrderDetailsDao od= new OrderDetailsDao();
                int id=0;
                RequestDispatcher dispatcher=null;
                HttpSession httpSession=request.getSession();

                String oid=request.getParameter("oid");
                String productid=request.getParameter("productid");
                String units=request.getParameter("units");
                String price=request.getParameter("price");
                String discoff=request.getParameter("discoff");
                String opn=request.getParameter("opn");
                String method=request.getParameter("method");


            if (method == null) {
                if ((oid != null) && (productid != null) && (units != null) && (price != null)) {
                    o.setOdid(Integer.parseInt(oid));
                    o.setProductid(Integer.parseInt(productid));
                    o.setUnits(Integer.parseInt(units));
                    o.setPrice(Double.parseDouble(price));
                    o.setDiscoff(Integer.parseInt(discoff));
                }

                if (opn != null) {
                    if (opn.equals("add")) {
                        od.create(o);
                    } else if (opn.equals("update")) {
                        id = Integer.parseInt(request.getParameter("odid"));
                        o.setOdid(id);
                        od.edit(o);
                    } else if (opn.equals("delete")) {
                        id = Integer.parseInt(request.getParameter("odid"));
                        o.setOdid(id);
                        od.remove(id);
                    }
                    ArrayList list = od.findAll();
                    httpSession.setAttribute("Orderdetails", list);
                    dispatcher = request.getRequestDispatcher("/pages/admin/");
                } else {
                    id = Integer.parseInt(request.getParameter("id"));
                    o = od.find(id);
                    httpSession.setAttribute("order", o);
                    dispatcher = request.getRequestDispatcher("/pages/admin/");
                }
                dispatcher.forward(request, response);

            }
            
        } finally { 
            out.close();
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
