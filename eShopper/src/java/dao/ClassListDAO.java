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
import java.util.ArrayList;

public class ClassListDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<ClassList> getAllClass() {
        ArrayList<ClassList> list = new ArrayList<>();
        String query = "SELECT * FROM swp391.class;";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassList clist = new ClassList(rs.getInt("id"), rs.getString("name"), rs.getString("teacher"), rs.getString("status"), rs.getString("note"));
                list.add(clist);
            }

        } catch (Exception e) {
        }
        return list;
    }
   
}
