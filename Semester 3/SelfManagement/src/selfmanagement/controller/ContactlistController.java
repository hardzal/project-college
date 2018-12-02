/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.model.AccountManagement;
import selfmanagement.view.ContactlistView;
import selfmanagement.model.Contactlist;
import selfmanagement.model.Dashboard;
import selfmanagement.model.Notes;
import selfmanagement.model.Todolist;
import selfmanagement.view.AccountManagementView;
import selfmanagement.view.AccountView;
import selfmanagement.view.DashboardView;
import selfmanagement.view.HomeView;
import selfmanagement.view.NotesView;
import selfmanagement.view.TodolistView;

/**
 *
 * @author user
 */
public class ContactlistController implements DefaultMenu {
    private ContactlistView contactlistView;
    private Contactlist contactlist;
    
    public ContactlistController(ContactlistView contactlistView, Contactlist contactlist) {
        this.contactlistView = contactlistView;
        this.contactlist = contactlist;
    }
    
    public void initContactlist() {
        contactlistView.getDashboardButton().addActionListener((el) -> dashboardFrame());
        contactlistView.getTodoButton().addActionListener((el) -> todoFrame());
        contactlistView.getNoteButton().addActionListener((el) ->  noteFrame());
        contactlistView.getAccountmanagementButton().addActionListener((el) -> accountManagementFrame());
        contactlistView.getContactButton().addActionListener((el) -> contactFrame());
        contactlistView.getAccountButton().addActionListener((el) -> accountFrame());
        contactlistView.getLogoutButton().addActionListener((el) -> logout());

    }

    @Override
    public void dashboardFrame() {
        try {
            contactlistView.getDashboardFrame().dispose();
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
            contactlistView.getDashboardFrame().dispose();
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
            contactlistView.getDashboardFrame().dispose();
            NotesView notesView = new NotesView();
            Notes notes = new Notes();
            NotesController notesController = new NotesController(notesView, notes);
            notesController.initNotes();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void accountManagementFrame() {
        try {
            contactlistView.getDashboardFrame().dispose();
            AccountManagementView accountManagementView = new AccountManagementView();
            AccountManagement accountManagement = new AccountManagement();
            AccountManagementController accountManagementController = new AccountManagementController(accountManagementView, accountManagement);
            accountManagementController.initAccountManagement();
        } catch(Exception er) {
            
        }

    }

    @Override
    public void contactFrame() {
    }

    @Override
    public void accountFrame() {
        try {
            contactlistView.getDashboardFrame().dispose();
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
            contactlistView.getDashboardFrame().dispose();
            HomeView homeView = new HomeView();
            Account account = new Account();
            LoginController loginController = new LoginController(homeView, account);
            loginController.initLogin();
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "ERROR", "Gagal Logout!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
