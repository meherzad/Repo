/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import EntityClass.DatabaseManager;
import EntityClass.Projectmaster;
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
 * @author Meherzad
 */
public class mostDownload extends HttpServlet {

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
            out.println("<title>Servlet mostDownload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mostDownload at " + request.getContextPath() + "</h1>");
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
        JSONArray jArray = new JSONArray();
        JSONObject json = new JSONObject();
        JSONObject jObject = null;
        PrintWriter out = null;
        String desc;
        System.out.println("------------------>" + request.getParameter("type"));
        int type = Integer.parseInt(request.getParameter("type"));
        DatabaseManager dbObject = new DatabaseManager();
        ArrayList<Projectmaster> list = dbObject.getMostDownload(type);

        for (int i = 0; i < 5; i++) {
            jObject = new JSONObject();
            jObject.put("projId", list.get(i).getProjId());
            jObject.put("projName", list.get(i).getProjName());
            desc = list.get(i).getProjDesc();
            if (desc.length() > 50) {
                desc = desc.substring(0, 50);
            } else if (desc.length() > 30) {
                desc = desc.substring(0, 30);
            } else {
                desc = desc.substring(0, 10);
            }
            jObject.put("projDesc", desc);
            jArray.add(jObject);
        }
        out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json.put("content", jArray);
        out.println(json);
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
