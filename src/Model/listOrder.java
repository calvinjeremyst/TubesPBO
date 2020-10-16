/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DetailRute;
import Model.RutePerjalanan;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class listOrder {
    
    public LinkedList<listOrder>order;
    private String ID_Order;
    private String TanggalOrder;
    
    public listOrder(){
        
    }

    public listOrder(String ID_Order, String tanggalOrder) {
        this.ID_Order = ID_Order;
        this.TanggalOrder = TanggalOrder;
        
    }

    public String getID_Order() {
        return ID_Order;
    }

    public void setID_Order(String ID_Order) {
        this.ID_Order = ID_Order;
    }

    public String getTanggalOrder() {
        return TanggalOrder;
    }

    public void setTanggalOrder(String TanggalOrder) {
        this.TanggalOrder = TanggalOrder;
    }
    
    public void listRute(DetailRute rute){
        
       JOptionPane.showInputDialog("Rute yang tersedia : " + rute.printRute()); 
        
    }
    
    public void pesanTiket(){
        
    }
    
    
    
}
