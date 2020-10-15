/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import static Model.EnumBis.*;
/**
 *
 * @author Hp
 */
public class ListBus {
    private String idBis;
    private EnumBis kelas;
    private int jumlahKapasitas;
    
    public ListBus(String idBis, int jumlahKapasitas) {
        this.idBis = idBis;
        this.kelas = Reguler;
        this.jumlahKapasitas = jumlahKapasitas;
    }

    public String getIdBis() {
        return idBis;
    }

    public void setIdBis(String idBis) {
        this.idBis = idBis;
    }

    public int getJumlahKapasitas() {
        return jumlahKapasitas;
    }

    public void setJumlahKapasitas(int jumlahKapasitas) {
        this.jumlahKapasitas = jumlahKapasitas;
    }
    
    
    
}
