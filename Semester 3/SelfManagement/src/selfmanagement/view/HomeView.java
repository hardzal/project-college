    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// CREATED 11-11-2018
/**
 *
 * @author izal
 */
public class HomeView extends DefaultView {
    JFrame homeFrame;
    JPanel messagePanel;
    JLabel appLabel;
    JLabel signupMessageLabel;
    JLabel forgotPasswordMessageLabel;
    JButton signupButton;
    JButton forgotPasswordButton;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton resetButton;
    JPanel loginPanel;
    
    public HomeView() {
        initComponents();
    }
    
    public void initComponents() {
        
        homeFrame = new JFrame("SelfTodos App");
        appLabel = new JLabel("SelfTodos App");
        messagePanel = new JPanel();
        signupMessageLabel = new JLabel("Sign Up here!");
        signupButton = new JButton("Sign Up");
        forgotPasswordMessageLabel = new JLabel("Forgot Password?");
        forgotPasswordButton = new JButton("Forgot Password");
       
        loginPanel  = new JPanel();
        
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        
        usernameField = new JTextField(32);
        passwordField = new JPasswordField(32);
        
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        
        
        appLabel.setOpaque(true);
        appLabel.setBounds(100, 50, 400, 100);
        appLabel.setFont(new Font("Cookie", Font.BOLD, 80));
        appLabel.setForeground(Color.white);
        appLabel.setBackground(Color.LIGHT_GRAY);
        
        messagePanel.setBounds(150, 560, 300, 150);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        messagePanel.setBackground(Color.white);
        
        signupMessageLabel.setBounds(25, 25, 120, 30);
        signupButton.setBounds(150, 25, 120, 30);
        
        forgotPasswordMessageLabel.setBounds(25, 80, 120, 30);
        forgotPasswordButton.setBounds(150, 80, 140, 30);
        
        messagePanel.add(signupMessageLabel);
        messagePanel.add(signupButton);
        messagePanel.add(forgotPasswordMessageLabel);
        messagePanel.add(forgotPasswordButton);
        messagePanel.setLayout(null);
      
        homeFrame.add(appLabel);
       
        loginPanel.setBounds(150, 200, 300, 350);
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        loginPanel.setBackground(Color.white);
        
        usernameLabel.setBounds(25, 25, 100, 40);
        usernameLabel.setFont(new Font("Sans-serif", Font.CENTER_BASELINE, 20));
        usernameField.setBounds(25, 75, 250, 50);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        passwordLabel.setBounds(25, 150, 100, 40);
        passwordLabel.setFont(new Font("Sans-serif", Font.CENTER_BASELINE, 20));
        passwordField.setBounds(25, 200, 250, 50);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));

        loginButton.setBounds(25, 275, 100, 50);
        resetButton.setBounds(150, 275, 100, 50);
        
        loginPanel.add(usernameLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(resetButton);
        loginPanel.setLayout(null);
        
        homeFrame.add(loginPanel);
        homeFrame.add(messagePanel);
        
        homeFrame.setLayout(null);
        homeFrame.setDefaultCloseOperation(3);
        homeFrame.setSize(600, 850);
        homeFrame.getContentPane().setBackground(Color.LIGHT_GRAY);      
        
        homeFrame.setResizable(true);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setVisible(true);
    }
    
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    public JTextField getPasswordField() {
        return passwordField;
    }
    
    public JButton getLoginButton() {
        return loginButton;
    }
    
    public JButton getResetButton() {
        return resetButton;
    }
    
    public JButton getSignUpButton() {
        return signupButton;
    }
    
    public JButton getForgotPasswordButton() {
        return forgotPasswordButton;
    }
    
    public JFrame getHomeFrame() {
        return homeFrame;
    }
}
