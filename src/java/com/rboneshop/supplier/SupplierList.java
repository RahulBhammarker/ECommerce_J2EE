package com.rboneshop.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SupplierList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Supplier s = new Supplier();
            SupplierDao sd = new SupplierDao();
            int id = 0;
            RequestDispatcher dispatcher = null;
            HttpSession httpSession = request.getSession();
            String suppcompany = request.getParameter("suppcompany");
            String contactperson = request.getParameter("contactperson");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String webaddress = request.getParameter("webaddress");
            String opn = request.getParameter("opn");
            String method = request.getParameter("method");
            if (method == null) {
                if ((suppcompany != null) && (contactperson != null) && (address != null) && (phone != null) && (mobile != null) && (email != null) && (webaddress != null)) {
                    s.setSuppcompany(suppcompany);
                    s.setContactperson(contactperson);
                    s.setAddress(address);
                    s.setPhone(phone);
                    s.setMobile(mobile);
                    s.setEmail(email);
                    s.setWebaddress(webaddress);
                }
                if (opn != null) {
                    if (opn.equals("add")) {
                        sd.create(s);
                    } else if (opn.equals("update")) {
                        id = Integer.parseInt(request.getParameter("suppid"));
                        s.setSuppid(id);
                        sd.edit(s);
                    } else if (opn.equals("delete")) {
                        System.out.println("delete");
                        id = Integer.parseInt(request.getParameter("suppid"));
                        sd.remove(id);
                    }
                }
                ArrayList list = sd.findAll();
                httpSession.setAttribute("suppdetails", list);
                dispatcher = request.getRequestDispatcher("/pages/admin/supplier/Supplier.jsp");
            } else {
                id = Integer.parseInt(request.getParameter("id"));
                s = sd.find(id);
                httpSession.setAttribute("supp", s);
                dispatcher = request.getRequestDispatcher("/pages/admin/supplier/SupplierUpdate.jsp");
            }
            dispatcher.forward(request, response);

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
