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
public class Slide {
    private int id;
    private String name;
    private String detail;
    private String image;
    private String status;

    public Slide() {
    }

    public Slide(String name, String detail, String image, String status) {
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.status = status;
    }

    public Slide(int id, String name, String detail, String image) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    public Slide(int id, String name, String detail, String image, String status) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.status = status;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Slide{" + "id=" + id + ", name=" + name + ", detail=" + detail + ", image=" + image + ", status=" + status + '}';
    }
    
}
