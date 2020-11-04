/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DetailRute;
import Controller.*;
import View.Helper.TampungDipilih;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author user
 */
public class HasilPencarianRuteScreen implements ActionListener {
    JLabel judul, LlistPerjalanan, header;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton pesan,back;
    JLabel[] listPerjalanan = new JLabel[10];
    JCheckBox[] list = new JCheckBox[10];
    int x = 150;
    int y = 165;
    
    public HasilPencarianRuteScreen(ArrayList<DetailRute> drute) {
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Hasil Pencarian List Perjalanan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(400, 20, 600, 100);
        
        LlistPerjalanan = new JLabel("List Perjalanan : ");
        LlistPerjalanan.setFont(new Font("Consolas", Font.PLAIN, 20));
        LlistPerjalanan.setBounds(20, 110, 200, 50);
        
        header = new JLabel("ID Rute");
        header.setFont(new Font("Consolas", Font.PLAIN, 20));
        header.setBounds(270, 110, 250, 50);
        
        for (int i=0; i<drute.size(); i++) {
            listPerjalanan[i] = new JLabel(drute.get(i).toString());
            listPerjalanan[i].setFont(new Font("Consolas", Font.PLAIN, 18));
            listPerjalanan[i].setBounds(270,x,700, 50);
            frame.add(listPerjalanan[i]);
            x += 40;
            list[i] = new JCheckBox();
            list[i].setBounds(800,y,20,20);
            frame.add(list[i]);
            y += 40;
        }
      
        pesan = new JButton("PESAN");
        pesan.setBounds(400, 500, 250, 30);
        pesan.setEnabled(true);
        pesan.addActionListener(this);
        pesan.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        back = new JButton("BACK");
        back.setBounds(700, 500, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(LlistPerjalanan);
        frame.add(header);
        frame.add(pesan);
        frame.add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("PESAN")){
            ArrayList<DetailRute> drute = new ArrayList<>();
            ArrayList<TampungDipilih> dipilih = new ArrayList<>();
            for (int i=0; i < drute.size(); i++) {
                if(list[i].isSelected()){ 
                    dipilih = Controller.pilihanRute(drute.get(i).getJamBerangkat(),drute.get(i).getTanggalBerangkat(),
                     drute.get(i).getHargaRute(),drute.get(i).getHargaBis(),drute.get(i).getIdRute(),
                     drute.get(i).getKotaAsal(),drute.get(i).getKotaTujuan(),drute.get(i).getListbis());
                }
            }
            new PemilihanKursi(); 
            frame.dispose();
        }else if(e.getActionCommand().equals("BACK")){
            new PencarianRuteScreen();
            frame.dispose();
        }
    }
    
}
