/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Rute {
    private String idRute;
    private String kotaAsal;
    private String kotaTujuan;
    ArrayList<ListBus> bis;
    
    public Rute(String idRute, String kotaAsal, String kotaTujuan) {
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
    }

    public String getIdRute() {
        return idRute;
    }

    public void setIdRute(String idRute) {
        this.idRute = idRute;
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

    public ArrayList<ListBus> getBis() {
        return bis;
    }

    public void setBis(ArrayList<ListBus> bis) {
        this.bis = bis;
    }
    
    public void tampilRute(){
        
    }
    
}
