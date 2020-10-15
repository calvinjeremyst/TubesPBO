/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.*;
/**
 *
 * @author Hp
 */
public class Controller {
    
    public Controller() {
        tambahData();
    }
    
    public void tambahData() {
        ArrayList<User> user = new ArrayList<>();
        user.add(new Admin("Calvin", "1234", "Pagarsih", "087876060872", "1001"));
        user.add(new Admin("Christian", "abcd", "Ujung Berung", "0888111222", "1002"));
        user.add(new Admin("Aji", "xyz", "Dago", "087811223344", "1003"));
        
        ArrayList<DetailRute> rute = new ArrayList<>();
        rute.add(new DetailRute("","",50000,10000,"101","Bandung","Jakarta"));
        rute.add(new DetailRute("","",35000,15000,"102","Bekasi","Depok"));
        rute.add(new DetailRute("","",100000,25000,"103","Lampung","Banten"));
        rute.add(new DetailRute("","",50000,20000,"104","Bogor","Majalengka"));
        rute.add(new DetailRute("","",20000,5000,"105","Indramayu","Cirebon"));
        rute.add(new DetailRute("","",80000,40000,"106","Tasikmalaya","Cicalengka"));
        rute.add(new DetailRute("","",75000,25000,"107","Subang","Pamanukan"));
        rute.add(new DetailRute("","",25000,10000,"108","Tangerang","Jakarta"));
        
    }
    
}
