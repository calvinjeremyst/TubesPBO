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
    private Date TanggalOrder;
    private int banyakPenumpang;
    private Member member;
    private Rute rute;
    private TransaksiPembayaran transaksi;
    
    public listOrder(){
        
    }

    public listOrder(int idOrder, Date TanggalOrder, int banyakPenumpang) {
        this.idOrder = idOrder;
        this.TanggalOrder = TanggalOrder;
        this.banyakPenumpang = banyakPenumpang;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getTanggalOrder() {
        return TanggalOrder;
    }

    public void setTanggalOrder(Date TanggalOrder) {
        this.TanggalOrder = TanggalOrder;
    }

    public int getBanyakPenumpang() {
        return banyakPenumpang;
    }

    public void setBanyakPenumpang(int banyakPenumpang) {
        this.banyakPenumpang = banyakPenumpang;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
