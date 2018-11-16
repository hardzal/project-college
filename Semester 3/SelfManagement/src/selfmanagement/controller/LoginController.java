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
import selfmanagement.model.Dashboard;
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
    private LoginRegisterDAOImpl loginRegisterdaoimpl = new LoginRegisterDAOImpl();

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
                dashboardView = new DashboardView();
                dashboardController = new DashboardController(dashboardView, dashboard);
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
