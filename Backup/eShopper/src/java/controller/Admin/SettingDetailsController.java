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

public class SettingDetailsController extends HttpServlet {

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
            out.println("<title>Servlet SettingDetailsController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingDetailsController at " + request.getContextPath() + "</h1>");
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
        //get setting id from url
        String settingId = request.getParameter("sid");
        if (settingId != null) {
            int sid = Integer.parseInt(settingId);
            SettingDAO sdb = new SettingDAO();
            SettingDetails sd = sdb.getSetting(sid);

            //read file inside WEB-INF
            ArrayList<SettingType> typelist = Utils.Function.getTypesFromInputStream(this.getClass().getClassLoader().getResourceAsStream("../../META-INF/type.txt"));

            request.setAttribute("setting", sd);
            request.setAttribute("typelist", typelist);
            request.getRequestDispatcher("/Admin/setting_details.jsp").forward(request, response);
        } else {
            response.sendRedirect("/WebApplication2/admin/");
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
        //get setting id from url
        String settingId = request.getParameter("sid");
        if (settingId != null) {
            int typeId = Integer.parseInt(request.getParameter("type"));
            String value = request.getParameter("value");
            String order = request.getParameter("order");
            String note = request.getParameter("note");
            Boolean status = Boolean.parseBoolean(request.getParameter("status"));
            
            
            int sid = Integer.parseInt(settingId);
            SettingDAO sdb = new SettingDAO();
            SettingDetails sd = sdb.getSetting(sid);
            sd.setTypeId(typeId);
            sd.setValue(value);
            sd.setOrder(order);
            sd.setNote(note);
            sd.setStatus(status);
            
            sdb.updateSetting(sd);
            response.sendRedirect("/WebApplication2/admin/setting/details?sid=" + sid +"&success=1");
        } else {    
            response.sendRedirect("/WebApplication2/admin");
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
