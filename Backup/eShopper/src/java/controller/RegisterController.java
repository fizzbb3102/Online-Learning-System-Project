/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegisterDAO;
import entity.Account;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterController", urlPatterns = {"/register_controller"})
public class RegisterController extends HttpServlet {

    DateTimeFormatter fmt = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd")
            .optionalStart()
            .appendPattern(" HH:mm")
            .optionalEnd()
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .toFormatter();

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
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        RegisterDAO dao = new RegisterDAO();
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String repass = request.getParameter("repass");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String title = request.getParameter("title");
        String dob = request.getParameter("dob");
        if (!pass.equals(repass)) {
            response.sendRedirect("register.jsp");
        } else {
            Account a = dao.checkAccountExist(email);
            if (a == null) {
                Account newAccount = new Account();
                newAccount.setFullname(name);
                newAccount.setEmail(email);
                newAccount.setPassword(pass);
                newAccount.setPhone(Integer.parseInt(phone));
                newAccount.setGender(Integer.parseInt(gender));
                if (gender.equals("1")) {
                    newAccount.setUser_title("Mr");
                } else if(gender.equals("0")){
                    newAccount.setUser_title("Mrs");
                }
                newAccount.setDob(LocalDateTime.parse(dob, fmt));
                dao.register(newAccount);
                response.sendRedirect("list_home_controller");
            } else {
                response.sendRedirect("register.jsp");
            }
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
