/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Parker
 */
//@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {

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
        
        /*
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NavigationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NavigationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    */
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
   
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        
        if(action.equals("wwe")){
            
     
            session.getAttribute("wweList");
            getServletContext().getRequestDispatcher("/WWE.jsp").forward(request, response);
            System.out.println("Working");
            
            
        }
       
        else if(action.equals("aew")){
            
            session.getAttribute("aewList");
            getServletContext().getRequestDispatcher("/AEW.jsp").forward(request, response);
            System.out.println("Working");
        
        }
        else if(action.equals("wt")){
            session.getAttribute("wtList");
            getServletContext().getRequestDispatcher("/WrestleTalk.jsp").forward(request, response);
            System.out.println("Working");
            
        }
        else if(action.equals("Home")){
            session.getAttribute("wtList");
            session.getAttribute("aewList");
            session.getAttribute("wweList");
            getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
            System.out.println("Working");
            
        }
    
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
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        
        if(action.equals("home")){
          
            WWETable.FillWWEList();
            ArrayList<WWE> wweList = new ArrayList<WWE>();
            
            wweList = WWETable.getWWEData();
            session.setAttribute("wweList", wweList);
            
             AEWTable.FillAEWList();
            ArrayList<AEW> aewList = new ArrayList<AEW>();
            
            aewList = AEWTable.getAEWData();
            session.setAttribute("aewList", aewList);
            
             WTTable.FillWTList();
            ArrayList<WT> wtList = new ArrayList<WT>();
            
            wtList = WTTable.getWTData();
            session.setAttribute("wtList", wtList);
            
            
            
            
            getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
        }
        else if(action.equals("wasteIt")){
        
         WWETable.deleteWWETables();
         AEWTable.deleteAEWTables();
         WTTable.deleteWTTables();
        }
        
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
