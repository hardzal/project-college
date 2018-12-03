/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.model;

/**
 *
 * @author izal
 */
public class Contactlist extends Parent{
    private String name;
    private String noHp;
    
    public Contactlist() {
        
    }

    public Contactlist(int idUser, String name, String noHp) {
        this.idUser = idUser;
        this.name = name;
        this.noHp = noHp;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    
}
