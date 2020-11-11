/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.DetailRute;
import model.RutePerjalanan;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class listOrder {
    
    public LinkedList<listOrder>order;
    private String kodeBayarMember;
    private String TanggalOrder;
    private String kotaAsalPilihan;
    private String kotaTujuanPilihan;
    private String tanggalBerangkatMember;
    private String jamBerangkatMember;
    private double totalBayarMember;
    public listOrder(){
        
    }

    public listOrder(String kodeBayarMember, String TanggalOrder, String kotaAsalPilihan, String kotaTujuanPilihan,
            String tanggalBerangkatMember, String jamBerangkatMember, double totalBayarMember) {
        this.kodeBayarMember = kodeBayarMember;
        this.TanggalOrder = TanggalOrder;
        this.kotaAsalPilihan = kotaAsalPilihan;
        this.kotaTujuanPilihan = kotaTujuanPilihan;
        this.tanggalBerangkatMember = tanggalBerangkatMember;
        this.jamBerangkatMember = jamBerangkatMember;
        this.totalBayarMember = totalBayarMember;
    }

    public String getKodeBayarMember() {
        return kodeBayarMember;
    }

    public void setKodeBayarMember(String kodeBayarMember) {
        this.kodeBayarMember = kodeBayarMember;
    }

   

    public String getTanggalOrder() {
        return TanggalOrder;
    }

    public void setTanggalOrder(String TanggalOrder) {
        this.TanggalOrder = TanggalOrder;
    }

    public String getKotaAsalPilihan() {
        return kotaAsalPilihan;
    }

    public void setKotaAsalPilihan(String kotaAsalPilihan) {
        this.kotaAsalPilihan = kotaAsalPilihan;
    }

    public String getKotaTujuanPilihan() {
        return kotaTujuanPilihan;
    }

    public void setKotaTujuanPilihan(String kotaTujuanPilihan) {
        this.kotaTujuanPilihan = kotaTujuanPilihan;
    }

    public String getTanggalBerangkatMember() {
        return tanggalBerangkatMember;
    }

    public void setTanggalBerangkatMember(String tanggalBerangkatMember) {
        this.tanggalBerangkatMember = tanggalBerangkatMember;
    }

    public String getJamBerangkatMember() {
        return jamBerangkatMember;
    }

    public void setJamBerangkatMember(String jamBerangkatMember) {
        this.jamBerangkatMember = jamBerangkatMember;
    }

    public double getTotalBayarMember() {
        return totalBayarMember;
    }

    public void setTotalBayarMember(double totalBayarMember) {
        this.totalBayarMember = totalBayarMember;
    }

 
    
    public void batalTiket(String IDorder){
        IDorder = JOptionPane.showInputDialog("Input ID Order : ");
        boolean cek = false;
        while(cek == false){
            for(int i = 0; i < order.size();i++){
                if(IDorder.equals(order.get(i).kodeBayarMember)){
                    order.remove(order.get(i).kodeBayarMember);
                    order.remove(order.get(i).TanggalOrder);
                    cek = true;
                }
            }
        }
        
        
    }
    
    
    
}
