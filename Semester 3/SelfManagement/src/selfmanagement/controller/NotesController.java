/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import selfmanagement.view.NotesView;
import selfmanagement.model.Notes;

/**
 *
 * @author user
 */
public class NotesController {
    private NotesView notesView;
    private Notes notes;
    
    public NotesController(NotesView notesView, Notes notes) {
        this.notesView = notesView;
        this.notes = notes;
    }
    
    public void initNotes() {
        
    }
    
    
}
