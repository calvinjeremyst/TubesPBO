/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class DetailRute extends Rute {
    private String jamBerangkat;
    private Date tanggalBerangkat;
    private double hargaRute;
    private double hargaBis;
    private String jenisBis;
    
    public DetailRute(){
    
    }

    public DetailRute(String ID_Rute,String ID_Bis ,String kotaAsal, String kotaTujuan,String jamBerangkat, 
             double hargaRute,double hargaBis, String jenisBis) {
        super(ID_Rute,ID_Bis,kotaAsal,kotaTujuan);
        this.jamBerangkat = jamBerangkat; 
        this.tanggalBerangkat = tanggalBerangkat;
        this.hargaRute = hargaRute;
        this.hargaBis = hargaBis;
        this.jenisBis = jenisBis;
    }
    
    public double getHargaBis() {
        return hargaBis;
    }

    public void setHargaBis(double hargaBis) {
        this.hargaBis = hargaBis;
    }
   
    @Override
    public String getID_Rute() {
        return ID_Rute;
    }

    @Override
    public void setID_Rute(String ID_Rute) {
        this.ID_Rute = ID_Rute;
    }

    @Override
    public String getID_Bis() {
        return ID_Bis;
    }

    @Override
    public void setID_Bis(String ID_Bis) {
        this.ID_Bis = ID_Bis;
    }

    @Override
    public String getKotaAsal() {
        return kotaAsal;
    }

    @Override
    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    @Override
    public String getKotaTujuan() {
        return kotaTujuan;
    }

    @Override
    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public Date getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(Date tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }
    
    public double getHargaRute() {
        return hargaRute;
    }

    public void setHargaRute(double hargaRute) {
        this.hargaRute = hargaRute;
    }

    public String getJenisBis() {
        return jenisBis;
    }

    public void setJenisBis(String jenisBis) {
        this.jenisBis = jenisBis;
    }

    @Override
    public String toString(){
        String hasil = "";
        hasil = "ID_Rute : " + this.getID_Rute()+ "\n" + 
                "ID Bis : " + this.getID_Bis()+ "\n" + 
                "Kota Asal : " + this.getKotaAsal() + "\n" + 
                "Kota Tujuan : " + this.getKotaTujuan() + "\n" +
                "Harga Bis : " + this.getHargaBis() + "\n" + 
                "Tanggal Berangkat : " + this.getTanggalBerangkat() + "\n" +
                "Jam Berangkat : " + this.getJamBerangkat() + "\n" +
                "Harga Rute : " + this.getHargaRute();
                return hasil;
    
    }
}       
