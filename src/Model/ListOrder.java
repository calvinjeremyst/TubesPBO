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
public class ListOrder {
    private String idOrder;
    private String tanggalOrder;
    ArrayList<ListBus> bis;
    ArrayList<Rute> rute;
    ArrayList<Kursi> kursi;
    
    public ListOrder(String idOrder, String tanggalOrder) {
        this.idOrder = idOrder;
        this.tanggalOrder = tanggalOrder;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(String tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }
    
    
}
