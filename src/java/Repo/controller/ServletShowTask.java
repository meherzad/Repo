/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projecttask;
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
public class ServletShowTask extends HttpServlet {

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
            out.println("<title>Servlet ServletShowTask</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletShowTask at " + request.getContextPath() + "</h1>");
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
        System.out.println("---------------@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        DatabaseManager obj = new DatabaseManager();
        PrintWriter out = response.getWriter();
        String stat;
        int projId = Integer.parseInt(request.getParameter("projId"));
        int phaseId = Integer.parseInt(request.getParameter("phaseId"));
        ArrayList<Projecttask> taskList = null;
        try {
            taskList = obj.getTask(projId, phaseId);
        } catch (Exception e) {
            stat = "Fail";
        }
        JSONArray jArray = new JSONArray();
        JSONObject json = new JSONObject();
        JSONObject task = null;
        if (taskList.isEmpty()) {
            stat = "empty";
        }
        for (Projecttask t : taskList) {
            task = new JSONObject();
            task.put("deadLine", t.getDeadLine().toString());
            task.put("phaseId", t.getPhaseId());
            task.put("projId", t.getProjectId());
            task.put("taskDescription", t.getTaskDescription());
            task.put("taskId", t.getTaskId());
            jArray.add(task);
        }
        stat = "Success";
        json.put("status", stat);
        json.put("task", jArray);
        System.out.print(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
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
