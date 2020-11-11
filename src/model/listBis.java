/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import model.listBis;

/**LinkedList<Order>();
 *
 * @author lenovo
 */
public class listBis  {
    private String IDbis;
    private int jumlahKapasitas;
    private String namaBis;
    private String kelasBis;
    public ArrayList<listBis> daftarBis;
    
    public listBis(){}
    
    
    public listBis(String IDbis,String namaKelas, int jumlahKapasitas,String kelasBis,listBis daftarBis) {
        this.IDbis = IDbis;
        this.jumlahKapasitas = jumlahKapasitas;
        this.kelasBis = kelasBis;
        this.daftarBis = new ArrayList<listBis>();
        
    }

    public String getIDbis() {
        return IDbis;
    }

    public void setIDbis(String IDbis) {
        this.IDbis = IDbis;
    }

  

    public int getJumlahKapasitas() {
        return jumlahKapasitas;
    }

    public void setJumlahKapasitas(int jumlahKapasitas) {
        this.jumlahKapasitas = jumlahKapasitas;
    }

    public String getNamaBis() {
        return namaBis;
    }

    public void setNamaBis(String namaBis) {
        this.namaBis = namaBis;
    }

    public String getKelasBis() {
        return kelasBis;
    }

    public void setKelasBis(String kelasBis) {
        this.kelasBis = kelasBis;
    }

    public ArrayList<listBis> getDaftarBis() {
        return daftarBis;
    }

    public void setDaftarBis(ArrayList<listBis> daftarBis) {
        this.daftarBis = daftarBis;
    }

   
    
    
   
    
}