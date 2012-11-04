/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.ProjectLicense;
import Repo.model.Projectmaster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author meherzad
 */
public class ServletGetLicense extends HttpServlet {

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
            out.println("<title>Servlet ServletGetLicense</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletGetLicense at " + request.getContextPath() + "</h1>");
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
        int type = Integer.parseInt(request.getParameter("type"));
        int licId, projId;
        //System.out.println(licId);
        ProjectLicense lc = null;
        Projectmaster project = new Projectmaster();
        DatabaseManager dm = new DatabaseManager();
        JSONObject json = new JSONObject();
        try {

            if (type == 1) {
                licId = Integer.parseInt(request.getParameter("licenseId"));
                lc = dm.getLicense(licId);
                if (lc == null) {
                    json.put("status", "fail");

                } else {
                    json.put("status", "success");
                    json.put("licId", lc.getLicenseId());
                    json.put("licName", lc.getLicenseName());
                    json.put("desc", lc.getLicenseDesc());
                }
            } else if (type == 2) {
                licId = Integer.parseInt(request.getParameter("licenseId"));
                projId = Integer.parseInt(request.getParameter("projId"));
                project.setLicenseId(licId);
                project.setProjId(projId);
                if (dm.setLicense(project)) {
                    json.put("status", "success");
                } else {
                    json.put("status", "fail");
                }
            } else {
                projId = Integer.parseInt(request.getParameter("projId"));
                lc = dm.getProjectLicense(projId);
                if (lc == null) {
                    json.put("status", "fail");
                } else {
                    json.put("status", "success");
                    json.put("licenseId", lc.getLicenseId());
                    json.put("licenseName", lc.getLicenseName());
                    json.put("licenseDesc", lc.getLicenseDesc());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(lc);
        PrintWriter out = response.getWriter();
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
