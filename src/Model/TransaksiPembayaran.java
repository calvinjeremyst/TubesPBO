/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.listOrder;
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
    
    public void bayarTiket(DetailRute rute,String kodePembayaran,ArrayList<Member> member,LinkedList<listOrder> order){
       String status = "";
        double bayar = rute.totalHarga(kodePembayaran);
        kodePembayaran = JOptionPane.showInputDialog("Input kode pembayaran : ");
        for(int i = 0; i < order.size(); i++){
            if(kodePembayaran.equals(order.get(i).getKodeBayarMember())){
                JOptionPane.showMessageDialog(null, "Total Bayar anda : " + bayar);
                metodePembayaran  = JOptionPane.showInputDialog("Input metode bayar : \n "
                                    + " Cash \n"
                                    + " Debit\n" + ".OVO");
                if(this.metodePembayaran.equals("Cash")){
                    JOptionPane.showMessageDialog(null, "Silahkan bayar di kasir");
                }
                else if(this.metodePembayaran.equals("Debit")){
                        String nomorKartu = JOptionPane.showInputDialog("Input nomor kartu debit : ");
                        for(int j = 0; j < member.size();j++){
                            if(nomorKartu.equals(member.get(j).getNumbercard())){
                            int masukan = Integer.parseInt(JOptionPane.showInputDialog("Masukan jumlah yang harus diabayar"));
                                if(masukan == bayar){
                                    JOptionPane.showMessageDialog(null, "Transaksi berhasil !");
                                    status.equals(this.status.paid);
                                }
                            }
                        }
                }
                else if(this.metodePembayaran.equals("OVO")){
                    String nomorOVO = JOptionPane.showInputDialog("Input nomor account OVO : ");
                    for(int j = 0; j < member.size(); j++){
                        if(nomorOVO.equals(member.get(j).getNumberOVO())){
                        int masukan = Integer.parseInt(JOptionPane.showInputDialog("Masukan jumlah yang harus dibayar : "));
                        if(bayar < member.get(j).getOVObalance()){
                            double saldo = member.get(j).getOVObalance();
                            saldo = saldo - bayar;
                            JOptionPane.showMessageDialog(null, "Transaksi berhasil , sisa saldo anda : " + saldo);
                            status.equals(this.status.paid);
                        }
                        else if(bayar > member.get(j).getOVObalance()){
                            JOptionPane.showMessageDialog(null, "Saldo anda kurang");
                        }
                }
            }
        }
        }
        
      
    }
        
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
