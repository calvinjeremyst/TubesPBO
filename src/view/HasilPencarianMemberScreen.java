/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.DetailRute;
import view.Helper.TampungDipilih2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class HasilPencarianMemberScreen implements ActionListener {
    JLabel judul, LlistPerjalanan, header;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton pesan,back;
    ArrayList<JLabel> listPerjalanan = new ArrayList<>();
    ArrayList<JRadioButton> listTombol = new ArrayList<>();
    ButtonGroup buttonGroup = new ButtonGroup();
    int tinggiRadio = 150;
    TampungDipilih2 dipilih = new TampungDipilih2();
    ArrayList<DetailRute> drutes = new ArrayList<>();
    String rute = "";
    JTable jt;
     
    public HasilPencarianMemberScreen(ArrayList<DetailRute> drute) {
        drutes = drute;
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Hasil Pencarian List Perjalanan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(400, 20, 600, 100);
        
        LlistPerjalanan = new JLabel("List Perjalanan : ");
        LlistPerjalanan.setFont(new Font("Consolas", Font.PLAIN, 20));
        LlistPerjalanan.setBounds(20, 110, 200, 50);
        
        header = new JLabel("ID Rute");
        header.setFont(new Font("Consolas", Font.PLAIN, 20));
        header.setBounds(270, 110, 250, 50);
        
        jt = new JTable();
        jt.setBounds(270,150,700,50);
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
            
            listTombol.add(new JRadioButton());
            listTombol.get(i).setBounds(900,tinggiRadio,20,20);
            buttonGroup.add(listTombol.get(i));
            frame.add(listTombol.get(i));
            tinggiRadio += 40;
        }  
        jt.setModel(model);
      
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
        frame.add(jt);
        frame.add(header);
        frame.add(pesan);
        frame.add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("PESAN")){
            cekPilihan();
        }else if(e.getActionCommand().equals("BACK")){
            new PencarianRuteScreen();
            frame.dispose();
        }
    }
    
    public void cekPilihan(){
        boolean pilihan = false;
        for (int i = 0; i < listTombol.size(); i++) {
            if (listTombol.get(i).isSelected()) {
                dipilih.setIdRute(drutes.get(i).getIdRute());
                dipilih.setKotaAsal(drutes.get(i).getKotaAsal());
                dipilih.setKotaTujuan(drutes.get(i).getKotaTujuan());
                dipilih.setIdbis(drutes.get(i).getIdbis());
                dipilih.setJamBerangkat(drutes.get(i).getJamBerangkat());
                dipilih.setTanggalBerangkat(drutes.get(i).getTanggalBerangkat());
                dipilih.setHargaBis(drutes.get(i).getHargaBis());
                dipilih.setHargaRute(drutes.get(i).getHargaRute());
                pilihan = true;
                break;
            }
        }
        
        if(pilihan){
             new PemilihanKursi(dipilih); 
            frame.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Rute!");
        }
        
    }
    
}
