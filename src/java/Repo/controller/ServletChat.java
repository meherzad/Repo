/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.chat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
public class ServletChat extends HttpServlet {

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
            out.println("<title>Servlet ServletChat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletChat at " + request.getContextPath() + "</h1>");
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
        Integer projId = Integer.parseInt(request.getParameter("projId"));
        HttpSession session = request.getSession(true);
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        JSONObject result = new JSONObject();
        PrintWriter out = response.getWriter();
        String status, type = request.getParameter("type");

        if (type.equals("chatonload")) {
            ArrayList<chat> chat_log = db.getchatlog(projId);
            
            JSONArray jArray = new JSONArray();
            JSONObject task = null;
            result.put("user", session.getAttribute("userName").toString());
            for (chat ch : chat_log) {
                task = new JSONObject();
                task.put("username", ch.getUsername());
                task.put("projId", ch.getProjId());
                task.put("chat", ch.getChat());
                jArray.add(task);
            }
            result.put("chat_log", jArray);
            System.out.println("-------------->" + result);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(result);
            out.close();
        } else if (type.equals("insertchat")) {
            chat ch = new chat();
            String chat = request.getParameter("chat");
            ch.setChat(chat);
            ch.setProjId(projId);
            ch.setUserId(userId);
            ch.setTime(new Timestamp(new java.util.Date().getTime()));
            Boolean ins = db.insertchat(ch);
            if (ins) {
                status = "success";
            } else {
                status = "fail";
            }
            result.put("status", status);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(result);
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
