
package com.netcracker.atm.servlets;

import com.netcracker.atm.ArgumentException_Exception;
import com.netcracker.atm.Atm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pin extends Dispatcher {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            response.setContentType("text/html;charset=UTF-8");
            Atm atm = new Atm();
            request.getSession().setAttribute("atm", atm);
        try {
                atm.getDispenser().cardInstance(request.getParameter("card"));
                if(!atm.checkDate()){
                    super.forward("/cardOver.jsp", request, response);
                }else{
                    super.forward("/pin.jsp", request, response);
                }
        } catch (ArgumentException_Exception ex) {
            Logger.getLogger(Pin.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute("ex", ex.getMessage());
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
