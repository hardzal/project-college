/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.model.AccountManagement;
import selfmanagement.model.Contactlist;
import selfmanagement.model.Dashboard;
import selfmanagement.view.NotesView;
import selfmanagement.model.Notes;
import selfmanagement.model.Todolist;
import selfmanagement.view.AccountManagementView;
import selfmanagement.view.AccountView;
import selfmanagement.view.ContactlistView;
import selfmanagement.view.DashboardView;
import selfmanagement.view.HomeView;
import selfmanagement.view.TodolistView;

/**
 *
 * @author user
 */
public class NotesController implements DefaultMenu {
    private NotesView notesView;
    private Notes notes;
    
    public NotesController(NotesView notesView, Notes notes) {
        this.notesView = notesView;
        this.notes = notes;
    }
    
    public void initNotes() {
        notesView.getDashboardButton().addActionListener((el) -> dashboardFrame());
        notesView.getTodoButton().addActionListener((el) -> todoFrame());
        notesView.getNoteButton().addActionListener((el) ->  noteFrame());
        notesView.getAccountmanagementButton().addActionListener((el) -> accountManagementFrame());
        notesView.getContactButton().addActionListener((el) -> contactFrame());
        notesView.getAccountButton().addActionListener((el) -> accountFrame());
        notesView.getLogoutButton().addActionListener((el) -> logout());
    }

    @Override
    public void dashboardFrame() {
        try {
            notesView.getDashboardFrame().dispose();
            DashboardView dashboardView = new DashboardView();
            Dashboard dashboard = new Dashboard();
            DashboardController dashboardController = new DashboardController(dashboardView, dashboard);
            dashboardController.initDashboard();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void todoFrame() {
        try {
            notesView.getDashboardFrame().dispose();
            TodolistView todolistView = new TodolistView();
            Todolist todolist = new Todolist();
            TodolistController todolistController = new TodolistController(todolistView, todolist);
            todolistController.initTodo();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void noteFrame() {
        try {
            
        } catch(Exception er) {
            
        }
    }

    @Override
    public void accountManagementFrame() {
        try {
            notesView.getDashboardFrame().dispose();
            AccountManagementView accountManagementView = new AccountManagementView();
            AccountManagement accountManagement = new AccountManagement();
            AccountManagementController accountManagementController = new AccountManagementController(accountManagementView, accountManagement);
            accountManagementController.initAccountManagement();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void contactFrame() {
        try {
            notesView.getDashboardFrame().dispose();
            ContactlistView contactlistView = new ContactlistView();
            Contactlist contactlist = new Contactlist();
            ContactlistController contactlistController = new ContactlistController(contactlistView, contactlist);
            contactlistController.initContactlist();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void accountFrame() {
        try {
            notesView.getDashboardFrame().dispose();
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
            int input = JOptionPane.showConfirmDialog(null, "Ingin Logout?","",JOptionPane.YES_NO_OPTION);
            if(input == 0) {
                notesView.getDashboardFrame().dispose();
                HomeView homeView = new HomeView();
                Account account = new Account();
                LoginController loginController = new LoginController(homeView, account);
                loginController.initLogin();
            } 
        } catch(Exception er) {
           er.printStackTrace();
        }
    } 
}
