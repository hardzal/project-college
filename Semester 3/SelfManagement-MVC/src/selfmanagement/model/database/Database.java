/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author izal
 */
public class Database {
    private static Connection connection = null;
    
    private static String hostDB = "jdbc:mysql://localhost/project_pbo_selfmanagement";
    private static String usernameDB = "root";
    private static String passwordDB = "";
    private static String libDB = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName(libDB);
                connection = (Connection) DriverManager.getConnection(hostDB, usernameDB, passwordDB);
            } catch(ClassNotFoundException | SQLException er) {
                er.printStackTrace();
                return null;
            }
        }
        return connection;
    }
    
}
