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
        TodoModel = new DefaultTableModel(columnTable, 5);
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
        TodoTable.setCellSelectionEnabled(true);
        TodoTable.getTableHeader().setReorderingAllowed(false);
        TodoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TodoTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        TodoTable.getColumnModel().getColumn(1).setPreferredWidth(350);
        TodoTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        TodoScroll.setBounds(10, 80, 520, 500);

        mainPanel.add(TodoPanel);
    }

    public JPanel getTodoPanel() {
        return TodoPanel;
    }

    public void setTodoPanel(JPanel TodoPanel) {
        this.TodoPanel = TodoPanel;
    }

    public JTable getTodoTable() {
        return TodoTable;
    }

    public void setTodoTable(JTable TodoTable) {
        this.TodoTable = TodoTable;
    }

    public DefaultTableModel getTodoModel() {
        return TodoModel;
    }

    public void setTodoModel(DefaultTableModel TodoModel) {
        this.TodoModel = TodoModel;
    }

    public JScrollPane getTodoScroll() {
        return TodoScroll;
    }

    public void setTodoScroll(JScrollPane TodoScroll) {
        this.TodoScroll = TodoScroll;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public void setViewButton(JButton viewButton) {
        this.viewButton = viewButton;
    }

    public Object[] getColumnTable() {
        return columnTable;
    }

    public void setColumnTable(Object[] columnTable) {
        this.columnTable = columnTable;
    }

    public static void main(String[] args) {
        new TodolistView();
    }
}
