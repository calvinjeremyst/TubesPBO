/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
/**
 *
 * @author Christian
 */
public class OVO implements ActionListener{
    User user = new User();
    User[] usr = new User[10];
    JFrame frame,frame1;
    JLabel logo,lsaldo,saldo,salam,lnominal,lmetode;
    JButton cek,topup,history,konfirmasi;
    JPanel panel;
    JPanel p1,p2,p3;
    JTabbedPane tab;
    JTable jt;
    JScrollPane sp;
    JComboBox nominal,metode;
    int jmlNom;
    String metodeOVO;
    RiwayatTopup riwayatTopUp;
    public OVO(){
        
        frame = new JFrame("OVO");
        frame1 = new JFrame("Top Up OVO");
        usr[0] = new User("U01","satya","123",50000);

        //logo
        logo = new JLabel("OVO");
        logo.setBounds(0,0,300,50);
        logo.setFont(font.logo);
        logo.setForeground(Color.white);
        frame.add(logo);
        
        //salam nama
        salam = new JLabel("Hi, " + user.getNama());
        salam.setBounds(950,10,400,50);
        salam.setFont(font.small);
        salam.setForeground(Color.white);
        cek = new JButton("Cek Saldo");
        cek.setBounds(0,100,600,50);
        cek.setFont(font.medium);
        cek.addActionListener(this);
        history = new JButton("Riwayat");
        history.setBounds(600,100,600,50);
        history.setFont(font.medium);
        history.addActionListener(this);
        frame.add(cek);frame.add(history);frame.add(salam);
        
        //cek saldo
        lsaldo = new JLabel("Jumlah saldo :");
        saldo = new JLabel("Rp." + user.getSaldo() + ",00");
        topup = new JButton("Top Up");
        lsaldo.setBounds(300,150,300,300);
        lsaldo.setFont(font.medium);
        lsaldo.setForeground(Color.white);
        saldo.setBounds(700,150,300,300);
        saldo.setFont(font.medium);
        saldo.setForeground(Color.white);
        topup.setBounds(400,450,400,100);
        topup.setFont(font.large);
        topup.setForeground(Color.black);
        topup.addActionListener(this);
        lsaldo.setVisible(false);
        saldo.setVisible(false);
        topup.setVisible(false);
        frame.add(lsaldo);frame.add(saldo);frame.add(topup);
        
        //topup
        lnominal = new JLabel("Jumlah Nominal : ");
        lnominal.setBounds(50,50,300,20);
        lnominal.setFont(font.small);
        lnominal.setForeground(Color.white);
        String[] arrayNominal = {"50000","100000","200000","500000","1000000","1500000","2000000"};
        nominal = new JComboBox(arrayNominal);
        nominal.setBounds(320,45,100,30);
        lmetode = new JLabel("Metode Pembayaran : ");
        lmetode.setBounds(50,150,300,20);
        lmetode.setFont(font.small);
        lmetode.setForeground(Color.white);
        String[] arrayMetode = {"Transfer","Cash"};
        metode = new JComboBox(arrayMetode);
        metode.setBounds(320,145,100,30);
        konfirmasi = new JButton("Konfirmsai");
        konfirmasi.setBounds(200,250,100,50);
        
        frame1.add(lnominal);frame1.add(nominal);frame1.add(lmetode);frame1.add(metode);frame1.add(konfirmasi);
        
        frame1.getContentPane().setLayout(null);
        frame1.setSize(500, 400);
        frame1.setVisible(false);
        frame1.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
        
        
        String data[][]={ {"10000","1000","670000"}, {"12321","123123","780000"}, {"12323","123123","700000"}};    
        String column[]={"Topup","Penarikan","Tanggal"};  
        jt=new JTable(data,column);
        jt.setBounds(0,150,1200,650);
        jt.setFont(font.small);
        sp = new JScrollPane(jt);
        sp.setVisible(false);
        jt.setVisible(false);
        frame.add(jt);frame.add(sp);          
        
        frame.getContentPane().setLayout(null);
        frame.setSize(1200, 800);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new OVO();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Cek Saldo")){
            lsaldo.setVisible(true);
            saldo.setVisible(true);
            topup.setVisible(true);
            sp.setVisible(false);
            jt.setVisible(false);
        }else if(e.getActionCommand().equals("Top Up")){
            frame1.setVisible(true);
        }else if(e.getActionCommand().equals("Konfirmasi")){
            String ID = JOptionPane.showInputDialog("Masukan ID anda : ");
            String pass = JOptionPane.showInputDialog("Masukan password anda : ");
            for (int i = 0; i < usr.length; i++) {
                if(ID.equals(user.getID())){
                    if (pass.equals(user.getPw())){
                        int confirm = JOptionPane.showConfirmDialog(null,"Apakah anda sudah yakin ?");
                        if(confirm==JOptionPane.YES_OPTION){
                            jmlNom = (Integer) this.nominal.getSelectedItem();
                            metodeOVO = (String) this.nominal.getSelectedItem();
                            Date date = new Date();
                            SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
                            String tanggal = (String) SDF.format(date);
                            
                            riwayatTopUp= new RiwayatTopup(jmlNom,metodeOVO,tanggal);
                            JOptionPane.showMessageDialog(null,"Selamat Pembayaran Anda Berhasil !");
                        }else{
                            JOptionPane.showMessageDialog(null,"Mohon Maaf Pembayaran Anda Tidak Dapat Diproses !");
                        }  
                    }
                }
            }
            System.out.println("aa");
            
            
        }else{
            sp.setVisible(true);
            jt.setVisible(true);
            lsaldo.setVisible(false);
            saldo.setVisible(false);
            topup.setVisible(false);
        }
    }
}
