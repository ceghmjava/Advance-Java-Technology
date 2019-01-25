/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author ehs
 */
public class ViewCart extends HttpServlet {


    public void init(ServletConfig cfg){
                        Products.initData();
    }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            ArrayList cartObj = (ArrayList)session.getAttribute("cart");
            if(cartObj==null){
                out.println("Your cart is empty");
            }
            else{
             out.println("<table border='1'>");
             out.println("<tr>" +
                     "<th>Sr No.</th>" +
                     "<th>Product Name</th>" +
                     "<th>Qty</th>" +
                     "<th>Price</th>" +
                     "<th>Subtotal</th>" +
                     "</tr>");
             double grandTotal = 0;
                for(int i=0;i<cartObj.size();i++){
                      SelectedProduct temp = (SelectedProduct) cartObj.get(i);
                      Products p = (Products)Products.products.get(new Integer(temp.pid));
                      double price = p.getPrice();
                      double subTotal = price*temp.qty;
                      out.println("<tr>");
                      out.println("<td>"+(i+1)+"</td>");
                      out.println("<td>"+p.getProductName()+"</td>");
                      out.println("<td>"+temp.qty+"</td>");
                      out.println("<td>"+price+"</td>");
                      out.println("<td>"+subTotal+"</td>");
                      grandTotal += subTotal;

                      out.println("</tr>");
                }
             out.println("</table>");
             out.println("<div style='float:right'>"+grandTotal+"</div>");
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
