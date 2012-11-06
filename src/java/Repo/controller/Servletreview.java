/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import Repo.model.Downloadreview;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Servletreview extends HttpServlet {

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
            out.println("<title>Servlet Servletreview</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servletreview at " + request.getContextPath() + "</h1>");
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
        DatabaseManager db = new DatabaseManager();
        String drop = request.getParameter("drop");
        String review = request.getParameter("review");
        String type = request.getParameter("type");
        String resp;
        JSONObject result = new JSONObject();
        int projId = Integer.parseInt(request.getParameter("projId"));
        HttpSession session = request.getSession(true);
        Object obj = request.getAttribute("userId");
        Integer userId=null;//= 1;//null;//get user from session
        if (obj != null) {
            userId = Integer.parseInt(obj.toString());
        }
        Downloadreview re = new Downloadreview();
        if (type.equals("review")) {
            if (!review.equals("") && !drop.equals("")) {
                re.setProjId(projId);
                re.setRate(Integer.parseInt(drop));
                re.setReview(review);
                re.setUserId(userId);
                re.setTime(new Date());
                db.updatedreview(re);
            }
        } else if (type.equals("loadreview")) {
            try {
                ArrayList<Downloadreview> reviews = db.getdownloadreviews(projId);
                ArrayList<Downloadreview> project = db.download_project(projId);
                JSONArray jArray = new JSONArray();
                JSONObject task = null;
                for (Downloadreview re1 : reviews) {
                    task = new JSONObject();
                    DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
                    String today = formatter.format(re1.getTime());
                    task.put("username", re1.getUsername());
                    task.put("reviewId", re1.getReviewId());
                    task.put("projId", re1.getProjId());
                    task.put("userId", re1.getUserId());
                    task.put("review", re1.getReview());
                    task.put("rate", re1.getRate());
                    task.put("time", today.toString());
                    if (userId != null) {
                        result.put("checkUser", "login");
                    } else {
                        result.put("checkUser", "notlogin");

                    }
                    jArray.add(task);
                }
                result.put("reviews", jArray);
                JSONArray jArray2 = new JSONArray();

                for (Downloadreview re2 : project) {
                    task = new JSONObject();
                    task.put("projName", re2.getProjName());
                    task.put("downloads", re2.getDownloads());
                    task.put("Rating", re2.getRating());
                    task.put("Reviewed", re2.getReviewd());

                    if (userId != null) {
                        result.put("checkUser", "login");
                    } else {
                        result.put("checkUser", "notlogin");

                    }
                    jArray2.add(task);
                }
                result.put("project", jArray2);
                System.out.println("-------------->" + result);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(result);
                

            } catch (Exception e) {
                e.printStackTrace();
            }
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
