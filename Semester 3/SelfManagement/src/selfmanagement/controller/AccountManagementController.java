/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.view.AccountManagementView;
import selfmanagement.model.AccountManagement;
import selfmanagement.model.Contactlist;
import selfmanagement.model.Dashboard;
import selfmanagement.model.Notes;
import selfmanagement.model.Todolist;
import selfmanagement.view.AccountView;
import selfmanagement.view.ContactlistView;
import selfmanagement.view.DashboardView;
import selfmanagement.view.HomeView;
import selfmanagement.view.NotesView;
import selfmanagement.view.TodolistView;
/**
 *
 * @author user
 */
public class AccountManagementController implements DefaultMenu {
    private AccountManagementView accountManagementView;
    private AccountManagement accountManagement;
    
    public AccountManagementController(AccountManagementView accountManagementView, AccountManagement accountManagement) {
        this.accountManagementView = accountManagementView;
        this.accountManagement = accountManagement;
    }
            
    public void initAccountManagement() {
        accountManagementView.getDashboardButton().addActionListener((el) -> dashboardFrame());
        accountManagementView.getTodoButton().addActionListener((el) -> todoFrame());
        accountManagementView.getNoteButton().addActionListener((el) ->  noteFrame());
        accountManagementView.getAccountmanagementButton().addActionListener((el) -> accountManagementFrame());
        accountManagementView.getContactButton().addActionListener((el) -> contactFrame());
        accountManagementView.getAccountButton().addActionListener((el) -> accountFrame());
        accountManagementView.getLogoutButton().addActionListener((el) -> logout());

    }

    @Override
    public void dashboardFrame() {
        try {
            accountManagementView.getDashboardFrame().dispose();
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
            accountManagementView.getDashboardFrame().dispose();
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
            accountManagementView.getDashboardFrame().dispose();
            NotesView notesView = new NotesView();
            Notes notes = new Notes();
            NotesController notesController = new NotesController(notesView, notes);
            notesController.initNotes();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void accountManagementFrame() {
    }

    @Override
    public void contactFrame() {
        try {
            accountManagementView.getDashboardFrame().dispose();
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
            accountManagementView.getDashboardFrame().dispose();
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
            accountManagementView.getDashboardFrame().dispose();
            HomeView homeView = new HomeView();
            Account account = new Account();
            LoginController loginController = new LoginController(homeView, account);
            loginController.initLogin();
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "ERROR", "Gagal Logout!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
