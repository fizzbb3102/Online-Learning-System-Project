/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ductd
 */
public class LessonDetailDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Lesson getLessonDetailByID(int id) {
        String query = "select * from lesson where id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editLessonDetail(int id, String title, String type, String belongingtopic, String order, String status, String link, String content) {
        String query = "UPDATE lesson SET title = ? , type = ? , belongingtopic = ?  , lessonorder = ? , status = ? , videolink = ? , content = ?  WHERE id = ?;";
        try { 
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, type);
            ps.setString(3, belongingtopic);
            ps.setString(4, order);
            ps.setString(5, status);
            ps.setString(6, link);
            ps.setString(7, content);
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
