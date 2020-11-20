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
public class TransaksiPembayaran {
    private int idTransaksi;
    private int banyakPenumpang;
    private double grandTotal;
    private double cashBack;
    private int useOVO;
    private String metodePembayaran;
    private Date tanggalTransaksi;

    public TransaksiPembayaran() {
    
    }
    
    public TransaksiPembayaran(int idTransaksi,int banyakPenumpang,double grandTotal,double cashBack,int useOVO,String metodePembayaran,Date tanggalTransaksi){
        this.idTransaksi = idTransaksi;
        this.banyakPenumpang = banyakPenumpang;
        this.grandTotal = grandTotal;
        this.cashBack = cashBack;
        this.useOVO = useOVO;
        this.metodePembayaran = metodePembayaran;
        this.tanggalTransaksi = tanggalTransaksi;
    }
    public TransaksiPembayaran(int banyakPenumpang,double grandTotal,double cashBack,int useOVO,String metodePembayaran,Date tanggalTransaksi){
        this.idTransaksi = idTransaksi;
        this.banyakPenumpang = banyakPenumpang;
        this.grandTotal = grandTotal;
        this.cashBack = cashBack;
        this.useOVO = useOVO;
        this.metodePembayaran = metodePembayaran;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
    public int getBanyakPenumpang() {
        return banyakPenumpang;
    }

    public void setBanyakPenumpang(int banyakPenumpang) {
        this.banyakPenumpang = banyakPenumpang;
    }
    
    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public int getUseOVO() {
        return useOVO;
    }

    public void setUseOVO(int useOVO) {
        this.useOVO = useOVO;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
    
}
