/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TodolistView extends DefaultView {
    JPanel TodoPanel;
    JTable TodoTable;
    DefaultTableModel TodoModel;
    JTextField searchField;
    JComboBox categoryCombo;
    JScrollPane TodoScroll;
    JButton addButton;
    JButton editButton;
    JButton deleteButton;
    JButton doneButton;
    JButton searchButton;
    
    Object columnTable[] = {"ID", "Check", "Title", "End Date"};
    
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
        searchField = new JTextField(32);
        categoryCombo = new JComboBox(new Object[]{"Private", "Learning", "Working"});
        addButton = new JButton("Add Todolist");
        editButton = new JButton("Edit Todolist");
        deleteButton = new JButton("Delete Todolist");
        doneButton = new JButton("Completed Todos");
        searchButton = new JButton("Search!");
        
        TodoPanel.setBounds(30, 30, 530, 650);
        TodoPanel.setLayout(null);
        
        mainPanel.add(doneButton);
        doneButton.setBounds(40, 620, 140, 30);
        
        mainPanel.add(searchField);
        searchField.setBounds(200, 620, 130, 30);
        
        mainPanel.add(categoryCombo);
        categoryCombo.setBounds(340, 620, 120, 30);
        
        mainPanel.add(searchButton);
        searchButton.setBounds(470, 620, 100, 30);
        
        mainLabel.setText("Todolist Hari ini");
        
        TodoPanel.add(addButton);
        addButton.setBounds(10, 30, 120, 30);
       
        TodoPanel.add(editButton);
        editButton.setBounds(210, 30, 120, 30);
        
        TodoPanel.add(deleteButton);
        deleteButton.setBounds(400, 30, 120, 30);
        
        TodoPanel.add(TodoScroll);
        TodoTable.setCellSelectionEnabled(true);
        TodoTable.getTableHeader().setReorderingAllowed(false);
        TodoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TodoTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        TodoTable.getColumnModel().getColumn(1).setPreferredWidth(67);
        TodoTable.getColumnModel().getColumn(2).setPreferredWidth(265);
        TodoTable.getColumnModel().getColumn(3).setPreferredWidth(150);
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
    
    public Object[] getColumnTable() {
        return columnTable;
    }

    public void setColumnTable(Object[] columnTable) {
        this.columnTable = columnTable;
    }
    
    public String getIdTodo() {
        int row = TodoTable.getSelectedRow();
        int column = TodoTable.getSelectedColumn();
        return TodoTable.getValueAt(row, 0).toString();
    }
    
    public static void main(String[] args) {
        new TodolistView();
    }
}
