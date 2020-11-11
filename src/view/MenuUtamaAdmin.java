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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class MenuUtamaAdmin implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton lihatDataMember,tambahListPerjalanan, cekListPerjalanan;
    JLabel judul;
    
    public MenuUtamaAdmin() {
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Menu Utama Admin");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        lihatDataMember = new JButton("Lihat Data Member");
        lihatDataMember.setBounds(500, 120, 300, 30);
        lihatDataMember.setEnabled(true);
        lihatDataMember.addActionListener(this);
        lihatDataMember.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        cekListPerjalanan = new JButton("Cek List Perjalanan");
        cekListPerjalanan.setBounds(500, 180, 300, 30);
        cekListPerjalanan.setEnabled(true);
        cekListPerjalanan.addActionListener(this);
        cekListPerjalanan.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        tambahListPerjalanan = new JButton("Tambah List Perjalanan");
        tambahListPerjalanan.setBounds(480, 240, 350, 30);
        tambahListPerjalanan.setEnabled(true);
        tambahListPerjalanan.addActionListener(this);
        tambahListPerjalanan.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(lihatDataMember);
        frame.add(cekListPerjalanan);
        frame.add(tambahListPerjalanan);
        
    }
    
    public static void main(String[] args) {
        new MenuUtamaAdmin();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Lihat Data Member")){
            new LihatDataMember();
        }else if(e.getActionCommand().equals("Cek List Perjalanan")){
            //new PencarianPerjalananScreen();
        }else if(e.getActionCommand().equals("Tambah List Perjalanan")){
            //new TambahListPerjalanan();
        }
    }
    
}
