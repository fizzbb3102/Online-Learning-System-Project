/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubjectDao {

    public Subject findById(int id) {
        String SQL = "SELECT s.id,s.title,s.featured,s.status,s.thumbnail,a.fullname as author,a.aid,s.introduction,s.brief_infor\n"
                + "    FROM subject s\n"
                + "    JOIN account a on a.aid = s.aid\n"
                + "    WHERE s.id = ? ";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            System.out.println(SQL);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setAuthor(new AccountDAO().getById(rs.getInt("aid")));
                subject.setId(rs.getInt("id"));
                subject.setFeatured(rs.getString("featured"));
                subject.setTitle(rs.getString("title"));
                subject.setStatus(rs.getString("status"));
                subject.setThumbnail(rs.getString("thumbnail"));
                subject.setContent(rs.getString("introduction"));
                subject.setBriefInfor(rs.getString("brief_infor"));
                return subject;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Subject> getSubjectList(int pageIndex, int pageSize, String sortBy, String searchKeyWord, int authorId, String status) {
        List<Subject> result = new ArrayList<>();
        String SQL = "SELECT * FROM"
                + "    ("
                + "    SELECT s.id,s.title,s.featured,s.status,s.thumbnail,a.fullname as author,a.aid,s.price,s.sale_price\n"
                + "    FROM subject s\n"
                + "    JOIN account a on a.aid = s.aid\n"
                + "    WHERE s.title LIKE ?  #TYPE_CONDITION# "
                + "     ) temp\n";
        //sort by
        if (!sortBy.equals("none") && !sortBy.equals("")) {
            SQL += " ORDER BY " + sortBy + "\n";
        }
        SQL += "    LIMIT ? \n"
                + "    OFFSET ? \n";
        String condition = "";
        if (authorId != -1) {
            condition += " AND s.aid = ? ";
        }
        if (status != null && !status.equals("all")) {
            condition += " AND s.status = ? ";
        }

        SQL = SQL.replaceAll("#TYPE_CONDITION#", condition);

        int index = 0;
        //tính toán phân trang (ví dụ chọn page 2 và page size = 10 thì sẽ lấy từ record thứ 11 -> 20)
        //2 biến start và end sẽ là offset (bắt đầu từ) và limit (lấy đến)
        int start = pageSize * (pageIndex - 1);
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            System.out.println(SQL);
            preparedStatement.setString(++index, "%" + searchKeyWord + "%");
            if (authorId != -1) {
                preparedStatement.setInt(++index, authorId);
            }
            if (status != null && !status.equals("all")) {
                preparedStatement.setString(++index, status);
            }

            preparedStatement.setInt(++index, pageSize);
            preparedStatement.setInt(++index, start);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getInt("id"));
                subject.setFeatured(rs.getString("featured"));
                Account author = new AccountDAO().getById(rs.getInt("aid"));
                subject.setAuthor(author);
                subject.setTitle(rs.getString("title"));
                subject.setStatus(rs.getString("status"));
                subject.setThumbnail(rs.getString("thumbnail"));
                subject.setPrice(rs.getDouble("price"));
                subject.setSalePrice(rs.getDouble("sale_price"));
                result.add(subject);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int countPost(String searchKeyWord, int authorId, String status) {
        String SQL = "SELECT COUNT(*) AS TOTAL \n"
                + "    FROM subject s\n"
                + "    WHERE s.title LIKE ? #TYPE_CONDITION#\n";
        //nếu không chọn all setting thì thêm điều kiện vào để select ra đúng setting type (cái này chọn ở dropdown list)
        String condition = "";
        if (authorId != -1) {
            condition += " AND s.aid = ? ";
        }
        if (status != null && !status.equals("all")) {
            condition += " AND s.status = ? ";
        }

        SQL = SQL.replaceAll("#TYPE_CONDITION#", condition);

        System.out.println(SQL);
        System.out.println(searchKeyWord);
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setString(1, "%" + searchKeyWord + "%");
            int index = 1;
            if (authorId != -1) {
                preparedStatement.setInt(++index, authorId);
            }
            if (status != null && !status.equals("all")) {
                preparedStatement.setString(++index, status);
            }

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void update(Subject subject) {
        String SQL = "UPDATE subject s\n"
                + "SET title = ?,brief_infor = ?, introduction = ?, featured = ?, status = ?, thumbnail = ? \n"
                + "WHERE s.id = ? ";
        int index = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setString(++index, subject.getTitle());
            preparedStatement.setString(++index, subject.getBriefInfor());
            preparedStatement.setString(++index, subject.getContent());
            preparedStatement.setString(++index, subject.getFeatured());
            preparedStatement.setString(++index, subject.getStatus());
            preparedStatement.setString(++index, subject.getThumbnail());
            preparedStatement.setInt(++index, subject.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        String SQL = "DELETE FROM post"
                + " WHERE post.id = ?";
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
