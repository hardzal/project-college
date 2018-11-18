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

/**
 *
 * @author izal
 */
public class RegisterView extends DefaultView {
    JFrame signUpFrame;
    JPanel appPanel;
    JLabel appLabel;
    JPanel formPanel;
    JLabel formLabel;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JLabel emailLabel;
    JTextField emailField;
    JLabel nameLabel;
    JTextField nameField;
    JButton submitButton;
    JButton resetButton;
    JButton homeButton;
    
    String error[] = {
        "ERROR"
    };
    
    public RegisterView() {
        initComponents();
    }
    
    public void initComponents() {
        signUpFrame = new JFrame("Register Form - SelfTodos App");
        appPanel = new JPanel();
        appLabel = new JLabel("SelfTodos App");
        
        formPanel = new JPanel();
        formLabel = new JLabel("Sign Up");
        
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        nameLabel = new JLabel("Nama");
        emailLabel = new JLabel("Email");
        
        usernameField = new JTextField(32);
        passwordField = new JPasswordField(32);
        nameField = new JTextField(32);
        emailField = new JTextField(32);
        
        submitButton = new JButton("SUBMIT");
        resetButton = new JButton("RESET");
        homeButton = new JButton("HOME");
        
        appLabel.setOpaque(false);
        appLabel.setBounds(10, 10, 350, 50);
        appLabel.setFont(new Font("Cookie", Font.BOLD, 30));
        appLabel.setForeground(Color.white);
        appLabel.setBackground(Color.LIGHT_GRAY);

        appPanel.setBounds(10, 10, 200, 60);
        appPanel.setBackground(Color.LIGHT_GRAY);
        appPanel.add(appLabel);
        appPanel.setLayout(null);
        
        formLabel.setBounds(25, 10, 200, 100);
        formLabel.setFont(new Font("Sans-serif", Font.BOLD, 40));
        
        usernameLabel.setBounds(25, 120, 150, 30);
        usernameLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        usernameField.setBounds(160, 120, 200, 30);
        usernameField.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        
        passwordLabel.setBounds(25, 180, 150, 30);
        passwordLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        passwordField.setBounds(160, 180, 200, 30);
        passwordField.setFont(new Font("Sans-serif", Font.PLAIN, 24));

        nameLabel.setBounds(25, 240, 150, 30);
        nameLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        nameField.setBounds(160, 240, 200, 30);
        nameField.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        
        emailLabel.setBounds(25, 300, 150, 30);
        emailLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        emailField.setBounds(160, 300, 200, 30);
        emailField.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        
        submitButton.setBounds(25, 360, 150, 50);
        resetButton.setBounds(200, 360, 150, 50);
        homeButton.setBounds(120, 450, 150, 50);
        
        formPanel.setBounds(80, 120, 400, 525);
        formPanel.setBackground(Color.white);
        formPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        formPanel.setLayout(null);
        
        formPanel.add(formLabel);
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(submitButton);
        formPanel.add(resetButton);
        formPanel.add(homeButton);
        
        signUpFrame.add(appPanel);
        signUpFrame.add(formPanel);
        
        signUpFrame.setLayout(null);
        signUpFrame.setSize(600, 850);
        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setDefaultCloseOperation(3);
        signUpFrame.setResizable(false);
        signUpFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        signUpFrame.setVisible(true);        
    }
    
    public JTextField getUsername() {
        return usernameField;
    }
    
    public JTextField getPassword() {
        return passwordField;
    }
    
    public JTextField getName() {
        return nameField;
    }
    
    public JTextField getEmail() {
        return emailField;
    }
    
    public JButton getSubmit() {
        return submitButton;
    }
    
    public JButton getReset() {
        return resetButton;
    }
    
    public JButton getHome() {
        return homeButton;
    }
    
    public JFrame getSignUpFrame() {
        return signUpFrame;
    }
    
    public String errorMessage() {
       return error[0];
    }
}
