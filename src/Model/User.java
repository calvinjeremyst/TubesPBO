/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static View.Menu.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class User {
    private String nama;
    private String password;
    private String alamat;
    private String noHp;
    ArrayList<Admin> listAdmin;
    ArrayList<Member> listMember;
    
    
    public User(){
    
    }
    
    public User(String nama, String password, String alamat, String noHp) {
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    public boolean login(){
        boolean loginUser = false;
        String nama = JOptionPane.showInputDialog("Nama : ");
        String password = JOptionPane.showInputDialog("Password : ");
        for(int i = 0; i<listMember.size(); i++){
            if(listMember.get(i).getNama().equals(nama) && listMember.get(i).getPassword().equals(password)){
                loginUser = true;
            }else{
                loginA();
            } 
        }   
        return loginUser;
    }
    
    public boolean loginA(){
        boolean loginAdmin = false;
        for(int i = 0; i<listAdmin.size(); i++){
            if(listAdmin.get(i).getNama().equals(nama) && listAdmin.get(i).getPassword().equals(password)){
                loginAdmin = true;
            }else{
                loginAdmin = false;
            }
        }
        return loginAdmin;
    }
}
