/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;

/**
 *
 * @author LENOVO
 */
public class Account {

    private int aid;
    private String fullname;
    private String email;
    private String password;
    private int phone;
    private int role_id;
    private String token;
    private int enabled;
    private String user_title;
    private LocalDateTime created_at;
    private int gender;
    private LocalDateTime dob;
    private String pfp;
    private int count;

    public Account() {
    }

    public Account(String fullname, int count) {
        this.fullname = fullname;
        this.count = count;
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(int aid, String email, String fullname, int phone) {
        this.aid = aid;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
    }

    public Account(int aid, String email, String password) {
        this.aid = aid;
        this.email = email;
        this.password = password;
    }

    public Account(String fullname, String email, String password, int phone) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Account(int aid, String fullname, String email, String password, int phone) {
        this.aid = aid;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Account(int aid, String fullname, String email, String password, int phone, int role_id) {
        this.aid = aid;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role_id = role_id;
    }

    public Account(int aid, String fullname, String email, String password, int phone, int role_id, String token, String user_title, LocalDateTime created_at, int gender, LocalDateTime dob) {
        this.aid = aid;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role_id = role_id;
        this.token = token;
        this.user_title = user_title;
        this.created_at = created_at;
        this.gender = gender;
        this.dob = dob;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUser_title() {
        return user_title;
    }

    public void setUser_title(String user_title) {
        this.user_title = user_title;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Account{" + "aid=" + aid + ", fullname=" + fullname + ", email=" + email + ", password=" + password + ", phone=" + phone + ", role_id=" + role_id + ", token=" + token + ", enabled=" + enabled + ", user_title=" + user_title + ", created_at=" + created_at + ", gender=" + gender + ", dob=" + dob + ", pfp=" + pfp + ", count=" + count + '}';
    }

}
