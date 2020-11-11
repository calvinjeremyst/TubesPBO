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
public class RiwayatOrder extends ListOrder {

    public RiwayatOrder(int idOrder, Date tanggalOrder, int banyakPenumpang, Member member, Rute rute, TransaksiPembayaran transaksi) {
        super(idOrder, tanggalOrder, banyakPenumpang, member, rute, transaksi);
    }
    
}
