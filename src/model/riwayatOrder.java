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
public class riwayatOrder extends listOrder {
    
    public riwayatOrder(int idOrder, Date tanggalOrder, int banyakPenumpang, Rute rute, TransaksiPembayaran transaksi){
            super(idOrder, tanggalOrder, banyakPenumpang, rute, transaksi);
    }
    
}
