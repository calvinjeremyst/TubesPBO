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
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import model.*;

/**
 *
 * @author user
 */
public class PembayaranTiketScreen implements ActionListener {
    
    JFrame frame = new JFrame("Terminal Bis Emen");
    JLabel judul,metode,banyakKursi,lkursi,isiCCLabel,isiOvoLabel,isiOvo,total,totalHarga;
    JTextField isiCC;
    JRadioButton credit,ovo;
    JButton bayar;
    ButtonGroup bg;
    TampungDipilih dipilih2 = new TampungDipilih();
    ArrayList<Kursi> kursi2 = new ArrayList<>();
    
    public PembayaranTiketScreen(TampungDipilih dipilih, ArrayList<Kursi> kursi) {
        
        Member member = (Member) UserManager.getInstance().getUser();
        dipilih2 = dipilih;
        kursi2 = kursi;
        
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
        banyakKursi.setBounds(20, 250, 250, 50);
        
        lkursi = new JLabel(Integer.toString(dipilih.getBanyakPenumpang()));
        lkursi.setFont(new Font("Consolas", Font.PLAIN, 20));
        lkursi.setBounds(270, 250, 250, 50);
        
        total = new JLabel("Total Harga : ");
        total.setFont(new Font("Consolas", Font.PLAIN, 20));
        total.setBounds(20, 310, 250, 50);
        
        totalHarga = new JLabel();
        totalHarga.setFont(new Font("Consolas", Font.PLAIN, 20));
        totalHarga.setBounds(240,320,135,30);
        double harga = dipilih.getHargaRute() + dipilih.getHargaBis();
        totalHarga.setText(Double.toString(harga));
        frame.add(totalHarga);
        
        isiCCLabel = new JLabel("Nomor Credit Card (6 Digit) : ");
        isiCCLabel.setVisible(false);
        isiCCLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        isiCCLabel.setBounds(500 ,140, 350, 30);
        
        isiCC = new JTextField();
        isiCC.setVisible(false);
        isiCC.setFont(new Font("Consolas", Font.PLAIN, 20));
        isiCC.setBounds(500 ,200, 150, 30);
        
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
        
        String saldo = String.valueOf(member.getOvoBalance());
        
        isiOvo = new JLabel(saldo);
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
        bayar.setBounds(550, 500, 250, 50);
        bayar.setEnabled(true);
        bayar.addActionListener(this);
        bayar.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(metode);
        frame.add(banyakKursi);
        frame.add(total);
        frame.add(lkursi);
        frame.add(credit);
        frame.add(isiCCLabel);
        frame.add(isiCC);
        frame.add(isiOvoLabel);
        frame.add(isiOvo);
        frame.add(ovo);
        frame.add(bayar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        Member member = (Member) UserManager.getInstance().getUser();
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
        String nomorCC = this.isiCC.getText();
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
        
        if(e.getActionCommand().equals("SUBMIT")){
            TransaksiPembayaran trk = new TransaksiPembayaran(banyakPenumpang,grandTotal,cashback,useOvo,metode,tanggalPesan2);
            ListOrder order = new ListOrder(tanggalPesan2,member.getID_Member(),idRute);
            if(metode.equals("OVO")){
                if(member.getOvoBalance() < total){
                    JOptionPane.showMessageDialog(null,"Saldo OVO anda tidak cukup!");
                }else{
                    if(Controller.insertOrderOVO(trk,order)){
                        for(int i=0; i<kursi2.size(); i++){
                            if(Controller.insertKursi(kursi2.get(i).getNomorKursi(), order, dipilih2)){
                                JOptionPane.showMessageDialog(null,"Kursi " + kursi2.get(i).getNomorKursi() + " Berhasil Dipesan!");
                            }else{
                                JOptionPane.showMessageDialog(null, "Kursi Gagal Dipesan!");
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Tiket Anda Berhasil Dipesan!"); 
                        new MenuUtamaMember();
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Tiket Anda Gagal Dipesan!"); 
                        new MenuUtamaMember();
                        frame.dispose();
                    }
                }
            }else{
                if(nomorCC.length() == 0){
                    JOptionPane.showMessageDialog(null,"Masukan Nomor Kartu Kredit!");
                }else if(nomorCC.length() <= 5 || nomorCC.length() >= 7){
                    JOptionPane.showMessageDialog(null,"Nomor Kartu Kredit Tidak Valid!");
                }else{
                    if(Controller.insertOrderCC(trk,order)){
                        for(int i=0; i<kursi2.size(); i++){
                            if(Controller.insertKursi(kursi2.get(i).getNomorKursi(), order, dipilih2)){
                                JOptionPane.showMessageDialog(null,"Kursi " + kursi2.get(i).getNomorKursi() + " Berhasil Dipesan!");
                            }else{
                                JOptionPane.showMessageDialog(null, "Kursi Gagal Dipesan!");
                            }
                        }
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
    }
    
}
