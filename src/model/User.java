/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaceTubes;

/**
 *
 * @author Hp
 */
public abstract class User {
    public int ID_User;
    public String username;
    public String password;
    public String repassword;
    public String alamat;
    public String noHp;
    
    public User(){
    
    }

    public User(int ID_User,String username, String password,String repassword ,String alamat, String noHp) {
        this.ID_User = ID_User;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
}