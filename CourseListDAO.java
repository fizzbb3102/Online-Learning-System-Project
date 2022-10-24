/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.CourseList;
import entity.CourseRegistration;
import entity.RegisteredCourse;
import entity.SettingDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ductd
 */
public class CourseListDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Query query = new Query();
    String sql = null;
    public ArrayList<CourseList> get5Features() {
        ArrayList<CourseList> list = new ArrayList<>();
        String query = this.query.get5Features;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CourseList clist = new CourseList(
                        rs.getInt("courseid"), 
                        rs.getString("title"), 
                        rs.getString("author"), 
                        rs.getInt("ratedstar"), 
                        rs.getString("listprice"), 
                        rs.getString("saleprice"), 
                        rs.getString("thumbnail"), 
                        rs.getString("updatedDate"), 
                        rs.getInt("category"),
                        rs.getString("briefinfor"),
                        rs.getString("featuredflag"),
                        rs.getString("introduction"),
                        rs.getString("status"));
                list.add(clist);
            }

        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<CourseList> getAllCourseList() {
        ArrayList<CourseList> list = new ArrayList<>();
        String query = "select * from courselist";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CourseList clist = new CourseList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)
                );
                list.add(clist);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public int getNumberOfCourseList() {
        String query = this.query.getNumberOfCourseList;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<CourseList> pagingCourseList(int index) {
        List<CourseList> clist = new ArrayList<>();
        String query = this.query.pagingCourseList;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                clist.add(new CourseList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));

            }
        } catch (Exception e) {

        }
        return clist;
    }

    public int getNumberOfSearch(String txtSearch) {
        try {
            String query = this.query.getNumberOfCourseList;
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<CourseList> pagingSearch(String txtSearch, int index) {
        List<CourseList> clist = new ArrayList<>();
        String query = this.query.pagingSearch;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, (index - 1) * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                clist.add(new CourseList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));

            }
        } catch (Exception e) {

        }
        return clist;
    }

