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
import selfmanagement.model.database.Database;

/**
 *
 * @author user
 */
public class TodolistDAOImpl implements TodolistDAO {
    private List<Todolist> list;
    
    private final String insert = "INSERT INTO todolist(id_user, id_category, id_schedule, title, detail, attachement, priority, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String update = "UPDATE todolist SET id_category=?, id_schedule=?, title=?, detail=?, attachement=?, priority=?, status=? WHERE id=?";
    private final String delete = "DELETE FROM todolist WHERE id = ?";
    private final String select = 
     "SELECT \n" +
"       todolists.id_user, accounts.username, todolists.id_category, todolist_categories.title AS category, todolists.id_schedule, schedules.dateend, todolists.title, todolists.detail, todolists.priority, priorities.name AS priority_name, todolists.status \n" +
"    FROM todolists \n" +
"    INNER JOIN accounts ON accounts.id=todolists.id_user \n" +
"    INNER JOIN schedules ON schedules.id=todolists.id_schedule \n" +
"    INNER JOIN todolist_categories ON todolist_categories.id=todolists.id_category \n" +
"    INNER JOIN priorities ON priorities.id=todolists.priority \n" +
"    ORDER BY todolists.created_at DESC";
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
            prepareStatement.setInt(3, todo.getIdSchedule());
            prepareStatement.setString(4, todo.getTitle());
            prepareStatement.setString(5, todo.getDetail());
            prepareStatement.setString(6, todo.getAttachement());
            prepareStatement.setInt(7, todo.getPriority());
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
            
            prepareStatement.setInt(1, todo.getIdCategory());
            prepareStatement.setInt(2, todo.getIdSchedule());
            prepareStatement.setString(3, todo.getTitle());
            prepareStatement.setString(4, todo.getDetail());
            prepareStatement.setString(5, todo.getAttachement());
            prepareStatement.setInt(6, todo.getPriority());
            prepareStatement.setInt(7, todo.getStatus());
            
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
                     resultSet.getInt("id_user"),
                     resultSet.getInt("id_category"),
                     resultSet.getInt("id_schedule"),
                     resultSet.getString("title"),
                     resultSet.getString("detail"),
                     resultSet.getString("attachement"),
                     resultSet.getInt("priority"),
                     resultSet.getString("priority_name"),
                     resultSet.getInt("status"),
                     resultSet.getString("username"),
                     resultSet.getString("category")
                );
                list.add(todo);
            }
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
}
