/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class SummaryScreen implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,pilihan,penumpang;
    JLabel[] hasil = new JLabel[10];
    JTextField[] banyak = new JTextField[10];
    JLabel banyak2 = new JLabel();
    JButton bayar,back;
    int x = 150;
    int y = 165;
    
    public SummaryScreen(ArrayList<TampungDipilih> dipilih){
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Input Banyak Penumpang");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        pilihan = new JLabel("Pilihan User : ");
        pilihan.setFont(new Font("Consolas", Font.PLAIN, 20));
        pilihan.setBounds(20, 110, 250, 50);
        
        penumpang = new JLabel("Banyak Penumpang");
        penumpang.setFont(new Font("Consolas", Font.PLAIN, 20));
        penumpang.setBounds(800, 110, 250, 50);
        
        banyak2 = new JLabel();
        banyak2.setFont(new Font("Consolas", Font.PLAIN, 14));
        banyak2.setBounds(820,165,135,30);
        banyak2.setText("5");
        frame.add(banyak2);
        
        for (int i=0; i<dipilih.size(); i++) {
            hasil[i] = new JLabel(dipilih.get(i).toString());
            hasil[i].setFont(new Font("Consolas", Font.PLAIN, 18));
            hasil[i].setBounds(270,x,700, 50);
            frame.add(hasil[i]);
            x += 40;
            banyak[i] = new JTextField("Banyak Penumpang");
            banyak[i].setFont(new Font("Consolas", Font.PLAIN, 14));
            banyak[i].setBounds(800,y,135,30);
            frame.add(banyak[i]);
            y += 40;
        }
        
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
        frame.add(bayar);
        frame.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String jumlahText = this.banyak2.getText();
        int jumlahInt = Integer.parseInt(jumlahText);
        
        if(e.getActionCommand().equals("Pembayaran")){
            new PembayaranTiketScreen(); 
            frame.dispose();
        }else if(e.getActionCommand().equals("Back to Main Menu")){
            new MenuUtamaMember();
            frame.dispose();
        }
        
    }
    
}
