/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Admin.DasBoard;

import dao.AccountDAO;
import dao.CourseListDAO;
import entity.Account;
import entity.CourseList;
import entity.DateForPieChart;
import entity.OptionForPieChart;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PieChartController extends HttpServlet {

    AccountDAO accountDAO = new AccountDAO();
    CourseListDAO courseListDAO = new CourseListDAO();
    LocalDate today = LocalDate.now();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PieChartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PieChartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Account> pieDataListAccount = getAccountData("2022-01-01", today.plusDays(+1).toString());
        List<CourseList> pieDataListCourse = getCourseData("2022-01-01", today.plusDays(+1).toString());
        List<OptionForPieChart> listOption = listOption();
        List<DateForPieChart> listDate = listDate();

        String raw_oId = request.getParameter("optionId");
        if (raw_oId == null || raw_oId.length() == 0) {
            raw_oId = "1";
            List<Account> accountByDate = accountDAO.getAccountsByDate("2022-01-01", today.plusDays(+1).toString());
            request.setAttribute("detailsList", accountByDate);
        }
        int optionId = Integer.parseInt(raw_oId);

        String raw_dateId = request.getParameter("dateId");
        if (raw_dateId == null || raw_oId.length() == 0) {
            raw_dateId = "1";
        }
        int dateId = Integer.parseInt(raw_dateId);

        request.setAttribute("pieDataListCourse", pieDataListCourse);
        request.setAttribute("pieDataListAccount", pieDataListAccount);
        request.setAttribute("listOption", listOption);
        request.setAttribute("optionId", optionId);
        request.setAttribute("dateId", dateId);
        request.setAttribute("listDate", listDate);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/DashBoard/product-admin-master/dashBoard.jsp");
//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/DashBoard/chart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "details":
                details(request, response);
                break;
            case "date":
                date(request, response);
        }
    }

    private List<Account> getAccountData(String start, String end) {
        List<Account> list = new ArrayList<>();
        List<Account> accountList = accountDAO.getAllAccounts();
        List<Account> accountByDate = accountDAO.getAccountsByDate(start, end);

        Account all = new Account("All", accountList.size());
        list.add(all);

        Account getByDate = new Account("Account get by date", accountByDate.size());
        list.add(getByDate);

        return list;
    }

    private List<CourseList> getCourseData(String start, String end) {
        List<CourseList> list = new ArrayList<>();
        List<CourseList> courseList = courseListDAO.getAllCoursesList();
        List<CourseList> courseByDate = courseListDAO.getCourseListByDate(start, end);

        CourseList all = new CourseList("All", courseList.size());
        list.add(all);

        CourseList getByDate = new CourseList("Course get by date", courseByDate.size());
        list.add(getByDate);

        return list;
    }

    private List<OptionForPieChart> listOption() {
        List<OptionForPieChart> listOption = new ArrayList<>();
        OptionForPieChart account = new OptionForPieChart("Account", 1);
        listOption.add(account);
        OptionForPieChart course = new OptionForPieChart("Course", 2);
        listOption.add(course);
        return listOption;
    }

    private List<DateForPieChart> listDate() {
        List<DateForPieChart> listDate = new ArrayList<>();
        DateForPieChart allDate = new DateForPieChart("All Days", 1);
        listDate.add(allDate);
        DateForPieChart fourDays = new DateForPieChart("4 Days", 2);
        listDate.add(fourDays);
        DateForPieChart sevenDays = new DateForPieChart("7 Days", 3);
        listDate.add(sevenDays);
        return listDate;
    }

    private void details(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dateId = Integer.parseInt(request.getParameter("dateId"));
        String accountStart = "";
        String accountEnd = "";
        String courseStart = "";
        String courseEnd = "";
        if (dateId == 1) {
            accountStart = "2022-01-01";
            accountEnd = today.plusDays(+1).toString();
            courseStart = "2022-01-01";
            courseEnd = today.plusDays(+1).toString();
        } else if (dateId == 2) {
            accountStart = today.plusDays(-4).toString();
            accountEnd = today.plusDays(+1).toString();
            courseStart = today.plusDays(-4).toString();
            courseEnd = today.plusDays(+1).toString();
        } else {
            accountStart = today.plusDays(-7).toString();
            accountEnd = today.plusDays(+1).toString();
            courseStart = today.plusDays(-7).toString();
            courseEnd = today.plusDays(+1).toString();
        }
        int optionId = Integer.parseInt(request.getParameter("optionId"));
        if (optionId == 1) {
            List<Account> accountByDate = accountDAO.getAccountsByDate(accountStart, accountEnd);
            request.setAttribute("detailsList", accountByDate);
        } else {
            List<CourseList> courseByDate = courseListDAO.getCourseListByDate(courseStart, courseEnd);
            request.setAttribute("detailsList", courseByDate);
        }
        List<Account> pieDataListAccount = getAccountData(accountStart, accountEnd);
        List<CourseList> pieDataListCourse = getCourseData(courseStart, courseEnd);
        List<OptionForPieChart> listOption = listOption();
        List<DateForPieChart> listDate = listDate();

        request.setAttribute("pieDataListCourse", pieDataListCourse);
        request.setAttribute("pieDataListAccount", pieDataListAccount);
        request.setAttribute("listOption", listOption);
        request.setAttribute("optionId", optionId);
        request.setAttribute("dateId", dateId);
        request.setAttribute("listDate", listDate);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/DashBoard/product-admin-master/dashBoard.jsp");
//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/DashBoard/chart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void date(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dateId = Integer.parseInt(request.getParameter("dateId"));
        String accountStart = "";
        String accountEnd = "";
        String courseStart = "";
        String courseEnd = "";
        if (dateId == 1) {
            accountStart = "2022-01-01";
            accountEnd = today.plusDays(+1).toString();
            courseStart = "2022-01-01";
            courseEnd = today.plusDays(+1).toString();
        } else if (dateId == 2) {
            accountStart = today.plusDays(-4).toString();
            accountEnd = today.plusDays(+1).toString();
            courseStart = today.plusDays(-4).toString();
            courseEnd = today.plusDays(+1).toString();
        } else {
            accountStart = today.plusDays(-7).toString();
            accountEnd = today.plusDays(+1).toString();
            courseStart = today.plusDays(-7).toString();
            courseEnd = today.plusDays(+1).toString();
        }
        int optionId = Integer.parseInt(request.getParameter("optionId"));
        if (optionId == 1) {
            List<Account> accountByDate = accountDAO.getAccountsByDate(accountStart, accountEnd);
            request.setAttribute("detailsList", accountByDate);
        } else {
            List<CourseList> courseByDate = courseListDAO.getCourseListByDate(courseStart, courseEnd);
            request.setAttribute("detailsList", courseByDate);
        }
        List<Account> pieDataListAccount = getAccountData(accountStart, accountEnd);
        List<CourseList> pieDataListCourse = getCourseData(courseStart, courseEnd);
        List<OptionForPieChart> listOption = listOption();
        List<DateForPieChart> listDate = listDate();

        request.setAttribute("pieDataListCourse", pieDataListCourse);
        request.setAttribute("pieDataListAccount", pieDataListAccount);
        request.setAttribute("listOption", listOption);
        request.setAttribute("optionId", optionId);
        request.setAttribute("dateId", dateId);
        request.setAttribute("listDate", listDate);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/DashBoard/product-admin-master/dashBoard.jsp");
//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/DashBoard/chart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
