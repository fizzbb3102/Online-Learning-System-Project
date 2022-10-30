/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class BlogCategory {

    private int id;
    private String name;

    public BlogCategory() {
    }

    public BlogCategory(String name) {
        this.name = name;
    }

    public BlogCategory(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "BlogCategory{" + "id=" + id + ", name=" + name + '}';
    }

}
