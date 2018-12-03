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

/**
 *
 * @author izal
 */
abstract class DefaultView {
    JFrame dashboardFrame;
    JPanel headerPanel;
    JPanel bodyPanel;
    JPanel mainPanel;
    JPanel menuPanel;
    JButton dashboardButton;
    JButton todoButton;
    JButton noteButton;
    JButton accountButton;
    JButton accountmanagementButton;
    JButton logoutButton;
    JButton contactButton;
    JLabel headerLabel;
    JLabel mainLabel = new JLabel("SelfTodos App");
    JLabel dashboardLabel;
    
    public void template(String label[]) {
        dashboardFrame = new JFrame(label[0] + " - SelfTodos App");
        dashboardFrame.setLayout(null);
        dashboardFrame.setSize(800, 850);
        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.setResizable(false);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        headerPanel = new JPanel();
        headerLabel = new JLabel("SelfTodos App");
        
        bodyPanel = new JPanel();
        mainPanel = new JPanel();    
        menuPanel = new JPanel();
        
        dashboardLabel = new JLabel("<html><head></head><body>Java Swing App v1.0 ©2018<br>OOP Project</body></html>");
        dashboardButton = new JButton("Dashboard");
        todoButton = new JButton("Todolist");
        noteButton = new JButton("Notes");
        accountmanagementButton = new JButton("Account List");
        contactButton = new JButton("Contact List");
        accountButton = new JButton("Account Settings");
        logoutButton = new JButton("Logout");
        
        headerLabel.setOpaque(false);
        headerLabel.setBounds(0, 0, 300, 100);
        headerLabel.setFont(new Font("Cookie", Font.BOLD, 30));
        headerLabel.setForeground(Color.white);
        headerLabel.setBackground(Color.LIGHT_GRAY);
        
        headerPanel.setLayout(null);
        headerPanel.setBounds(10, 10, 780, 100);
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.add(headerLabel);
        
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 10, 200, 690);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        dashboardButton.setBounds(10, 40, 180, 50);
        dashboardButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(dashboardButton);
        
        todoButton.setBounds(10, 120, 180, 50);
        todoButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(todoButton);
        
        noteButton.setBounds(10, 200, 180, 50);
        noteButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(noteButton);
        
        accountmanagementButton.setBounds(10, 280, 180, 50);
        accountmanagementButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(accountmanagementButton);
        
        contactButton.setBounds(10, 360, 180, 50);
        contactButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(contactButton);
        
        accountButton.setBounds(10, 440, 180, 50);
        accountButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(accountButton);
        
        logoutButton.setBounds(10, 520, 180, 50);
        logoutButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(logoutButton);
        
        dashboardLabel.setBounds(10, 630, 200, 50);
        menuPanel.add(dashboardLabel);
        
        mainPanel.setLayout(null);
        mainPanel.setBounds(180, 10, 600, 690);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        mainLabel.setBounds(40, 10, 200, 50);
        mainLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));
        mainPanel.add(mainLabel);
    }
    
    public void initFrame() {
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(10, 100, 780, 700);
        
        bodyPanel.add(menuPanel);
        bodyPanel.add(mainPanel);
        
        dashboardFrame.add(headerPanel);
        dashboardFrame.add(bodyPanel);
       
        dashboardFrame.setVisible(true);
    }
    
    public JFrame getDashboardFrame() {
        return dashboardFrame;
    }

    public void setDashboardFrame(JFrame dashboardFrame) {
        this.dashboardFrame = dashboardFrame;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(JPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public JPanel getBodyPanel() {
        return bodyPanel;
    }

    public void setBodyPanel(JPanel bodyPanel) {
        this.bodyPanel = bodyPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public JButton getDashboardButton() {
        return dashboardButton;
    }

    public void setDashboardButton(JButton dashboardButton) {
        this.dashboardButton = dashboardButton;
    }
    
    public JButton getTodoButton() {
        return todoButton;
    }

    public void setTodoButton(JButton todoButton) {
        this.todoButton = todoButton;
    }

    public JButton getNoteButton() {
        return noteButton;
    }

    public void setNoteButton(JButton noteButton) {
        this.noteButton = noteButton;
    }

    public JButton getAccountButton() {
        return accountButton;
    }

    public void setAccountButton(JButton accountButton) {
        this.accountButton = accountButton;
    }

    public JButton getAccountmanagementButton() {
        return accountmanagementButton;
    }

    public void setAccountmanagementButton(JButton accountmanagementButton) {
        this.accountmanagementButton = accountmanagementButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JButton getContactButton() {
        return contactButton;
    }

    public void setContactButton(JButton contactButton) {
        this.contactButton = contactButton;
    }

    public JLabel getHeaderLabel() {
        return headerLabel;
    }

    public void setHeaderLabel(JLabel headerLabel) {
        this.headerLabel = headerLabel;
    }

    public JLabel getMainLabel() {
        return mainLabel;
    }

    public void setMainLabel(JLabel mainLabel) {
        this.mainLabel = mainLabel;
    }

    public JLabel getDashboardLabel() {
        return dashboardLabel;
    }

    public void setDashboardLabel(JLabel dashboardLabel) {
        this.dashboardLabel = dashboardLabel;
    }
}
