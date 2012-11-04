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
public class ServletPeople extends HttpServlet {

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
            out.println("<title>Servlet ServletPeople</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPeople at " + request.getContextPath() + "</h1>");
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
        int r;
        String resp;
        JSONObject result = new JSONObject();

        try {
            int projId =Integer.parseInt(request.getParameter("projId"));//Get projectid fromsession 
            DatabaseManager db = new DatabaseManager();
            db.connect();
            ArrayList<Usermaster> Owner = db.getowner(projId);
            ArrayList<Usermaster> Devlopers = db.getdevloper(projId);
            ArrayList<Usermaster> Followers = db.getallfollower(projId);

            JSONArray jArray = new JSONArray();
            JSONObject task = null;
            for (Usermaster user : Owner) {
                task = new JSONObject();
                task.put("image", user.getIurl());
                task.put("jDate", user.getJDate().toString());
                task.put("userId", user.getUserId());
                task.put("userName", user.getUsername());
                jArray.add(task);
            }
            result.put("owner", jArray);
            JSONArray ja1 = new JSONArray();
            for (Usermaster user : Devlopers) {
                task = new JSONObject();
                task.put("image", user.getIurl());
                task.put("jDate", user.getJDate().toString());
                task.put("userId", user.getUserId());
                task.put("userName", user.getUsername());
                ja1.add(task);
            }
            result.put("developer", ja1);
            JSONArray ja2 = new JSONArray();
            //jArray.clear();
            for (Usermaster user : Followers) {
                task = new JSONObject();
                task.put("image", user.getIurl());
                task.put("jDate", user.getJDate().toString());
                task.put("userId", user.getUserId());
                task.put("userName", user.getUsername());
                ja2.add(task);
            }
            result.put("follower", ja2);
            r = 0;
        } catch (Exception e) {
            r = -1;
        }
        if (r == -1) {
            resp = "Fail";
        } else {
            resp = "success";
        }
        result.put("status", resp);
        System.out.println("-------------->" + result);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.close();
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
