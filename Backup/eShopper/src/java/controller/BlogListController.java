/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BlogCategoryDAO;
import dao.BlogDAO;
import entity.Blog;
import entity.BlogCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogListController extends HttpServlet {

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
        processRequest(request, response);
        BlogDAO blogDAO = new BlogDAO();
        BlogCategoryDAO blogCategoryDAO = new BlogCategoryDAO();

        List<Blog> blog_list = new ArrayList<>();
        int endPage = 0;
        int count = 0;
        String cateId = request.getParameter("id");
        String index = request.getParameter("index");

        if (cateId == null) {
            count = blogDAO.countBLogs();
        } else {
            count = blogDAO.countBLogByCateId(Integer.parseInt(cateId));
        }
        endPage = count / 4;
        if (count % 4 != 0) {
            endPage++;
        }
        if (index == null && cateId == null) {
            index = "1";
        }
        if (index != null && cateId == null || cateId.trim().isEmpty()) {
            blog_list = blogDAO.pagingBlog(Integer.parseInt(index));
        }
        if (index == null && cateId != null) {
            index = "1";
            blog_list = blogDAO.pagingBlogByCateId(Integer.parseInt(cateId), 1);
            request.setAttribute("cateId", cateId);
        }
        if (index != null && cateId != null && !cateId.trim().isEmpty()) {
            blog_list = blogDAO.pagingBlogByCateId(Integer.parseInt(cateId), Integer.parseInt(index));
        }
        List<Blog> topFeatured = blogDAO.getTop5Blog();
        request.setAttribute("topFeatured", topFeatured);
        request.setAttribute("blog_list", blog_list);
        List<BlogCategory> blog_category_list = blogCategoryDAO.getAllBlogCates();
        request.setAttribute("blog_category_list", blog_category_list);
        request.setAttribute("endPage", endPage);
        request.getRequestDispatcher("blog.jsp").forward(request, response);
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
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        BlogDAO blogDAO = new BlogDAO();
        BlogCategoryDAO blogCategoryDAO = new BlogCategoryDAO();
        List<Blog> topFeatured = blogDAO.getTop5Blog();
        String text = request.getParameter("text");

        List<Blog> blog_list = blogDAO.getBlogByTitle(text);
        if (blog_list.isEmpty()) {
            blog_list = blogDAO.getAllBlogs();
        }
        request.setAttribute("blog_list", blog_list);

        List<BlogCategory> blog_category_list = blogCategoryDAO.getAllBlogCates();
        request.setAttribute("blog_category_list", blog_category_list);
        request.setAttribute("topFeatured", topFeatured);
        request.getRequestDispatcher("blog.jsp").forward(request, response);
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
