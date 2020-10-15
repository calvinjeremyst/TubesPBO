/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class DetailRute extends Rute {
    private String jamBerangkat;
    private String tanggalBerangkat;
    private double hargaRute;
    private double hargaBis;
    ArrayList<DetailRute> detailR;

    public DetailRute(){
        
    }
    
    public DetailRute(String jamBerangkat, String tanggalBerangkat, double hargaRute, double hargaBis, String idRute, String kotaAsal, String kotaTujuan) {
        super(idRute, kotaAsal, kotaTujuan);
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
        this.hargaRute = hargaRute;
        this.hargaBis = hargaBis;
    }
    
    public String tampilRute(){
        String hasil = "";
        for(DetailRute rute : detailR){
            hasil += "ID Rute: " + rute.getIdRute() + 
                    "\nKota Asal: " + rute.getKotaAsal() +
                    "\nKota Tujuan: " + rute.getKotaTujuan()+
                    "\nJam Berangkat: " + rute.jamBerangkat+
                    "\nTanggal Berangkat: " + rute.tanggalBerangkat+
                    "\nHarga Rute: " + rute.hargaRute +
                    "\nHarga Bis: " + rute.hargaBis + 
                    "\nJenis Bis: " + rute.bis;
        }
        return hasil;
    }
    
    public void tambahRute(String jam, String tanggal, double hargaRute, double hargaBis, String idRute, String kotaAsal, String kotaTujuan){
        detailR.add(new DetailRute(jam,tanggal,hargaRute,hargaBis,idRute,kotaAsal,kotaTujuan));
    }
    
}
