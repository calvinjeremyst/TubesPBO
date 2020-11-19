/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.Helper.TampungDipilih;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class SummaryScreen implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,pilihan,penumpang;
    JLabel hasil = new JLabel();
    JLabel banyak2 = new JLabel();
    JButton bayar,back;
    TampungDipilih dipilih2 = new TampungDipilih();
 
    public SummaryScreen(TampungDipilih dipilih) {
        dipilih2 = dipilih;
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Summary Order");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(550, 20, 500, 100);
        
        pilihan = new JLabel("Detail Pemesanan : ");
        pilihan.setFont(new Font("Consolas", Font.PLAIN, 20));
        pilihan.setBounds(20, 110, 250, 50);
        
        penumpang = new JLabel("Banyak Penumpang");
        penumpang.setFont(new Font("Consolas", Font.PLAIN, 20));
        penumpang.setBounds(850, 110, 250, 50);
        
        banyak2 = new JLabel();
        banyak2.setFont(new Font("Consolas", Font.PLAIN, 20));
        banyak2.setBounds(930,155,135,30);
        banyak2.setText(Integer.toString(dipilih.getBanyakPenumpang()));
        frame.add(banyak2);
        
        hasil = new JLabel(dipilih.toString());
        hasil.setFont(new Font("Consolas", Font.PLAIN, 18));
        hasil.setBounds(270,150,700, 50);
        
        bayar = new JButton("Pembayaran");
        bayar.setBounds(380, 420, 300, 30);
        bayar.setEnabled(true);
        bayar.addActionListener(this);
        bayar.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        back = new JButton("Back to Main Menu");
        back.setBounds(700, 420, 300, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(pilihan);
        frame.add(penumpang);
        frame.add(hasil);
        frame.add(bayar);
        frame.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Pembayaran")){
            new PembayaranTiketScreen(dipilih2); 
            frame.dispose();
        }else if(e.getActionCommand().equals("Back to Main Menu")){
            new MenuUtamaMember(null);
            frame.dispose();
        }
        
    }
    
}
