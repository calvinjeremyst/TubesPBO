/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class PembayaranTiketScreen implements ActionListener{
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,metode,banyakKursi,kursi;
    JRadioButton credit,ovo;
    JButton bayar,back;
    ButtonGroup bg;
    
    public PembayaranTiketScreen(){
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Pembayaran Tiket Bis");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        metode = new JLabel("Metode Pembayaran : ");
        metode.setFont(new Font("Consolas", Font.PLAIN, 20));
        metode.setBounds(20, 110, 250, 50);
        
        banyakKursi = new JLabel("Banyak Penumpang : ");
        banyakKursi.setFont(new Font("Consolas", Font.PLAIN, 20));
        banyakKursi.setBounds(20, 210, 250, 50);
        
        kursi = new JLabel("5");
        kursi.setFont(new Font("Consolas", Font.PLAIN, 20));
        kursi.setBounds(270, 210, 250, 50);
        
        bg = new ButtonGroup();
        credit = new JRadioButton("Credit Card");
        credit.setFont(new Font("Consolas", Font.PLAIN, 20));
        credit.setBounds(270,110,165,50);
        ovo = new JRadioButton("OVO");
        ovo.setFont(new Font("Consolas", Font.PLAIN, 20));
        ovo.setBounds(270,160,165,50);
        bg.add(credit);
        bg.add(ovo);
        
        bayar = new JButton("SUBMIT");
        bayar.setBounds(400, 500, 250, 30);
        bayar.setEnabled(true);
        bayar.addActionListener(this);
        bayar.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        back = new JButton("BACK");
        back.setBounds(700, 500, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(metode);
        frame.add(banyakKursi);
        frame.add(kursi);
        frame.add(credit);
        frame.add(ovo);
        frame.add(bayar);
        frame.add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("SUBMIT")){
            JOptionPane.showMessageDialog(null,"Tiket Anda Berhasil Dipesan!"); 
            new MenuUtamaMember();
        }else if(e.getActionCommand().equals("BACK")){
            //new PencarianPerjalananScreen();
        }
    }
}
