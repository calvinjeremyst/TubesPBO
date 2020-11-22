/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.DetailRute;
import view.Helper.TampungDipilih;
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
    JLabel judul, LlistPerjalanan;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton pesan,back;
    ArrayList<JLabel> listPerjalanan = new ArrayList<>();
    ArrayList<JRadioButton> listTombol = new ArrayList<>();
    ButtonGroup buttonGroup = new ButtonGroup();
    int tinggiRadio = 150;
    TampungDipilih dipilih = new TampungDipilih();
    ArrayList<DetailRute> drutes = new ArrayList<>();
    JTable jt;
    JScrollPane js;
    DefaultTableModel model = new DefaultTableModel();
    
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
        
        jt = new JTable();
        String headers[] = {"ID Rute","Kota Asal","Kota Tujuan","ID Bis","Jam Berangkat","Tanggal Berangkat","Harga Bis","Harga Rute"};
        model.setColumnIdentifiers(headers);
        jt.setModel(model);
        js = new JScrollPane(jt);
        
        insert();
        
        js.setBounds(270,130,700,300);
        js.setVisible(true);
        frame.add(js);
        
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
            cekPilihan();
        }else if(e.getActionCommand().equals("BACK")){
            new PencarianRuteScreen();
            frame.dispose();
        }
    }
    
    public void insert(){
        for (int i = 0; i < drutes.size(); i++) {
            model.addRow(new Object[]{drutes.get(i).getIdRute(),drutes.get(i).getKotaAsal(),drutes.get(i).getKotaTujuan(),
                                        drutes.get(i).getIdbis(),drutes.get(i).getJamBerangkat(),drutes.get(i).getTanggalBerangkat(),
                                        drutes.get(i).getHargaBis(),drutes.get(i).getHargaRute()
                                     });
            listTombol.add(new JRadioButton());
            listTombol.get(i).setBounds(975,tinggiRadio,20,15);
            buttonGroup.add(listTombol.get(i));
            frame.add(listTombol.get(i));
            tinggiRadio += 17;
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
