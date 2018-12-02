/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JOptionPane;
import selfmanagement.view.AccountView;
import selfmanagement.model.Account;
import selfmanagement.model.AccountManagement;
import selfmanagement.model.Contactlist;
import selfmanagement.model.Dashboard;
import selfmanagement.model.Notes;
import selfmanagement.model.Todolist;
import selfmanagement.view.AccountManagementView;
import selfmanagement.view.ContactlistView;
import selfmanagement.view.DashboardView;
import selfmanagement.view.HomeView;
import selfmanagement.view.NotesView;
import selfmanagement.view.TodolistView;

/**
 *
 * @author user
 */
public class AccountController implements DefaultMenu {
    private AccountView accountView;
    private Account account;
    
    public AccountController(AccountView accountView, Account account) {
        this.accountView = accountView;
        this.account = account;
    } 
    
    public void initAccount() {
        accountView.getDashboardButton().addActionListener((el) -> dashboardFrame());
        accountView.getTodoButton().addActionListener((el) -> todoFrame());
        accountView.getNoteButton().addActionListener((el) ->  noteFrame());
        accountView.getAccountmanagementButton().addActionListener((el) -> accountManagementFrame());
        accountView.getContactButton().addActionListener((el) -> contactFrame());
        accountView.getAccountButton().addActionListener((el) -> accountFrame());
        accountView.getLogoutButton().addActionListener((el) -> logout());

    }

    @Override
    public void dashboardFrame() {
        try {
            accountView.getDashboardFrame().dispose();
            DashboardView dashboardView = new DashboardView();
            Dashboard dashboard = new Dashboard();
            DashboardController dashboardController = new DashboardController(dashboardView, dashboard);
            dashboardController.initDashboard();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void todoFrame() {
         //To change body of generated methods, choose Tools | Templates.
        try {
            accountView.getDashboardFrame().dispose();
            TodolistView todolistView = new TodolistView();
            Todolist todolist = new Todolist();
            TodolistController todolistController = new TodolistController(todolistView, todolist);
            todolistController.initTodo();
        } catch(Exception er) {

        }
    }

    @Override
    public void noteFrame() {
         //To change body of generated methods, choose Tools | Templates.
         try {
            accountView.getDashboardFrame().dispose();
            NotesView notesView = new NotesView();
            Notes notes = new Notes();
            NotesController notesController = new NotesController(notesView, notes);
            notesController.initNotes();
         } catch(Exception er) {
             
         }
    }

    @Override
    public void accountManagementFrame() {
         //To change body of generated methods, choose Tools | Templates.
        try {
            accountView.getDashboardFrame().dispose();
            AccountManagementView accountManagementView = new AccountManagementView();
            AccountManagement accountManagement = new AccountManagement();
            AccountManagementController accountManagementController = new AccountManagementController(accountManagementView, accountManagement);
            accountManagementController.initAccountManagement();

        }catch(Exception er) {
                
        }
    }

    @Override
    public void contactFrame() {
         //To change body of generated methods, choose Tools | Templates.
         try {
            accountView.getDashboardFrame().dispose();
            ContactlistView contactlistView = new ContactlistView();
            Contactlist contactlist = new Contactlist();
            ContactlistController contactlistController = new ContactlistController(contactlistView, contactlist);
            contactlistController.initContactlist();
        } catch(Exception er) {
            
        }
    }

    @Override
    public void accountFrame() {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
         //To change body of generated methods, choose Tools | Templates.
         try {
            accountView.getDashboardFrame().dispose();
            HomeView homeView = new HomeView();
            Account account = new Account();
            LoginController loginController = new LoginController(homeView, account);
            loginController.initLogin();
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "ERROR", "Gagal Logout!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
