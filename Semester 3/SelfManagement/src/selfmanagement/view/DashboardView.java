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
    
    public DashboardView() {    
        initComponents();
    }
    
    public void initComponents() {
        template(new String[]{"Dashboard", "Menu Panel"});
    }

    public static void main(String[] args) {
        new DashboardView();
    }
}
