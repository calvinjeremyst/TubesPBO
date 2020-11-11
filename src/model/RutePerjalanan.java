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
public class RutePerjalanan {
    public String ID_Admin;
    public String ID_Rute;
    public String ID_Bis;
    public String kotaAsal;
    public String kotaTujuan;
    public Date tanggalBerangkat;
    
    public RutePerjalanan(){}

    public RutePerjalanan(String ID_Rute,String ID_Admin,String ID_Bis, String kotaAsal, String kotaTujuan,Date tanggalBerangkat) {
        
        this.ID_Admin = ID_Admin;
        this.ID_Rute = ID_Rute;
        this.ID_Admin = ID_Admin;
        this.ID_Bis = ID_Bis;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public String getID_Admin() {
        return ID_Admin;
    }

    public void setID_Admin(String ID_Admin) {
        this.ID_Admin = ID_Admin;
    }

    
    public String getID_Bis() {
        return ID_Bis;
    }

    public void setID_Bis(String ID_Bis) {
        this.ID_Bis = ID_Bis;
    }
    
    public Date getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(Date tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }
    
    

    public String getID_Rute() {
        return ID_Rute;
    }

    public void setID_Rute(String ID_Rute) {
        this.ID_Rute = ID_Rute;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }
    
}
