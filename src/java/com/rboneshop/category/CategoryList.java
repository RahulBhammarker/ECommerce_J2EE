package com.rboneshop.category;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CategoryList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Category c = new Category();
            CategoryDao cd = new CategoryDao();
            int id = 0;
            RequestDispatcher dispatcher = null;
            HttpSession httpSession = request.getSession();
            String jcatname = request.getParameter("jcatname");
            String jcatdetails = request.getParameter("jcatdetails");
            String opn = request.getParameter("opn");
            String method = request.getParameter("method");
            if (method == null) {
                if ((jcatname != null) && (jcatdetails != null)) {
                    c.setJcatname(jcatname);
                    c.setJcatdetails(jcatdetails);
                }
                if (opn != null) {
                    if (opn.equals("add")) {
                        cd.create(c);
                    } else if (opn.equals("update")) {
                        id = Integer.parseInt(request.getParameter("jcatid"));
                        c.setJcatid(id);
                        cd.edit(c);
                    } else if (opn.equals("delete")) {
                        id = Integer.parseInt(request.getParameter("jcatid"));
                        cd.remove(id);
                    }
                }
                ArrayList list = cd.findAll();
                httpSession.setAttribute("catdetails", list);
                dispatcher = request.getRequestDispatcher("/pages/admin/category/Category.jsp");
            } else {
                id = Integer.parseInt(request.getParameter("id"));
                c = cd.find(id);
                httpSession.setAttribute("cat", c);
                dispatcher = request.getRequestDispatcher("/pages/admin/category/CategoryUpdate.jsp");
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
