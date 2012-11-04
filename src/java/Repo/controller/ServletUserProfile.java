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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author meherzad
 */
public class ServletUserProfile extends HttpServlet {

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
            out.println("<title>Servlet ServletUserProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUserProfile at " + request.getContextPath() + "</h1>");
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
        String resp;
        HttpSession session = request.getSession(true);
        Integer usrId = (Integer) session.getAttribute("userId");
        int r;
        JSONObject result = new JSONObject();
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            DatabaseManager db = new DatabaseManager();
            db.connect();

            Usermaster user = db.getuser(userId);
            ArrayList<Projectmaster> coordinator = db.getprojectList(userId);
            ArrayList<Projectmaster> devloper = db.getdevloperprojectList(userId);
            ArrayList<Projectmaster> following = db.getfollowerprojectList(userId);

            JSONArray jArray = new JSONArray();
            JSONObject task = null;
            // for (Usermaster user : userdetail) {
            task = new JSONObject();
            task.put("image", user.getIurl());
            task.put("userId", user.getUserId());
            task.put("jDate", user.getJDate().toString());
            task.put("userName", user.getUsername());
            task.put("nick", user.getNick());
            task.put("userId", user.getUserId());
            task.put("statement", user.getAboutUser());
            jArray.add(task);
            //}
            result.put("userdetail", jArray);
            JSONArray ja1 = new JSONArray();
            for (Projectmaster project : coordinator) {
                task = new JSONObject();
                task.put("projectid", project.getProjId());
                task.put("project", project.getProjName());
                ja1.add(task);
            }
            result.put("coordinator", ja1);
            JSONArray ja2 = new JSONArray();
            for (Projectmaster dev : devloper) {
                task = new JSONObject();
                task.put("projectid", dev.getProjId());
                task.put("project", dev.getProjName());
                ja2.add(task);
            }
            result.put("devloper", ja2);
            JSONArray ja3 = new JSONArray();
            for (Projectmaster follower : following) {
                task = new JSONObject();
                task.put("projectid", follower.getProjId());
                task.put("project", follower.getProjName());
                ja3.add(task);
            }
            result.put("follower", ja3);
            result.put("sessionUser", usrId.toString());
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
