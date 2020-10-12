/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Controller {
    
    public Controller() {
        tambahData();
    }
    
    public void tambahData() {
        ArrayList<User> user = new ArrayList<>();
        user.add(new Admin("Calvin", "1234", "Pagarsih", "087876060872", "1001"));
        user.add(new Admin("Christian", "abcd", "Ujung Berung", "0888111222", "1002"));
        user.add(new Admin("Aji", "xyz", "Dago", "087811223344", "1003"));
        
    }
    
}
