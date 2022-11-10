/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    Query query = new Query();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Author getAuthorById(int id) {
        String query = this.query.getAuthorById;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Author blog = new Author(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                return blog;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Author> getAllAuthors() {
        List<Author> list = new ArrayList<>();
        String query = this.query.getAllAuthors;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Author(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4))
                );
            }

        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        AuthorDAO authorDAO = new AuthorDAO();
        List<Author> a = authorDAO.getAllAuthors();
        for (Author author_of_blog : a) {
            System.out.println(author_of_blog);
        }
    }
}
