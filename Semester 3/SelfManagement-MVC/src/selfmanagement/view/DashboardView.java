/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * @author izal
 */
public class DashboardView {
    JFrame dashboardFrame;
    JPanel appPanel;
    JLabel appLabel;
    JPanel dashboardPanel;
    JPanel mainPanel;
    JPanel menuPanel;
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
        dashboardFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
    
        dashboardFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new DashboardView();
    }
}
