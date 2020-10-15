/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hp
 */
public class TopUp {
    public String kodePembayaran;
    private int nominalTopUp;
    private int saldo;
    
    public TopUp(){
        
    }

    public TopUp(String kodePembayaran, int nominalTopUp, int saldo) {
        this.kodePembayaran = kodePembayaran;
        this.nominalTopUp = nominalTopUp;
        this.saldo = saldo;
    }

    public String getKodePembayaran() {
        return kodePembayaran;
    }

    public void setKodePembayaran(String kodePembayaran) {
        this.kodePembayaran = kodePembayaran;
    }

    public int getNominalTopUp() {
        return nominalTopUp;
    }

    public void setNominalTopUp(int nominalTopUp) {
        this.nominalTopUp = nominalTopUp;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public double topUpOVO(){
        double nominal = 100000;
        saldo += nominal;
        return nominal;
    }
}
