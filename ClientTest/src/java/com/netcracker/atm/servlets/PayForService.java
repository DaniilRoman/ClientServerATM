
package com.netcracker.atm.servlets;

import com.netcracker.atm.Atm;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PayForService extends Dispatcher {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Atm atm = (Atm)request.getSession().getAttribute("atm");
        try{
        Float cash = Float.parseFloat(request.getParameter("cash").replace(",","."));
        cash = new BigDecimal(cash).setScale(2, RoundingMode.UP).floatValue();     
        String company = (String)request.getSession().getAttribute("title");
        String cardNumber = atm.getDispenser().getCurdNumber();
        if(atm.payForService(cardNumber, company, cash)){
            request.getSession().setAttribute("page", "change.jsp");
            super.forward("/true.jsp", request, response);
        }else{
               request.getSession().setAttribute("ex", "Operation failed.");
               request.getSession().setAttribute("page", "payForService.jsp");
               super.forward("/false.jsp", request, response);
        }
        }
        catch(NumberFormatException ex){
        Logger.getLogger(PayForService.class.getName()).log(Level.SEVERE, null, ex);
        request.getSession().setAttribute("ex", "Check the amount entered.");
        super.forward("/error.jsp", request, response);
        }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
