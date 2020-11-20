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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lenovo
 */
public class HasilPencarianAdminScreen implements ActionListener{
    JLabel judul;
    JFrame framehasilCari = new JFrame("Terminal Bis Emen");
    JLabel[] hasilPerjalanan = new JLabel[5];
    JButton back = new JButton();
    JTable jt;
    int x = 150;
    
    public HasilPencarianAdminScreen(ArrayList<DetailRute> drute){
        framehasilCari.setExtendedState(JFrame.MAXIMIZED_BOTH);
        framehasilCari.getContentPane().setBackground(Color.WHITE);
        framehasilCari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framehasilCari.setLocationRelativeTo(null);
        framehasilCari.setVisible(true);
        framehasilCari.setLayout(null);
        
        judul = new JLabel("Hasil Pencarian Rute");
        back = new JButton("Back");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(400, 20, 600, 100);
        
        jt = new JTable();
        jt.setBounds(270,150,500,500);
        DefaultTableModel model = new DefaultTableModel();
        Object[] namaKolom = new Object[8];
        namaKolom[0] = "ID Rute";
        namaKolom[1] = "Kota Asal";
        namaKolom[2] = "Kota Tujuan";
        namaKolom[3] = "ID Bis";
        namaKolom[4] = "Jam Berangkat";
        namaKolom[5] = "Tanggal Berangkat";
        namaKolom[6] = "Harga Bis";
        namaKolom[7] = "Harga Rute";
        model.setColumnIdentifiers(namaKolom);
        Object[] dataKolom = new Object[8];
        
        for (int i = 0; i < drute.size(); i++) {
            dataKolom[0] = drute.get(i).getIdRute();
            dataKolom[1] = drute.get(i).getKotaAsal();
            dataKolom[2] = drute.get(i).getKotaTujuan();
            dataKolom[3] = drute.get(i).getIdbis();
            dataKolom[4] = drute.get(i).getJamBerangkat();
            dataKolom[5] = drute.get(i).getTanggalBerangkat();
            dataKolom[6] = drute.get(i).getHargaBis();
            dataKolom[7] = drute.get(i).getHargaRute();
            model.addRow(dataKolom);
        }
        jt.setModel(model);
        back.setBounds(700,800,100,30);
        back.setEnabled(true);
        back.addActionListener(this);
        framehasilCari.add(judul);
        framehasilCari.add(jt);
        framehasilCari.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Back")){
           new MenuUtamaAdmin();
       }
    }
}
