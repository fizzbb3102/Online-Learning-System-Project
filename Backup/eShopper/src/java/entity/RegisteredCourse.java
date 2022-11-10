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
public class RegisteredCourse {
    private int id;
    private int account_id;
    private int course_id;
    private int class_id;
    private LocalDateTime from_date;
    private LocalDateTime to_date;
    private int progress;
    private LocalDateTime last_access;

    public RegisteredCourse() {
    }

    public RegisteredCourse(int id, int account_id, int course_id, int class_id, LocalDateTime from_date, LocalDateTime to_date, int progress, LocalDateTime last_access) {
        this.id = id;
        this.account_id = account_id;
        this.course_id = course_id;
        this.class_id = class_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.progress = progress;
        this.last_access = last_access;
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

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public LocalDateTime getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDateTime from_date) {
        this.from_date = from_date;
    }

    public LocalDateTime getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDateTime to_date) {
        this.to_date = to_date;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public LocalDateTime getLast_access() {
        return last_access;
    }

    public void setLast_access(LocalDateTime last_access) {
        this.last_access = last_access;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}
