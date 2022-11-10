/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin.Class;

import dao.ClassDAO;
import dao.CourseListDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import entity.Class;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassDetailsController extends HttpServlet {

    ClassDAO classDAO = new ClassDAO();
    CourseListDAO courseListDAO = new CourseListDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClassDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassDetailsController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if (action == null) {
            defaultList(request, response);
        } else {
            switch (action) {
                case "editGet":
                    editGet(request, response);
                    break;
                case "addGet":
                    addGet(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
            }
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
        String action = request.getParameter("action");
        switch (action) {
            case "editPost":
                editPost(request, response);
                break;
            case "addPost":
                addPost(request, response);
                break;
        }
    }

    private void defaultList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Class> classList = classDAO.getAllClass();
        request.setAttribute("classList", classList);
        request.getRequestDispatcher("ClassList.jsp").forward(request, response);
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Class classs = classDAO.getClassById(id);
        request.setAttribute("classGetById", classs);
        request.getRequestDispatcher("/Admin/ClassSetting/edit.jsp").forward(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");
        String note = request.getParameter("note");
        String status = request.getParameter("option");
        Class newClass = new Class(id, name, teacher, status, note);
        classDAO.updateClass(newClass);
        response.sendRedirect("class_detail_controller");
    }

    private void addGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Admin/ClassSetting/add.jsp").forward(request, response);
    }

    private void addPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");
        String note = request.getParameter("note");
        String status = request.getParameter("option");
        Class newClass = new Class(name, teacher, status, note);
        classDAO.addClass(newClass);
        response.sendRedirect("class_detail_controller");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseListDAO.deleteRegisteredCourseByClassId(id);
        classDAO.deleteClass(id);
        response.sendRedirect("class_detail_controller");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
