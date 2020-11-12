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
public abstract class User {
    public String ID;
    public String nama;
    public String pass;
    
    public User(){}

    public User(String ID, String nama, String pass) {
        this.ID = ID;
        this.nama = nama;
        this.pass = pass;
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
    
    @Override
    public String toString() {
        return "User {" + "id=" + getID() + ", name=" + getID() + ", pass=" + getPass() + "'";
    }
}

