/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.model.dao.AccountDAOImpl;
import selfmanagement.view.HomeView;
import selfmanagement.view.RegisterView;
import selfmanagement.model.dao.AccountDAO;

/**
 *
 * @author izal
 */
public class RegisterController {
    private RegisterView registerView;
    private Account account;
    private AccountDAOImpl loginRegisterDAOImpl = new AccountDAOImpl();
    
    public RegisterController(RegisterView registerView, Account account) {
        this.registerView = registerView;
        this.account = account;
    }
    
    public void initRegister() {
        registerView.getSubmit().addActionListener(el -> register());
        registerView.getReset().addActionListener(el -> reset());
        registerView.getHome().addActionListener(el -> home());
    }
    
    public void register() {
        try {
            account = new Account(
                    registerView.getUsername().getText(), 
                    registerView.getPassword().getText(), 
                    "MEMBER", 
                    registerView.getName().getText(), 
                    registerView.getEmail().getText()
            );
            if(loginRegisterDAOImpl.insertAccount(account)) {
                JOptionPane.showMessageDialog(null, "Account Created", "Register Account", JOptionPane.INFORMATION_MESSAGE);
                reset();
            } else { 
                JOptionPane.showMessageDialog(null, "Username/Email sudah ada!", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "ERROR", "error created account "+er, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void reset() {
        try {
            registerView.getName().setText("");
            registerView.getEmail().setText("");
            registerView.getPassword().setText("");
            registerView.getUsername().setText("");
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "Error reset field "+ er, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void home() {
        try {
            registerView.getSignUpFrame().dispose();
            HomeView homeView = new HomeView();
            LoginController loginController = new LoginController(homeView, account);
            loginController.initLogin();
        } catch(Exception er) {
            JOptionPane.showMessageDialog(null, "Gagal Kembali", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
