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
public class DetailRute extends Rute {
    private String jamBerangkat;
    private String tanggalBerangkat;
    private double hargaRute;
    private double hargaBis;

    public DetailRute(String jamBerangkat, String tanggalBerangkat, double hargaRute, double hargaBis, String idRute, String kotaAsal, String kotaTujuan) {
        super(idRute, kotaAsal, kotaTujuan);
        this.jamBerangkat = jamBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
        this.hargaRute = hargaRute;
        this.hargaBis = hargaBis;
    }
    
}
