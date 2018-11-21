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
    JPanel TodoPanel;
    JTable TodoTable;
    DefaultTableModel TodoModel;
    JScrollPane TodoScroll;
    JButton addButton;
    JButton editButton;
    JButton deleteButton;
    JButton viewButton;
    Object columnTable[] = {"Check", "Title", "End Date"};
    
    public TodolistView() {
        template(new String[]{"Todolists"});
        initComponents();
        initFrame();
    }
    
    public void initComponents() {
        TodoPanel = new JPanel();
        TodoModel = new DefaultTableModel(columnTable, 0);
        TodoTable = new JTable(TodoModel);
        TodoScroll = new JScrollPane(TodoTable);
        addButton = new JButton("Add Todolist");
        editButton = new JButton("Edit Todolist");
        deleteButton = new JButton("Delete Todolist");
        viewButton = new JButton("View Todolist");
       
        TodoPanel.setBounds(30, 30, 530, 650);
        TodoPanel.setLayout(null);
        
        TodoPanel.add(addButton);
        addButton.setBounds(10, 30, 120, 30);
        
        TodoPanel.add(viewButton);
        viewButton.setBounds(140, 30, 120, 30);
        
        TodoPanel.add(editButton);
        editButton.setBounds(270, 30, 120, 30);
        
        TodoPanel.add(deleteButton);
        deleteButton.setBounds(400, 30, 120, 30);
        
        TodoPanel.add(TodoScroll);
        TodoScroll.setBounds(10, 80, 520, 500);

        mainPanel.add(TodoPanel);
    }
    
    public static void main(String[] args) {
        new TodolistView();
    }
}
