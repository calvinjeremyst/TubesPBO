/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.*;
/**
 *
 * @author Hp
 */
public class Menu {
    
    public Menu() {
            showMenuAwal();
    }
    
    private void showMenuAwal() {
        ArrayList<User> user = new ArrayList<>();
        int cek = JOptionPane.NO_OPTION;
        while(cek != JOptionPane.YES_OPTION){
            int number = Integer.parseInt(JOptionPane.showInputDialog(null,"Travel Bis Emen\n 1.Register\n 2.Login"));
            if(number == 1){
                String nama = JOptionPane.showInputDialog("Nama : ");
                String password = JOptionPane.showInputDialog("Password : ");
                String alamat = JOptionPane.showInputDialog("Alamat : ");
                String noHP = JOptionPane.showInputDialog("No.HP : ");
                int umur = Integer.parseInt(JOptionPane.showInputDialog("Umur : "));
                String ktp = JOptionPane.showInputDialog("No.KTP : ");
                user.add(new Member(nama, password, alamat, noHP, umur, ktp));
            }else if(number == 2){
                String nama = JOptionPane.showInputDialog("Nama : ");
                String password = JOptionPane.showInputDialog("Password : ");
                for(User i : user){
                    if(i.getNama().equals(nama) && i.getPassword().equals(password)){
                        JOptionPane.showMessageDialog(null, "Welcome Back, " + i.getNama() + " !");
                        showMenuLanjut();
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null, "Nama dan/atau Password Salah!");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null,"Input Salah!");
            }
        }
        cek = JOptionPane.showConfirmDialog(null,"Ulang Program?");
    }
    
    private void showMenuLanjut(){
        int cek = JOptionPane.NO_OPTION;
        while(cek != JOptionPane.YES_OPTION){
            int number = Integer.parseInt(JOptionPane.showInputDialog(null,"Travel Bis Emen\n 1.List Perjalanan \n2.Pesan Tiket \n3.Pembatalan Tiket \n4.Riwayat Pemesanan \n5.Cek Saldo OVO \n6.TopUp OVO"));
        }
    }
    
}