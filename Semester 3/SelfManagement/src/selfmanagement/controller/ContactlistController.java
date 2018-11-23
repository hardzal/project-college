/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import selfmanagement.view.ContactlistView;
import selfmanagement.model.Contactlist;

/**
 *
 * @author user
 */
public class ContactlistController {
    private ContactlistView contactlistView;
    private Contactlist contactlist;
    
    public ContactlistController(ContactlistView contactlistView, Contactlist contactlist) {
        this.contactlistView = contactlistView;
        this.contactlist = contactlist;
    }
    
    public void initContactlist() {
        
    }
}
