/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.ClassList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassDetaiDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ClassList getClassDetailByID(int id) {
        String query = "select * from classlist where id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ClassList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editClassDetail(String id, String name, String teacher, String status) {
        String query = "UPDATE classlist SET name = ?, teacher = ? , status = ? WHERE id = ?;";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, teacher);
            ps.setString(3, status);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertClass(String name, String teacher, String status) {
        String query = "insert into classlist(name,teacher,status) values(?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, teacher);
            ps.setString(3, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    

}
