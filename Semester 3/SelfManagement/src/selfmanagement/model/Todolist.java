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
public class Todolist {
    private int id;
    private int idUser;
    private int idCategory;
    private String categoryName;
    private String schedule;
    private String title;
    private String detail;
    private String attachement;
    private String priorityName;
    private int status;
    
    public Todolist() {
        
    }

    public Todolist(int idUser, int idCategory, String categoryName, String schedule, String title, String detail, String attachement, String priorityName, int status) {
        this.idUser = idUser;
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.schedule = schedule;
        this.title = title;
        this.detail = detail;
        this.attachement = attachement;
        this.priorityName = priorityName;
        this.status = status;
    }

    public Todolist(String dateend) {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
