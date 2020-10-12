/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Bis;

/**
 *
 * @author Christian
 */
public class BisEkonomi extends ListBis {
    private String namaBis;
    private int harga;
    
     public BisEkonomi(String namaKelas, int jumlahKapasitas){
        super(namaKelas,jumlahKapasitas);
        namaKelas = "VIP";
        jumlahKapasitas = 40;
    }
    
}