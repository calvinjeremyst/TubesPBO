/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.util.Date;
import Controller.Controller;
/**
 *
 * @author Christian
 */
public class RiwayatTopUp {
    private double nominal;
    private String metode;
    private String date;

    public RiwayatTopUp(){}
    public RiwayatTopUp(double nominal, String metode, String date) {
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
    public String toString(){
        return "Riwayat Topup {" + "Nominal=" + getNominal() + ", Metode=" + getMetode()+ ", Tanggal=" + getDate()+ "}";
    }
    public String[][] arrayData(){
        Controller.getHistory();
        String data[][] = {{Double.toString(getNominal()),getMetode(),getDate()}};
        return data;
    }
}


