/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectbugtrackcomment;
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
public class ServletShowBugDetail extends HttpServlet {

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
            out.println("<title>Servlet ServletShowBugDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletShowBugDetail at " + request.getContextPath() + "</h1>");
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
        int bug_id = Integer.parseInt(request.getParameter("BugId"));
        DatabaseManager dbCon = new DatabaseManager();
        ArrayList<Projectbugtrackcomment> bug_comm_list = null;
        String projiurl = request.getParameter("projiurl");
        String Projname = request.getParameter("ProjName");
        int bugid = Integer.parseInt(request.getParameter("BugId"));
        String bugissue = request.getParameter("bugissue");

        String status = "";
        try {
            bug_comm_list = dbCon.selectbug_detail(bugid);
            status = "success";

        } catch (Exception e) {
            status = "fail";
        }
        request.setAttribute("bugId", bug_id);
        request.setAttribute("bugissue", bugissue);
        request.setAttribute("status", "success");
        request.setAttribute("bug_comm_list", bug_comm_list);
        request.setAttribute("issue", bugissue);
        request.setAttribute("Projname", Projname);
        request.setAttribute("Projiurl", projiurl);
        RequestDispatcher rd = request.getRequestDispatcher("showBugDetail.jsp");
        rd.forward(request, response);
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
