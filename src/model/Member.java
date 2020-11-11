/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.interfaceTubes;
import java.util.LinkedList;
import model.TopUp;
import java.util.ArrayList;
/**
 *
 * @author Hp
 */
public class Member extends User implements interfaceTubes {
   
    private int ID_Member;
    private int umur;
    private String KTP;
    
    public Member(){
        
    }
    
    public Member(int ID_User,String username, String password,String repassword, String alamat, String noHp,int ID_Member,int umur, String KTP) {
        super(ID_User,username, password,repassword, alamat, noHp);
        this.ID_Member = ID_Member;
        this.umur = umur;
        this.KTP = KTP;
    }

    public int getID_Member() {
        return ID_Member;
    }

    public void setID_Member(int ID_Member) {
        this.ID_Member = ID_Member;
    }
    
    @Override
    public int getID_User() {
        return ID_User;
    }

    @Override
    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRepassword() {
        return repassword;
    }

    @Override
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String getNoHp() {
        return noHp;
    }

    @Override
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getKTP() {
        return KTP;
    }

    public void setKTP(String KTP) {
        this.KTP = KTP;
    }
    
}