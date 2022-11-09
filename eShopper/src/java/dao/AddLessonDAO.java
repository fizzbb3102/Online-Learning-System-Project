/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddLessonDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertLesson(String title, String type, String topic, String order, String status, String video, String content, String subjectid) {
        String query = "insert into lesson(title,type,belongingtopic,lessonorder,status,videolink,content,subjectid) values(?,?,?,?,?,?,?,?);";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, type);
            ps.setString(3, topic);
            ps.setString(4, order);
            ps.setString(5, status);
            ps.setString(6, video);
            ps.setString(7, content);
            ps.setString(8, subjectid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
