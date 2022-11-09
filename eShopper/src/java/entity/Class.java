/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LENOVO
 */
public class Class {
    private int id;
    private String name;
    private String teacher;
    private String status;
    private String note;
    private int subjectid;

    public Class() {
    }

    public Class(int id, String name, String teacher, String status) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.status = status;
    }

    public Class(int id, String name, String teacher, String status, String note) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.status = status;
        this.note = note;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public Class(int id, String name, String teacher, String status, String note, int subjectid) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.status = status;
        this.note = note;
        this.subjectid = subjectid;
    }

    public Class(String name, String teacher, String status, String note) {
        this.name = name;
        this.teacher = teacher;
        this.status = status;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", name=" + name + ", teacher=" + teacher + ", status=" + status + ", note=" + note + ", subjectid=" + subjectid + '}';
    }
    
}

