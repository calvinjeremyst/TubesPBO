/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Controller.*;
import Model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class View implements ActionListener{
    static JFrame frameOVO,frameTopUp,frameMember;
    JLayeredPane layerLogo,layerBack,layerTable;
    JLabel logo,lsaldo,saldo,salam,lcomboNominal,lcomboMetode;
    JButton buttonCek,buttonTopUp,buttonHistory,buttonKonfirmasi;
    JPanel panel;
    JPanel p1,p2,p3;
    JTable jt,table;
    JScrollPane sp,scroll;
    JComboBox comboNominal,comboMetode;
    int jmlNom;
    String comboMetodeOVO, id;
    RiwayatTopup riwayatTopUp;
    ArrayList<Member> riwayat,members;
    ArrayList<RiwayatTopup> topups;
    
    public View(){
        members = Controller.getAllData();
        for (Member member :members) {
           System.out.println(member.toString());
        }
        id = JOptionPane.showInputDialog("Masukan id : ");
        riwayat = Controller.getData(id);
        topups = Controller.getHistory(id);
        

        frameOVO = new JFrame("OVO");
        frameTopUp = new JFrame("Top Up OVO");
        frameMember = new JFrame("Lihat data member");
       
        //logo
        logo = new JLabel("OVO");
        logo.setBounds(0,0,300,50);
        logo.setFont(font.logo);
        logo.setForeground(Color.white);
        layerLogo = new JLayeredPane();
        layerLogo.add(logo);
        layerLogo.setBounds(0,0,300,50);
        frameOVO.add(layerLogo);
        
        //salam 
        salam = new JLabel("Hi, " + riwayat.get(0).getNama());
        salam.setBounds(950,10,400,50);
        salam.setFont(font.small);
        salam.setForeground(Color.white);
        buttonCek = new JButton("Cek Saldo");
        buttonCek.setBounds(0,100,600,50);
        buttonCek.setFont(font.medium);
        buttonCek.addActionListener(this);
        buttonHistory = new JButton("Riwayat");
        buttonHistory.setBounds(600,100,600,50);
        buttonHistory.setFont(font.medium);
        buttonHistory.addActionListener(this);
        frameOVO.add(buttonCek);frameOVO.add(buttonHistory);frameOVO.add(salam);

        //button buttonCek saldo
        lsaldo = new JLabel("Jumlah saldo :");
        saldo = new JLabel("Rp." + riwayat.get(0).getSaldo() + ",00");
        buttonTopUp = new JButton("Top Up");
        lsaldo.setBounds(300,150,300,300);
        lsaldo.setFont(font.medium);
        lsaldo.setForeground(Color.white);
        saldo.setBounds(700,150,300,300);
        saldo.setFont(font.medium);
        saldo.setForeground(Color.white);
        buttonTopUp.setBounds(400,450,400,100);
        buttonTopUp.setFont(font.large);
        buttonTopUp.setForeground(Color.black);
        buttonTopUp.addActionListener(this);
        lsaldo.setVisible(false);
        saldo.setVisible(false);
        buttonTopUp.setVisible(false);
        frameOVO.add(lsaldo);frameOVO.add(saldo);frameOVO.add(buttonTopUp);

        //button buttonTopUp
        lcomboNominal = new JLabel("Jumlah Nominal : ");
        lcomboNominal.setBounds(50,50,300,20);
        lcomboNominal.setFont(font.small);
        lcomboNominal.setForeground(Color.white);
        Integer[] arrayNominal = {50000,100000,200000,500000,1000000,1500000,2000000};
        comboNominal = new JComboBox(arrayNominal);
        comboNominal.setBounds(320,45,100,30);
        lcomboMetode = new JLabel("Metode Pembayaran : ");
        lcomboMetode.setBounds(50,150,300,20);
        lcomboMetode.setFont(font.small);
        lcomboMetode.setForeground(Color.white);
        String[] arrayMetode = {"Transfer","Cash"};
        comboMetode = new JComboBox(arrayMetode);
        comboMetode.setBounds(320,145,100,30);
        buttonKonfirmasi = new JButton("Konfirmasi");
        buttonKonfirmasi.setBounds(200,250,100,50);
        buttonKonfirmasi.addActionListener(this);
        frameTopUp.add(lcomboNominal);frameTopUp.add(comboNominal);frameTopUp.add(lcomboMetode);frameTopUp.add(comboMetode);frameTopUp.add(buttonKonfirmasi);

        //lihat riwayatTopUp
        jt = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] namaKolom = new Object[3];
        namaKolom[0] = "Nominal Topup";
        namaKolom[1] = "Metode";
        namaKolom[2] = "Tanggal";
        model.setColumnIdentifiers(namaKolom);
        Object[] dataKolom = new Object[3];
        for (int i = 0; i < topups.size(); i++) {
           dataKolom[0] = topups.get(i).getNominal();
           dataKolom[1] = topups.get(i).getMetode();
           dataKolom[2] = topups.get(i).getDate();
           model.addRow(dataKolom);
        }
        jt.setModel(model);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        sp = new JScrollPane(jt);
        sp.setVisible(false);
        frameOVO.add(sp);

        //lihat data member
        table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        Object[] kolomNama = new Object[4];
        kolomNama[0] = "ID";
        kolomNama[1] = "Nama";
        kolomNama[2] = "Pass";
        kolomNama[3] = "Saldo";
        tableModel.setColumnIdentifiers(kolomNama);
        Object[] kolomData = new Object[4];
        for (int i = 0; i < members.size(); i++) {
           kolomData[0] = members.get(i).getID();
           kolomData[1] = members.get(i).getNama();
           kolomData[2] = members.get(i).getPass();
           kolomData[3] = members.get(i).getSaldo();
           tableModel.addRow(kolomData);
        }
        table.setModel(tableModel);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        scroll = new JScrollPane(table);
        scroll.setVisible(true);
        frameMember.add(scroll);
        
        
        frameOVO.setSize(1200, 800);
        frameOVO.setVisible(true);
        frameOVO.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
        frameOVO.setResizable(false);
        frameOVO.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frameTopUp.getContentPane().setLayout(null);
        frameTopUp.setSize(500, 400);
        frameTopUp.setVisible(false);
        frameTopUp.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
        
        frameMember.setSize(1000, 700);
        frameMember.setVisible(true);
    }
     public static void main(String[] args) {
        new View();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Cek Saldo")){
            lsaldo.setVisible(true);
            saldo.setVisible(true);
            buttonTopUp.setVisible(true);
            sp.setVisible(false);
            jt.setVisible(false);
        }else if(e.getActionCommand().equals("Top Up")){
            frameTopUp.setVisible(true);
        }else if(e.getActionCommand().equals("Konfirmasi")){
            int jmlNominal =(Integer) this.comboNominal.getSelectedItem();
            String comboMetodeOVO = (String) this.comboMetode.getSelectedItem();
            System.out.println(Controller.konfirmasi(riwayat, jmlNominal, comboMetodeOVO));
        }else if(e.getActionCommand().equals("Riwayat")){
            System.out.println("aaaa");
            sp.setVisible(true);
            lsaldo.setVisible(false);
            saldo.setVisible(false);
            buttonTopUp.setVisible(false);
            buttonHistory.setVisible(false);
            buttonCek.setVisible(false);
            logo.setVisible(false);
            salam.setVisible(false);
        }else if(e.getActionCommand().equals("Back")){
            logo.setVisible(true);
            salam.setVisible(true);
            buttonHistory.setVisible(true);
            buttonCek.setVisible(true);
            buttonTopUp.setVisible(false);
            sp.setVisible(false);
            jt.setVisible(false);
            lsaldo.setVisible(false);
            saldo.setVisible(false);
        }else{
            System.out.println("error");
        }
    }
}
