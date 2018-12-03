/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author izal
 */
public class AccountView extends DefaultView {
    JLabel usernameLabel;
    JLabel currentPasswordLabel;
    JLabel newPasswordLabel;
    JLabel newPasswordAgainLabel;
    JLabel nameLabel;
    JLabel emailLabel;
    JTextField usernameField;
    JPasswordField currentPasswordField;
    JPasswordField newPasswordField;
    JPasswordField newPasswordAgainField;
    JTextField emailField;
    JTextField nameField;
    JButton submitButton;
    JButton deleteButton;
    
    public AccountView() {
        template(new String[]{"Account Settings"});
        initComponents();
        initFrame();
    }
    
    public void initComponents() {
        usernameLabel = new JLabel("Username");
        currentPasswordLabel = new JLabel("Current Password");
        newPasswordLabel = new JLabel("New Password");
        newPasswordAgainLabel = new JLabel("Confirm New Password");
        nameLabel = new JLabel("Name");
        emailLabel = new JLabel("Email");
        
        usernameField = new JTextField(32);
        currentPasswordField = new JPasswordField(32);
        newPasswordField = new JPasswordField(32);
        newPasswordAgainField = new JPasswordField(32);
        emailField = new JTextField(32);
        nameField = new JTextField(32);
        
        submitButton = new JButton("Update!");
        deleteButton = new JButton("Delete Account");
        
        mainPanel.add(usernameLabel);
        usernameLabel.setBounds(50, 80, 150, 50);
        usernameLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
    
        mainPanel.add(currentPasswordLabel);
        currentPasswordLabel.setBounds(50, 150, 250, 50);
        currentPasswordLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(newPasswordLabel);
        newPasswordLabel.setBounds(50, 220, 150, 50);
        newPasswordLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(newPasswordAgainLabel);
        newPasswordAgainLabel.setBounds(50, 290, 250, 50);
        newPasswordAgainLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(emailLabel);
        emailLabel.setBounds(50, 360, 150, 50);
        emailLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(nameLabel);
        nameLabel.setBounds(50, 430, 150, 50);
        nameLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(submitButton);
        submitButton.setBounds(50, 520, 150, 50);
        submitButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        
        mainPanel.add(deleteButton);
        deleteButton.setBounds(280, 520, 200, 50);
        deleteButton.setFont(new Font("Sans-serif", Font.BOLD, 16));
        
        mainPanel.add(usernameField);
        usernameField.setBounds(270, 80, 250, 40);
        usernameField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(currentPasswordField);
        currentPasswordField.setBounds(270, 150, 250, 40);
        currentPasswordField.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        mainPanel.add(newPasswordField);
        newPasswordField.setBounds(270, 220, 250, 40);
        newPasswordField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        
        mainPanel.add(newPasswordAgainField);
        newPasswordAgainField.setBounds(270, 290, 250, 40);
        newPasswordAgainField.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        mainPanel.add(emailField);
        emailField.setBounds(270, 360, 250, 40);
        emailField.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        mainPanel.add(nameField);
        nameField.setBounds(270, 430, 250, 40);
        nameField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
    }
    
    public static void main(String[] args) {
        new AccountView();
    }
}
