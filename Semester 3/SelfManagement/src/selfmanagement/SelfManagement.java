/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement;

import selfmanagement.controller.LoginController;
import selfmanagement.model.Account;
import selfmanagement.view.HomeView;

/**
 *
 * @author izal
 */
public class SelfManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Account account = new Account();
        HomeView homeView = new HomeView();
        LoginController loginController = new LoginController(homeView, account);
        loginController.initLogin();
    }
    
}
