/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rboneshop.category;

import com.rboneshop.product.ReportBean;
import com.rboneshop.order.OrdersDao;
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
 * @author rahul
 */
public class CategoryWiseSales extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            CategoryDao c = new CategoryDao();
            String fromdate = request.getParameter("fromdate");
            String todate = request.getParameter("todate");
            if (fromdate != null && todate != null) {

                ArrayList<ReportBean> ar = c.findCategoryWiseSales(OrdersDao.convertDate(fromdate), OrdersDao.convertDate(todate));
                String strXML = "";
                strXML += "- <chart palette='2' caption='Category Wise Quantity Sold And Amount' shownames='1' showvalues='0' decimals='0' numberPrefix='$' useRoundEdges='1' legendBorderAlpha='0'>";
                strXML += "<categories>";
                for (ReportBean r : ar) {
                    strXML += "<category label='" + r.getCategoryname() + "'/>";
                }
                strXML += "</categories>";
                strXML += "<dataset seriesName='Amount' color='AFD8F8' showValues='1'>";
                for (ReportBean r : ar) {
                    strXML += "<set value='" + r.getAmount() + "'/>";
                }
                strXML += "</dataset>";
                strXML += "<dataset seriesName='Units' color='F6BD0F' showValues='0'>";
                for (ReportBean r : ar) {
                    strXML += "<set value='" + r.getUnits() + "'/>";
                }
                strXML += "</dataset>";

                strXML += "</chart>";
                request.setAttribute("categorywisesales", strXML);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/admin/charts/Sales.jsp");
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
