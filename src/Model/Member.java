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
    private String umur;
    private String KTP;
    ArrayList<TransaksiPembayaran> transaksi;

    public Member(){
        
    }
    
    public Member(String nama, String password, String alamat, String noHp, String umur, String KTP) {
        super(nama, password, alamat, noHp);
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
    
    public void riwayatPemesanan(){
        LinkedList<String> listP = new LinkedList<>(); 
    }
    
    public double cekSaldoOVO(){
        int saldo = saldoOVOAwal;
        return saldo;
    }
}