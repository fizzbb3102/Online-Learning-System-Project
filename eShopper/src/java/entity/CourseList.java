/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ductd
 */
public class CourseList {

    private int id;
    private String title;
    private String author;
    private int ratedStar;
    private String listPrice;
    private String salePrice;
    private String thumbnail;
    private String updatedDate;
    private int category;
    private String briefInfo;
    private String featuredFlag;
    private String introduction;
    private String status;
    private int count;

    public CourseList() {
    }

    public CourseList(int id, String title, String author, int ratedStar, String listPrice, String salePrice, String thumbnail, String updatedDate, int category, String briefInfo, String featuredFlag, String introduction, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ratedStar = ratedStar;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
        this.updatedDate = updatedDate;
        this.category = category;
        this.briefInfo = briefInfo;
        this.featuredFlag = featuredFlag;
        this.introduction = introduction;
        this.status = status;
    }

    public CourseList(int id, String title, String author, String listPrice, String salePrice, String thumbnail, String updatedDate, int category, String briefInfo, String featuredFlag, String introduction, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
        this.updatedDate = updatedDate;
        this.category = category;
        this.briefInfo = briefInfo;
        this.featuredFlag = featuredFlag;
        this.introduction = introduction;
        this.status = status;
    }

    public CourseList(int id, String title, String author, int ratedStar, String listPrice, String salePrice, String thumbnail, String updatedDate, int category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ratedStar = ratedStar;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
        this.updatedDate = updatedDate;
        this.category = category;
    }

    public CourseList(int id, String title, String author, int ratedStar, String listPrice, String salePrice, String thumbnail, String updatedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ratedStar = ratedStar;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
        this.updatedDate = updatedDate;
    }

    public CourseList(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public CourseList(int id) {
        this.id = id;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRatedStar() {
        return ratedStar;
    }

    public void setRatedStar(int ratedStar) {
        this.ratedStar = ratedStar;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public String getFeaturedFlag() {
        return featuredFlag;
    }

    public void setFeaturedFlag(String featuredFlag) {
        this.featuredFlag = featuredFlag;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseList{" + "id=" + id + ", title=" + title + ", author=" + author + ", ratedStar=" + ratedStar + ", listPrice=" + listPrice + ", salePrice=" + salePrice + ", thumbnail=" + thumbnail + ", updatedDate=" + updatedDate + ", category=" + category + ", briefInfo=" + briefInfo + ", featuredFlag=" + featuredFlag + ", introduction=" + introduction + ", status=" + status + ", count=" + count + '}';
    }

}
