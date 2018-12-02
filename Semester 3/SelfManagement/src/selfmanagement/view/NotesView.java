/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author izal
 */
public class NotesView extends DefaultView {
    JTextArea notesField;
    JLabel titleField;
    JButton editButton;
    JButton deleteButton;
    
    public NotesView() {
        template(new String[]{"Notes"});
        initComponents();
        initFrame();
    }
    
    public void initComponents() {
        mainLabel.setText("Notes");
    }
    
    public static void main(String[] args) {
        new NotesView();
    }
}
