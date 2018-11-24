/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selfmanagement.model.Account;
import selfmanagement.model.Todolist;
import selfmanagement.model.TodolistCategory;
import selfmanagement.model.database.Database;

/**
 *
 * @author user
 */
public class TodolistDAOImpl implements TodolistDAO {
    private List<Todolist> list;
    
    private final String insert = "INSERT INTO todolists(id_user, id_category, schedule, title, detail, attachement, priority, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String update = "UPDATE todolist SET category_name=?, schedule=?, title=?, detail=?, attachement=?, priority=?, status=? WHERE id=?";
    private final String delete = "DELETE FROM todolist WHERE id = ?";
    private final String select = "SELECT todolists.id, todolists.id_user, todolists.id_category, todolist_categories.title AS category_name, todolists.schedule, todolists.title, todolists.detail, todolists.attachement, todolists.priority, todolists.status FROM todolists INNER JOIN accounts ON todolists.id_user = accounts.id INNER JOIN todolist_categories ON todolists.id_category = todolist_categories.id ORDER BY todolists.status";
    private String title;
    private final String search = "SELECT * FROM todolist WHERE title LIKE %"+title+"%";
    
    Statement statement;
    PreparedStatement prepareStatement;
    ResultSet resultSet;
    
    @Override
    public boolean insertTodolist(Todolist todo) {
        try {
            prepareStatement = Database.getConnection().prepareStatement(insert);
            
            prepareStatement.setInt(1, todo.getIdUser());
            prepareStatement.setInt(2, todo.getIdCategory());
            prepareStatement.setString(3, todo.getSchedule());
            prepareStatement.setString(4, todo.getTitle());
            prepareStatement.setString(5, todo.getDetail());
            prepareStatement.setString(6, todo.getAttachement());
            prepareStatement.setString(7, todo.getPriorityName());
            prepareStatement.setInt(8, todo.getStatus());
            
            if(prepareStatement.executeUpdate() > 0) {
                prepareStatement.close();
                return true;
            } 
            prepareStatement.close();
        } catch(SQLException er) {
            Logger.getLogger(Todolist.class.getName()).log(Level.SEVERE, null, er);
        }
         return false;
    }

    @Override
    public boolean updateTodolist(Todolist todo) {
        try {
            prepareStatement = Database.getConnection().prepareStatement(update);
            
            if(prepareStatement.executeUpdate() > 0) { 
                prepareStatement.close();
                return true;
            }
            prepareStatement.close();
        } catch(SQLException er) {
            Logger.getLogger(Todolist.class.getName()).log(Level.SEVERE, null, er);
        }
        return false;
    }

    @Override
    public boolean deleteTodolist(int id) {
        try {
            prepareStatement = Database.getConnection().prepareStatement(delete);
            prepareStatement.setInt(1, id);
            if(prepareStatement.executeUpdate() > 0) {
                prepareStatement.close();
                return true;
            }
            prepareStatement.close();
        } catch(SQLException er) {
            Logger.getLogger(Todolist.class.getName()).log(Level.SEVERE, null, er);
        }
        return false;
    }
    
    @Override
    public List<Todolist> getAllTodolist() {
        list = new ArrayList<Todolist>();
        
        try {
            statement = Database.getConnection().createStatement();
            resultSet = statement.executeQuery(select);
            while(resultSet.next()) {
                Todolist todo = new Todolist(
                     resultSet.getInt("id"),
                     resultSet.getInt("id_user"),
                     resultSet.getInt("id_category"),
                     resultSet.getString("category_name"),
                     resultSet.getString("schedule"),
                     resultSet.getString("title"),
                     resultSet.getString("detail"),
                     resultSet.getString("attachement"),
                     resultSet.getString("priority"),
                     resultSet.getInt("status")
                );
                list.add(todo);
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException er) {
            Logger.getLogger(Todolist.class.getName()).log(Level.SEVERE, null, er);
        }
        return null;
    }

    @Override
    public List<Todolist> getTodolist() {
        try {
            statement = Database.getConnection().createStatement();
            resultSet = statement.executeQuery(search);
            if(resultSet.next()) {
                
            }
        } catch(SQLException er) {
            Logger.getLogger(Todolist.class.getName()).log(Level.SEVERE, null, er);
        }
        return null;
    }
    
    public List<TodolistCategory> getCategoryTodolist() {
        List<TodolistCategory> listCategory = new ArrayList<TodolistCategory>();
        
        try {
            statement = Database.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM todolist_categories");
            while(resultSet.next()) {
                TodolistCategory todolistCategory = new TodolistCategory();
                todolistCategory.setName(resultSet.getString("title"));
                listCategory.add(todolistCategory);
            }
            resultSet.close();
            statement.close();
            return listCategory;
        } catch(SQLException er) {
            Logger.getLogger(Todolist.class.getName()).log(Level.SEVERE, null, er);
        }   
        return null;
    }
}
