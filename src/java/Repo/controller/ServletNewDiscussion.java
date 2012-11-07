/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectdiscussion;
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
public class ServletNewDiscussion extends HttpServlet {

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
            out.println("<title>Servlet ServletNewDiscussion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletNewDiscussion at " + request.getContextPath() + "</h1>");
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
        try {
            System.out.println(request.getParameter("hdnProjId"));
            int projID = Integer.parseInt(request.getParameter("hdnProjId"));  //to be fetched from sesion
            String subject = request.getParameter("txtSubject");
            int userID;
            //Integer.parseInt(request.getParameter("txtUserId"));  //to be fetched from session
            HttpSession session = request.getSession(true);
            userID = Integer.parseInt(session.getAttribute("userId").toString());
            Date timestamp = new java.util.Date();
            DatabaseManager dbm3 = new DatabaseManager();
            Projectdiscussion dm = new Projectdiscussion();
            dm.setProjId(projID);
            dm.setDiscussionHead(subject);
            dm.setTimeStamp(timestamp);
            dm.setUserId(userID);
            System.out.println("Servlet Created");
            if (dbm3.addDiscussion(dm)) {
                System.out.println("Inserted successfuly");
            } else {
                System.out.println("Not Inserted successfuly");
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AlertMsg.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            //System.out.println("Saumyaaaa");
            e.printStackTrace();
            response.sendRedirect("ErrorAlert.jsp");
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
