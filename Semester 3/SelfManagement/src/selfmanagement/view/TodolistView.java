/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author izal
 */
public class TodolistView extends DefaultView {

    JLabel TodoLabel;
    JPanel TodoPanel;
    JTable TodoTable;
    DefaultTableModel TodoModel;
    JScrollPane TodoScroll;
    JButton addButton;
    JButton editButton;
    JButton deleteButton;
    JButton viewButton;
    
    Object data[][];
    Object columnTable[] = {"Check", "Title", "Start Date", "End Date", "Priority"};
    
    public TodolistView() {
        template(new String[]{"Todolists"});
        initComponents();
        initFrame();
    }
    
    public void initComponents() {
        TodoPanel = new JPanel();
        TodoLabel = new JLabel("Todo Hari ini : ");
        TodoModel = new DefaultTableModel(columnTable, 0);
        TodoTable = new JTable(TodoModel);
        TodoScroll = new JScrollPane(TodoTable);
        
        TodoPanel.setBounds(30, 30, 350, 550);
        TodoPanel.setLayout(null);

        TodoPanel.add(TodoLabel);
        TodoLabel.setBounds(10, 10, 100, 50);

        TodoPanel.add(TodoScroll);
        TodoScroll.setBounds(10, 60, 300, 450);

        mainPanel.add(TodoPanel);
    }
    
    public static void main(String[] args) {
        new TodolistView();
    }
}
