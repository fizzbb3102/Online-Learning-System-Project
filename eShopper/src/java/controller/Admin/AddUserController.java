/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import Utils.Function;
import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserController extends HttpServlet {

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
            out.println("<title>Servlet AddUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUserController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("/Admin/add_user.jsp").forward(request, response);
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
        AccountDAO dao = new AccountDAO();
        Account a = new Account();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("pass");
        String statusRaw = request.getParameter("status");
        String roleRaw = request.getParameter("role");
        a.setRole_id(Integer.parseInt(roleRaw));
        a.setEnabled(Integer.parseInt(statusRaw));
        a.setEmail(email);
        a.setPassword(password);
        a.setPhone(Integer.parseInt(phone));
        a.setFullname(fullname);
        if (email != null && !email.equals("")) {
            if (dao.isExistEmail(email)) {
                request.setAttribute("message", "Email existed");
                request.getRequestDispatcher("/Admin/add_user.jsp").forward(request, response);
                return;
            }
        }
        int inserted = dao.insert(a);
        if (inserted == 1) {

            String loginUrl = request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login_controller";
            String subject = "eShopper Notification";
            String content = "<p>Hi " + a.getFullname() + ",<p><br>"
                    + "<p>We created an account for you.</p><br>"
                    + "<p>This is your password <b>" + a.getPassword() + "<b></p><br>"
                    + "<p>Visit:" + loginUrl + "</p>";
            Function.sendEmail(a.getEmail(), subject, content);
        }
        response.sendRedirect(request.getContextPath() + "/admin/user");
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
