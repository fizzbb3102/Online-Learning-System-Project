/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import dao.AccountDAO;
import dao.CourseListDAO;
import entity.Account;
import entity.CourseList;
import entity.CourseRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationListController extends HttpServlet {

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
            out.println("<title>Servlet RegistrationListController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationListController at " + request.getContextPath() + "</h1>");
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
        //Initialize DAO objects
        AccountDAO accountDb = new AccountDAO();
        CourseListDAO courseListDb = new CourseListDAO();

        Account currentUser = (Account) session.getAttribute("currentUser");
        String action = request.getParameter("action");
        
        int reg_id = 0;
        if (request.getParameter("rid") != null) {
            reg_id = Integer.parseInt(request.getParameter("rid"));
        }
        if (action != null) {
            switch (action) {
                case "approve":
                    courseListDb.changeRegistrationStatus(reg_id, 1, currentUser.getAid());
                    break;
                case "reject":
                    courseListDb.changeRegistrationStatus(reg_id, 2, currentUser.getAid());
                    break;
            }
        }
        
        //Search parameter
        String email = "";
        String fromDate = "";
        String toDate = "";
        int status = -1;
        int courseId = -1;
        
        if (request.getParameter("email") != null) {
            email = request.getParameter("email");
        }
        
        if (request.getParameter("fromDate") != null) {
            fromDate = request.getParameter("fromDate");
        }
        
        if (request.getParameter("toDate") != null) {
            toDate = request.getParameter("toDate");
        }
        
        if (request.getParameter("status") != null) {
            status = Integer.parseInt(request.getParameter("status"));
        }
        
        if (request.getParameter("courseId") != null) {
            courseId = Integer.parseInt(request.getParameter("courseId"));
        }
        
        
        int page = 1;
        int recordsPerPage = 6;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        //Get data to show
        ArrayList<CourseRegistration> registrationList = courseListDb.getRegistrationList((page-1)*recordsPerPage, recordsPerPage, email, courseId, status, fromDate, toDate);
        int numOfReg = courseListDb.getNumberOfRegistrations(email, courseId, status, fromDate, toDate);
        int numofPage = (int)Math.ceil(numOfReg*1.0/recordsPerPage);
        
        ArrayList<CourseList> courses = courseListDb.getAllCourseList();
        ArrayList<Account> accounts = accountDb.getAllAccounts();
        ArrayList<CourseRegistration> distinctCourseList = courseListDb.getAllRegisteredCourse();
        
        //send search paremeters
        request.setAttribute("email", email);
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        request.setAttribute("status", status);
        request.setAttribute("courseId", courseId);
        
        //send resources
        request.setAttribute("distinctCourseList", distinctCourseList);
        request.setAttribute("currentPage", page);
        request.setAttribute("numofPage", numofPage);
        request.setAttribute("courses", courses);
        request.setAttribute("list", registrationList);
        request.setAttribute("accounts", accounts);

        request.getRequestDispatcher("/Admin/registration_list.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Account currentUser = (Account) session.getAttribute("currentUser");
        String note = request.getParameter("note");
        String reg_id = request.getParameter("reg_id");
        
        CourseListDAO courseListDb = new CourseListDAO();
        courseListDb.updateRegistrationNote(Integer.parseInt(reg_id), note, 24);
        
        response.sendRedirect("registration_list");
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
