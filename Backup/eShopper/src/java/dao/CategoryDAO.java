/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public Category getById(int id) {
        String query = "select * from category\n"
                + "where id = ?\n";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(query);
            if (rs.next()) {
                Category category = new Category();
                category.setId(id);
                category.setName(rs.getString("name"));
                return category;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Category> getAll() {
        String query = "select * from category\n";
        List<Category> result = new ArrayList<>();
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                result.add(category);
            }
        } catch (Exception e) {

        }
        return result;
    }

    Query query = new Query();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = this.query.getAllCategories;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1),
                        rs.getString(2))
                );
            }

        } catch (Exception e) {
        }
        return categories;
    }
}
