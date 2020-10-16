/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.listOrder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class DetailRute extends RutePerjalanan {
    public LinkedList<DetailRute>rute;
    public LinkedList<listOrder>order;
    private String jamBerangkat;
    private String tanggalBerangkat;
    private double hargaRute;
    private String jenisBis;
    
    public DetailRute(){}

    public DetailRute(String ID_Rute, String kotaAsal, String kotaTujuan,String jamBerangkat, 
            String tanggalBerangkat, double hargaRute, String jenisBis) {
        super(ID_Rute,kotaAsal,kotaTujuan);
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
        this.hargaRute = hargaRute;
        this.jenisBis = jenisBis;
        this.rute = new LinkedList<DetailRute>();
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public double getHargaRute() {
        return hargaRute;
    }

    public void setHargaRute(double hargaRute) {
        this.hargaRute = hargaRute;
    }

    public String getJenisBis() {
        return jenisBis;
    }

    public void setJenisBis(String jenisBis) {
        this.jenisBis = jenisBis;
    }

    
    
    
    public void HargaBis(listBis bis){
        double hargaBis = bis.HargaBis(jamBerangkat);
        
    }
    
    public void Rute(String ID_Rute, String kotaAsal, String kotaTujuan,String jamBerangkat, 
         String tanggalBerangkat, double hargaRute,String jenisBis){
       
        ID_Rute = super.getID_Rute();
        kotaAsal = super.getKotaAsal();
        kotaTujuan = super.getKotaTujuan();
        jamBerangkat = this.jamBerangkat;
        tanggalBerangkat = this.tanggalBerangkat;
        hargaRute = this.hargaRute;
        jenisBis = this.jenisBis;
        
        ID_Rute = JOptionPane.showInputDialog("Input ID Rute");
        kotaAsal = JOptionPane.showInputDialog("Input Kota Asal : ");
        kotaTujuan = JOptionPane.showInputDialog("Input Kota Tujuan : ");
        jamBerangkat = JOptionPane.showInputDialog("Input jam berangkat : ");
        tanggalBerangkat = JOptionPane.showInputDialog("Input tanggal keberangkatan : ");
        hargaRute = Double.parseDouble(JOptionPane.showInputDialog("Input harga rute : "));
        jenisBis = JOptionPane.showInputDialog("Input kelas Bis : ");
        
        rute.add(new DetailRute(ID_Rute,kotaAsal,kotaTujuan,jamBerangkat,tanggalBerangkat,hargaRute,jenisBis));
        
    }
    
    public String printRute(){
       String hasil = "";
        for(int i = 0; i < rute.size();i++){
            hasil += "ID Rute : " + rute.get(i).getID_Rute() + "\n Kota Asal : "
                    + rute.get(i).getKotaAsal() + "\n Kota Tujuan : " + rute.get(i).getKotaTujuan()
                    + "\nJam Berangkat : " + rute.get(i).jamBerangkat + "\n Tanggal Kebrangkatan : " 
                    + rute.get(i).tanggalBerangkat + "\n harga rute : " + rute.get(i).hargaRute + "\n Jenis Bis : "
                    + rute.get(i).jenisBis;
        }
      return hasil;
    }
    
    public void pesanTiket(String kotaAsal,String kotaTujuan){
        kotaAsal = JOptionPane.showInputDialog("Input kota asal : ");
        kotaTujuan = JOptionPane.showInputDialog("Input kota tujuan : ");
        String hasil = "";
        for(int i = 0; i < rute.size(); i++){
            if(kotaTujuan.equals(rute.get(i).getKotaTujuan()) && kotaAsal.equals(rute.get(i).getKotaAsal())){
                hasil += "ID Rute : " + rute.get(i).getID_Rute() + "\n Kota Asal : "
                    + rute.get(i).getKotaAsal() + "\n Kota Tujuan : " + rute.get(i).getKotaTujuan()
                    + "\nJam Berangkat : " + rute.get(i).jamBerangkat + "\n Tanggal Kebrangkatan : " 
                    + rute.get(i).tanggalBerangkat + "\n harga rute : " + rute.get(i).hargaRute + "\n Jenis Bis : "
                    + rute.get(i).jenisBis;
                    String id = JOptionPane.showInputDialog("Input ID Rute : ");
                    for(int j = 0; j < rute.size();j++){
                        if(id.equals(rute.get(j).getID_Rute())){
                            String idOrder = UUID.randomUUID().toString();
                            String tanggalOrder = JOptionPane.showInputDialog("Input tnaggal pemesan-an : ");
                            order.add(new listOrder(idOrder,tanggalOrder));
                        }
                    }
            }
        }
        
    }
}
