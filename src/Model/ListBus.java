/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import Model.EnumBis;
/**
 *
 * @author Hp
 */
public class ListBus {
    private String idBis;
    private String kelasBis;
    private int jumlahKapasitas;
    
    public ListBus(String idBis, String kelasBis, int jumlahKapasitas) {
        this.idBis = idBis;
        this.kelasBis = kelasBis;
        this.jumlahKapasitas = jumlahKapasitas;
    }

    public String getIdBis() {
        return idBis;
    }

    public void setIdBis(String idBis) {
        this.idBis = idBis;
    }

    public String getKelasBis() {
        return kelasBis;
    }

    public void setKelasBis(String kelasBis) {
        this.kelasBis = kelasBis;
    }

    public int getJumlahKapasitas() {
        return jumlahKapasitas;
    }

    public void setJumlahKapasitas(int jumlahKapasitas) {
        this.jumlahKapasitas = jumlahKapasitas;
    }
    
    
    
}
