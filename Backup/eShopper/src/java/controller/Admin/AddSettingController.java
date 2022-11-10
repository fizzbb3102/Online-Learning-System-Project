/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import dao.SettingDAO;
import entity.SettingDetails;
import entity.SettingType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSettingController extends HttpServlet {

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
            out.println("<title>Servlet AddSettingController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSettingController at " + request.getContextPath() + "</h1>");
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
        //read file inside WEB-INF
        ArrayList<SettingType> typelist = Utils.Function.getTypesFromInputStream(this.getClass().getClassLoader().getResourceAsStream("../type.txt"));
        request.setAttribute("typelist", typelist);
        request.getRequestDispatcher("/Admin/add_setting.jsp").forward(request, response);
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
        try {
            int typeId = Integer.parseInt(request.getParameter("type"));
            String value = request.getParameter("value");
            String order = request.getParameter("order");
            String note = request.getParameter("note");
            Boolean status = Boolean.parseBoolean(request.getParameter("status"));
            
            SettingDetails sd = new SettingDetails();
            sd.setTypeId(typeId);
            sd.setValue(value);
            sd.setOrder(order);
            sd.setNote(note);
            sd.setStatus(status);
            
            SettingDAO settingDb = new SettingDAO();
            settingDb.addSetting(sd);
            response.sendRedirect("/WebApplication2/admin/setting/add?success=1");
        } catch (Exception e) {
            response.sendRedirect("/WebApplication2/admin/setting/add?success=0");
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
