/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hp
 */
public class RiwayatOrder extends ListOrder {

    public RiwayatOrder(int idOrder, String tanggalOrder, int banyakPenumpang, Member member, Rute rute, TransaksiPembayaran transaksi) {
        super(idOrder, tanggalOrder, banyakPenumpang, member, rute, transaksi);
    }
    
}
