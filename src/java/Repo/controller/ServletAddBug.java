/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectbugtrack;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author meherzad
 */
public class ServletAddBug extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAddBug</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAddBug at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int temp = 0;
        String tempp1 = request.getParameter("hdnProj");
        System.out.println(tempp1);
        int p1 = Integer.parseInt(tempp1);
        String tempp2 = request.getParameter("txtissue");
        HttpSession session = request.getSession(true);
        String tempp3 = session.getAttribute("userId").toString();
        int p3 = Integer.parseInt(tempp3);
        Date p4 = new java.util.Date();
        //String p5 = request.getParameter("txtbugfile");
        DatabaseManager dbcon = new DatabaseManager();
        Projectbugtrack obj = new Projectbugtrack();
        obj.setProjectId(p1);
        obj.setIssue(tempp2);
        obj.setUserId(p3);
        //obj.setFileUrl(p5);


        obj.setTimeStamp(p4);
        System.out.println("servlet created");
        try {

            temp = dbcon.addBug(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(temp);
        request.setAttribute("temp", temp);
        RequestDispatcher rd = request.getRequestDispatcher("addbugfile.jsp");
        rd.forward(request, response);
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
