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
    private int idSchedule;
    private String title;
    private String detail;
    private String attachement;
    private int priority;
    private String priorityName;
    private int status;
    private String username;
    private String category;
    
    public Todolist() {
        
    }

    public Todolist(int idUser, int idCategory, int idSchedule, String title, String detail, String attachement, int priority, int status, String username, String category) {
        this.idUser = idUser;
        this.idCategory = idCategory;
        this.idSchedule = idSchedule;
        this.title = title;
        this.detail = detail;
        this.attachement = attachement;
        this.priority = priority;
        this.status = status;
        this.username = username;
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
