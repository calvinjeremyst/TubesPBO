/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Christian
 */
public class Member extends User{
    private double saldo;

    public Member(){}

    public Member(String ID, String nama, String pass, double saldo) {
        super(ID, nama, pass);
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String toString(){
        return "User {" + "id=" + getID() + ", name=" + getNama() + ", pass=" + getPass() + ", Saldo=" + getSaldo() + "}";
    }
    
}
