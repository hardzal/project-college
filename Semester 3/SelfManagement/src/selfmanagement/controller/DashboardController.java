/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.model.AccountManagement;
import selfmanagement.model.Contactlist;
import selfmanagement.view.DashboardView;
import selfmanagement.model.Dashboard;
import selfmanagement.model.Notes;
import selfmanagement.model.Todolist;
import selfmanagement.view.AccountManagementView;
import selfmanagement.view.AccountView;
import selfmanagement.view.ContactlistView;
import selfmanagement.view.HomeView;
import selfmanagement.view.NotesView;
import selfmanagement.view.TodolistView;
/**
 *
 * @author izal
 */
public class DashboardController implements DefaultMenu {
    private DashboardView dashboardView;
    private Dashboard dashboard;
    
    public DashboardController(DashboardView dashboardView, Dashboard dashboard) {
        this.dashboardView = dashboardView;
        this.dashboard = dashboard;
    }
    
    public void initDashboard() {
        dashboardView.getTodoButton().addActionListener((ae) -> todoFrame());
        dashboardView.getNoteButton().addActionListener((ae) -> noteFrame());
        dashboardView.getContactButton().addActionListener((ae) -> contactFrame());
        dashboardView.getAccountmanagementButton().addActionListener((ae) -> accountManagementFrame());
        dashboardView.getContactButton().addActionListener((ae) -> contactFrame());
        dashboardView.getAccountButton().addActionListener((ae) -> accountFrame());
        dashboardView.getLogoutButton().addActionListener((ae) -> logout());
    }
    
    @Override
    public void dashboardFrame() {
        try {
            
        } catch(Exception er) {
            
        }
    }
    
    @Override
    public void todoFrame() {
        try {
            dashboardView.getDashboardFrame().dispose();
            TodolistView todolistView = new TodolistView();
            Todolist todolist = new Todolist();
            todolist.setIdUser(dashboard.getIdUser());
            TodolistController todo = new TodolistController(todolistView, todolist);
            todo.initTodo();
        } catch(Exception er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR", er.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void noteFrame() {
        try {
            dashboardView.getDashboardFrame().dispose();
            NotesView notesView = new NotesView();
            Notes notes = new Notes();
            NotesController notesController = new NotesController(notesView, notes);
            notesController.initNotes();
        } catch(Exception er) {
            
        }
    }
    
    @Override
    public void contactFrame() {
        try {
            dashboardView.getDashboardFrame().dispose();
            ContactlistView contactlistView = new ContactlistView();
            Contactlist contactlist = new Contactlist();
            ContactlistController contactlistController = new ContactlistController(contactlistView, contactlist);
            contactlistController.initContactlist();
        } catch(Exception er) {
            
        }
    }
    
    @Override
    public void accountManagementFrame() {
        try {
            dashboardView.getDashboardFrame().dispose();
            AccountManagementView accountManagementView = new AccountManagementView();
            AccountManagement accountManagement = new AccountManagement();
            AccountManagementController accountManagementController = new AccountManagementController(accountManagementView, accountManagement);
            accountManagementController.initAccountManagement();
        } catch(Exception er){
            
        }
    }
    
    @Override
    public void accountFrame() {
        try {
            dashboardView.getDashboardFrame().dispose();
            AccountView accountView = new AccountView();
            Account account = new Account();
            AccountController accountController = new AccountController(accountView, account);
            accountController.initAccount();            
        } catch(Exception er) {
            
        }
    }
    
    @Override
    public void logout() {
        try {
            dashboardView.getDashboardFrame().dispose();
            HomeView homeView = new HomeView();
            Account account = new Account();
            LoginController loginController = new LoginController(homeView, account);
            loginController.initLogin();
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "ERROR", "Gagal Logout!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
