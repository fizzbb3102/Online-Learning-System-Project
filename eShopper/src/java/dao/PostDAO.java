/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostDAO {

    public Post findById(int id) {
        String SQL = "SELECT p.id,p.title,p.featured,p.status,p.thumbnail,a.fullname as author,c.name as category,a.aid,c.id as cate_id,p.content,p.brief_infor\n"
                + "    FROM post p\n"
                + "    JOIN account a on a.aid = p.aid\n"
                + "    JOIN category c on c.id = p.cate_id\n"
                + "    WHERE p.id = ? ";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            System.out.println(SQL);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setFeatured(rs.getString("featured"));
                post.setCategory(new CategoryDAO().getById(rs.getInt("cate_id")));
                post.setTitle(rs.getString("title"));
                post.setStatus(rs.getString("status"));
                post.setThumbnail(rs.getString("thumbnail"));
                post.setContent(rs.getString("content"));
                post.setBriefInfor(rs.getString("brief_infor"));
                return post;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Post> getPostList(int pageIndex, int pageSize, String sortBy, String searchKeyWord, int authorId, int cateId, String status) {
        List<Post> result = new ArrayList<>();
        String SQL = "SELECT * FROM"
                + "    ("
                + "    SELECT p.id,p.title,p.featured,p.status,p.thumbnail,a.fullname as author,c.name as category,a.aid,c.id as cate_id\n"
                + "    FROM post p\n"
                + "    JOIN account a on a.aid = p.aid\n"
                + "    JOIN category c on c.id = p.cate_id\n"
                + "    WHERE p.title LIKE ?  #TYPE_CONDITION# "
                + "     ) temp\n";
        //sort by
        if (!sortBy.equals("none") && !sortBy.equals("")) {
            SQL += " ORDER BY " + sortBy + "\n";
        }
        SQL += "    LIMIT ? \n"
                + "    OFFSET ? \n";
        String condition = "";
        if (authorId != -1) {
            condition += " AND p.aid = ? ";
        }
        if (cateId != -1) {
            condition += " AND p.cate_id = ? ";
        }
        if (status != null && !status.equals("all")) {
            condition += " AND p.status = ? ";
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
            if (cateId != -1) {
                preparedStatement.setInt(++index, cateId);
            }
            if (status != null && !status.equals("all")) {
                preparedStatement.setString(++index, status);
            }

            preparedStatement.setInt(++index, pageSize);
            preparedStatement.setInt(++index, start);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setFeatured(rs.getString("featured"));
                Account author = new AccountDAO().getById(rs.getInt("aid"));
                post.setAuthor(author);
                post.setCategory(new CategoryDAO().getById(rs.getInt("cate_id")));
                post.setTitle(rs.getString("title"));
                post.setStatus(rs.getString("status"));
                post.setThumbnail(rs.getString("thumbnail"));
                result.add(post);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int countPost(String searchKeyWord, int authorId, int cateId, String status) {
        String SQL = "SELECT COUNT(*) AS TOTAL \n"
                + "    FROM post p\n"
                + "    WHERE p.title LIKE ? #TYPE_CONDITION#\n";
        //nếu không chọn all setting thì thêm điều kiện vào để select ra đúng setting type
        String condition = "";
        if (authorId != -1) {
            condition += " AND p.aid = ? ";
        }
        if (cateId != -1) {
            condition += " AND p.cate_id = ? ";
        }
        if (status != null && !status.equals("all")) {
            condition += " AND p.status = ? ";
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
            if (cateId != -1) {
                preparedStatement.setInt(++index, cateId);
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

    public void update(Post post) {
        String SQL = "UPDATE post p\n"
                + "SET cate_id = ? , title = ?,brief_infor = ?, content = ?, featured = ?, status = ? , thumbnail = ?\n"
                + "WHERE p.id = ? ";
        int index = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setInt(++index, post.getCategory().getId());
            preparedStatement.setString(++index, post.getTitle());
            preparedStatement.setString(++index, post.getBriefInfor());
            preparedStatement.setString(++index, post.getContent());
            preparedStatement.setString(++index, post.getFeatured());
            preparedStatement.setString(++index, post.getStatus());
            preparedStatement.setString(++index, post.getThumbnail());
            preparedStatement.setInt(++index, post.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insert(Post post) {
        String SQL = "INSERT INTO post(aid,cate_id,title,featured,status,thumbnail,content,brief_infor) \n"
                + "VALUES(?,?,?,?,?,?,?,?)";
        int index = 0;
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement(SQL)) {
            preparedStatement.setInt(++index, post.getAuthor().getAid());
            preparedStatement.setInt(++index, post.getCategory().getId());
            preparedStatement.setString(++index, post.getTitle());
            preparedStatement.setString(++index, post.getFeatured());
            preparedStatement.setString(++index, post.getStatus());
            preparedStatement.setString(++index, post.getThumbnail());
            preparedStatement.setString(++index, post.getContent());
            preparedStatement.setString(++index, post.getBriefInfor());
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

//    public int addPost(Post post) {
//        String UPDATE_SETTING_SQL = "INSERT INTO `setting_details`\n"
//                + "(`typeId`,\n"
//                + "`value`,\n"
//                + "`order`,\n"
//                + "`note`,\n"
//                + "`status`,\n"
//                + "`created_time`,\n"
//                + "`updated_time`)\n"
//                + "VALUES\n"
//                + "(?,\n"
//                + "?,\n"
//                + "?,\n"
//                + "?,\n"
//                + "?,\n"
//                + "?,\n"
//                + "?);";
//
//        int result = 0;
//        try (Connection connection = new DBContext().getConnection();
//                // Step 2:Create a statement using connection object
//                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SETTING_SQL)) {
////            preparedStatement.setInt(1, setting.getTypeId());
////            preparedStatement.setString(2, setting.getValue());
////            preparedStatement.setString(3, setting.getOrder());
////            preparedStatement.setString(4, setting.getNote());
////            preparedStatement.setBoolean(5, setting.isStatus());
//            preparedStatement.setString(6, LocalDateTime.now().toString());
//            preparedStatement.setString(7, LocalDateTime.now().toString());
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            result = preparedStatement.executeUpdate();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
}
