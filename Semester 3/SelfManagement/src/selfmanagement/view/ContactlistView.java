/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.view;

/**
 *
 * @author user
 */
public class ContactlistView extends DefaultView {
    
    public ContactlistView() {
        template(new String[]{"Contactlist"});
        initComponents();
        initFrame();
    }
    
    public void initComponents() {
        
    }
    
    public static void main(String[] args) {
        new ContactlistView();
    }
}
