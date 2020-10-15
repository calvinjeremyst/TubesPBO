/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Admin extends User {
    private String ID;
    ArrayList<Member> listMember;
  
    public Admin(){
        
    }
    
    public Admin(String nama, String password, String alamat, String noHp, String ID){
        super(nama, password, alamat, noHp);
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String lihatDataMember(){
        String hasil = "";
        for(Member member : listMember){
            hasil += "Nama: " + member.getNama() + 
            "\nAlamat: " + member.getAlamat() +
            "\nNo.HP: " + member.getNoHp() +
            "\nUmur: " + member.getUmur() +
            "\nKTP: " + member.getKTP();
        }
        return hasil;
    }
    
}
