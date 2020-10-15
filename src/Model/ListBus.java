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
public class ListBus {
    private String namaKelas;
    private int jumlahKapasitas;
    private String namaBis;
    public ArrayList<ListBus> daftarBis;
    
    public ListBus(String namaKelas, int jumlahKapasitas) {
        this.namaKelas = namaKelas;
        this.jumlahKapasitas = jumlahKapasitas;
    }
    
}
