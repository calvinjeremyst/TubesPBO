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
    private double nominalTopUp;
    private double saldo;
  
    public TopUp(){
        
    }

    public TopUp(double nominalTopUp, double saldo) {
        this.nominalTopUp = nominalTopUp;
        this.saldo = saldo;
    }

    public double getNominalTopUp() {
        return nominalTopUp;
    }

    public void setNominalTopUp(double nominalTopUp) {
        this.nominalTopUp = nominalTopUp;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
