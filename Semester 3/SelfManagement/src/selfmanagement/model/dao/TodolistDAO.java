/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.dao;

import java.util.List;
import selfmanagement.model.Todolist;
/**
 *
 * @author izal
 */
public interface TodolistDAO {
    
    public boolean insertTodolist(Todolist todo);
    public boolean updateTodolist(Todolist todo);
    public boolean deleteTodolist(int id);
    public List<Todolist> getAllTodolist(int idUser);
    public Todolist getTodolist(int id);
}
