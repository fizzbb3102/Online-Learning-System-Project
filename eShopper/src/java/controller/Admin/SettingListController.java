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
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SettingListController extends HttpServlet {

    private static final int PAGE_SIZE = 4;

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
        int type = getType(request);
        String orderBy = getOrderByParam(request);
        String searchKeyword = request.getParameter("search");
        if (searchKeyword == null) {
            searchKeyword = "";
        }
        //mac dinh la 1
        int pageIndex = getPageIndex(request);
        List<Integer> paging = calculatePaging(searchKeyword, type);
        //khi page index lớn hơn tổng số page. (nút >> bên fontend ) thì quay lại trang 1
        if (pageIndex > paging.size()) {
            pageIndex = 1;
            //khi page index <= 0. (nút << bên fontend ) thì đi tới trang cuối cùng
        } else if (pageIndex <= 0) {
            pageIndex = paging.size();
        }

        List<SettingDetails> data = new SettingDAO().getSettingList(pageIndex, PAGE_SIZE, orderBy, searchKeyword, type);
        //set parameter nguoc la vao request
        setParam(request);
        request.setAttribute("data", data);
        //read file inside WEB-INF
        ArrayList<SettingType> typelist = Utils.Function.getTypesFromInputStream(this.getClass().getClassLoader().getResourceAsStream("../../META-INF/type.txt"));
        request.setAttribute("typelist", typelist);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("paging", paging);
        request.getRequestDispatcher("/Admin/setting_list.jsp").forward(request, response);
    }

    private String getOrderByParam(HttpServletRequest request) {
        String orderBy = request.getParameter("orderBy");
        //mac dinh se sap xep theo settingId
        if (orderBy == null || orderBy.equals("")) {
            return "settingId";
        }
        return orderBy;
    }

    private int getPageIndex(HttpServletRequest request) {
        String pageIndexRaw = request.getParameter("pageIndex");
        try {
            return Integer.parseInt(pageIndexRaw);
        } catch (NumberFormatException e) {

        }
        return 1;
    }

    private int getType(HttpServletRequest request) {
        String typeRaw = request.getParameter("typeId");
        try {
            return Integer.parseInt(typeRaw);
        } catch (NumberFormatException e) {

        }
        return -1;
    }

    //hàm này dùng để set lại các param truyền từ fontend về vào request để gửi lại lên fontend
    private void setParam(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        params.keySet().forEach((key) -> {
            request.setAttribute(key, params.get(key)[0]);
        });
    }

    private List<Integer> calculatePaging(String searchKeyWord, int typeId) {
        List<Integer> result = new ArrayList<>();
        int total = new SettingDAO().countSetting(searchKeyWord, typeId);
        int index = 0;
        //ví dụ total = 10 & page size = 10 => có 1 trang thôi thì k cần hiện ra phân trang
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
