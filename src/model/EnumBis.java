/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hp
 */
public enum EnumBis {
    
    EKONOMI("Ekonomi"), REGULER("Reguler"), VIP("VIP");
    
    private final String tipe;

    private EnumBis(String tipe2) {
        tipe = tipe2;
    }
    
    @Override
    public String toString() {
        return this.tipe;
    }
}
