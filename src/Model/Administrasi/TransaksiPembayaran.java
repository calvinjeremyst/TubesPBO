/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Administrasi;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class TransaksiPembayaran extends harga {
    private String idTransaksi;
    private double grandTotal;
    private double cashBack;
    private boolean useOVO;
    private String metodePembayaran;
    private Date tanggalTransaksi;
    
    public TransaksiPembayaran(){}
    
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
    
}
