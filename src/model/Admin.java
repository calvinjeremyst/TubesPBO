/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author Hp
 */
public class Admin extends User{
    private String IDAdmin;
  
    public Admin(){
        
    }
    
    public Admin(int id_user, String username, String password, String repassword, String alamat, String noHp, String IDAdmin){
        super(id_user, username, password, repassword, alamat, noHp);
        this.IDAdmin = IDAdmin;
    }

    public String getID() {
        return IDAdmin;
    }

    public void setID(String IDAdmin) {
        this.IDAdmin = IDAdmin;
    }
   
}