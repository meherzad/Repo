/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Usermaster;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletEditProfile extends HttpServlet {

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
            out.println("<title>Servlet ServletEditProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEditProfile at " + request.getContextPath() + "</h1>");
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
        try {
            DatabaseManager db = new DatabaseManager();
            JSONObject result = new JSONObject();
            int userId;//from session
            HttpSession session = request.getSession(true);
            userId = (Integer) session.getAttribute("userId");
            String type = request.getParameter("type");
            if (type.equals("updateabout")) {
                db.personalstatement(userId, request.getParameter("val"));
            } else if (type.equals("changepass")) {
                String Current = request.getParameter("Current");
                String Newpass = request.getParameter("New");
                JSONObject json = new JSONObject();
                if (db.changepassword(Newpass, Current, userId)) {
                    json.put("result", "Success");
                } else {
                    json.put("result", "Fail");
                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.println(json);
            } else if (type.equals("userdetail")) {
                Usermaster user = db.getuser(userId);
                JSONArray jArray = new JSONArray();
                JSONObject task = null;
                task = new JSONObject();
                task.put("image", user.getIurl());
                task.put("jDate", user.getJDate().toString());
                task.put("userName", user.getUsername());
                task.put("userId", user.getUserId());
                jArray.add(task);
                result.put("userdetail", jArray);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(result);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
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
