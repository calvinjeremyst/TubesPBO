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
public class listOrder {
    private int idOrder;
    private Date tanggalOrder;
    private int banyakPenumpang;
    private Rute rute;
    private TransaksiPembayaran transaksi;
    
    public listOrder(){
        
    }

    public listOrder(int idOrder, Date tanggalOrder, int banyakPenumpang, Rute rute, TransaksiPembayaran transaksi) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
        this.banyakPenumpang = banyakPenumpang;
        this.rute = rute;
        this.transaksi = transaksi;
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

    public int getBanyakPenumpang() {
        return banyakPenumpang;
    }

    public void setBanyakPenumpang(int banyakPenumpang) {
        this.banyakPenumpang = banyakPenumpang;
    }

    public Rute getRute() {
        return rute;
    }

    public void setRute(Rute rute) {
        this.rute = rute;
    }

    public TransaksiPembayaran getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(TransaksiPembayaran transaksi) {
        this.transaksi = transaksi;
    }
    
}
