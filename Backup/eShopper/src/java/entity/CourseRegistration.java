/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;

/**
 *
 * @author Zake
 */
public class CourseRegistration {
    private int id;
    private int account_id;
    private LocalDateTime registration_time;
    private int course_id;
    private double total_cost;
    private int status;
    private LocalDateTime last_updated;
    private int updated_by;
    private String note;

    public CourseRegistration() {
    }

    public CourseRegistration(int id, int account_id, LocalDateTime registration_time, int course_id, double total_cost, int status, LocalDateTime last_updated, int updated_by, String note) {
        this.id = id;
        this.account_id = account_id;
        this.registration_time = registration_time;
        this.course_id = course_id;
        this.total_cost = total_cost;
        this.status = status;
        this.last_updated = last_updated;
        this.updated_by = updated_by;
        this.note = note;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public LocalDateTime getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(LocalDateTime registration_time) {
        this.registration_time = registration_time;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
