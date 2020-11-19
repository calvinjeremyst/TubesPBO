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
public class Member extends User {
    private int ID_Member;
    private int umur;
    private String KTP;
    private double ovoBalance;

    public Member() {
        
    }
    
    public Member(int ID_Member,int umur, String KTP, double ovoBalance,int ID_User,String username, String password,String repassword, String alamat, String noHp,int tipeUser) {
        super(ID_User,username, password,repassword, alamat, noHp, tipeUser);
        this.ID_Member = ID_Member;
        this.umur = umur;
        this.KTP = KTP;
        this.ovoBalance = ovoBalance;
    }
    
    public Member(int ID_Member,int umur, String KTP, double ovoBalance){
        this.ID_Member = ID_Member;
        this.umur = umur;
        this.KTP = KTP;
        this.ovoBalance = ovoBalance;
    }
        
    public int getID_Member() {
        return ID_Member;
    }

    public void setID_Member(int ID_Member) {
        this.ID_Member = ID_Member;
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
    
    public double getOvoBalance() {
        return ovoBalance;
    }

    public void setOvoBalance(double ovoBalance) {
        this.ovoBalance = ovoBalance;
    }
    
    @Override
    public String toString(){
        return this.getUsername() + this.getNoHp() + this.getAlamat() + this.getKTP() + this.getUmur();
    }
    
}