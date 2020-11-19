/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Member;
import model.UserManager;
import model.ListOrder;

/**
 *
 * @author user
 */
public class RiwayatPemesananTiket implements ActionListener {
    JLabel judul;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton back;
    JTable jt;
    
    public RiwayatPemesananTiket(){
        Member member = (Member) UserManager.getInstance().getUser();
        ArrayList<ListOrder> order = Controller.getRiwayat(member);
        
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Riwayat Pemesanan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(400, 20, 600, 100);
        
        jt = new JTable();
        jt.setBounds(270,150,700,50);
        DefaultTableModel model = new DefaultTableModel();
        Object[] namaKolom = new Object[4];
        namaKolom[0] = "ID Order";
        namaKolom[1] = "Tanggal Order";
        namaKolom[2] = "ID Rute";
        namaKolom[3] = "ID Transaksi";
        model.setColumnIdentifiers(namaKolom);
        Object[] dataKolom = new Object[4];
        
        for (int i = 0; i < order.size(); i++) {
            dataKolom[0] = order.get(i).getIdOrder();
            dataKolom[1] = order.get(i).getTanggalOrder();
            dataKolom[2] = order.get(i).getIdRute();
            model.addRow(dataKolom);
        }  
        jt.setModel(model);
        
        back = new JButton("Back");
        back.setBounds(700, 500, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(jt);
        frame.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back")){
            new MenuUtamaMember();
            frame.dispose();
        }
    }
    
}
