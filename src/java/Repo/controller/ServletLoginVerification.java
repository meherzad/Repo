/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Hashing;
import Repo.model.Usermaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author XANDER
 */
public class ServletLoginVerification extends HttpServlet {

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
            out.println("<title>Servlet LoginVerification</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginVerification at " + request.getContextPath() + "</h1>");
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
        Usermaster user = new Usermaster();
        user.setUsername(request.getParameter("user"));
        String pd = null;
        System.out.println(request.getParameter("user"));
        HttpSession session = request.getSession(true);
        String result, status;
        try {
            pd = request.getParameter("pass");
            System.out.println(pd + " -----***");
            if (pd != null) {
                System.out.println("========" + pd);
                pd = Hashing.getHashValue(pd);
            }
        } catch (NoSuchAlgorithmException ex) {
            //Logger.getLogger(LoginVerification.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        user.setPassword(pd);
        DatabaseManager dm = new DatabaseManager();
        Usermaster verifUser = null;
        PrintWriter out = response.getWriter();
        try {
            if (pd != null || pd != "") {
                verifUser = dm.LoginVerify(user);
                status = "success";
            } else {
                status = "fail";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            status = "fail";
        }
        if (verifUser != null) {
            result = "Valid User";
            session.setAttribute("userId", verifUser.getUserId());
            session.setAttribute("userName", user.toString());
        } else {
            result = "Invalid User";
        }
        JSONObject json = new JSONObject();
        json.put("result", result);
        json.put("status", status);
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