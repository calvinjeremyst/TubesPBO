/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.listOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class TransaksiPembayaran extends harga {
  
    public ArrayList<TransaksiPembayaran>bayar;
    public ArrayList<Member>member;
    private String idTransaksi;
    private double grandTotal;
    private double cashBack;
    private boolean useOVO;
    private String metodePembayaran;
    private Date tanggalTransaksi;
    private statusBayar status;
    
    public TransaksiPembayaran(){}
    
    public TransaksiPembayaran(String kodePembayaran,String idTransaksi,double grandTotal,double cashBack,boolean useOVO,
            String metodePembayaran,Date tanggalTransaksi,statusBayar status){
        super(kodePembayaran);
        this.idTransaksi = idTransaksi;
        this.grandTotal = grandTotal;
        this.cashBack = cashBack;
        this.useOVO = useOVO;
        this.metodePembayaran = metodePembayaran;
        this.tanggalTransaksi = tanggalTransaksi;
        this.status = status;
        this.bayar = new ArrayList<TransaksiPembayaran>();
        this.member = new ArrayList<Member>();
        
       
         
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

    public statusBayar getStatus() {
        return status;
    }

    public void setStatus(statusBayar status) {
        this.status = status;
    }
    
   
    public void printTiket(String idTransaksi,String status){
        String hasil = "";
        idTransaksi = JOptionPane.showInputDialog(null, "Input id Transaksi Pembayaran");
              for(int i = 0; i < bayar.size(); i++){
                if(bayar.get(i).status.paid.equals(status)){
                    hasil += bayar.get(i).idTransaksi;
                }
              
          
          }
          
    
    }
    
}
