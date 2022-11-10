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
public class Author {
    private int id;
    private String name;
    private String job;
    private String image;

    public Author() {
    }

    public Author(int id, String name, String job, String image) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.image = image;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Author_of_blog{" + "id=" + id + ", name=" + name + ", job=" + job + ", image=" + image + '}';
    }
    
}
