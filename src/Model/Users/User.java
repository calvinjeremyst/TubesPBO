/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Users;
import Model.TerminalPusat.InterfaceTubes;
/**
 *
 * @author Christian
 */
public abstract class User {
    private String nama;
    private String password;
    private String alamat;
    private String noHp;
    
    public User(){
    
    }
    
    public User(String nama, String password, String alamat, String noHp) {
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    
    
}
