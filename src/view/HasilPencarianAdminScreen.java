/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.DetailRute;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lenovo
 */
public class HasilPencarianAdminScreen implements ActionListener {
    
    JLabel judul;
    JFrame framehasilCari = new JFrame("Terminal Bis Emen");
    JButton back;
    JTable jt;
    JScrollPane js;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<DetailRute> drute2 = new ArrayList<>();
    
    public HasilPencarianAdminScreen(ArrayList<DetailRute> drute) {
        
        drute2 = drute;
        framehasilCari.setExtendedState(JFrame.MAXIMIZED_BOTH);
        framehasilCari.getContentPane().setBackground(Color.WHITE);
        framehasilCari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framehasilCari.setLocationRelativeTo(null);
        framehasilCari.setVisible(true);
        framehasilCari.setLayout(null); 
        
        judul = new JLabel("Hasil Pencarian Rute Admin");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(450, 20, 600, 100);
        
        jt = new JTable();
        String headers[] = {"ID Rute","Kota Asal","Kota Tujuan","ID Bis","Jam Berangkat","Tanggal Berangkat","Harga Bis","Harga Rute"};
        model.setColumnIdentifiers(headers);
        jt.setModel(model);
        js = new JScrollPane(jt);
        
        insert();
        
        js.setBounds(340,130,700,300);
        js.setVisible(true);
        framehasilCari.add(js);
        
        back = new JButton("Back");
        back.setBounds(550, 500, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        framehasilCari.add(judul);
        framehasilCari.add(back);
    }
    
    public void insert(){
        for (int i = 0; i < drute2.size(); i++) {
            model.addRow(new Object[]{drute2.get(i).getIdRute(),drute2.get(i).getKotaAsal(),drute2.get(i).getKotaTujuan(),
                                        drute2.get(i).getIdbis(),drute2.get(i).getJamBerangkat(),drute2.get(i).getTanggalBerangkat(),
                                        drute2.get(i).getHargaBis(),drute2.get(i).getHargaRute()
                                     });
        }  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Back")){
           new MenuUtamaAdmin();
           framehasilCari.dispose();
       }
    }
    
}
