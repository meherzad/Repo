/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectmaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author meherzad
 */
public class ServletAddProject extends HttpServlet {

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
            out.println("<title>Servlet ServletAddProject</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAddProject at " + request.getContextPath() + "</h1>");
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
        String status, p1 = request.getParameter("txtprojname");
        String p2 = request.getParameter("txtprojdescrip");
        HttpSession session = request.getSession(true);
        String tempp3 = "8";//session.getAttribute("userId").toString();
        int p3 = Integer.parseInt(tempp3);
        String p4 = request.getParameter("visibility");
        ArrayList<Integer> tagids = new ArrayList<Integer>();
        String[] tagstring = new String[4];
        String tags = request.getParameter("hdnVal");
        JSONObject json = new JSONObject();
        for (int j = 0; j < tags.length(); j++) {
            tagstring = tags.split(",");
        }
        for (int j = 0; j < tagstring.length; j++) {
            tagids.add(Integer.parseInt(tagstring[j]));
        }
        DatabaseManager dbcon = new DatabaseManager();
        Projectmaster oaddproj = new Projectmaster();
        oaddproj.setProjName(p1);
        oaddproj.setProjDesc(p2);
        oaddproj.setProjOwner(p3);
        oaddproj.setProjType(p4);

        System.out.println("servlet created");
        try {
            if (dbcon.addProject(oaddproj, tagids)) {
                System.out.println("Done");
                status = "success";
            } else {
                System.out.println("Notdone");
                status = "fail";
            }
        } catch (Exception e) {
            status = "fail";
            System.out.println(e);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json.put("status", status);
        out.print(json);
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
