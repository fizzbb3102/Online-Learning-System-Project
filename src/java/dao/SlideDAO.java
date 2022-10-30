/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Slide;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlideDAO {
    Query query = new Query();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Slide> getAllSlides() {
        List<Slide> slides = new ArrayList<>();
        String query = this.query.getAllSlides;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                slides.add(new Slide(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("detail"),
                        rs.getString("image"),
                        rs.getString("status"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return slides;
    }
    public List<Slide> getPagingActiveOrNonActiveSlides(String status, int index) {
        List<Slide> slides = new ArrayList<>();
        String query = this.query.getPagingActiveOrNonActiveSlides;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, (index-1)*4);
            rs = ps.executeQuery();
            while (rs.next()) {
                slides.add(new Slide(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("detail"),
                        rs.getString("image"),
                        rs.getString("status"))
                );
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return slides;
    }
    public int countSlides(){
        String query = this.query.countSlide;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public List<Slide> getPagingSlide(String status, int index){
        List<Slide> list = new ArrayList<>();
        String query = "";
        if(status.equals("all")){
            query = this.query.getPagingSlide;
        }else{
            query = this.query.getPagingActiveOrNonActiveSlides;
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, (index-1)*4);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Slide(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("detail"),
                        rs.getString("image"),
                        rs.getString("status"))
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public Slide getSlidebyId(int id){
       String query = this.query.getSlideById;
       Slide slide = new Slide();
       try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                slide = new Slide(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("detail"),
                        rs.getString("image"),
                        rs.getString("status")
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
       return slide;
    }
    public boolean updateSlide(Slide slide){
        boolean result = false;
        String query = this.query.updateSlide;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, slide.getName());
            ps.setString(2, slide.getDetail());
            ps.setString(3, slide.getImage());
            ps.setString(4, slide.getStatus());
            ps.setInt(5, slide.getId());
            ps.executeUpdate();
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    public boolean addSlide(Slide slide){
        boolean result = false;
        String query = this.query.addSlide;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, slide.getName());
            ps.setString(2, slide.getDetail());
            ps.setString(3, slide.getImage());
            ps.setString(4, slide.getStatus());
            ps.executeUpdate();
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    public boolean deleteSlide(int id){
        boolean result = false;
        String query = this.query.deleteSlide;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
    public void changeStatus(String status, int id){
        String query = this.query.changeStatus;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public List<Slide> searchSlide(String title){
       String query = this.query.searchSlide;
       List<Slide> slides = new ArrayList<>();
       try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                slides.add(new Slide(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("detail"),
                        rs.getString("image"),
                        rs.getString("status")
                ));
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SettingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
       return slides;
    }
//    public static void main(String[] args) {
//        SlideDAO dao = new SlideDAO();
//        List<Slide> slide = dao.getAllSlides();
//        for (Slide slide1 : slide) {
//            System.out.println(slide1);
//        }
//    }
}
