/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import view.Helper.TampungDipilih;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import model.ListOrder;
import model.TransaksiPembayaran;

/**
 *
 * @author user
 */
public class PembayaranTiketScreen implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,metode,banyakKursi,kursi,isiCCLabel,isiOvoLabel,isiOvo;
    JTextField isiCC;
    JRadioButton credit,ovo;
    JButton bayar,back;
    ButtonGroup bg;
    TampungDipilih dipilih2;
    
    public PembayaranTiketScreen(TampungDipilih dipilih) {
        dipilih2 = dipilih;
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
        
        kursi = new JLabel(Integer.toString(dipilih.getBanyakPenumpang()));
        kursi.setFont(new Font("Consolas", Font.PLAIN, 20));
        kursi.setBounds(270, 210, 250, 50);
        
        isiCCLabel = new JLabel("Nomor Credit Card");
        isiCCLabel.setVisible(false);
        isiCCLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        isiCCLabel.setBounds(500 ,140, 250, 30);
        
        isiCC = new JTextField();
        isiCC.setVisible(false);
        isiCC.setFont(new Font("Consolas", Font.PLAIN, 20));
        isiCC.setBounds(800 ,140, 250, 30);
        
        bg = new ButtonGroup();
        credit = new JRadioButton("Credit Card");
        credit.setFont(new Font("Consolas", Font.PLAIN, 20));
        credit.setBounds(270,110,165,50);
        credit.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    isiCCLabel.setVisible(true);
                    isiCC.setVisible(true);
                    isiOvoLabel.setVisible(false);
                    isiOvoLabel.setVisible(false);
                }
            }
        });
        
        isiOvoLabel = new JLabel("Saldo OVO Anda");
        isiOvoLabel.setVisible(false);
        isiOvoLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        isiOvoLabel.setBounds(500 ,140, 250, 30);
        
        isiOvo = new JLabel("50000");
        isiOvo.setVisible(false);
        isiOvo.setFont(new Font("Consolas", Font.PLAIN, 20));
        isiOvo.setBounds(800 ,140, 250, 30);
        
        ovo = new JRadioButton("OVO");
        ovo.setFont(new Font("Consolas", Font.PLAIN, 20));
        ovo.setBounds(270,160,165,50);
        ovo.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    isiCCLabel.setVisible(false);
                    isiCC.setVisible(false);
                    isiOvoLabel.setVisible(true);
                    isiOvo.setVisible(true);
                    ovo.isSelected();
                }
            }
        });
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
        frame.add(isiCCLabel);
        frame.add(isiCC);
        frame.add(isiOvoLabel);
        frame.add(isiOvo);
        frame.add(ovo);
        frame.add(bayar);
        frame.add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        int banyakPenumpang = this.dipilih2.getBanyakPenumpang();
        double total = this.dipilih2.getHargaBis() + this.dipilih2.getHargaRute();
        double cashback = 0;
        if(total < 200000){
            cashback = 0.05 * total;
        }else if(total > 200000){
            cashback = 0.1 * total;
        }
        double grandTotal = this.dipilih2.getHargaBis() + this.dipilih2.getHargaRute() - cashback;
        String metode = "";
        int useOvo = 0;
        if(this.ovo.isSelected()){   
            metode = "OVO";
            useOvo = 1;
        }else if(this.credit.isSelected()){   
            metode = "Credit Card";
            useOvo = 0;
        }
        Date tanggalPesan = new Date();
        java.sql.Date tanggalPesan2 = new java.sql.Date(tanggalPesan.getTime());
        int idRute = this.dipilih2.getIdRute();
        String kotaAsal = this.dipilih2.getKotaAsal();
        String kotaTujuan = this.dipilih2.getKotaTujuan();
        java.sql.Date tanggalPergi = new java.sql.Date(this.dipilih2.getTanggalBerangkat().getTime());
        String jam = this.dipilih2.getJamBerangkat();
        int idBis = this.dipilih2.getIdbis();
        
        if(e.getActionCommand().equals("SUBMIT")){
            TransaksiPembayaran trk = new TransaksiPembayaran(banyakPenumpang,grandTotal,cashback,useOvo,metode,tanggalPesan2);
            ListOrder order = new ListOrder(tanggalPesan2,idRute,kotaAsal,kotaTujuan,idBis,jam,tanggalPergi);
            if(Controller.insertOrder(trk,order)){
                JOptionPane.showMessageDialog(null,"Tiket Anda Berhasil Dipesan!"); 
                new MenuUtamaMember();
                frame.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Tiket Anda Gagal Dipesan!"); 
                new MenuUtamaMember();
                frame.dispose();
            }
        }
    }
    
}
