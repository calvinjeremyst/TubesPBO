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
public class Kursi extends listOrder {
    private String nomorKursi;

    public Kursi(String nomorKursi, int idOrder, Date tanggalOrder, int banyakPenumpang, Member member, Rute rute, TransaksiPembayaran transaksi) {
        super(idOrder, tanggalOrder, banyakPenumpang, rute, transaksi);
        this.nomorKursi = nomorKursi;
    }

    public String getNomorKursi() {
        return nomorKursi;
    }

    public void setNomorKursi(String nomorKursi) {
        this.nomorKursi = nomorKursi;
    }
    
}
