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
    static boolean cekAdmin = false;
    public static User user = new User();
    public static DetailRute detailR = new DetailRute();
    public static Admin admins = new Admin();
    public static ArrayList<User> listUser = new ArrayList<>();
    public static ArrayList<Admin> listAdmin = new ArrayList<>();
    
    public Menu() {
        showMenuAwal();
    }
    
    static void showMenuAwal() {
        boolean isLanjut = true;
        while(isLanjut){
            String choice_str = JOptionPane.showInputDialog(null,"Travel Bis Emen\n 1.Register\n 2.Login");      
            if(choice_str == null || choice_str.equals("")){
                JOptionPane.showMessageDialog(null,"Input pilihan menu","Alert",JOptionPane.WARNING_MESSAGE);
            }else{ 
                int choice = Integer.parseInt(choice_str);
                switch (choice) {
                    case 1:
                        Register();         
                        break;
                    case 2:
                        Login();
                        break;
                    case 3:
                        isLanjut = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Pilihan tidak tersedia!","Alert",JOptionPane.WARNING_MESSAGE);
                        break;
                }
            }
        }
    }
    
    static void Register(){
        String nama = JOptionPane.showInputDialog("Nama : ");
        String password = JOptionPane.showInputDialog("Password : ");
        String alamat = JOptionPane.showInputDialog("Alamat : ");
        String noHP = JOptionPane.showInputDialog("No.HP : ");
        String umur = JOptionPane.showInputDialog("Umur : ");
        String ktp = JOptionPane.showInputDialog("No.KTP : ");
        listUser.add(new Member(nama, password, alamat, noHP, umur, ktp));
    }
    
    static void Login(){
        boolean cek = user.login();
        if(cek){
            JOptionPane.showMessageDialog(null, "Welcome Back, " + user.getNama() + " !");
            showMenuLanjut();
        }else{
            JOptionPane.showMessageDialog(null, "Nama dan/atau Password Salah!");
        }
    }
    
    static void showMenuLanjut(){
        boolean isLanjut = true;
        while(isLanjut){
            if(cekAdmin = true){
                String choice_str = JOptionPane.showInputDialog(null,"Travel Bis Emen\n 1.List Rute \n2.Tambah Rute \n3.Lihat Data Member");      
                if(choice_str == null || choice_str.equals("")){
                    JOptionPane.showMessageDialog(null,"Input pilihan menu","Alert",JOptionPane.WARNING_MESSAGE);
                }else{ 
                    int choice = Integer.parseInt(choice_str);
                    switch (choice) {
                        case 1:
                            tampilRute();         
                            break;
                        case 2:
                            tambahRute();
                            break;
                        case 3:
                            dataMember();
                            break;
                        case 4:
                            isLanjut = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Pilihan tidak tersedia!","Alert",JOptionPane.WARNING_MESSAGE);
                            break;
                    }
                }
            }else{
                String choice_str = JOptionPane.showInputDialog(null,"Travel Bis Emen\n1.Pesan Tiket \n2.Pembatalan Tiket \n3.Riwayat Pemesanan \n4.Cek Saldo OVO \n5.TopUp OVO");
                if(choice_str == null || choice_str.equals("")){
                    JOptionPane.showMessageDialog(null,"Input pilihan menu","Alert",JOptionPane.WARNING_MESSAGE);
                }else{ 
                    int choice = Integer.parseInt(choice_str);
                    switch (choice) {
                        case 1:
                            pesanTiket();         
                            break;
                        case 2:
                            batalTiket();
                            break;
                        case 3:
                            riwayat();
                            break;
                        case 4:
                            cekSaldo();
                            break;
                        case 5:
                            topUp();
                            break;
                        case 6:
                            isLanjut = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Pilihan tidak tersedia!","Alert",JOptionPane.WARNING_MESSAGE);
                            break;
                    }
                }
            }
        }
    }
    
    static void tampilRute(){
        String data = detailR.tampilRute();
        JOptionPane.showMessageDialog(null, data);
    }
                    
    static void tambahRute(){
        String jam = JOptionPane.showInputDialog(null, "Input Jam : ");
        String tanggal = JOptionPane.showInputDialog(null, "Input Tanggal : ");
        double hargaRute = Double.parseDouble(JOptionPane.showInputDialog(null, "Input Harga Rute : "));
        double hargaBis = Double.parseDouble(JOptionPane.showInputDialog(null, "Input Harga Bis : "));
        String idRute = JOptionPane.showInputDialog(null, "ID Rute : ");
        String kotaAsal = JOptionPane.showInputDialog(null, "Kota Asal : ");
        String kotaTujuan = JOptionPane.showInputDialog(null, "Kota Tujuan : ");
        detailR.tambahRute(jam, tanggal, hargaRute, hargaBis, idRute, kotaAsal, kotaTujuan);
    }
    
    static void dataMember(){
        String data = admins.lihatDataMember();
        JOptionPane.showMessageDialog(null, data);
    }
        
    static void pesanTiket(){
        
    }
    static void batalTiket(){
        
    }
    static void riwayat(){
        
    }
    static void cekSaldo(){
        
    }
    static void topUp(){
        
    }
}