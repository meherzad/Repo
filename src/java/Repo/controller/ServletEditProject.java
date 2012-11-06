/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectmaster;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletEditProject extends HttpServlet {

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
            out.println("<title>Servlet ServletEditProject</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEditProject at " + request.getContextPath() + "</h1>");
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

        DatabaseManager db = new DatabaseManager();

        JSONObject result = new JSONObject();
        PrintWriter out = response.getWriter();

        try {
            db.connect();
            int projectId = Integer.parseInt(request.getParameter("projId"));//= 1;//from session
            String type = request.getParameter("type");
            System.out.println(type);
            if (type.equals("updateabout")) {
                JSONObject json = new JSONObject();
                if (db.updatedesc(projectId, request.getParameter("val"))) {
                    json.put("status", "success");
                } else {
                    json.put("status", "fail");
                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(json);
            } else if (type.equals("projectdetail")) {
                Projectmaster project = db.getprojectdetail(projectId);
                JSONArray jArray = new JSONArray();
                JSONObject task = null;
                int pub = 0, pre = 0;
                task = new JSONObject();
                task.put("projId", project.getProjId());
                task.put("projName", project.getProjName());
                task.put("projDesc", project.getProjDesc());
                task.put("projOwner", project.getProjOwner());
                task.put("downloads", project.getDownloads());
                task.put("likes", project.getLikes());
                task.put("projType", project.getProjType());
                if (project.getProjType().toLowerCase().equals("public")) {
                    pub = 1;
                } else {
                    pre = 1;
                }
                task.put("public", pub);
                task.put("private", pre);
                jArray.add(task);
                result.put("projectdetail", jArray);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(result);

            } else if (type.equals("uptype")) {

                JSONObject json = new JSONObject();
                if (db.updateprojtype(projectId, request.getParameter("projtype"))) {
                    json.put("status", "success");
                } else {
                    json.put("status", "fail");
                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(json);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
