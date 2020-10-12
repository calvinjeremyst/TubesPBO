/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Menu {
    
    public Menu() {
            showMenuAwal();
    }
    
    private void showMenuAwal() {
        int cek = JOptionPane.NO_OPTION;
        while(cek != JOptionPane.YES_OPTION){
            int number = Integer.parseInt(JOptionPane.showInputDialog(null,"Bis Emen\n 1.Register\n 2.Login"));
        }
    }
}