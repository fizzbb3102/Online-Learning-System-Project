/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ClassDetaiDAO;
import dao.ClassListDAO;
import entity.ClassList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditClassController extends HttpServlet {

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
        ClassDetaiDAO classDetailDAO = new ClassDetaiDAO();
        String cid = request.getParameter("id");
        String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");
        String status = request.getParameter("status");
        ClassListDAO classlistDAO = new ClassListDAO();
        List<ClassList> listClass = classlistDAO.getAllClass();
        for (ClassList listClas : listClass) {
            if (listClas.getName().equalsIgnoreCase(name)) {
                int id = Integer.parseInt(request.getParameter("id"));
                ClassList getClassByDetail = classDetailDAO.getClassDetailByID(id);
                request.setAttribute("getClassByDetail", getClassByDetail);
                request.setAttribute("mess", "abc");
                request.getRequestDispatcher("ClassDetail.jsp").forward(request, response);
                return;
            }
        }
        classDetailDAO.editClassDetail(cid, name, teacher, status);
        response.sendRedirect("ClassListController");

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
