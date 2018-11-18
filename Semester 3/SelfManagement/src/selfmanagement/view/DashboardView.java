/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * @author izal
 */
public class DashboardView extends DefaultView {
    JFrame dashboardFrame;
    JPanel headerPanel;
    JPanel bodyPanel;
    JPanel mainPanel;
    JPanel menuPanel;
    JButton todoButton;
    JButton noteButton;
    JButton accountButton;
    JButton accountmanagementButton;
    JButton logoutButton;
    JButton contactButton;
    JLabel headerLabel;
    JLabel menuLabel;
    JLabel mainLabel;
    JLabel todoLabel;
    JLabel noteLabel;
    JLabel contactLabel;
    JLabel dashboardLabel;
    
    public DashboardView() {    
        initComponents();
    }
    
    public void initComponents() {
        dashboardFrame = new JFrame("Dashboard SelfTodos");
        dashboardFrame.setLayout(null);
        dashboardFrame.setSize(600, 850);
        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.setResizable(false);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        headerPanel = new JPanel();
        headerLabel = new JLabel("SelfTodos App");
        
        bodyPanel = new JPanel();
        dashboardLabel = new JLabel("");
        
        mainPanel = new JPanel();
        mainLabel = new JLabel("Selamat datang!");
        
        menuPanel = new JPanel();
        menuLabel = new JLabel("Dashboard Panel");
        
        todoLabel = new JLabel("Todo Hari ini : ");
        noteLabel = new JLabel("Last Note : ");
        contactLabel = new JLabel("Contact Terakhir : ");
        
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
        headerPanel.setBounds(10, 10, 580, 100);
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.add(headerLabel);
        
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 10, 200, 590);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        menuLabel.setBounds(20, 0, 200, 50);        
        menuLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        menuPanel.add(menuLabel);
        
        todoButton.setBounds(10, 60, 180, 50);
        todoButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(todoButton);
        
        noteButton.setBounds(10, 140, 180, 50);
        noteButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(noteButton);
        
        accountmanagementButton.setBounds(10, 220, 180, 50);
        accountmanagementButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(accountmanagementButton);
        
        contactButton.setBounds(10, 300, 180, 50);
        contactButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(contactButton);
        
        accountButton.setBounds(10, 380, 180, 50);
        accountButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(accountButton);
        
        logoutButton.setBounds(10, 460, 180, 50);
        logoutButton.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        menuPanel.add(logoutButton);
        
        mainPanel.setLayout(null);
        mainPanel.setBounds(180, 10, 400, 590);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        mainLabel.setBounds(40, 10, 300, 50);
        mainLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));
        mainPanel.add(mainLabel);
        
        mainPanel.add(todoLabel);
        mainPanel.add(noteLabel);
        mainPanel.add(contactLabel);
        
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(10, 100, 580, 600);
        
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

    public JLabel getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(JLabel menuLabel) {
        this.menuLabel = menuLabel;
    }

    public JLabel getMainLabel() {
        return mainLabel;
    }

    public void setMainLabel(JLabel mainLabel) {
        this.mainLabel = mainLabel;
    }

    public JLabel getTodoLabel() {
        return todoLabel;
    }

    public void setTodoLabel(JLabel todoLabel) {
        this.todoLabel = todoLabel;
    }

    public JLabel getNoteLabel() {
        return noteLabel;
    }

    public void setNoteLabel(JLabel noteLabel) {
        this.noteLabel = noteLabel;
    }

    public JLabel getContactLabel() {
        return contactLabel;
    }

    public void setContactLabel(JLabel contactLabel) {
        this.contactLabel = contactLabel;
    }

    public JLabel getDashboardLabel() {
        return dashboardLabel;
    }

    public void setDashboardLabel(JLabel dashboardLabel) {
        this.dashboardLabel = dashboardLabel;
    }
   
    public static void main(String[] args) {
        new DashboardView();
    }
}
