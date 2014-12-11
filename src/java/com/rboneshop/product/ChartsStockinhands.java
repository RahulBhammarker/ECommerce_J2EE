/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rboneshop.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rboneshop
 */
public class ChartsStockinhands extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            ProductDao p = new ProductDao();
            ArrayList<ReportBean> ar = p.findAllProductsLeft();
            String strXml="<chart caption='Stock in Hands' xAxisName='Category' yAxisName='Units in Stock' showValues='0' formatNumberScale='0' showBorder='1'>";

            for(ReportBean rr:ar)
            {
             strXml += "<set label='"+rr.getModelno()+"' value='"+rr.getUnits()+"'/> " ;
                }
                strXml+="</chart>";
                System.out.println("ggg"+strXml);
            request.setAttribute("stockinhand", strXml);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/admin/charts/Stockinhands.jsp");
            dispatcher.include(request, response);
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
