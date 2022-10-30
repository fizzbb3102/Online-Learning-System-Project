/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RegisterDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account checkAccountExist(String email) {
        String query = "select * from swp391.account where email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void register(Account a) {
        String query = "INSERT INTO `swp391`.`account`\n"
                + "(`fullname`,\n"
                + "`email`,\n"
                + "`password`,\n"
                + "`phone`,\n"
                + "`role_id`,\n"
                + "`status`,\n"
                + "`register`,\n"
                + "`token`,\n"
                + "`enabled`,\n"
                + "`usertitle`,\n"
                + "`created_at`,\n"
                + "`gender`,\n"
                + "`date_of_birth`)\n"
                + "VALUES (?,?,?,?,5,'normal','registered',null,1,?,?,?,?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, a.getFullname());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getPassword());
            ps.setInt(4, a.getPhone());
            ps.setString(5, a.getUser_title());
            ps.setString(6, LocalDateTime.now().toString());
            ps.setInt(7, a.getGender());
            ps.setString(8, a.getDob().toString());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        RegisterDAO DB = new RegisterDAO();
//        Account a = new Account();
//        a.setFullname("abc");
//        a.setEmail("gira@gmail.com");
//        a.setPassword("1234567");
//        a.setPassword("523534313");
//        a.setUser_title("Mr");
//        DB.register(a);
//    }
}
