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
public class Kursi extends ListOrder {
    private String nomorKursi;

    public Kursi(String nomorKursi, String idOrder, String tanggalOrder) {
        super(idOrder, tanggalOrder);
        this.nomorKursi = nomorKursi;
    }
    
}