//    public ArrayList<CourseList> getAllCourseList() {
//        String GET_COURSE_LIST = "SELECT * FROM swp391.courselist;";
//
//        ArrayList<CourseList> result = new ArrayList<>();
//
//        try (Connection connection = new DBContext().getConnection();
//                // Step 2:Create a statement using connection object
//                PreparedStatement preparedStatement = connection.prepareStatement(GET_COURSE_LIST)) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                CourseList cl = new CourseList();
//                cl.setId(rs.getInt("courseid"));
//                cl.setTitle(rs.getString("title"));
//                cl.setAuthor(rs.getString("author"));
//                cl.setRatedStar(rs.getInt("ratedstar"));
//                cl.setListPrice(rs.getString("listprice"));
//                cl.setSalePrice(rs.getString("saleprice"));
//                cl.setThumbnail(rs.getString("thumbnail"));
//                cl.setUpdatedDate(rs.getTimestamp("updatedDate").toString());
//                result.add(cl);
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }

    public ArrayList<CourseList> getCourseListByTitle(String title) {
        String GET_COURSE_LIST_BY_TITLE = "SELECT * FROM swp391.courselist WHERE title LIKE ?;";
        ArrayList<CourseList> result = new ArrayList<>();

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_COURSE_LIST_BY_TITLE)) {
            preparedStatement.setString(1, "%" + title + "%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CourseList cl = new CourseList();
                cl.setId(rs.getInt("courseid"));
                cl.setTitle(rs.getString("title"));
                cl.setAuthor(rs.getString("author"));
                cl.setRatedStar(rs.getInt("ratedstar"));
                cl.setListPrice(rs.getString("listprice"));
                cl.setSalePrice(rs.getString("saleprice"));
                cl.setThumbnail(rs.getString("thumbnail"));
                cl.setUpdatedDate(rs.getTimestamp("updatedDate").toString());
                result.add(cl);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<SettingDetails> getCategory() {
        List<SettingDetails> list = new ArrayList<>();
        String query = "select * from setting_details";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SettingDetails(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getTimestamp(7).toLocalDateTime(),
                        rs.getTimestamp(8).toLocalDateTime()
                ));

            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<CourseList> getCourseListByCateID(int id) {
        List<CourseList> list = new ArrayList<>();
        String query = "select * from courselist where category = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CourseList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<CourseRegistration> getRegistrationList(int offset, int numOfRecords, String email, int courseId, int status, String fromDate, String toDate) {
        String GET_REGISTRATION_LIST = "SELECT * FROM swp391.registration_list WHERE 1";

        if (!email.isEmpty()) {
            AccountDAO accountDb = new AccountDAO();
            ArrayList<Account> accountList = accountDb.getAccountListByEmail(email);
            GET_REGISTRATION_LIST += " AND account_id IN (#aid#)";
            String aid = "";
            for (Account a : accountList) {
                aid += "'" + a.getAid() + "',";
            }
            if (!accountList.isEmpty()) {
                aid = aid.substring(0, aid.length() - 1);
            }

            GET_REGISTRATION_LIST = GET_REGISTRATION_LIST.replaceAll("#aid#", aid);
        }

        if (courseId > 0) {
            GET_REGISTRATION_LIST += " AND course_id = #cid#";
            GET_REGISTRATION_LIST = GET_REGISTRATION_LIST.replaceAll("#cid#", String.valueOf(courseId));
        }

        if (status >= 0) {
            GET_REGISTRATION_LIST += " AND status = #status#";
            GET_REGISTRATION_LIST = GET_REGISTRATION_LIST.replaceAll("#status#", String.valueOf(status));
        }

        if (!fromDate.isEmpty()) {
            GET_REGISTRATION_LIST += " AND registration_time >= '#from#'";
            GET_REGISTRATION_LIST = GET_REGISTRATION_LIST.replace("#from#", fromDate);
        }

        if (!toDate.isEmpty()) {
            GET_REGISTRATION_LIST += " AND registration_time <= '#to#'";
            GET_REGISTRATION_LIST = GET_REGISTRATION_LIST.replace("#to#", toDate);
        }

        GET_REGISTRATION_LIST += " limit " + offset + "," + numOfRecords + ";";
        ArrayList<CourseRegistration> result = new ArrayList<>();

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_REGISTRATION_LIST)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CourseRegistration cr = new CourseRegistration();
                cr.setId(rs.getInt("id"));
                cr.setAccount_id(rs.getInt("account_id"));
                cr.setRegistration_time(rs.getTimestamp("registration_time").toLocalDateTime());
                cr.setCourse_id(rs.getInt("course_id"));
                cr.setTotal_cost(rs.getDouble("total_cost"));
                cr.setStatus(rs.getInt("status"));
                cr.setLast_updated(rs.getTimestamp("last_updated").toLocalDateTime());
                cr.setUpdated_by(rs.getInt("updated_by"));
                cr.setNote(rs.getString("note"));
                result.add(cr);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public List<CourseList> getCourseListByID(int id) {
        List<CourseList> list = new ArrayList<>();
        String query = "select * from courselist where courseid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CourseList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)
                ));
			}
        	} catch (Exception e) {
        }
        return list;
    }

    public int changeRegistrationStatus(int registration_id, int status, int updated_by) {

        String UPDATE_ACCOUNT_INFO = "UPDATE `swp391`.`registration_list`\n"
                + "SET\n"
                + "`status` = ?,\n"
                + "`last_updated` = ?,\n"
                + "`updated_by` = ?\n"
                + "WHERE `id` = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_INFO)) {
            preparedStatement.setInt(1, status);
            preparedStatement.setString(2, LocalDateTime.now().toString());
            preparedStatement.setInt(3, updated_by);
            preparedStatement.setInt(4, registration_id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int getNumberOfRegistrations(String email, int subjectId, int status, String fromDate, String toDate) {

        String GET_NUM_OF_REG = "SELECT count(*) count FROM swp391.registration_list WHERE 1";

        if (!email.isEmpty()) {
            AccountDAO accountDb = new AccountDAO();
            ArrayList<Account> accountList = accountDb.getAccountListByEmail(email);
            GET_NUM_OF_REG += " AND account_id IN (#aid#)";
            String aid = "";
            for (Account a : accountList) {
                aid += "'" + a.getAid() + "',";
            }
            if (!accountList.isEmpty()) {
                aid = aid.substring(0, aid.length() - 1);
            }

            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#aid#", aid);
        }

        if (subjectId > 0) {
            GET_NUM_OF_REG += " AND course_id = #cid#";
            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#cid#", String.valueOf(subjectId));
        }

        if (status >= 0) {
            GET_NUM_OF_REG += " AND status = #status#";
            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#status#", String.valueOf(status));
        }

        if (!fromDate.isEmpty()) {
            GET_NUM_OF_REG += " AND registration_time >= '#from#'";
            GET_NUM_OF_REG = GET_NUM_OF_REG.replace("#from#", fromDate);
        }

        if (!toDate.isEmpty()) {
            GET_NUM_OF_REG += " AND registration_time <= '#to#'";
            GET_NUM_OF_REG = GET_NUM_OF_REG.replace("#to#", toDate);
        }

        int result = 0;

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_NUM_OF_REG)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = rs.getInt("count");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateRegistrationNote(int reg_id, String note, int updated_by) {
        String UPDATE_REG_NOTE = "UPDATE `swp391`.`registration_list`\n"
                + "SET\n"
                + "`last_updated` = ?,\n"
                + "`updated_by` = ?,\n"
                + "`note` = ?\n"
                + "WHERE `id` = ?;";

        int result = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REG_NOTE)) {
            preparedStatement.setString(1, LocalDateTime.now().toString());
            preparedStatement.setInt(2, updated_by);
            preparedStatement.setString(3, note);
            preparedStatement.setInt(4, reg_id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<CourseRegistration> getAllRegisteredCourse() {
        String GET_REGISTRATION_LIST = "SELECT distinct course_id FROM swp391.registration_list;";
        ArrayList<CourseRegistration> result = new ArrayList<>();

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_REGISTRATION_LIST)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CourseRegistration cr = new CourseRegistration();
                cr.setCourse_id(rs.getInt("course_id"));
                result.add(cr);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<RegisteredCourse> getMyCourseList(int id, String searchtxt, int subjectId, String fromDate, String toDate, int offset, int numOfRecords) {
        String GET_COURSE_LIST = "SELECT * FROM swp391.registered_courses WHERE account_id = ?";
        ArrayList<RegisteredCourse> result = new ArrayList<>();

        if (!searchtxt.isEmpty()) {
            CourseListDAO clDb = new CourseListDAO();
            ArrayList<CourseList> clist = clDb.getCourseListByTitle(searchtxt);
            GET_COURSE_LIST += " AND course_id in (#cid#)";
            String cid = "";
            for (CourseList c : clist) {
                cid += "'" + c.getId() + "',";
            }
            if (!clist.isEmpty()) {
                cid = cid.substring(0, cid.length() - 1);
            }

            GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#cid#", cid);
        }

        if (subjectId > 0) {
            GET_COURSE_LIST += " AND course_id = #sid#";
            GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#sid#", String.valueOf(subjectId));
        }

        if (!fromDate.isEmpty()) {
            GET_COURSE_LIST += " AND from_date BETWEEN '#from#' AND '#to#'";
            GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#from#", fromDate);
            if (!toDate.isEmpty()) {
                GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#to#", toDate);
            } else {
                GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#to#", "3000-12-28");
            }
        }

        if (!toDate.isEmpty()) {
            GET_COURSE_LIST += " AND to_date BETWEEN '#from#' AND '#to#'";
            if (!toDate.isEmpty()) {
                GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#from#", fromDate);
            } else {
                GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#to#", "1900-01-01");
            }
            GET_COURSE_LIST = GET_COURSE_LIST.replaceAll("#to#", toDate);
        }

        GET_COURSE_LIST += " limit " + offset + "," + numOfRecords + ";";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_COURSE_LIST)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RegisteredCourse rc = new RegisteredCourse();
                rc.setId(rs.getInt("id"));
                rc.setAccount_id(rs.getInt("account_id"));
                rc.setCourse_id(rs.getInt("course_id"));
                rc.setClass_id(rs.getInt("class_id"));
                rc.setFrom_date(rs.getTimestamp("from_date").toLocalDateTime());
                rc.setTo_date(rs.getTimestamp("to_date").toLocalDateTime());
                rc.setProgress(rs.getInt("progress"));
                rc.setLast_access(rs.getTimestamp("last_access").toLocalDateTime());
                result.add(rc);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<RegisteredCourse> getCourseSubjectByAccountId(int id) {
        String GET_REGISTRATION_LIST = "SELECT distinct course_id FROM swp391.registered_courses WHERE account_id = ?;";
        ArrayList<RegisteredCourse> result = new ArrayList<>();

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_REGISTRATION_LIST)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RegisteredCourse rc = new RegisteredCourse();
                rc.setCourse_id(rs.getInt("course_id"));
                result.add(rc);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int getNumberOfRegisteredCourse(int id, String searchtxt, int subjectId, String fromDate, String toDate) {

        String GET_NUM_OF_REG = "SELECT count(*) count FROM swp391.registered_courses WHERE account_id = ?";

        if (!searchtxt.isEmpty()) {
            CourseListDAO clDb = new CourseListDAO();
            ArrayList<CourseList> clist = clDb.getCourseListByTitle(searchtxt);
            GET_NUM_OF_REG += " AND course_id in (#cid#)";
            String cid = "";
            for (CourseList c : clist) {
                cid += "'" + c.getId() + "',";
            }
            if (!clist.isEmpty()) {
                cid = cid.substring(0, cid.length() - 1);
            }

            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#cid#", cid);
        }

        if (subjectId > 0) {
            GET_NUM_OF_REG += " AND course_id = #sid#";
            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#sid#", String.valueOf(subjectId));
        }

        if (!fromDate.isEmpty()) {
            GET_NUM_OF_REG += " AND from_date BETWEEN '#from#' AND '#to#'";
            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#from#", fromDate);
            if (!toDate.isEmpty()) {
                GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#to#", toDate);
            } else {
                GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#to#", "3000-12-28");
            }
        }

        if (!toDate.isEmpty()) {
            GET_NUM_OF_REG += " AND to_date BETWEEN '#from#' AND '#to#'";
            if (!toDate.isEmpty()) {
                GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#from#", fromDate);
            } else {
                GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#to#", "1900-01-01");
            }
            GET_NUM_OF_REG = GET_NUM_OF_REG.replaceAll("#to#", toDate);
        }

        int result = 0;

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(GET_NUM_OF_REG)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = rs.getInt("count");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public List<CourseList> getAllCoursesList() {
        List<CourseList> list = new ArrayList<>();
        String query = this.query.getAllCoursesList;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CourseList(rs.getInt("courseid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("ratedstar"),
                        rs.getString("listprice"),
                        rs.getString("saleprice"),
                        rs.getString("thumbnail"),
                        rs.getString("updatedDate"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public List<CourseList> getCourseListByDate(String start, String end) {
        List<CourseList> list = new ArrayList<>();
        String query = this.query.getCourseByDate;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, start);
            ps.setString(2, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CourseList(rs.getInt("courseid"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("ratedstar"),
                        rs.getString("listprice"),
                        rs.getString("saleprice"),
                        rs.getString("thumbnail"),
                        rs.getString("updatedDate"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public void deleteRegisteredCourseByClassId(int id){
        String sql = this.query.deleteRegisteredCourseByClassId;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public List<CourseList> getCourseListByClassId(int id) {
        List<CourseList> list = new ArrayList<>();
        String query = "select cl.* from courselist as cl inner join class as c where cl.courseid = c.subjectid and c.id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CourseList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<CourseList> getTop1CourseEachCate(){
        List<CourseList> list = new ArrayList<>();
        sql = this.query.getTop1CourseEachCate;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CourseList(rs.getInt("id_top_course"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public CourseList getCourseById(int id){
        CourseList course = new CourseList();
        sql = this.query.getCourseById;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                course = new CourseList(rs.getInt("courseid"), 
                        rs.getString("title"), 
                        rs.getString("author"), 
                        rs.getInt("ratedstar"), 
                        rs.getString("listprice"), 
                        rs.getString("saleprice"), 
                        rs.getString("thumbnail"), 
                        rs.getString("updatedDate"), 
                        rs.getInt("category"),
                        rs.getString("briefinfor"),
                        rs.getString("featuredflag"),
                        rs.getString("introduction"),
                        rs.getString("status"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return course;
    }
    public static void main(String[] args) {
        CourseListDAO dao = new CourseListDAO();
        List<CourseList> list = dao.get5Features();
        for (CourseList courseList : list) {
            System.out.println(courseList);
        }
    }
}
