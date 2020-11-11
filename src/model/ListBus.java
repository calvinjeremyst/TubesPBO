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
public class ListBus {
    private String idBis;
    private EnumBis kelas;
    private int jumlahKapasitas;
    
    public ListBus(String idBis, int jumlahKapasitas) {
        this.idBis = idBis;
        this.jumlahKapasitas = jumlahKapasitas;
    }

    public EnumBis getKelas() {
        return kelas;
    }

    public void setKelas(EnumBis kelas) {
        this.kelas = kelas;
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
