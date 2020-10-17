/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.interfaceTubes;
import java.util.LinkedList;
import Model.TopUp;
import java.util.ArrayList;
/**
 *
 * @author Hp
 */
public class Member extends User implements interfaceTubes{
   
    private int umur;
    private String KTP; 
    private String numberCard;
    private String numberOvo;
    private double OVObalance;
   
    public Member(){
        
    }
    
    public Member(String nama, String password, String alamat, String noHp, int umur, String KTP,String numberCard,
            String numberOvo,double OVObalance) {
        super(nama, password, alamat, noHp);
        this.umur = umur;
        this.KTP = KTP;
        this.numberCard = numberCard;
        this.numberOvo = numberOvo;
        this.OVObalance = OVObalance;
        
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
    
    public String getNumbercard(){
        return numberCard;
    }
    public void setNumbercard(String numberCard){
        this.numberCard = numberCard;
    }
    
    public String getNumberOVO(){
        return numberOvo;
    }
    
    public void setNumberOVO(String numberOvo){
        this.numberOvo = numberOvo;
    }
    
    public double getOVObalance(){
        return OVObalance;
    }
    
    public void setOVObalance(double OVObalance){
      
        this.OVObalance = OVObalance;    
    }
    
    public void riwayatPemesanan(){
        LinkedList<String> listP = new LinkedList<>(); 
    }
    
    public double cekSaldoOVO(){
        int saldo = saldoOVOAwal;
        return saldo;
    }
    
    
    
}