/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.sql.Date;

/**
 *
 * @author Christian
 */
public class RiwayatTopUp {
    private double nominal;
    private String metode;
    private Date date;
    private String id;

    public RiwayatTopUp(){}
    public RiwayatTopUp(double nominal, String metode, Date date, String id) {
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
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    
}

