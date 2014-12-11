package com.rboneshop.product;

import com.rboneshop.ConnectionPool;
import com.rboneshop.category.*;
import com.rboneshop.supplier.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javazoom.upload.*;

public class ProductList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = null;
        HttpSession httpSession = request.getSession();

        ConnectionPool conn = ConnectionPool.getInstance();
        String str = conn.getPath();
        System.out.println("str set path :" + str);//just for testin purpose
        int id = 0;
        Product p = new Product();
        ProductDao pd = new ProductDao();
        String method = request.getParameter("method");
        if (method == null) {

            if (MultipartFormDataRequest.isMultipartFormData(request)) {

                MultipartFormDataRequest mrequest;
                try {
                    System.out.println("try start");
                    UploadBean upBean = new UploadBean();
                    //The following lines works only when developin on local host
                    str = "C:\\Users\\Rahul\\Documents\\NetBeansProjects\\RBOneShop\\web\\photo";
                    str = str.replace('\\', '/').replace('/', File.separatorChar);
                    upBean.setFolderstore(str);
                    System.out.println("set folderstore str :"+str);
                    upBean.setParser(MultipartFormDataRequest.CFUPARSER);
                    //  upBean.setParsertmpdir(str);
                    mrequest = new MultipartFormDataRequest(request);
                    
                    String opn = mrequest.getParameter("opn");
                    System.out.println("opn is : " + opn);
                    if (opn != null) {
                        String todo = null;
                        if (mrequest != null) {
                            todo = mrequest.getParameter("todo");
                        }
                        if ((todo != null) && (todo.equalsIgnoreCase("upload"))) {
                            Hashtable files = mrequest.getFiles();
                            if ((files != null) && (!files.isEmpty())) {
                                UploadFile file = (UploadFile) files.get("uploadfile");
                                upBean.store(mrequest, "uploadfile");
                                System.out.println("upbean store :"+mrequest);
                                String categoryid = mrequest.getParameter("categoryid");
                                String price = mrequest.getParameter("price");
                                String make = mrequest.getParameter("make");
                                String remarks = mrequest.getParameter("remarks");
                                String supplierid = mrequest.getParameter("supplierid");
                                String modelno = mrequest.getParameter("modelno");
                                String stockinhand = mrequest.getParameter("stockinhand");
                                if ((categoryid != null) && (price != null) && (make != null) && (remarks != null) && (supplierid != null) && (modelno != null) && (stockinhand != null)) {
                                    p.setCategoryid(Integer.parseInt(categoryid));
                                    p.setPrice(Double.parseDouble(price));
                                    p.setMake(make);
                                    p.setRemarks(remarks);
                                    p.setSupplierid(Integer.parseInt(supplierid));
                                    p.setModelno(modelno);
                                    p.setStockinhand(Integer.parseInt(stockinhand));
                                }

                                if (opn.equals("add")) {
                                    File imgfile = new File(str + "//" + file.getFileName());
                                    FileInputStream fin = new FileInputStream(imgfile);
                                    p.setPhoto(file.getFileName());
                                    pd.create(p);
                                } else if (opn.equals("update")) {
                                    if (!file.getFileName().equals("")) {
                                        File imgfile = new File(str + "//" + file.getFileName());
                                        FileInputStream fin = new FileInputStream(imgfile);
                                        System.out.println("in update imgfile :"+imgfile);
                                        id = Integer.parseInt(mrequest.getParameter("productid"));
                                        p.setProductid(id);
                                        p.setPhoto(file.getFileName());
                                        pd.edit(p);
                                    } else {

                                        id = Integer.parseInt(mrequest.getParameter("productid"));
                                        p.setProductid(id);
                                        p.setPhoto(mrequest.getParameter("photo"));
                                        pd.edit(p);

                                    }
                                }
                            }
                        }
                    }
                    ArrayList list = pd.findAll();
                    System.out.println("list    size :  " + list.size());
                    httpSession.setAttribute("productdetails", list);
                    dispatcher = request.getRequestDispatcher("/pages/admin/product/Product.jsp");

                } catch (UploadException ex) {
                }
            } else {
                ArrayList list = pd.findAll();
                System.out.println("list2     " + list.size());
                httpSession.setAttribute("productdetails", list);
                dispatcher = request.getRequestDispatcher("/pages/admin/product/Product.jsp");
            }
        } else {
            CategoryDao cd = new CategoryDao();
            SupplierDao sd = new SupplierDao();
            if (method.equals("fetch")) {
                id = Integer.parseInt(request.getParameter("id"));
                p = pd.find(id);
                httpSession.setAttribute("pro", p);
                request.setAttribute("catid", p.getCategoryid());
                Category c = cd.find(p.getCategoryid());
                request.setAttribute("catname", c.getJcatname());
                request.setAttribute("suppid", p.getSupplierid());
                Supplier s = sd.find(p.getSupplierid());
                System.out.println("aa   " + s.getSuppcompany() + "    " + p.getSupplierid());
                request.setAttribute("suppname", s.getSuppcompany());
                String cat = cd.getOptions();
                request.setAttribute("cat", cat);
                String supp = sd.getOptions();
                request.setAttribute("supp", supp);
                request.setAttribute("path", str);
                dispatcher = request.getRequestDispatcher("/pages/admin/product/ProductUpdate.jsp");
            } else if (method.equals("fetch1")) {
                id = Integer.parseInt(request.getParameter("id"));
                p = pd.find(id);
                httpSession.setAttribute("pro", p);
                request.setAttribute("catid", p.getCategoryid());
                Category c = cd.find(p.getCategoryid());
                request.setAttribute("catname", c.getJcatname());
                request.setAttribute("suppid", p.getSupplierid());
                Supplier s = sd.find(p.getSupplierid());
                System.out.println("aa   " + s.getSuppcompany() + "    " + p.getSupplierid());
                request.setAttribute("suppname", s.getSuppcompany());
                String cat = cd.getOptions();
                request.setAttribute("cat", cat);
                String supp = sd.getOptions();
                request.setAttribute("supp", supp);
                request.setAttribute("path", str);
                dispatcher = request.getRequestDispatcher("/pages/admin/product/ProductView.jsp");
            } else if (method.equals("fetch2")) {
                id = Integer.parseInt(request.getParameter("id"));
                p = pd.find(id);
                httpSession.setAttribute("pro", p);                
                dispatcher = request.getRequestDispatcher("/pages/customer/ProductView.jsp");
            }else if (method.equals("add")) {
                String cat = cd.getOptions();
                request.setAttribute("cat", cat);
                String supp = sd.getOptions();
                request.setAttribute("supp", supp);
                dispatcher = request.getRequestDispatcher("/pages/admin/product/ProductAdd.jsp");
            } else if (method.equals("delete")) {
                id = Integer.parseInt(request.getParameter("productid"));
                pd.remove(id);
                ArrayList list = pd.findAll();
                httpSession.setAttribute("productdetails", list);
                dispatcher = request.getRequestDispatcher("/pages/admin/product/Product.jsp");
            } else if (method.equals("search")) {
                String categoryid = request.getParameter("categoryid");
                if (categoryid != null) {
                    String cat = cd.getOptions();
                    request.setAttribute("cat", cat);
                    ArrayList list = pd.findAll1(Integer.parseInt(categoryid));
                    httpSession.setAttribute("catproductdetails", list);
                } else {
                    String cat = cd.getOptions();
                    request.setAttribute("cat", cat);
                }
                dispatcher = request.getRequestDispatcher("/pages/admin/product/ProductSearch.jsp");
            } else if (method.equals("searchmenu")) {
                String modelno = request.getParameter("modelno");
                p = pd.searchbymodelnno(modelno);
                request.setAttribute("prodetails", p);

                dispatcher = request.getRequestDispatcher("/pages/customer/ProductSearch1.jsp");
            }


        }
        dispatcher.forward(request, response);
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
            throws ServletException,
            IOException {
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
            throws ServletException,
            IOException {
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
