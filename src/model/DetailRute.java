/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Hp
 */
public class DetailRute extends Rute {
    private String jamBerangkat;
    private Date tanggalBerangkat;
    private double hargaRute;
    private double hargaBis;
    private String jenisBis;

    public DetailRute(){
        
    }
    
    public DetailRute(String jamBerangkat, Date tanggalBerangkat, double hargaRute, double hargaBis, String idRute, String kotaAsal, String kotaTujuan, String idbis, String jenisBis) {
        super(idRute, kotaAsal, kotaTujuan, idbis);
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
        this.hargaRute = hargaRute;
        this.hargaBis = hargaBis;
        this.jenisBis = jenisBis;
    }

    @Override
    public String getIdRute() {
        return idRute;
    }
    
    @Override
    public void setIdRute(String idRute) {
        this.idRute = idRute;
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

    @Override
    public String getIdbis() {
        return idbis;
    }

    @Override
    public void setIdbis(String idbis) {
        this.idbis = idbis;
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
               this.getIdbis() + this.getJamBerangkat() + this.getTanggalBerangkat() +
               this.getHargaRute() + this.getHargaBis();
    }
    
}
