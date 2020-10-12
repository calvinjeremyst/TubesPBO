/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.TerminalPusat;

import java.util.Date;
import Model.Bis.ListBis;
import Model.Users.Member;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public abstract class Terminal implements InterfaceTubes {
    private String kotaAsal;
    private String kotaTujuan;
    private String jamKebrangkatan;
    private String jamTiba;
    private int hargaTiket;//ngecek harga berdasarkan jarak & durasi perjalanan, serta jenis bus
    private Date tanggalPesan;
    public ArrayList<Member> member;
    
    public Terminal(){
        
    }

    public Terminal(String kotaAsal, String kotaTujuan, String jamKebrangkatan, String jamTiba, int lamaPerjalanan, int hargaTiket, Date tanggal) {
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.jamKebrangkatan = jamKebrangkatan;
        this.jamTiba = jamTiba;
        this.lamaPerjalanan = lamaPerjalanan;
        this.hargaTiket = hargaTiket;
        this.tanggalPesan = tanggal;
    }
    
    public void listPerjalanan(){
        
    }
    
    public double bayarTiket(){
        
    }
    
    public int pesanTiket(){
        bayarTiket();
    }
    
    public String pembatalanTiket(){
        for(Member i : member){
            member[i].riwayatPemesanan();
        }
    }
    
}