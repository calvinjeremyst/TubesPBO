/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hp
 */
public abstract class Rute {
    public String idRute;
    public String kotaAsal;
    public String kotaTujuan;
    public String idbis;
    
    public Rute(){
        
    }
    
    public Rute(String idRute, String kotaAsal, String kotaTujuan, String idbis) {
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.idbis = idbis;
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

    public String getIdbis() {
        return idbis;
    }

    public void setIdbis(String idbis) {
        this.idbis = idbis;
    }
    
}
