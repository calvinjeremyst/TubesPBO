/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class ListOrder {
    
    private int idOrder;
    private Date tanggalOrder;
    private int idRute;
    private String kotaAsal;
    private String kotaTujuan;
    private int idBis;
    private String jamBerangkat;
    private Date tanggalBerangkat;
    
    public ListOrder() {
        
    }

    public ListOrder(int idOrder, Date tanggalOrder, int idRute) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
        this.idRute = idRute;
    }
    
    public ListOrder(int idOrder, Date tanggalOrder, int idRute, String kotaAsal, String kotaTujuan, int idBis, String jamBerangkat, Date tanggalBerangkat) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.idBis = idBis;
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public ListOrder(Date tanggalOrder, int idRute, String kotaAsal, String kotaTujuan, int idBis, String jamBerangkat, Date tanggalBerangkat) {
        this.tanggalOrder = tanggalOrder;
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.idBis = idBis;
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
    }
    
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(Date TanggalOrder) {
        this.tanggalOrder = TanggalOrder;
    }
    
    public int getIdRute() {
        return idRute;
    }

    public void setIdRute(int idRute) {
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

    public int getIdBis() {
        return idBis;
    }

    public void setIdBis(int idBis) {
        this.idBis = idBis;
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
    
}
