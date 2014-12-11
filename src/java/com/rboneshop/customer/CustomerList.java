package com.rboneshop.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            Customer c = new Customer();
            CustomerDao cd = new CustomerDao();
            int id = 0;
            RequestDispatcher dispatcher = null;
            HttpSession httpSession = request.getSession();
            String cusername = request.getParameter("cusername");
            String cpassword = request.getParameter("cpassword");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String opn = request.getParameter("opn");
            String method = request.getParameter("method");

            if (method == null) {
                if ((cusername != null) && (name != null)) {

                    c.setCusername(cusername);
                    c.setCpassword(cpassword);
                    c.setName(name);
                    c.setAddress(address);
                    c.setMobile(mobile);
                    c.setEmail(email);
                }

                if (opn != null) {
                    if (opn.equals("add")) {
                        cd.create(c);
                    } else if (opn.equals("update")) {
                        id = Integer.parseInt(request.getParameter("customerid"));
                        c.setCustomerid(id);
                        cd.edit(c);
                    } else if (opn.equals("delete")) {
                        System.out.println("delete");
                        id = Integer.parseInt(request.getParameter("customerid"));
                        cd.remove(id);
                    }
                }

                ArrayList list = cd.findAll();
                httpSession.setAttribute("custdetails", list);
                dispatcher = request.getRequestDispatcher("/pages/customer/CustomerHome.jsp");
            } else {
                if (method.equals("fetch")) {
                    id = (Integer) httpSession.getAttribute("customerid");
                    c = cd.find(id);
                    httpSession.setAttribute("cust", c);
                    dispatcher = request.getRequestDispatcher("/pages/customer/CustomerUpdate.jsp");
                } else if (method.equals("search")) {
                    String a = request.getParameter("customer");
                    ArrayList list = cd.findAll(a);
                    httpSession.setAttribute("customerdetails", list);
                    dispatcher = request.getRequestDispatcher("/pages/customer/CustomerSearch.jsp");
                } else if (method.equals("register")) {
                    String un = request.getParameter("uname");
                    String pwd = request.getParameter("pwd");
                    int count = cd.check1(un, pwd);
                    Customer cust = cd.check(un, pwd);
                    if (count != 0) {
                        httpSession.setAttribute("uname", cust.getCusername());
                        httpSession.setAttribute("pwd", cust.getCpassword());
                        httpSession.setAttribute("name", cust.getName());
                        httpSession.setAttribute("phno", cust.getMobile());
                        httpSession.setAttribute("addr", cust.getAddress());
                        httpSession.setAttribute("email", cust.getEmail());
                        httpSession.setAttribute("customerid", cust.getCustomerid());
                        dispatcher = request.getRequestDispatcher("/pages/customer/AddToCart.jsp");
                    } else {
                        dispatcher = request.getRequestDispatcher("/pages/customer/MyAccount.jsp");
                    }
                }
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
