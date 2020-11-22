/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.UserManager;
import view.Helper.FontStyle;

/**
 *
 * @author user
 */
public class MenuUtamaMember implements ActionListener {
    
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton pesanTiket, batalTiket,riwayatTiket,cekOvo,topupOvo,logOut;
    JLabel judul, namaAkun;
    
    public MenuUtamaMember() {
        
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Menu Utama Member");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        namaAkun = new JLabel("Halo " + UserManager.getInstance().getUser().getUsername());
        namaAkun.setFont(FontStyle.small);
        namaAkun.setBackground(Color.BLACK);
        namaAkun.setForeground(Color.WHITE);
        namaAkun.setOpaque(true);
        namaAkun.setBounds(1000,20,300,50);
        
        logOut = new JButton("Log Out");
        logOut.setBounds(1000,100,300,50);
        logOut.setEnabled(true);
        logOut.addActionListener(this);
        logOut.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        pesanTiket = new JButton("Pesan Tiket");
        pesanTiket.setBounds(550, 120, 200, 30);
        pesanTiket.setEnabled(true);
        pesanTiket.addActionListener(this);
        pesanTiket.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        batalTiket = new JButton("Pembatalan Tiket");
        batalTiket.setBounds(525, 180, 250, 30);
        batalTiket.setEnabled(true);
        batalTiket.addActionListener(this);
        batalTiket.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        riwayatTiket = new JButton("Riwayat Pemesanan Tiket");
        riwayatTiket.setBounds(480, 240, 350, 30);
        riwayatTiket.setEnabled(true);
        riwayatTiket.addActionListener(this);
        riwayatTiket.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        cekOvo = new JButton("Cek Saldo OVO");
        cekOvo.setBounds(525, 300, 250, 30);
        cekOvo.setEnabled(true);
        cekOvo.addActionListener(this);
        cekOvo.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        topupOvo = new JButton("TopUp Saldo OVO");
        topupOvo.setBounds(525, 360, 250, 30);
        topupOvo.setEnabled(true);
        topupOvo.addActionListener(this);
        topupOvo.setFont(new Font("Consolas", Font.PLAIN, 24));
    
        frame.add(judul);
        frame.add(namaAkun);
        frame.add(logOut);
        frame.add(pesanTiket);
        frame.add(batalTiket);
        frame.add(riwayatTiket);
        frame.add(cekOvo);
        frame.add(topupOvo);
        
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Pesan Tiket")){
            new PencarianRuteScreen(); 
            frame.dispose();
        }else if(e.getActionCommand().equals("Pembatalan Tiket")){
            new PembatalanTiketScreen();
            frame.dispose();
        }else if(e.getActionCommand().equals("Riwayat Pemesanan Tiket")){
            new RiwayatPemesananTiket();
            frame.dispose();
        }else if(e.getActionCommand().equals("Cek Saldo OVO")){
            new CekSaldo();
            frame.dispose();
        }else if(e.getActionCommand().equals("TopUp Saldo OVO")){
            new TopupOVO();
            frame.dispose();
        }else if(e.getActionCommand().equals("Log Out")){
            new LoginScreen();
            frame.dispose();
        }
    }
    
}
