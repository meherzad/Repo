/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectmaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author meherzad
 */
public class ServletDisplayRequest extends HttpServlet {

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
            out.println("<title>Servlet ServletDisplayRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletDisplayRequest at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        DatabaseManager dbm3 = new DatabaseManager();
        ArrayList<Projectmaster> nameList = new ArrayList<Projectmaster>();
        //int projId=Integer.parseInt(request.getParameter("ProjectId"));
        HttpSession session=request.getSession(true);
        
        int UserId = Integer.parseInt(session.getAttribute("userId").toString());//get from session
        String status1 = "";
        try {
            nameList = dbm3.displayinvi(UserId);
            //umc.getName();
            System.out.println("Display Invitation sucess");
            status1 = "sucess";
            request.setAttribute("status", status1);
            request.setAttribute("nameList", nameList);
            System.out.println(nameList);
            System.out.println(status1);
            RequestDispatcher rd = request.getRequestDispatcher("AcceptInvitation.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Inserted successfuly");
            status1 = "unsucessfull saved";
        }
        out.close();
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
        DatabaseManager dbm3 = new DatabaseManager();
        ArrayList<Projectmaster> nameList = new ArrayList<Projectmaster>();
        //int projId=Integer.parseInt(request.getParameter("ProjectId"));
        int UserId = 3;//get from session
        //dbm3.displayinvi(UserId);
        //JSONObject obj = new JSONObject();
        String status1 = "";
        try {
            nameList = dbm3.displayinvi(UserId);
            //umc.getName();
            System.out.println("Display Invitation sucess");
            status1 = "sucess";
            request.setAttribute("status", status1);
            request.setAttribute("nameList", nameList);
            System.out.println(nameList);
            System.out.println(status1);
            RequestDispatcher rd = request.getRequestDispatcher("AcceptInvi.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Inserted successfuly");
            status1 = "unsucessfull saved";
        }
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
