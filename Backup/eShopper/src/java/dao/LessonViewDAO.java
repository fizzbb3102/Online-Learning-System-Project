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
import java.util.ArrayList;
import java.util.List;

public class LessonViewDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Lesson> getLesson() {
        ArrayList<Lesson> list = new ArrayList<>();
        String query = "select * from lesson";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson llist = new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(llist);
            }

        } catch (Exception e) {
        }
        return list;
    }
    public Lesson getLessonBySubId(int id) {
        try {
            String query = "select * from lesson where subjectid = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Lesson a = new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Lesson> getLessonByID(int id) {
        List<Lesson> list = new ArrayList<>();
        String query = "select * from lesson where id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
