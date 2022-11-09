/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AuthorDAO;
import dao.BlogCategoryDAO;
import dao.BlogDAO;
import entity.Author;
import entity.Blog;
import entity.BlogCategory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogSingleController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BlogDAO blogDAO = new BlogDAO();
        AuthorDAO authorDAO = new AuthorDAO();
        BlogCategoryDAO blogCategoryDAO = new BlogCategoryDAO();
        
        int id = Integer.parseInt(request.getParameter("id"));
        Blog blog = blogDAO.getBlogById(id);
        List<Blog> topFeatured = blogDAO.getTop5Blog();
        Author author = authorDAO.getAuthorById(blog.getAuthor_id());
        BlogCategory blogCategory = blogCategoryDAO.getBlogCateNameById(blog.getBlog_category_id());
        List<BlogCategory> blog_category = blogCategoryDAO.getAllBlogCates();
        request.setAttribute("blog_single", blog);
        request.setAttribute("author", author);
        request.setAttribute("post_content", blogCategory);
        request.setAttribute("blog_category_list", blog_category);
        request.setAttribute("topFeatured", topFeatured);
        request.getRequestDispatcher("blog_single.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
