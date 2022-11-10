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

public class NewSubjectDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertSubject(String title, String author, String listPrice, String salePrice, String thumbnail, String updatedDate, int category, String briefInfor, String featuredFlag, String introduction, String status) {
        String query = "insert into courselist(title,author,listprice,saleprice,thumbnail,updatedDate,category,briefinfor,featuredflag,introduction,status) values(?,?,?,?,?,?,?,?,?,?,?);";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, listPrice);
            ps.setString(4, salePrice);
            ps.setString(5, thumbnail);
            ps.setString(6, updatedDate);
            ps.setInt(7, category);
            ps.setString(8, briefInfor);
            ps.setString(9, featuredFlag);
            ps.setString(10, introduction);
            ps.setString(11, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
  
}
