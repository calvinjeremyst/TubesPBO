/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.Date;

/**
 *
 * @author Christian
 */
public class RiwayatTopup {
    
    private double nominal;
    private String metode;
    private Date date;
    private int id;

    public RiwayatTopup() {
   
    }
    
    public RiwayatTopup(double nominal, String metode, Date date, int id) {
        this.nominal = nominal;
        this.metode = metode;
        this.date = date;
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
}

