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
public class TopUp {
    private int nominalTopUp;
    private int saldo;
    
    public TopUp(){
        
    }

    public TopUp(int nominalTopUp, int saldo) {
        this.nominalTopUp = nominalTopUp;
        this.saldo = saldo;
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
  
}
