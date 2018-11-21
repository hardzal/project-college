/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model.dao;

import java.util.List;
import selfmanagement.model.Notes;

/**
 *
 * @author izal
 */
public interface NotesDAO {
    
    public boolean insertNotes();
    public boolean updateNotes();
    public boolean deleteNotes();
    public List<Notes> getAllNotes();
    public List<Notes> getNotes();
    
}
