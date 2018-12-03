/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class AccountDAOImpl implements AccountDAO {
    private int id;
    PreparedStatement prepareStatement;
    Statement statement;
    ResultSet resultSet;
    final String insert = "INSERT INTO accounts(username, password, name, email) VALUES(?, ?, ?, ?)";
    final String update = "";
    final String delete = "";
    final String selectAll = "";
    final String select = "SELECT * FROM accounts WHERE username=? AND password=?";
    
    @Override
    public boolean insertAccount(Account ac) {
        try {
            String sql = "SELECT * FROM accounts WHERE username = ? OR email = ?";
            prepareStatement = Database.getConnection().prepareStatement(sql);
            prepareStatement.setString(1, ac.getUsername());
            prepareStatement.setString(2, ac.getEmail());
            resultSet = prepareStatement.executeQuery();
            if(resultSet.next()) {
                prepareStatement.close();
                return false;
             }
            resultSet.close();
            prepareStatement.close();
            //// continue statement if true
            prepareStatement = Database.getConnection().prepareStatement(insert);

            prepareStatement.setString(1, ac.getUsername());
            prepareStatement.setString(2, ac.getPassword());
            prepareStatement.setString(3, ac.getName());
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
    public List<Account> getAllAccount(Account ac) {
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
            this.id = resultSet.getInt("id");
            resultSet.close();
            prepareStatement.close();
        } catch(SQLException er) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, er);
        }
        return true;
    }
    
    public int getIdUser() {
        return id;
    }
}

