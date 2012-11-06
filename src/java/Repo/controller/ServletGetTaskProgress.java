/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projecttaskdetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author meherzad
 */
public class ServletGetTaskProgress extends HttpServlet {

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
            out.println("<title>Servlet ServletGetTaskProgress</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletGetTaskProgress at " + request.getContextPath() + "</h1>");
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
        int progress, t, f, taskId;
        String status;
        taskId = Integer.parseInt(request.getParameter("taskId"));
        JSONObject json = new JSONObject();
        DatabaseManager obj = new DatabaseManager();
        PrintWriter out = response.getWriter();
        try {
            ArrayList<Projecttaskdetail> subTaskList = obj.getSubTask(taskId);
            t = f = 0;
            for (Projecttaskdetail pj : subTaskList) {
                t++;
                if (pj.getStatus().equalsIgnoreCase("complete")) {
                    f++;
                }
            }
            status = "success";
            progress = 100 * f / t;
        } catch (Exception e) {
            status = "fail";
            progress = 0;
            e.printStackTrace();
        }
        json.put("status", status);
        json.put("prog", progress);
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
