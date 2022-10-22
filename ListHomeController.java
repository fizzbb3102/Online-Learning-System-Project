/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AuthorDAO;
import dao.BlogDAO;
import dao.CategoryDAO;
import dao.CourseListDAO;
import dao.SlideDAO;
import entity.Author;
import entity.Blog;
import entity.Category;
import entity.CourseList;
import entity.Slide;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ListHomeController", urlPatterns = {"/list_home_controller"})
public class ListHomeController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        CourseListDAO courseListDAO = new CourseListDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        SlideDAO slideDAO = new SlideDAO();
        BlogDAO blogDAO = new BlogDAO();
        List<CourseList> courseList = courseListDAO.getTop1CourseEachCate();
        List<CourseList> top1_list = new ArrayList<>();
        for (CourseList id : courseList) {
            CourseList course = courseListDAO.getCourseById(id.getId());
            top1_list.add(course);
        }
        List<CourseList> topFeatured = courseListDAO.get5Features();
        List<Category> categories = categoryDAO.getAllCategories();
        List<Slide> slides = slideDAO.getAllSlides();
        List<Blog> blogs = blogDAO.getAllBlogs();
        request.setAttribute("blogs", blogs);
        request.setAttribute("slides", slides);
        request.setAttribute("categories", categories);
        request.setAttribute("top1_course", top1_list);
        request.setAttribute("topFeatured", topFeatured);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
