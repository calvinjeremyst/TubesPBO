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
public class Rute {
    public String ID_Rute;
    public String ID_Bis;
    public String kotaAsal;
    public String kotaTujuan;
    
    public Rute(){
    
    }

    public Rute(String ID_Rute,String ID_Bis, String kotaAsal, String kotaTujuan) {
        this.ID_Rute = ID_Rute;
        this.ID_Bis = ID_Bis;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
    }

    public String getID_Bis() {
        return ID_Bis;
    }

    public void setID_Bis(String ID_Bis) {
        this.ID_Bis = ID_Bis;
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
