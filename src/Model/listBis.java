/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.ArrayList;
import Model.listBis;

/**LinkedList<Order>();
 *
 * @author lenovo
 */
public class listBis  {
    private String namaKelas;
    private int jumlahKapasitas;
    private String namaBis;
    private BisEnum kelasBis;
    public ArrayList<listBis> daftarBis;
    
    
    public listBis(String namaKelas, int jumlahKapasitas,BisEnum kelasBis,listBis daftarBis) {
        this.namaKelas = namaKelas;
        this.jumlahKapasitas = jumlahKapasitas;
        this.kelasBis = kelasBis;
        this.daftarBis = new ArrayList<listBis>();
        
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
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

    public BisEnum getKelasBis() {
        return kelasBis;
    }

    public void setKelasBis(BisEnum kelasBis) {
        this.kelasBis = kelasBis;
    }

    public ArrayList<listBis> getDaftarBis() {
        return daftarBis;
    }

    public void setDaftarBis(ArrayList<listBis> daftarBis) {
        this.daftarBis = daftarBis;
    }

   
    public double HargaBis(String bisPilihan){
        double hargaBis = 0;
        if(bisPilihan.equals(kelasBis.VIP)){
            hargaBis = 75000;
        }
        else if(bisPilihan.equals(kelasBis.ekonomi)){
            hargaBis = 50000;
        }
        else if(bisPilihan.equals(kelasBis.reguler)){
            hargaBis = 30000;
        }
        return hargaBis;
    }
    
   
    
}