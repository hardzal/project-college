/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model;

/**
 *
 * @author izal
 */
public class TodolistCategory extends Parent {
    private String name;
    private String detail;
    
    public TodolistCategory() {
        
    }

    public TodolistCategory(int id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
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
    
    
}
