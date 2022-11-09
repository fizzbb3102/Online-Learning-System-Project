/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.PostDAO;
import entity.Account;
import entity.Category;
import entity.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostListController extends HttpServlet {

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
        request.getRequestDispatcher("../Admin/post.jsp").forward(request, response);
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
        int cateId = getIntegerParam(request, "cateId");
        String status = request.getParameter("status");
        status = (status == null || status.equals("")) ? null : status;
        int authorId = getIntegerParam(request, "authorId");
        String sortBy = request.getParameter("sortBy");
        sortBy = (sortBy == null ? "" : sortBy);
        String keyword = request.getParameter("search");
        keyword = (keyword == null ? "" : keyword);

        CategoryDAO cateDao = new CategoryDAO();
        List<Category> categoryList = cateDao.getAll();
        request.setAttribute("categoryList", categoryList);

        List<Account> authorList = new AccountDAO().getAuthorInPost();
        request.setAttribute("authorList", authorList);
        //mac dinh la 1
        int pageIndex = getPageIndex(request);
        List<Integer> paging = calculatePaging(keyword, authorId, cateId, status);
        request.setAttribute("paging", paging);
        request.setAttribute("pageIndex", pageIndex);
        List<Post> data = new PostDAO().getPostList(pageIndex, PAGE_SIZE, sortBy, keyword, authorId, cateId, status);
        request.setAttribute("data", data);
        setParam(request);
        request.getRequestDispatcher("../Admin/post.jsp").forward(request, response);
    }

    private int getIntegerParam(HttpServletRequest request, String paramName) {
        String rawVal = request.getParameter(paramName);
        try {
            return Integer.parseInt(rawVal);
        } catch (NumberFormatException e) {
            return - 1;
        }
    }

    //hàm này dùng để set lại các param truyền từ fontend về vào request để gửi lại lên fontend
    private void setParam(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        params.keySet().forEach((key) -> {
            request.setAttribute(key, params.get(key)[0]);
        });
    }

    private int getPageIndex(HttpServletRequest request) {
        String pageIndexRaw = request.getParameter("pageIndex");
        try {
            return Integer.parseInt(pageIndexRaw);
        } catch (NumberFormatException e) {

        }
        return 1;
    }

    private List<Integer> calculatePaging(String searchKeyWord, int authorId, int cateId, String status) {
        List<Integer> result = new ArrayList<>();
        int total = new PostDAO().countPost(searchKeyWord, authorId, cateId, status);
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
