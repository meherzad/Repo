/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectinvitation;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletRequestUser extends HttpServlet {

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
            out.println("<title>Servlet ServletRequestUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletRequestUser at " + request.getContextPath() + "</h1>");
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
        Projectinvitation pi = new Projectinvitation();
        DatabaseManager dbm3 = new DatabaseManager();
        java.util.Date timestamp = new java.util.Date();
        java.sql.Date creationDate = new java.sql.Date(timestamp.getTime());
        System.out.println(creationDate);
        int UserId = Integer.parseInt(request.getParameter("userId"));
        int fromUser ;//1;//to be feched from session
        HttpSession session=request.getSession(true);
        fromUser=Integer.parseInt(session.getAttribute("userId").toString());
        int projId = Integer.parseInt(request.getParameter("projId"));
        String Flag = "No";
        String Status = "Pending";
        pi.setFromUser(fromUser);
        pi.setToUser(UserId);
        pi.setProjId(projId);
        pi.setTimeStamp(creationDate);
        pi.setFlag(Flag);
        pi.setStatus(Status);
//        dbm3.requestinvi(pi);
        JSONObject obj = new JSONObject();
        String status1 = "";
        try {
            if (dbm3.requestinvi(pi)) {
                System.out.println("Inserted successfuly");
                status1 = "successfull saved";

            } else {
                System.out.println("Not Inserted successfuly");
                status1 = "unsucessfull saved";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Inserted successfuly");
            status1 = "unsucessfull saved";
        }
        obj.put("savestatus", status1);
        out.println(obj);
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
