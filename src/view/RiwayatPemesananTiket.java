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
    JScrollPane js;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<ListOrder> list = new ArrayList<>();
    ArrayList<TransaksiPembayaran> list2 = new ArrayList<>();
    ArrayList<DetailRute> list3 = new ArrayList<>();
        
    public RiwayatPemesananTiket(){
        Member member = (Member) UserManager.getInstance().getUser();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Riwayat Pemesanan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(250, 20, 500, 100);
        
         //Table
        if(Controller.getRiwayat(member,list,list2,list3)){
            jt = new JTable();
            String headers[] = {"ID Order","Tanggal Order","ID Rute","ID Transaksi","Metode Pembayaran",
                                "Grand Total","Banyak Penumpang","Kota Asal","Kota Tujuan","Jam Berangkat",
                                "Tanggal Berangkat","Harga Rute","Harga Bis"};
            model.setColumnIdentifiers(headers);
            jt.setModel(model);
            js = new JScrollPane(jt);

            insert();

            js.setBounds(30,180,1300,300);
            js.setVisible(true);
            frame.add(js);
        }else{
            JOptionPane.showMessageDialog(null,"Gagal Mengambil Riwayat dari Database!");
        }
        
        back = new JButton("Back");
        back.setBounds(750, 50, 150, 50);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(back);
    }
    
    public void insert(){
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdOrder(),list.get(i).getTanggalOrder(),list.get(i).getIdRute(),
                                        list2.get(i).getIdTransaksi(),list2.get(i).getMetodePembayaran(),
                                        list2.get(i).getGrandTotal(),list2.get(i).getBanyakPenumpang(),
                                        list3.get(i).getKotaAsal(),list3.get(i).getKotaTujuan(),list3.get(i).getJamBerangkat(),
                                        list3.get(i).getTanggalBerangkat(),list3.get(i).getHargaRute(),list3.get(i).getHargaBis()
                                     });
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Show")){
           js.setVisible(true);
        }
        else if(e.getActionCommand().equals("Back")){
            new MenuUtamaMember();
            frame.dispose();
        }
    }
    
}
