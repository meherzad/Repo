/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Usermaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author meherzad
 */
public class ServletGetUser extends HttpServlet {

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
            out.println("<title>Servlet ServletGetUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletGetUser at " + request.getContextPath() + "</h1>");
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
        int projId = 1;//Integer.parseInt(request.getParameter("projId"));
        PrintWriter out=response.getWriter();
        DatabaseManager obj = new DatabaseManager();
        ArrayList<Usermaster> members = obj.getProjectMembers(projId);
        JSONArray jArray = new JSONArray();
        JSONObject json = new JSONObject();
        JSONObject user = null;
        for (Usermaster us : members) {
            user = new JSONObject();
            user.put("userId", us.getUserId());
            user.put("nick", us.getNick());
            jArray.add(user);
        }
        json.put("members", jArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(json);
        
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
