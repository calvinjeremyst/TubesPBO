/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author lenovo
 */
import controller.DataBaseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class PencarianPerjalananScreen implements ActionListener {
    JLabel judul, LlistPerjalanan, listPerjalanan;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton pesan,back;
    JCheckBox list;
    int x=110,y=120;
    String dipilih = "";
    
    public PencarianPerjalananScreen() {
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Pencarian List Perjalanan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        LlistPerjalanan = new JLabel("List Perjalanan : ");
        LlistPerjalanan.setFont(new Font("Consolas", Font.PLAIN, 20));
        LlistPerjalanan.setBounds(20, 110, 250, 50);
        for(int i=0; i<=7; i++){
            listPerjalanan = new JLabel("Output List Pejalanan yang Dicari");
            listPerjalanan.setFont(new Font("Consolas", Font.PLAIN, 20));
            listPerjalanan.setBounds(270,x,500, 50);
            list = new JCheckBox();
            list.setBounds(800,y,20,20);
            frame.add(listPerjalanan);
            frame.add(list);
            x += 40;
            y += 40;
            if(this.list.isSelected()){ 
                dipilih += listPerjalanan;  
            }
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
        frame.add(pesan);
        frame.add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("PESAN")){
           
        }else if(e.getActionCommand().equals("BACK")){
            new PencarianRuteScreen();
        }
        
    }
    
}
