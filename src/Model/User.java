/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import Model.*;

/**
 *
 * @author Christian
 */
public class User {
    private String ID;
    private String nama;
    private String pw;
    private double saldo;
    
    public User(){
        
    }

    public User(String ID, String nama, String pw, double saldo) {
        this.ID = ID;
        this.nama = nama;
        this.pw = pw;
        this.saldo = saldo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
