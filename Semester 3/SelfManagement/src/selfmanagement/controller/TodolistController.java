/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import selfmanagement.view.TodolistView;
import selfmanagement.model.Todolist;
import selfmanagement.view.DashboardView;
import selfmanagement.model.Dashboard;
import selfmanagement.model.dao.TodolistDAOImpl;
/**
 *
 * @author user
 */
public class TodolistController implements DefaultMenu {
    private TodolistView todolistView;
    private Todolist todolist;
    private DashboardView dashboardView;
    private Dashboard dashboard;
    private List<Todolist> list;
    private TodolistDAOImpl todolistDAOImpl;
    
    public TodolistController(TodolistView todolistView, Todolist todolist) {
        this.todolist = todolist;
        this.todolistView = todolistView;
        todolistDAOImpl = new TodolistDAOImpl();
        list = todolistDAOImpl.getAllTodolist();
    }
    
    public void initTodo() {
        todolistView.getDashboardButton().addActionListener((ae) -> dashboardFrame());
        todolistView.getAddButton().addActionListener((ae) -> addTodoFrame());
        todolistView.getEditButton().addActionListener((ae) -> editTodoFrame());
        todolistView.getDeleteButton().addActionListener((ae) -> deleteTodoFrame());
        todolistView.getViewButton().addActionListener((ae) -> viewTodoFrame());
    }
    
    public void reloadData() {
        try {
            list = todolistDAOImpl.getAllTodolist();
            Object[] kolom = todolistView.getColumnTable();
            for(Todolist todo : list) {
                Object[] isi = new Object[3];
                isi[0] = todo.getStatus();
                isi[1] = todo.getTitle();
                isi[2] = todo.getDateend();
                todolistView.getTodoModel().addRow(isi);
            }
            todolistView.getTodoTable().setModel(todolistView.getTodoModel());
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "ERROR", er.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void dashboardFrame() {
        try {
            todolistView.getDashboardFrame().dispose();
            dashboardView = new DashboardView();
            dashboard = new Dashboard();
            DashboardController dashboardController = new DashboardController(dashboardView, dashboard);
            dashboardController.initDashboard();
        } catch(Exception er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR", er.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void todoFrame() {
        try {
            reloadData();
            
        } catch(Exception er) {
            
        }
    }

    @Override
    public void noteFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accountManagementFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contactFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accountFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addTodoFrame() {
       try {
           
           
       } catch(Exception er) {
           
       }
    }
    
    public void editTodoFrame() {
        try {
            
        } catch(Exception er) {
            
        }
    }
    
    public void deleteTodoFrame() {
        try {
            
        } catch(Exception er) {
            
        }
    }
    
    public void viewTodoFrame() {
        try {
            
        } catch(Exception er) {
            
        }
    }
}
