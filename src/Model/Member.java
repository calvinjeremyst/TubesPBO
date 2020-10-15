/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import Model.TopUp;
/**
 *
 * @author Hp
 */
public class Member extends User implements Interface{
    private int umur;
    private String KTP;
    public ArrayList<Member> member;

    public Member(){
        
    }
    
    public Member(String nama, String password, String alamat, String noHp, int umur, String KTP) {
        super(nama, password, alamat, noHp);
        this.umur = umur;
        this.KTP = KTP;
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
    
    public void riwayatPemesanan(){
        LinkedList<String> listP = new LinkedList<>(); 
    }
    
    public double cekSaldoOVO(){
        int saldo = saldoOVOAwal;
        return saldo;
    }
}