/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import dao.CategoryDAO;
import dao.PostDAO;
import entity.Category;
import entity.Post;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class PostDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = getIntegerParam(request, "id");
        if (id == -1) {
            response.sendRedirect("../posts");
            return;
        }
        Post data = new PostDAO().findById(id);
        if (data == null) {
            response.sendRedirect("../posts");
            return;
        }
        CategoryDAO cateDao = new CategoryDAO();
        List<Category> categoryList = cateDao.getAll();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("data", data);
        request.getRequestDispatcher("/Admin/post_detail.jsp").forward(request, response);
    }

    private int getIntegerParam(HttpServletRequest request, String paramName) {
        String rawVal = request.getParameter(paramName);
        try {
            return Integer.parseInt(rawVal);
        } catch (NumberFormatException e) {
            return - 1;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = getIntegerParam(request, "id");
        if (id == -1) {
            response.sendRedirect("../posts");
            return;
        }
        Post data = new PostDAO().findById(id);
        if (data == null) {
            response.sendRedirect("../posts");
            return;
        }

        String title = request.getParameter("title");
        int cateId = getIntegerParam(request, "cateId");
        String brief = request.getParameter("brief");
        String content = request.getParameter("content");
        String featured = request.getParameter("featured");
        String status = request.getParameter("status");
        featured = (featured == null || !featured.equals("on")) ? "no" : "yes";
        String thumbnail = uploadFile(request);
        data.getCategory().setId(cateId);
        data.setTitle(title);
        data.setBriefInfor(brief);
        data.setContent(content);
        data.setStatus(status);
        data.setFeatured(featured);
        data.setThumbnail(thumbnail);
        new PostDAO().update(data);
        response.sendRedirect("../posts");
    }
    private static final String UPLOAD_DIR = "images";

    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("thumbnail");
            fileName = (String) getFileName(filePart);
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }

        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
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
