/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Class;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassDAO {
    Query query = new Query();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Class> getAllClass() {
        List<Class> classes = new ArrayList<>();
        String sql = this.query.getAllClass;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                classes.add(new Class(rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getString("teacher"),
                        rs.getString("status"),
                        rs.getString("note"),
                        rs.getInt("subjectid"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return classes;
    }
    public Class getClassById(int id) {
        Class classId = new Class();
        String sql = this.query.getClassById;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                classId = new Class(rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getString("teacher"),
                        rs.getString("status"),
                        rs.getString("note"),
                        rs.getInt("subjectid")
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return classId;
    }
    public void updateClass(Class newClass){
        String sql = this.query.updateClass;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newClass.getName());
            ps.setString(2, newClass.getTeacher());
            ps.setString(3, newClass.getStatus());
            ps.setString(4, newClass.getNote());
            ps.setInt(5, newClass.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void addClass(Class newClass){
        String sql = this.query.addClass;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newClass.getName());
            ps.setString(2, newClass.getTeacher());
            ps.setString(3, newClass.getStatus());
            ps.setString(4, newClass.getNote());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void deleteClass(int id){
        String sql = this.query.deleteClass;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void main(String[] args) {
        ClassDAO dao = new ClassDAO();
        dao.deleteClass(2);
    }
}
