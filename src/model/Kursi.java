/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Hp
 */
public class Kursi extends ListOrder {
    
    private String nomorKursi;

    public Kursi(){
        
    }
    
    public Kursi(String nomorKursi, int idOrder, Date tanggalOrder, int idMember, int idrute, int idTransaksi) {
        super(idOrder, tanggalOrder, idMember, idrute, idTransaksi);
        this.nomorKursi = nomorKursi;
    }

    public String getNomorKursi() {
        return nomorKursi;
    }

    public void setNomorKursi(String nomorKursi) {
        this.nomorKursi = nomorKursi;
    }
    
}
