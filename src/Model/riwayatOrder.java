/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class riwayatOrder extends listOrder {
    
    public riwayatOrder(){}
    
    public riwayatOrder(String ID_Order, String TanggalOrder, String kotaAsalPilihan, String kotaTujuanPilihan,
            String tanggalBerangkatMember, String jamBerangkatMember, double totalBayarMember){
        
        super(ID_Order,TanggalOrder,kotaAsalPilihan,kotaTujuanPilihan,
            tanggalBerangkatMember, jamBerangkatMember, totalBayarMember);
    }
    
    
    
}
