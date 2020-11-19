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
    
    public int idRute;
    public String kotaAsal;
    public String kotaTujuan;
    public int idbis;
    
    public Rute() {
        
    }
    
    public Rute(int idRute, String kotaAsal, String kotaTujuan, int idbis) {
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.idbis = idbis;
    }

    public int getIdRute() {
        return idRute;
    }

    public void setIdRute(int idRute) {
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

    public int getIdbis() {
        return idbis;
    }

    public void setIdbis(int idbis) {
        this.idbis = idbis;
    }
    
}
