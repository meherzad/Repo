package Repo.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import EntityClass.DatabaseManager;
import EntityClass.Usermaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author Meherzad
 */
public class ServleTCheckUserName extends HttpServlet {

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
            out.println("<title>Servlet ServleTCheckUserName</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServleTCheckUserName at " + request.getContextPath() + "</h1>");
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
        user.setUsername(request.getParameter("username"));
        PrintWriter out;
        DatabaseManager obj = new DatabaseManager();
        JSONObject jObject = new JSONObject();
        try {
            boolean r = obj.checkUsername(user);
            System.out.println("--------------------------->>>>>" + r);
            if (r) {
                jObject.put("resp", "Username in use");
            } else {
                jObject.put("resp", "Success");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            jObject.put("resp", "Error");
        }
        out = response.getWriter();
        System.out.println("-------------->  " + jObject);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //json.put("catalog", jObject);
        out.println(jObject);
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
