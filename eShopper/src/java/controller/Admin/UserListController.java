/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import dao.AccountDAO;
import dao.PostDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController extends HttpServlet {

    private static final int PAGE_SIZE = 3;

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
            out.println("<title>Servlet UserListController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserListController at " + request.getContextPath() + "</h1>");
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
        AccountDAO dao = new AccountDAO();
        String pageIndexRaw = request.getParameter("pageIndex");
        String sortBy = request.getParameter("sortBy");
        //mac dinh sorrt theo full name
        sortBy = sortBy == null || sortBy.equals("") ? "fullname" : sortBy;
        String roleRaw = request.getParameter("role");
        int role = -1;
        try {
            role = Integer.parseInt(roleRaw);
        } catch (Exception e) {

        }
        String statusRaw = request.getParameter("status");

        int status = - 1;
        try {
            status = Integer.parseInt(statusRaw);
        } catch (Exception e) {

        }
        String search = request.getParameter("search");
        search = search == null ? "" : search;
        int pageIndex = 1;
        try {
            pageIndex = Integer.parseInt(pageIndexRaw);
        } catch (NumberFormatException e) {
        }
        List<Account> data = dao.getList(pageIndex, PAGE_SIZE, sortBy, search, role, status);
        request.setAttribute("data", data);
        List<Integer> paging = calculatePaging(search, role, status);
        request.setAttribute("paging", paging);
        request.setAttribute("pageIndex", pageIndex);
        setParam(request);
        request.setAttribute("role", role);
        request.getRequestDispatcher("user_list.jsp").forward(request, response);
    }

    private List<Integer> calculatePaging(String searchKeyWord, int role, int status) {
        List<Integer> result = new ArrayList<>();
        int total = new AccountDAO().countAccount(searchKeyWord, role, status);
        int index = 0;
        if (total <= PAGE_SIZE) {
            return result;
        }
        while (true) {
            result.add(++index);
            total = total - PAGE_SIZE;
            if (total <= 0) {
                break;
            }
        }
        return result;
    }

    //hàm này dùng để set lại các param truyền từ fontend về vào request để gửi lại lên fontend
    private void setParam(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        params.keySet().forEach((key) -> {
            request.setAttribute(key, params.get(key)[0]);
        });
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
