/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lenovo
 */
public class RutePerjalanan {
    private String ID_Rute;
    private String kotaAsal;
    private String kotaTujuan;
    
    public RutePerjalanan(){}

    public RutePerjalanan(String ID_Rute, String kotaAsal, String kotaTujuan) {
        this.ID_Rute = ID_Rute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
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
