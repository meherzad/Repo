/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.controller;

import Repo.model.DatabaseManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author meherzad
 */
public class ServletProjectImage extends HttpServlet {

    private File tmpDir;
    private File destinationDir;
    String name, pic;

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
            out.println("<title>Servlet ServletProjectImage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProjectImage at " + request.getContextPath() + "</h1>");
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
        try {
            String username;//Username_userid from session.........
            Integer userId = null;
            String TMP_DIR_PATH = getServletContext().getRealPath("/") + "Temp";
            tmpDir = new File(TMP_DIR_PATH);
            if (!tmpDir.isDirectory()) {
                throw new ServletException(TMP_DIR_PATH + " is not a directory");
            }
            String DESTINATION_DIR_PATH = getServletContext().getRealPath("/") + "images/projPic";
            String realPath = DESTINATION_DIR_PATH;
            destinationDir = new File(realPath);
            if (!destinationDir.isDirectory()) {
                throw new ServletException(DESTINATION_DIR_PATH + " is not a directory");
            }
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            fileItemFactory.setSizeThreshold(1 * 1024 * 1024); // 1 MB
            fileItemFactory.setRepository(tmpDir);
            ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
            List items = uploadHandler.parseRequest(request);
            Iterator itr;
            itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                    if (name.equals("hiddenProjId")) {
                        userId = Integer.parseInt(value);
                    }
                }
            }
            Iterator itr1 = items.iterator();
            while (itr1.hasNext()) {
                FileItem item = (FileItem) itr1.next();
                pic = name = item.getName();
                System.out.print("######" + pic);
                if (!item.isFormField()) {
                    int ind = pic.indexOf('.');
                    String ext = pic.substring(ind);
                    File file = new File(destinationDir, userId.toString() + ext);
                    item.write(file);
                    db.updateprojectimage(userId, userId.toString() + ext);
                    response.sendRedirect("projectEditDetail.html?projId=" + userId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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
