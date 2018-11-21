/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.dao;

import java.util.List;
import selfmanagement.model.Account;

/**
 *
 * @author izal
 */
public interface AccountDAO {
    
    public boolean insertAccount(Account ac);
    public boolean updateAccount();
    public boolean deleteAccount();
    public List<Account> getAllAccount(Account ac);
    public List<Account> getAccount(Account ac);
    public boolean checkLogin(String username, String password);
    
}
