/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import selfmanagement.model.Todolist;
import selfmanagement.model.dao.TodolistDAOImpl;

/**
 *
 * @author user
 */
public class TodolistFormView {
    JFrame todoFrame;
    JPanel todoPanel;
    JLabel todoLabel;
    JLabel titleTodoLabel;
    JLabel dateEndTodoLabel;
    JLabel statusLabel;
    JLabel priorityLabel;
    JLabel detailLabel;
    JLabel categoryLabel;
    JLabel attachementLabel;
    JTextField titleField;
    JTextField dateEndField;
    JComboBox categoryCombo;
    Object[] categoryTodo;
    JComboBox priorityCombo;
    Object[] priorityTodo;
    JComboBox statusCombo;
    Object[] statusTodo;
    JButton attachementFileButton;
    JTextArea detailTextArea;
    JButton submitButton;
    JButton resetButton;
    
    Todolist todo;
    TodolistDAOImpl todoDAO;
    
    public TodolistFormView() {
        initComponents();
        todo = new Todolist();
        todoDAO = new TodolistDAOImpl();
    }
    
    @SuppressWarnings("empty-statement")
    public void initComponents() {
        todoFrame = new JFrame("Add new Todo");
        todoFrame.setLayout(null);
        todoFrame.setSize(400, 600);
//        todoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        todoFrame.setLocationRelativeTo(null);
        todoFrame.setResizable(false);
        
        todoPanel = new JPanel();
        todoPanel.setLayout(null);
        todoPanel.setBounds(10, 10, 360, 560);
        
        todoLabel = new JLabel("Add New Todo");
        todoLabel.setBounds(10, 10, 150, 30);
        todoLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
        
        titleTodoLabel = new JLabel("Title Todo");
        titleTodoLabel.setBounds(10, 60, 100, 30);
        titleTodoLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        dateEndTodoLabel = new JLabel("Deadline");
        dateEndTodoLabel.setBounds(10, 100, 100, 30);
        dateEndTodoLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(10, 140, 100, 30);
        categoryLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        priorityLabel = new JLabel("Prioritas");
        priorityLabel.setBounds(10, 180, 100, 30);
        priorityLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(10, 220, 100, 30);
        statusLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        attachementLabel = new JLabel("Attachement");
        attachementLabel.setBounds(10, 260, 100, 30);
        attachementLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        detailLabel = new JLabel("Detail");
        detailLabel.setBounds(10, 300, 100, 30);
        detailLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));

        titleField = new JTextField(32);
        titleField.setBounds(120, 60, 225, 30);
        titleField.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        dateEndField = new JTextField(12);
        dateEndField.setBounds(120, 100, 225, 30);
        dateEndField.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        
        categoryTodo = new Object[]{"Work", "Learn", "Travel"};
        categoryCombo = new JComboBox(categoryTodo);
        categoryCombo.setBounds(120, 140, 100, 30);
    
        priorityTodo = new Object[]{"High", "Medium", "Low"};
        priorityCombo = new JComboBox(priorityTodo);
        priorityCombo.setBounds(120, 180, 100, 30);
        
        statusTodo = new Object[]{"Progress", "Done"};
        statusCombo = new JComboBox(statusTodo);
        statusCombo.setBounds(120, 220, 100, 30);
        
        attachementFileButton = new JButton("Upload");
        attachementFileButton.setBounds(120, 260, 100, 30);
        
        detailTextArea = new JTextArea();
        detailTextArea.setBounds(120, 300, 225, 150);
        detailTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(120, 475, 100, 40);
        
        resetButton = new JButton("Reset");
        resetButton.setBounds(240, 475, 100, 40);
        
        todoPanel.add(todoLabel);
        todoPanel.add(titleTodoLabel);
        todoPanel.add(dateEndTodoLabel);
        todoPanel.add(categoryLabel);
        todoPanel.add(priorityLabel);
        todoPanel.add(statusLabel);
        todoPanel.add(attachementLabel);
        todoPanel.add(detailLabel);
        
        todoPanel.add(titleField);
        todoPanel.add(dateEndField);
        todoPanel.add(categoryCombo);
        todoPanel.add(priorityCombo);
        todoPanel.add(statusCombo);
        todoPanel.add(attachementFileButton);
        todoPanel.add(detailTextArea);
        todoPanel.add(submitButton);
        todoPanel.add(resetButton);
        
        todoFrame.add(todoPanel);
    }

    public JFrame getTodoFrame() {
        return todoFrame;
    }

    public void setTodoFrame(JFrame todoFrame) {
        this.todoFrame = todoFrame;
    }

    public JPanel getTodoPanel() {
        return todoPanel;
    }

    public void setTodoPanel(JPanel todoPanel) {
        this.todoPanel = todoPanel;
    }

    public JLabel getTodoLabel() {
        return todoLabel;
    }

    public void setTodoLabel(JLabel todoLabel) {
        this.todoLabel = todoLabel;
    }

    public JLabel getTitleTodoLabel() {
        return titleTodoLabel;
    }

    public void setTitleTodoLabel(JLabel titleTodoLabel) {
        this.titleTodoLabel = titleTodoLabel;
    }

    public JLabel getDateEndTodoLabel() {
        return dateEndTodoLabel;
    }

    public void setDateEndTodoLabel(JLabel dateEndTodoLabel) {
        this.dateEndTodoLabel = dateEndTodoLabel;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public JLabel getPriorityLabel() {
        return priorityLabel;
    }

    public void setPriorityLabel(JLabel priorityLabel) {
        this.priorityLabel = priorityLabel;
    }

    public JLabel getDetailLabel() {
        return detailLabel;
    }

    public void setDetailLabel(JLabel detailLabel) {
        this.detailLabel = detailLabel;
    }

    public JLabel getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(JLabel categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public JLabel getAttachementLabel() {
        return attachementLabel;
    }

    public void setAttachementLabel(JLabel attachementLabel) {
        this.attachementLabel = attachementLabel;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public void setTitleField(String titleField) {
        this.titleField.setText(titleField);
    }

    public JTextField getDateEndField() {
        return dateEndField;
    }

    public void setDateEndField(String dateEndField) {
        this.dateEndField.setText(dateEndField);
    }

    public JComboBox getCategoryCombo() {
        return categoryCombo;
    }

    public void setCategoryCombo(String categoryCombo) {
        this.categoryCombo.setSelectedItem(categoryCombo);
    }

    public Object[] getCategoryTodo() {
        return categoryTodo;
    }

    public void setCategoryTodo(Object[] categoryTodo) {
        this.categoryTodo = categoryTodo;
    }

    public JComboBox getPriorityCombo() {
        return priorityCombo;
    }

    public void setPriorityCombo(String priorityCombo) {
        this.priorityCombo.setSelectedItem(priorityCombo);
    }

    public Object[] getPriorityTodo() {
        return priorityTodo;
    }

    public void setPriorityTodo(Object[] priorityTodo) {
        this.priorityTodo = priorityTodo;
    }

    public JComboBox getStatusCombo() {
        return statusCombo;
    }

    public void setStatusCombo(int statusCombo) {
        this.statusCombo.setSelectedIndex(statusCombo);
    }

    public Object[] getStatusTodo() {
        return statusTodo;
    }

    public void setStatusTodo(Object[] statusTodo) {
        this.statusTodo = statusTodo;
    }

    public JButton getAttachementFileButton() {
        return attachementFileButton;
    }

    public void setAttachementFileButton(JButton attachementFileButton) {
        this.attachementFileButton = attachementFileButton;
    }

    public JTextArea getDetailTextArea() {
        return detailTextArea;
    }

    public void setDetailTextArea(String detailTextArea) {
        this.detailTextArea.setText(detailTextArea);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }
}
