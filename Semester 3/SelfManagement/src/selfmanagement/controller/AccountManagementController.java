/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import selfmanagement.view.AccountManagementView;
import selfmanagement.model.AccountManagement;
/**
 *
 * @author user
 */
public class AccountManagementController {
    private AccountManagementView accountManagementView;
    private AccountManagement accountManagement;
    
    public AccountManagementController(AccountManagementView accountManagementView, AccountManagement accountManagement) {
        this.accountManagementView = accountManagementView;
        this.accountManagement = accountManagement;
    }
            
    public void initAccountManagement() {
        
    }
}
