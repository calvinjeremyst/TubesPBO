/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Helper;

import model.DetailRute;
import java.util.Date;

/**
 *
 * @author user
 */
public class TampungDipilih {
    int banyakPenumpang = 0;
    String jamBerangkat;
    Date tanggalBerangkat;
    double hargaRute;
    double hargaBis;
    String idRute;
    String kotaAsal;
    String kotaTujuan;
    String listbis;
    
    public TampungDipilih() {
    }

    public TampungDipilih(String jamBerangkat, Date tanggalBerangkat, double hargaRute, double hargaBis, String idRute, String kotaAsal, String kotaTujuan, String listbis, int banyakPenumpang) {
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.listbis = listbis;
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
        this.hargaBis = hargaBis;
        this.hargaRute = hargaRute;
        this.banyakPenumpang = banyakPenumpang;
    }

    public int getBanyakPenumpang() {
        return banyakPenumpang;
    }

    public void setBanyakPenumpang(int banyakPenumpang) {
        this.banyakPenumpang = banyakPenumpang;
    }
    
    public String getIdRute() {
        return idRute;
    }

    public void setIdRute(String idRute) {
        this.idRute = idRute;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public String getListbis() {
        return listbis;
    }

    public void setListbis(String listbis) {
        this.listbis = listbis;
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

    public double getHargaBis() {
        return hargaBis;
    }

    public void setHargaBis(double hargaBis) {
        this.hargaBis = hargaBis;
    }
    
    @Override
    public String toString(){
        return this.getIdRute() + this.getKotaAsal() + this.getKotaTujuan() +
               this.getListbis() + this.getJamBerangkat() + this.getTanggalBerangkat() +
               this.getHargaRute() + this.getHargaBis();
    }
    
}
