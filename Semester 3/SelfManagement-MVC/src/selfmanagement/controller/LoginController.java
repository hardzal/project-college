/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.model.dao.LoginRegisterDAOImpl;
import selfmanagement.view.DashboardView;
import selfmanagement.view.HomeView;

/**
 *
 * @author izal
 */
public class LoginController {
    private Account account;
    private HomeView homeView;
    private DashboardView dashboardView;
    private LoginRegisterDAOImpl loginRegisterdaoimpl = new LoginRegisterDAOImpl();
    private RegisterController registerController;
    private DashboardController dashboardController;
    
    
    public LoginController(HomeView homeView, Account account) {
        this.account = account;
        this.homeView = homeView;
    }
    
    public void initLogin() {
        homeView.getLoginButton().addActionListener(e -> login());
        homeView.getResetButton().addActionListener(e -> reset());
        homeView.getSignUpButton().addActionListener(e -> register());
        homeView.getForgotPasswordButton().addActionListener(e -> forgotPassword());
    }
    
    public void login() {
        try {
            if(loginRegisterdaoimpl.checkLogin(homeView.getUsernameField().getText(), homeView.getPasswordField().getText())) {
                JOptionPane.showMessageDialog(null, "Login Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
                homeView.getHomeFrame().dispose();
                dashboardController = new DashboardController();
                dashboardController.initDashboard();
            } else {
                JOptionPane.showMessageDialog(null, "Username/Passsword Wrong!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception er) {
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
            registerController = new RegisterController();
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
