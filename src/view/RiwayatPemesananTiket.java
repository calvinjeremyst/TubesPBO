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
import model.DetailRute;
import model.Member;
import model.UserManager;
import model.ListOrder;
import model.Rute;
import model.TransaksiPembayaran;

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
        ArrayList<ListOrder> list = new ArrayList<>();
        ArrayList<TransaksiPembayaran> list2 = new ArrayList<>();
        ArrayList<DetailRute> list3 = new ArrayList<>();
        
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Riwayat Pemesanan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(250, 20, 500, 100);
        
        if(Controller.getRiwayat(member,list,list2,list3)){
            jt = new JTable();
            jt.setBounds(150,150,1000,500);
            DefaultTableModel model = new DefaultTableModel();
            Object[] namaKolom = new Object[13];
            namaKolom[0] = "ID Order";
            namaKolom[1] = "Tanggal Order";
            namaKolom[2] = "ID Rute";
            namaKolom[3] = "ID Transaksi";
            namaKolom[4] = "Metode Pembayaran";
            namaKolom[5] = "Grand Total";
            namaKolom[6] = "Banyak Penumpang";
            namaKolom[7] = "Kota Asal";
            namaKolom[8] = "Kota Tujuan";
            namaKolom[9] = "Jam Berangkat";
            namaKolom[10] = "Tanggal Berangkat";
            namaKolom[11] = "Harga Rute";
            namaKolom[12] = "Harga Bis";
            model.setColumnIdentifiers(namaKolom);
            Object[] dataKolom = new Object[13];
            for (int i = 0; i < list.size(); i++) {
                dataKolom[0] = list.get(i).getIdOrder();
                dataKolom[1] = list.get(i).getTanggalOrder();
                dataKolom[2] = list.get(i).getIdRute();
                model.addRow(dataKolom);
            }  
            for (int i = 0; i < list2.size(); i++) {
                dataKolom[3] = list2.get(i).getIdTransaksi();
                dataKolom[4] = list2.get(i).getMetodePembayaran();
                dataKolom[5] = list2.get(i).getGrandTotal();
                dataKolom[6] = list2.get(i).getBanyakPenumpang();
                model.addRow(dataKolom);
            }
            for (int i = 0; i < list3.size(); i++) {
                dataKolom[7] = list3.get(i).getKotaAsal();
                dataKolom[8] = list3.get(i).getKotaTujuan();
                dataKolom[9] = list3.get(i).getJamBerangkat();
                dataKolom[10] = list3.get(i).getTanggalBerangkat();
                dataKolom[11] = list3.get(i).getHargaRute();
                dataKolom[12] = list3.get(i).getHargaBis();
                model.addRow(dataKolom);
            }
            jt.setModel(model);
        }else{
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan!");
        }
        
        back = new JButton("Back");
        back.setBounds(850, 20, 250, 100);
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
