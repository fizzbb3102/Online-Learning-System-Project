/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ductd
 */
public class Lesson {

    private int id;
    private String title;
    private String type;
    private String belongingtopic;
    private String order;
    private String status;
    private String videolink;
    private String conent;
    private String subjectID;

    public Lesson() {
    }

    public Lesson(int id, String title, String type, String belongingtopic, String order, String status, String videolink, String conent, String subjectID) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.belongingtopic = belongingtopic;
        this.order = order;
        this.status = status;
        this.videolink = videolink;
        this.conent = conent;
        this.subjectID = subjectID;
    }

    public Lesson(int id, String title, String type, String belongingtopic, String order, String status, String videolink, String conent) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.belongingtopic = belongingtopic;
        this.order = order;
        this.status = status;
        this.videolink = videolink;
        this.conent = conent;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBelongingtopic() {
        return belongingtopic;
    }

    public void setBelongingtopic(String belongingtopic) {
        this.belongingtopic = belongingtopic;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

}
