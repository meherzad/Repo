/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectmaster;
import Repo.model.Usermaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author meherzad
 */
public class ServletSearch extends HttpServlet {

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
            out.println("<title>Servlet ServletSearch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSearch at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        System.out.println("req received");
        String projstatus, unamestatus;

        try {

            String projectname = request.getParameter("searchSite");//text entered in the textbox
            ArrayList<Projectmaster> project = new ArrayList();//arraylist for storing the objects of ProjectMaster class
            ArrayList<Usermaster> username = new ArrayList();//Arratlist for storing the objects of UserMaster class

            DatabaseManager dm = new DatabaseManager();

            project = dm.getProject(projectname);
            projstatus = "true";
            username = dm.getUsername(projectname);
            unamestatus = "true";
            System.out.println(project);
            //setting attributes and sending them to the searchresult page for displaying.
            request.setAttribute("project", project);
            request.setAttribute("projstatus", projstatus);
            request.setAttribute("username", username);
            request.setAttribute("unamestatus", unamestatus);

            RequestDispatcher rd = request.getRequestDispatcher("SearchResult.jsp");
            rd.forward(request, response);

        } catch (Exception exception) {
            exception.printStackTrace();
            projstatus = "false";
            unamestatus = "false";
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
