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
    boolean cekAdmin = false;
    public static Rute rute = new Rute();
    public static ArrayList<User> listUser = new ArrayList<>();
    public static ArrayList<Admin> listAdmin = new ArrayList<>();
    
    public Menu() {
        showMenuAwal();
    }
    
    private void showMenuAwal() {
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
                listUser.add(new Member(nama, password, alamat, noHP, umur, ktp));
            }else if(number == 2){
                String nama = JOptionPane.showInputDialog("Nama : ");
                String password = JOptionPane.showInputDialog("Password : ");
                for(User user : listUser){
                    Member member = (Member) user;
                    Admin admin = (Admin) user;
                    if(member.getNama().equals(nama) && member.getPassword().equals(password)){
                        JOptionPane.showMessageDialog(null, "Welcome Back, " + user.getNama() + " !");
                        showMenuLanjut();
                        break;
                    }else if(admin.getNama().equals(nama) && admin.getPassword().equals(password)){
                        cekAdmin = true;
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
            if(cekAdmin = true){
                int number = Integer.parseInt(JOptionPane.showInputDialog(null,"Travel Bis Emen\n 1.List Rute \n2.Tambah Rute \n3.Lihat Data Member"));
                if(number == 1){
                    
                }else if(number == 2){
                    String jam = JOptionPane.showInputDialog(null, "Input Jam : ");
                    String tanggal = JOptionPane.showInputDialog(null, "Input Tanggal : ");
                    double hargaRute = Double.parseDouble(JOptionPane.showInputDialog(null, "Input Harga Rute : "));
                    double hargaBis = Double.parseDouble(JOptionPane.showInputDialog(null, "Input Harga Bis : "));
                    String idRute = JOptionPane.showInputDialog(null, "ID Rute : ");
                    String kotaAsal = JOptionPane.showInputDialog(null, "Kota Asal : ");
                    String kotaTujuan = JOptionPane.showInputDialog(null, "Kota Tujuan : ");
                    rute.tambahRute(jam, tanggal, hargaRute, hargaBis, idRute, kotaAsal, kotaTujuan);
                }else if(number == 3){
                    
                }
            }else{
                int number = Integer.parseInt(JOptionPane.showInputDialog(null,"Travel Bis Emen\n1.Pesan Tiket \n2.Pembatalan Tiket \n3.Riwayat Pemesanan \n4.Cek Saldo OVO \n5.TopUp OVO"));
                if(number == 1){
                    
                }else if(number == 2){
                    
                }else if(number == 3){
                    
                }else if(number == 4){
                    
                }else if(number == 5){
                    
                }
            }
        }
    }
    
}