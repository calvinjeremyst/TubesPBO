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
   
    private double nominalTopUp;
    private double saldo;
    
    public TopUp(){
        
    }

    public TopUp(int nominalTopUp, int saldo) {
        
        this.nominalTopUp = nominalTopUp;
        this.saldo = saldo;
    }

    public double getNominalTopUp() {
        return nominalTopUp;
    }

    public void setNominalTopUp(int nominalTopUp) {
        this.nominalTopUp = nominalTopUp;
    }

    public double getSaldo() {
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
