/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CourseListDAO;
import entity.CourseList;
import entity.SettingDetails;
import java.io.IOException;
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
@WebServlet(name = "CourseListController", urlPatterns = {"/CourseListController"})
public class CourseListController extends HttpServlet {

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
        try {
            String txtSearch = request.getParameter("txtSearch");
            CourseListDAO courselistDAO = new CourseListDAO();
            List<SettingDetails> listCategory = courselistDAO.getCategory();
            request.setAttribute("listCategory", listCategory);
            int numberOfRecord = 0;
            if (txtSearch == null || txtSearch.trim().isEmpty()) {
                numberOfRecord = courselistDAO.getNumberOfCourseList();
            } else {
                numberOfRecord = courselistDAO.getNumberOfSearch(txtSearch);
            }
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int endP = numberOfRecord / 8;
            if (numberOfRecord % 8 != 0) {
                endP++;
            }
            List<CourseList> listSearchPaging = new ArrayList();
            if (txtSearch == null || txtSearch.trim().isEmpty()) {
                listSearchPaging = courselistDAO.pagingCourseList(index);
            } else {
                listSearchPaging = courselistDAO.pagingSearch(txtSearch, index);
                request.setAttribute("txtSearch", txtSearch);
            }
            if (request.getParameter("id") != null) {
                int categoryID = Integer.parseInt(request.getParameter("id"));
                List<CourseList> getCourseByCategoryID = courselistDAO.getCourseListByCateID(categoryID);
                request.setAttribute("listPaging", getCourseByCategoryID);
                List<CourseList> top5Features = courselistDAO.get5Features();
                request.setAttribute("top5Features", top5Features);
                String subject = request.getParameter("subject");
                request.setAttribute("select", subject);
                request.getRequestDispatcher("CourseList.jsp").forward(request, response);
            }
            request.setAttribute("listPaging", listSearchPaging);
            request.setAttribute("endPage", endP);
            request.setAttribute("active", index);
            List<CourseList> top5Features = courselistDAO.get5Features();
            request.setAttribute("top5Features", top5Features);
            request.setAttribute("select", "Subject");
            request.getRequestDispatcher("CourseList.jsp").forward(request, response);
        } catch (Exception e) {
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
