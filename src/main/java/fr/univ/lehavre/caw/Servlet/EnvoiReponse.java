/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sekrafi
 */
@WebServlet(urlPatterns = {"/EnvoiReponse"})
public class EnvoiReponse extends HttpServlet {
  
     private String text;
    private RequestDispatcher dispat;
     public int conversionDec(char c){
        int ascii;
        return  ascii=(int)c;
    }
     
     public static String conversionHex(char c){
        String hexa;
        return hexa =Integer.toHexString(c);
    }
     
      public String conversionUnicode(char c){
        int i=Integer.parseInt(conversionHex(c));
        return "&0x" + conversionHex(c) + ";";
    }
     

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
        PrintWriter out = response.getWriter();
       
        try {
            
            text=request.getParameter("caractere");
            char c=text.charAt(0);
            int ascii=(int)c;
            StringBuilder sb=new StringBuilder();
            sb.append(ascii);
            
            request.setAttribute("ascii",sb.toString());
            request.setAttribute("hexa",conversionHex(c));
            request.setAttribute("html",conversionUnicode(c));
            
	    dispat = request.getRequestDispatcher("./Converter.jsp");  
            dispat.forward(request, response);
     
     
     
        } finally {
            out.close();
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
