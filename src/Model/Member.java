/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
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
    
    public Member(int id_user, String nama, String password, String alamat, String noHp, String umur, String KTP) {
        super(id_user, nama, password, alamat, noHp);
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
        return this.getNama() + this.getNoHp() + this.getAlamat() + this.getKTP() + this.getUmur();
    }
    
}