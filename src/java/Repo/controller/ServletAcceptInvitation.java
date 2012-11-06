/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectdetail;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletAcceptInvitation extends HttpServlet {

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
            out.println("<title>Servlet ServletAcceptInvitation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAcceptInvitation at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String type = request.getParameter("type");
        HttpSession session = request.getSession(true);
        int ProjectId = Integer.parseInt(request.getParameter("ProjectId"));
        int UserId = Integer.parseInt(session.getAttribute("userId").toString());//retrive from session
        String result;
        //  int ProjId=Integer.parseInt(request.getParameter("ProjectId"));
        System.out.println(type);
        Projectdetail pd = new Projectdetail();
        DatabaseManager dm1 = new DatabaseManager();
        java.util.Date timestamp = new java.util.Date();
        java.sql.Date creationDate = new java.sql.Date(timestamp.getTime());

        pd.setUserId(UserId);
        pd.setProjectId(ProjectId);
        pd.setjDate(creationDate);
        if (dm1.update(pd, type, ProjectId, UserId)) {
            result = "success";
        } else {
            result = "fail";

        }
        System.out.println("----->" + result);
        RequestDispatcher rd = request.getRequestDispatcher("AcceptInvitation.jsp");
        //response.sendRedirect("resp.jsp");
        rd.forward(request, response);
        System.out.println(pd);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
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
