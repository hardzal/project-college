/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model;

/**
 *
 * @author izal
 */
public class AccountManagement extends Parent{
    private String platform;
    private String username;
    private String password;
    private String email;

    public AccountManagement() {}

    public AccountManagement(int id, String platform, String username, String password, String email) {
        this.id = id;
        this.platform = platform;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
