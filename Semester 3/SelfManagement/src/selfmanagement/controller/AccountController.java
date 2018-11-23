/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import selfmanagement.view.AccountView;
import selfmanagement.model.Account;

/**
 *
 * @author user
 */
public class AccountController {
    private AccountView accountView;
    private Account account;
    
    public AccountController(AccountView accountView, Account account) {
        this.accountView = accountView;
        this.account = account;
    } 
    
    public void initAccount() {
        
    }
}
