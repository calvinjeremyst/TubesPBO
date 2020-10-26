/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.util.Date;

/**
 *
 * @author Christian
 */
public class RiwayatTopup {
    private double nominal;
    private String metode;
    private String date;

    public RiwayatTopup(double nominal, String metode, String date) {
        this.nominal = nominal;
        this.metode = metode;
        this.date = date;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}


