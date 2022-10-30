/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.BlogCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogCategoryDAO {
    Query query = new Query();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public BlogCategory getBlogCateNameById(int id){
        String query = this.query.getBlogCateNameById;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                BlogCategory blog = new BlogCategory(rs.getString(1));
                return blog;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<BlogCategory> getAllBlogCates(){
        String query = this.query.getAllBlogCates;
        List<BlogCategory> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BlogCategory(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        BlogCategoryDAO dao = new BlogCategoryDAO();
//        BlogCategory blog = dao.getBlogCateNameByBlogId(1);
//        System.out.println(blog);
        List<BlogCategory> list = dao.getAllBlogCates();
        for (BlogCategory blogCategory : list) {
            System.out.println(blogCategory);
        }
    }
}
