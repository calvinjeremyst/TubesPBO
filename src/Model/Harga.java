package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lenovo
 */
public abstract class Harga {
    String kodePembayaran;
    
    public Harga(){
    
    }
    
    public Harga(String kodePembayaran){
        this.kodePembayaran = kodePembayaran;
    }

    public String getKodePembayaran() {
        return kodePembayaran;
    }

    public void setKodePembayaran(String kodePembayaran) {
        this.kodePembayaran = kodePembayaran;
    }
    
}
