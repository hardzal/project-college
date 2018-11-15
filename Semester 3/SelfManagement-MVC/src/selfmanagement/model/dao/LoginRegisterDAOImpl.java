/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import selfmanagement.model.Account;
import selfmanagement.model.database.Database;

/**
 *
 * @author izal
 */
public class LoginRegisterDAOImpl implements LoginRegisterDAO {
    PreparedStatement prepareStatement;
    ResultSet resultSet;
    final String insert = "INSERT INTO accounts(username, password, level, nama, email) VALUES(?, ?, ?, ?, ?)";
    final String update = "";
    final String delete = "";
    final String selectAll = "";
    final String select = "SELECT username, password FROM accounts WHERE username=? AND password=?";
    
    @Override
    public boolean insertAccount(Account ac) {
        try {
            prepareStatement = Database.getConnection().prepareStatement(insert);
            prepareStatement.setString(0, ac.getUsername());
            prepareStatement.setString(1, ac.getPassword());
            prepareStatement.setString(2, "MEMBER");
            prepareStatement.setString(3, ac.getNama());
            prepareStatement.setString(4, ac.getEmail());
            
            if(prepareStatement.executeUpdate() > 0) {
                return true;
            }
            prepareStatement.close();
        } catch(SQLException er) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, er);
        }
        return false;
    }

    @Override
    public boolean updateAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAllAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAccount(Account ac) {
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean checkLogin(String username, String password) {
        try {
            prepareStatement = Database.getConnection().prepareStatement(select);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            
            resultSet = prepareStatement.executeQuery();
            if(!resultSet.next()) {
                return false;
            } 
            resultSet.close();
            prepareStatement.close();
        } catch(SQLException er) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, er);
        }
        return true;
    }
}

