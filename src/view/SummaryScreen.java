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
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Kursi;

/**
 *
 * @author user
 */
public class SummaryScreen implements ActionListener {
    
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,pilihan,penumpang,banyak2,total,totalHarga;
    JButton bayar,back;
    JTable jt;
    JScrollPane js;
    DefaultTableModel model = new DefaultTableModel();
    TampungDipilih dipilih2 = new TampungDipilih();
    ArrayList<Kursi> kursi2;
 
    public SummaryScreen(TampungDipilih dipilih, ArrayList<Kursi> kursi) {
        
        kursi2 = kursi;
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
        
        penumpang = new JLabel("Banyak Penumpang : ");
        penumpang.setFont(new Font("Consolas", Font.PLAIN, 20));
        penumpang.setBounds(20, 210, 250, 50);
        
        banyak2 = new JLabel();
        banyak2.setFont(new Font("Consolas", Font.PLAIN, 20));
        banyak2.setBounds(240,220,135,30);
        banyak2.setText(Integer.toString(dipilih.getBanyakPenumpang()));
        frame.add(banyak2);
        
        total = new JLabel("Total Harga : ");
        total.setFont(new Font("Consolas", Font.PLAIN, 20));
        total.setBounds(20, 310, 250, 50);
        
        totalHarga = new JLabel();
        totalHarga.setFont(new Font("Consolas", Font.PLAIN, 20));
        totalHarga.setBounds(240,320,135,30);
        double harga = dipilih.getHargaRute() + dipilih.getHargaBis();
        totalHarga.setText(Double.toString(harga));
        frame.add(totalHarga);
        
        jt = new JTable();
        String headers[] = {"ID Rute","Kota Asal","Kota Tujuan","ID Bis","Jam Berangkat","Tanggal Berangkat","Harga Bis","Harga Rute"};
        model.setColumnIdentifiers(headers);
        jt.setModel(model);
        js = new JScrollPane(jt);
        
        insert();
        
        js.setBounds(270,130,700,50);
        js.setVisible(true);
        frame.add(js);
        
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
        frame.add(total);
        frame.add(back);
    }
    
    public void insert(){
        model.addRow(new Object[]{dipilih2.getIdRute(),dipilih2.getKotaAsal(),dipilih2.getKotaTujuan(),
                                    dipilih2.getIdbis(),dipilih2.getJamBerangkat(),dipilih2.getTanggalBerangkat(),
                                    dipilih2.getHargaBis(),dipilih2.getHargaRute()
                                  });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Pembayaran")){
            new PembayaranTiketScreen(dipilih2,kursi2); 
            frame.dispose();
        }else if(e.getActionCommand().equals("Back to Main Menu")){
            new MenuUtamaMember();
            frame.dispose();
        }
    }
    
}
