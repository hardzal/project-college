/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import selfmanagement.model.Account;
import selfmanagement.view.DashboardView;
import selfmanagement.model.Dashboard;
import selfmanagement.view.HomeView;
/**
 *
 * @author izal
 */
public class DashboardController {
    private DashboardView dashboardView;
    private Dashboard dashboard;
    
    public DashboardController(DashboardView dashboardView, Dashboard dashboard) {
        this.dashboardView = dashboardView;
        this.dashboard = dashboard;
    }
    
    public void initDashboard() {
        dashboardView.getLogoutButton().addActionListener((ae) -> logout());
    }
    
    public void todo() {
        
    }
    
    public void note() {
        
    }
    
    public void contact() {
        
    }
    
    public void accountManagement() {
        
    }
    
    public void account() {
        
    }
    
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
