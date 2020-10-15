/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Rute extends ListOrder {
    private String idRute;
    private String kotaAsal;
    private String kotaTujuan;
    ArrayList<ListBus> bis;
    
    public Rute(String idRute, String kotaAsal, String kotaTujuan, String idOrder, String tanggalOrder) {
        super(idOrder, tanggalOrder);
        this.idRute = idRute;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
    }
    
}
