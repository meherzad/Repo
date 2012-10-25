/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.Projecttask;
import Repo.model.Projecttaskdetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
public class ServletAddSubtask extends HttpServlet {

    Projecttask task = null;

    public ServletAddSubtask() {
        super();
        task = new Projecttask();
    }

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
            out.println("<title>Servlet ServletAddSubtask</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAddSubtask at " + request.getContextPath() + "</h1>");
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
        System.out.println("-------------------");
        PrintWriter out = response.getWriter();
        String resp, str = request.getParameter("type");
        HttpSession session = request.getSession(true);
        JSONObject result = new JSONObject();
        int type = Integer.parseInt(str);
        Projecttaskdetail subTask = null;
        if (type == 1) {
            subTask = new Projecttaskdetail();
            subTask.setStatus("Incomplete");
            subTask.setSubTask(request.getParameter("subTask"));
            subTask.setTimeStamp(new Date());
            task.addSubTask(subTask);
        } else {
            System.out.println("++++++++++++");
            ArrayList<Projecttaskdetail> list = task.getSubTask();
            for (Projecttaskdetail subtask : list) {
                System.out.println(subtask);
            }
        }
        result.put("status", "success");
        System.out.println(result);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(result);

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
