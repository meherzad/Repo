/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Projectmaster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
public class ServletViewDocumentation extends HttpServlet {

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
            out.println("<title>Servlet ServletViewDocumentation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletViewDocumentation at " + request.getContextPath() + "</h1>");
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
        DatabaseManager cnn = new DatabaseManager();
        int projId = Integer.parseInt(request.getParameter("projId"));
        //DBConn cnn = new DBConn();
        Projectmaster doc = null;
        HttpSession session = request.getSession(true);
        Object userId = session.getAttribute("userId");

        String status = "";
        try {
            doc = cnn.viewDocument(projId);
            if (userId != null) {
                if (Integer.parseInt(userId.toString()) == doc.getProjOwner()) {
                    request.setAttribute("user", "yes");
                } else {
                    request.setAttribute("user", "no");
                }
            } else {
                request.setAttribute("user", "no");
            }
            status = "success";
        } catch (Exception e) {
            e.printStackTrace();
            status = "fail";
        }
        request.setAttribute("status", status);
        request.setAttribute("doc", doc);

        RequestDispatcher rd = request.getRequestDispatcher("ProjectviewDocument.jsp?projId"+projId);

        rd.forward(request, response);
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
        DatabaseManager cnn = new DatabaseManager();
        int projId = Integer.parseInt(request.getParameter("projId"));
        int type = Integer.parseInt(request.getParameter("type"));
        if (type == 1) {
            Projectmaster doc = null;
            String status = "";
            JSONObject json = new JSONObject();
            try {
                doc = cnn.viewDocument(projId);
                json.put("projDoc", doc.getProjectDoc());
                //json.put();
                status = "success";
            } catch (Exception e) {
                e.printStackTrace();
                status = "fail";
            }
            json.put("status", status);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(json);
        } else {
            Projectmaster doc = null;
            String status = "";
            try {
                doc = cnn.viewDocument(projId);
                HttpSession session = request.getSession(true);
                Object userId = session.getAttribute("userId");

                if (userId != null) {
                    if (Integer.parseInt(userId.toString()) == doc.getProjOwner()) {
                        request.setAttribute("user", "yes");
                    } else {
                        request.setAttribute("user", "no");
                    }
                } else {
                    request.setAttribute("user", "no");
                }
                status = "success";
            } catch (Exception e) {
                e.printStackTrace();
                status = "fail";
            }
            request.setAttribute("status", status);
            request.setAttribute("doc", doc);

            RequestDispatcher rd = request.getRequestDispatcher("ProjectviewDocument.jsp");

            rd.forward(request, response);
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
