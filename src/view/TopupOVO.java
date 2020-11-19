/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.*;
import model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import view.Helper.*;
/**
 *
 * @author Christian
 */
public class TopupOVO implements ActionListener {
    static JFrame frameOVO,frameTopUp,frameMember;
    JLayeredPane layerLogo,layerBack,layerTable;
    JLabel logo,salam,lcomboNominal,lcomboMetode;
    JButton buttonCek,buttonTopUp,buttonHistory,buttonKonfirmasi;
    JPanel panel;
    JPanel p1,p2,p3;
    JTable jt,table;
    JScrollPane sp,scroll;
    JComboBox comboNominal,comboMetode;
    int jmlNom;
    String comboMetodeOVO, id;
    RiwayatTopup riwayatTopUp;
    ArrayList<RiwayatTopup> topups;
   
    
    public TopupOVO() {
        Member mem = (Member) UserManager.getInstance().getUser();
        
        /*
        members = Controller.getAllData();
        for (Member member : members) {
           System.out.println(member.toString());
        }
        id = JOptionPane.showInputDialog("Masukan id : ");
        */
        //riwayat = Controller.getData(id);
        
        topups = Controller.getHistory(mem.getID_Member());
        
        frameOVO = new JFrame("OVO");
        frameTopUp = new JFrame("Top Up OVO");
        //frameMember = new JFrame("Lihat data member");
       
        //logo
        logo = new JLabel("OVO");
        logo.setBounds(0,0,300,50);
        logo.setFont(FontStyle.logo);
        logo.setForeground(Color.white);
        layerLogo = new JLayeredPane();
        layerLogo.add(logo);
        layerLogo.setBounds(0,0,300,50);
        
        salam = new JLabel("Hi, " + mem.getUsername());
        salam.setBounds(950,10,400,50);
        salam.setFont(FontStyle.small);
        salam.setForeground(Color.white);
       
        buttonHistory = new JButton("Riwayat");
        buttonHistory.setBounds(600,100,600,50);
        buttonHistory.setFont(FontStyle.medium);
        buttonHistory.addActionListener(this);
        
        buttonTopUp = new JButton("Top Up");
        buttonTopUp.setBounds(400,450,400,100);
        buttonTopUp.setFont(FontStyle.large);
        buttonTopUp.setForeground(Color.black);
        buttonTopUp.addActionListener(this);
       
        //button buttonTopUp
        lcomboNominal = new JLabel("Jumlah Nominal : ");
        lcomboNominal.setBounds(50,50,300,20);
        lcomboNominal.setFont(FontStyle.small);
        lcomboNominal.setForeground(Color.white);
        Integer[] arrayNominal = {50000,100000,200000,500000,1000000,1500000,2000000};
        comboNominal = new JComboBox(arrayNominal);
        comboNominal.setBounds(320,45,100,30);
        lcomboMetode = new JLabel("Metode Pembayaran : ");
        lcomboMetode.setBounds(50,150,300,20);
        lcomboMetode.setFont(FontStyle.small);
        lcomboMetode.setForeground(Color.white);
        String[] arrayMetode = {"Transfer","Cash"};
        comboMetode = new JComboBox(arrayMetode);
        comboMetode.setBounds(320,145,100,30);
        buttonKonfirmasi = new JButton("Konfirmasi");
        buttonKonfirmasi.setBounds(200,250,100,50);
        buttonKonfirmasi.addActionListener(this);

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
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        scroll = new JScrollPane(table);
        scroll.setVisible(true);
        
        frameOVO.add(buttonHistory);
        frameOVO.add(salam);
        frameOVO.add(layerLogo);
        frameOVO.add(buttonTopUp);
        frameOVO.add(sp);
        frameOVO.setSize(1200, 800);
        frameOVO.setVisible(true);
        frameOVO.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
        frameOVO.setResizable(false);
        frameOVO.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frameTopUp.add(lcomboNominal);
        frameTopUp.add(comboNominal);
        frameTopUp.add(lcomboMetode);
        frameTopUp.add(comboMetode);
        frameTopUp.add(buttonKonfirmasi);
        frameTopUp.getContentPane().setLayout(null);
        frameTopUp.setSize(500, 400);
        frameTopUp.setVisible(false);
        frameTopUp.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
      
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Top Up")){
            frameTopUp.setVisible(true);
        }else if(e.getActionCommand().equals("Konfirmasi")){
            int jmlNominal =(Integer) this.comboNominal.getSelectedItem();
            String comboMetodeOVO = (String) this.comboMetode.getSelectedItem();
            if(Controller.topUp(jmlNominal,comboMetodeOVO)){
                JOptionPane.showMessageDialog(null,"Selamat TopUp Anda Berhasil !");
            }else{
                 JOptionPane.showMessageDialog(null,"Mohon Maaf Pembayaran Anda Tidak Dapat Diproses !");
            }
        }else if(e.getActionCommand().equals("Riwayat")){
            sp.setVisible(true);
            buttonTopUp.setVisible(false);
            buttonHistory.setVisible(false);
            logo.setVisible(false);
            salam.setVisible(false);
        }else if(e.getActionCommand().equals("Back")){
            logo.setVisible(true);
            salam.setVisible(true);
            buttonHistory.setVisible(true);
            buttonTopUp.setVisible(false);
            sp.setVisible(false);
            jt.setVisible(false);
        }
    }
}
