/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.model.dao.AccountDAOImpl;
import selfmanagement.view.DashboardView;
import selfmanagement.view.HomeView;
import selfmanagement.model.Dashboard;
import selfmanagement.model.database.Database;
import selfmanagement.view.RegisterView;
/**
 *
 * @author izal
 */
public class LoginController {
    private Account account;
    private Dashboard dashboard;
    private HomeView homeView;
    private DashboardView dashboardView;
    private RegisterController registerController;
    private DashboardController dashboardController;
    private AccountDAOImpl loginRegisterdaoimpl; 

    public LoginController(HomeView homeView, Account account) {
        this.account = account;
        this.homeView = homeView;
        loginRegisterdaoimpl = new AccountDAOImpl();
    }
    
    public void initLogin() {
        homeView.getLoginButton().addActionListener(e -> login());
        homeView.getResetButton().addActionListener(e -> reset());
        homeView.getSignUpButton().addActionListener(e -> register());
        homeView.getForgotPasswordButton().addActionListener(e -> forgotPassword());
    }
    
    public void login() {
        try {
            if(!homeView.getUsernameField().getText().trim().isEmpty() && !homeView.getPasswordField().getText().trim().isEmpty()) {
                if(Database.getConnection() != null) {
                    if(loginRegisterdaoimpl.checkLogin(homeView.getUsernameField().getText().trim(), homeView.getPasswordField().getText().trim())) {
                        JOptionPane.showMessageDialog(null, "Login Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        homeView.getHomeFrame().dispose();
                        dashboardView = new DashboardView();
                        dashboard = new Dashboard();
                        dashboard.setIdUser(loginRegisterdaoimpl.getIdUser());
                        dashboardController = new DashboardController(dashboardView, dashboard);
                        dashboardController.initDashboard();
                    } else {
                        reset();
                        JOptionPane.showMessageDialog(null, "Username/Passsword Wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Database belum terkoneksi");
                } 
            } else {
                JOptionPane.showMessageDialog(null, "Please Fill Username/Password Field!", "ERROR",  JOptionPane.ERROR_MESSAGE);
            }
        }
       catch(Exception er) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, er);
        }
    }
    
    public void reset() {
        try {
            homeView.getUsernameField().setText("");
            homeView.getPasswordField().setText("");
        } catch(Exception er) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, er);
        }
    }
    
    public void register() {
        try {
            homeView.getHomeFrame().dispose();
            RegisterView registerView = new RegisterView();
            Account account = new Account();
            registerController = new RegisterController(registerView, account);
            registerController.initRegister();
        } catch(Exception er) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, er);
        }
    }
    
    public void forgotPassword() {
        try {
            
        } catch(Exception er) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, er);
        }
    }
}
