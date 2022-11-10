/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dao.LessonDetailDAO;
import entity.Lesson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditLessonDetailController extends HttpServlet {

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
            LessonDetailDAO lessonDetailDAO = new LessonDetailDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            Lesson getLessonByDetail = lessonDetailDAO.getLessonDetailByID(id);
            request.setAttribute("getLessonByDetail", getLessonByDetail);
            request.getRequestDispatcher("/Admin/EditLessonDetail.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("Title");
        String type = request.getParameter("Type");
        boolean myCheckBox = request.getParameter("Type") != null;
        if(myCheckBox){
            type="true";
        }else{
            type="false";
        }
        String topic = request.getParameter("Topic");
        String order = request.getParameter("Order");
        String status = request.getParameter("Status");
        String link = request.getParameter("Link");
        String content = request.getParameter("Content");
        LessonDetailDAO lessonDetailDAO = new LessonDetailDAO();
        lessonDetailDAO.editLessonDetail(id, title, type, topic, order, status, link, content);
        response.sendRedirect("LessonDetailController?id="+id);
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
