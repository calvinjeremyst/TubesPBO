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
public class TransaksiPembayaran extends Harga {
    private String idTransaksi;
    private double grandTotal;
    private double cashBack;
    private boolean useOVO;
    private String metodePembayaran;
    private Date tanggalTransaksi;
    
    public TransaksiPembayaran() {
    
    }
    
    public TransaksiPembayaran(String kodePembayaran,String idTransaksi,double grandTotal,double cashBack,boolean useOVO,
        String metodePembayaran,Date tanggalTransaksi){
        super(kodePembayaran);
        this.idTransaksi = idTransaksi;
        this.grandTotal = grandTotal;
        this.cashBack = cashBack;
        this.useOVO = useOVO;
        this.metodePembayaran = metodePembayaran;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
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

    public boolean isUseOVO() {
        return useOVO;
    }

    public void setUseOVO(boolean useOVO) {
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
