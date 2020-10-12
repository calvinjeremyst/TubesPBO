/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Users;
import Model.TerminalPusat.InterfaceTubes;
import java.util.LinkedList;
import Administrasi.TopUp;
import java.util.ArrayList;
/**
 *
 * @author Christian
 */
public class Member extends User implements InterfaceTubes{
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
