/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import view.Helper.TampungDipilih;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.*;
import model.EnumBis;
import model.Kursi;
import model.ListBus;
/**
 *
 * @author user
 */
public class PemilihanKursi implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,pilihan;
    JLabel[] noKursi = new JLabel[100];
    JCheckBox[] kursi = new JCheckBox[100];
    JButton next,back;
    int x = 130;
    int y = 130;
    int banyakPenumpang = 0;
    TampungDipilih dipilih2 = new TampungDipilih();
    ListBus bus2;
    ArrayList<Kursi> arrKursi = new ArrayList<>();
    
    public PemilihanKursi(TampungDipilih dipilih) {
        dipilih2 = dipilih;
        arrKursi = Controller.getKursi(dipilih2.getIdRute());
        
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Pemilihan Kursi Bis");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        //Cek Tipe Bis
        ListBus bus = Controller.getKelasBis(dipilih2.getIdbis());
        bus2 = bus;
        
        pilihan = new JLabel("Pilihan Kursi : Bis " + bus.getKelas().toString());
        pilihan.setFont(new Font("Consolas", Font.PLAIN, 20));
        pilihan.setBounds(20, 110, 350, 50);
        
        if(bus.getKelas().equals(EnumBis.VIP)){
            for(int i=1; i<=10; i++){
                if(i<=5){
                    noKursi[i] = new JLabel("Kursi " + i);
                    noKursi[i].setBounds(500,x,80,20);
                    noKursi[i].setFont(new Font("Consolas", Font.PLAIN, 18));
                    frame.add(noKursi[i]);
                    kursi[i] = new JCheckBox();
                    kursi[i].setBounds(600,x,20,20);
                    frame.add(kursi[i]);
                    if(i-1 < arrKursi.size()){
                        if(arrKursi.get(i-1).getNomorKursi().equals(String.valueOf(i))){
                            kursi[i].setEnabled(false);
                            kursi[i].setSelected(true);
                        }else{
                            kursi[i].setEnabled(true);
                            kursi[i].setSelected(false);
                        }
                    }
                    x += 30;
                }else{
                    noKursi[i] = new JLabel("Kursi " + i);
                    noKursi[i].setFont(new Font("Consolas", Font.PLAIN, 18));
                    noKursi[i].setBounds(700,y,80,20);
                    frame.add(noKursi[i]);
                    kursi[i] = new JCheckBox();
                    kursi[i].setBounds(800,y,20,20);
                    frame.add(kursi[i]);
                    if(i-1 < arrKursi.size()){
                        if(arrKursi.get(i-1).getNomorKursi().equals(String.valueOf(i))){
                            kursi[i].setEnabled(false);
                            kursi[i].setSelected(true);
                        }else{
                            kursi[i].setEnabled(true);
                            kursi[i].setSelected(false);
                        }
                    }
                    y += 30;   
                }
            }
        }else if(bus.getKelas().equals(EnumBis.REGULER)){
            for(int i=1; i<=15; i++){
                if(i<=7){
                    noKursi[i] = new JLabel("Kursi " + i);
                    noKursi[i].setBounds(500,x,80,20);
                    noKursi[i].setFont(new Font("Consolas", Font.PLAIN, 18));
                    frame.add(noKursi[i]);
                    kursi[i] = new JCheckBox();
                    kursi[i].setBounds(600,x,20,20);
                    frame.add(kursi[i]);
                    if(i-1 < arrKursi.size()){
                        if(arrKursi.get(i-1).getNomorKursi().equals(String.valueOf(i))){
                            kursi[i].setEnabled(false);
                            kursi[i].setSelected(true);
                        }else{
                            kursi[i].setEnabled(true);
                            kursi[i].setSelected(false);
                        }
                    }
                    x += 30;
                }else{
                    noKursi[i] = new JLabel("Kursi " + i);
                    noKursi[i].setFont(new Font("Consolas", Font.PLAIN, 18));
                    noKursi[i].setBounds(700,y,80,20);
                    frame.add(noKursi[i]);
                    kursi[i] = new JCheckBox();
                    kursi[i].setBounds(800,y,20,20);
                    frame.add(kursi[i]);
                    if(i-1 < arrKursi.size()){
                        if(arrKursi.get(i-1).getNomorKursi().equals(String.valueOf(i))){
                            kursi[i].setEnabled(false);
                            kursi[i].setSelected(true);
                        }else{
                            kursi[i].setEnabled(true);
                            kursi[i].setSelected(false);
                        }
                    }
                    y += 30;   
                }
            }
        }else if(bus.getKelas().equals(EnumBis.EKONOMI)){
            for(int i=1; i<=20; i++){
                if(i<=10){
                    noKursi[i] = new JLabel("Kursi " + i);
                    noKursi[i].setBounds(500,x,80,20);
                    noKursi[i].setFont(new Font("Consolas", Font.PLAIN, 18));
                    frame.add(noKursi[i]);
                    kursi[i] = new JCheckBox();
                    kursi[i].setBounds(600,x,20,20);
                    frame.add(kursi[i]);
                    if(i-1 < arrKursi.size()){
                        if(arrKursi.get(i-1).getNomorKursi().equals(String.valueOf(i))){
                            kursi[i].setEnabled(false);
                            kursi[i].setSelected(true);
                        }else{
                            kursi[i].setEnabled(true);
                            kursi[i].setSelected(false);
                        }
                    }
                    x += 30;
                }else{
                    noKursi[i] = new JLabel("Kursi " + i);
                    noKursi[i].setFont(new Font("Consolas", Font.PLAIN, 18));
                    noKursi[i].setBounds(700,y,80,20);
                    frame.add(noKursi[i]);
                    kursi[i] = new JCheckBox();
                    kursi[i].setBounds(800,y,20,20);
                    frame.add(kursi[i]);
                    if(i-1 < arrKursi.size()){
                        if(arrKursi.get(i-1).getNomorKursi().equals(String.valueOf(i))){
                            kursi[i].setEnabled(false);
                            kursi[i].setSelected(true);
                        }else{
                            kursi[i].setEnabled(true);
                            kursi[i].setSelected(false);
                        }
                    }
                    y += 30;   
                }
            }
        }
      
        next = new JButton("SUMMARY");
        next.setBounds(400, 500, 250, 30);
        next.setEnabled(true);
        next.addActionListener(this);
        next.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        back = new JButton("BACK");
        back.setBounds(700, 500, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(pilihan);
        frame.add(next);
        frame.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Kursi> kursi2 = new ArrayList<>();
        if(bus2.getKelas().equals(EnumBis.VIP)){
            for(int i=1; i<=10; i++){
                Kursi kursi3 = new Kursi();
                String nomorKursi = "";
                if(kursi[i].isSelected()){
                    nomorKursi += i;
                    kursi3.setNomorKursi(nomorKursi);
                    banyakPenumpang++;
                    kursi2.add(kursi3);
                }
            }
        }else if(bus2.getKelas().equals(EnumBis.REGULER)){
            for(int i=1; i<=15; i++){
                Kursi kursi3 = new Kursi();
                String nomorKursi = "";
                if(kursi[i].isSelected()){
                    nomorKursi += i;
                    kursi3.setNomorKursi(nomorKursi);
                    banyakPenumpang++;
                    kursi2.add(kursi3);
                }
            }
        }else if(bus2.getKelas().equals(EnumBis.EKONOMI)){
            for(int i=1; i<=20; i++){
                Kursi kursi3 = new Kursi();
                String nomorKursi = "";
                if(kursi[i].isSelected()){
                    nomorKursi += i;
                    kursi3.setNomorKursi(nomorKursi);
                    banyakPenumpang++;
                    kursi2.add(kursi3);
                }
            }
        }
        
        if(e.getActionCommand().equals("SUMMARY")){
            dipilih2.setBanyakPenumpang(banyakPenumpang);
            if(banyakPenumpang == 0){
                JOptionPane.showMessageDialog(null,"Silahkan Pilih Kursi!");
            }else{
                new SummaryScreen(dipilih2,kursi2);
                frame.dispose();
            }
        }else if(e.getActionCommand().equals("BACK")){
            new MenuUtamaMember();
            frame.dispose();
        }
    }
    
}
