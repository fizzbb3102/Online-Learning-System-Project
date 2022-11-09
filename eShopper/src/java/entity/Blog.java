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
public class Blog {
    private int id;
    private String short_detail;
    private String detail;
    private int author_id;
    private String title;
    private int blog_category_id;
    private LocalDateTime updated_date;
    private String image;
    private Boolean featured;
    private String status;
    
    private String author_name;
    private String blog_category_name;
    public Blog() {
    }

    public Blog(int id, String short_detail, String detail, int author_id, String title, int blog_category_id, LocalDateTime updated_date, String image, Boolean featured, String status) {
        this.id = id;
        this.short_detail = short_detail;
        this.detail = detail;
        this.author_id = author_id;
        this.title = title;
        this.blog_category_id = blog_category_id;
        this.updated_date = updated_date;
        this.image = image;
        this.featured = featured;
        this.status = status;
    }

    public Blog(int id, String short_detail, String detail, int author_id, String title, int blog_category_id, LocalDateTime updated_date, String image, Boolean featured, String status, String author_name, String blog_category_name) {
        this.id = id;
        this.short_detail = short_detail;
        this.detail = detail;
        this.author_id = author_id;
        this.title = title;
        this.blog_category_id = blog_category_id;
        this.updated_date = updated_date;
        this.image = image;
        this.featured = featured;
        this.status = status;
        this.author_name = author_name;
        this.blog_category_name = blog_category_name;
    }

    public String getBlog_category_name() {
        return blog_category_name;
    }

    public void setBlog_category_name(String blog_category_name) {
        this.blog_category_name = blog_category_name;
    }

    

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_detail() {
        return short_detail;
    }

    public void setShort_detail(String short_detail) {
        this.short_detail = short_detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBlog_category_id() {
        return blog_category_id;
    }

    public void setBlog_category_id(int blog_category_id) {
        this.blog_category_id = blog_category_id;
    }

    public LocalDateTime getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDateTime updated_date) {
        this.updated_date = updated_date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", short_detail=" + short_detail + ", detail=" + detail + ", author_id=" + author_id + ", title=" + title + ", blog_category_id=" + blog_category_id + ", updated_date=" + updated_date + ", image=" + image + ", featured=" + featured + ", status=" + status + ", author_name=" + author_name + ", blog_category_name=" + blog_category_name + '}';
    }
    
}