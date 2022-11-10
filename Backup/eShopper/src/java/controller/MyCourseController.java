/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClassListDAO;
import dao.CourseListDAO;
import entity.Account;
import entity.ClassList;
import entity.CourseList;
import entity.RegisteredCourse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyCourseController extends HttpServlet {

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
            out.println("<title>Servlet MyCourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyCourseController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account currentUser = (Account) session.getAttribute("currentUser");

        CourseListDAO clDb = new CourseListDAO();
        ClassListDAO classDb = new ClassListDAO();

        String search = "";
        int subjectId = 0;
        String fromDate = "";
        String toDate = "";

        if (request.getParameter("searchtxt") != null) {
            search = request.getParameter("searchtxt");
        }
        if (request.getParameter("subjectId") != null) {
            subjectId = Integer.parseInt(request.getParameter("subjectId"));
        }
        if (request.getParameter("fromDateSearch") != null) {
            fromDate = request.getParameter("fromDateSearch");
        }
        if (request.getParameter("toDateSearch") != null) {
            toDate = request.getParameter("toDateSearch");
        }
        
        int page = 1;
        int recordsPerPage = 6;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        int numOfReg = clDb.getNumberOfRegisteredCourse(currentUser.getAid(), search, subjectId, fromDate, toDate);
        int numOfPage = (int)Math.ceil(numOfReg*1.0/recordsPerPage);

        ArrayList<ClassList> classes = classDb.getAllClass();
        ArrayList<CourseList> courses = clDb.getAllCourseList();
        ArrayList<RegisteredCourse> registered_courses = clDb.getMyCourseList(currentUser.getAid(), search, subjectId, fromDate, toDate, (page-1)*recordsPerPage, recordsPerPage);
        List<CourseList> top5Features = clDb.get5Features();
        ArrayList<RegisteredCourse> subjectList = clDb.getCourseSubjectByAccountId(currentUser.getAid());
        
        
        
        //send search parameters
        request.setAttribute("search", search);
        request.setAttribute("subjectId", subjectId);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        
        //send pagination resources
        request.setAttribute("currentPage", page);
        request.setAttribute("numOfPage", numOfPage);
        
        //send resources
        request.setAttribute("top5Features", top5Features);
        request.setAttribute("classes", classes);
        request.setAttribute("courses", courses);
        request.setAttribute("reg_courses", registered_courses);
        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("my_course.jsp").forward(request, response);
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
        String search = "";
        int subjectId = 0;
        String fromDate = "";
        String toDate = "";

        if (request.getParameter("searchtxt") != null) {
            search = request.getParameter("searchtxt");
        }
        if (request.getParameter("subjectId") != null) {
            subjectId = Integer.parseInt(request.getParameter("subjectId"));
        }
        if (request.getParameter("fromDateSearch") != null) {
            fromDate = request.getParameter("fromDateSearch");
        }
        if (request.getParameter("toDateSearch") != null) {
            toDate = request.getParameter("toDateSearch");
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
