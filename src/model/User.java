/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public abstract class User {
    private int id_user;
    private String nama;
    private String password;
    private String alamat;
    private String noHp;
    
    public User() {
        
    }
    
    public User(int id_user, String nama, String password, String alamat, String noHp) {
        this.id_user = id_user;
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
    
    @Override
    public String toString(){
        return "ID : " + this.getId_user() + " Nama : " + this.getNama() + " Alamat : " + this.getAlamat() + " No.HP : " + this.getNoHp();
    }

}
