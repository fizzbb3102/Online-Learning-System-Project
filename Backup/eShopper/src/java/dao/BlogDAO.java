/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlogDAO {
    Query query = new Query();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Blog> getAllBlogs() {
        List<Blog> blogs = new ArrayList<>();
        String query = this.query.getAllBlogs;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return blogs;
    }
    public List<Blog> getAllBlogsByBlogCateId(int id) {
        List<Blog> blogs = new ArrayList<>();
        String query = this.query.getAllBlogsByBlogCateId;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return blogs;
    }
    public Blog getBlogById(int id){
        String query = this.query.getBlogById;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Blog blog = new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"));
                return blog;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public List<Blog> getBlogByTitle(String title){
        String query = this.query.getBlogByTitle;
        List<Blog> blogs = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%" + title + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"))
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return blogs;
    }
    public int countBLogs(){
        String query = this.query.countBlog;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public int countBLogByCateId(int id){
        String query = this.query.countBlogByCateId;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public List<Blog> pagingBlog(int index){
        List<Blog> list = new ArrayList<>();
        String query = this.query.pagingBlog;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*4);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"),
                        rs.getString("name"),
                        rs.getString("blog_category_name"))
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public List<Blog> pagingBlogByCateId(int cateId, int index) {
        List<Blog> blogs = new ArrayList<>();
        String query = this.query.pagingBlogByCateId;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cateId);
            ps.setInt(2, (index-1)*4);
            rs = ps.executeQuery();
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"),
                        rs.getString("name"),
                        rs.getString("blog_category_name"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return blogs;
    }
    public List<Blog> getTop5Blog(){
        List<Blog> blogs = new ArrayList<>();
        String sql = this.query.getTop5Blog;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("id"), 
                        rs.getString("short_detail"), 
                        rs.getString("detail"), 
                        rs.getInt("author_id"), 
                        rs.getString("title"), 
                        rs.getInt("blog_category_id"), 
                        rs.getTimestamp("updated_date").toLocalDateTime(),
                        rs.getString("image"),
                        rs.getBoolean("featured"),
                        rs.getString("status"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return blogs;
    }
    public static void main(String[] args) {
        BlogDAO dao = new BlogDAO();
        List<Blog> list = dao.getBlogByTitle("java");
        for (Blog blog : list) {
            System.out.println(blog);
        }
    }
}
