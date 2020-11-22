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
    private int idMember;
    private int idRute;
    private int idTransaksi;
    
    public ListOrder() {
        
    }

    public ListOrder(int idOrder, Date tanggalOrder, int idMember, int idRute, int idTransaksi) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
        this.idMember = idMember;
        this.idRute = idRute;
        this.idTransaksi = idTransaksi;
    }
    
    public ListOrder(Date tanggalOrder, int idMember, int idRute) {
        this.tanggalOrder = tanggalOrder;
        this.idMember = idMember;
        this.idRute = idRute;
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

    public void setTanggalOrder(Date tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdRute() {
        return idRute;
    }

    public void setIdRute(int idRute) {
        this.idRute = idRute;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
}
