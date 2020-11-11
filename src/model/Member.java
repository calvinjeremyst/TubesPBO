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
public class Member extends User implements Interface{
    private String umur;
    private String KTP;
    private double ovoBalance;
    
    public Member(){
        
    }
    
    public Member(int ID_User, String username, String password, String repassword, String alamat, String noHp, String umur, String KTP) {
        super(ID_User, username, password, repassword, alamat, noHp);
        this.umur = umur;
        this.KTP = KTP;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
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
    
    public double cekSaldoOVO(){
        int saldo = saldoOVOAwal;
        return saldo;
    }
    
    @Override
    public String toString(){
        return this.getUsername() + this.getNoHp() + this.getAlamat() + this.getKTP() + this.getUmur();
    }
    
}