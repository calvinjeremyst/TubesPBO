/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hp
 */
public class ListOrder {
    private int idOrder;
    private String tanggalOrder;
    private int banyakPenumpang;
    private Member member;
    private Rute rute;
    private TransaksiPembayaran transaksi;

    public ListOrder(){
        
    }
    
    public ListOrder(int idOrder, String tanggalOrder, int banyakPenumpang, Member member, Rute rute, TransaksiPembayaran transaksi) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
        this.banyakPenumpang = banyakPenumpang;
        this.member = member;
        this.rute = rute;
        this.transaksi = transaksi;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(String tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
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
