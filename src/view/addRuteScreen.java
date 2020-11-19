/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Helper.fontStyle;
import view.Helper.DateFormat;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import model.DetailRute;
import model.listBis;

/**
 *
 * @author lenovo
 */
public class addRuteScreen implements ActionListener {
    JFrame frameRute = new JFrame("Menambahkan List perjalanan");
    JLabel title = new JLabel("Menambahkan Rute");
    JLabel idRute = new JLabel("ID Rute : ");
    JTextField idRuteText = new JTextField();
    
    JLabel kotaAsal = new JLabel("Kota Asal : ");
    JTextField kotaAsalText = new JTextField();
    
    JLabel kotaTujuan = new JLabel("Kota Tujuan : ");
    JTextField kotaTujuanText = new JTextField();
    
    JLabel jam = new JLabel("Jam Berangkat : ");
    JTextField jamText = new JTextField();
    
    JLabel idBis = new JLabel("ID Bis : ");
    JTextField idBisText = new JTextField();
    
    JLabel tanggalBerangkat = new JLabel("Tanggal : ");
    JDatePickerImpl datePicker;
    UtilDateModel model;
    Properties p;
    JDatePanelImpl datePanel;
    
    JLabel kelasBis = new JLabel("Kelas Bis : ");
    JTextField kelasBisText = new JTextField();
    
    JLabel hargaBis = new JLabel("Harga Bis : ");
    JTextField hargaBisText = new JTextField();
    
    JLabel hargaRute = new JLabel("Harga Rute : ");
    JTextField hargaRuteText = new JTextField();
    
    JLabel jumlahKapasitas = new JLabel("Jumlah Kapasitas");
    JTextField isiJumlahKapasitas = new JTextField();
    
    JButton buttonAdd = new JButton("Add");
    
    public addRuteScreen() {    
        frameRute.getContentPane().setBackground(Color.WHITE);
        frameRute.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameRute.setLocationRelativeTo(null);
        frameRute.setLayout(null);
        frameRute.setVisible(true);
        frameRute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title.setBounds(500,1,400,150);
        title.setFont(fontStyle.medium);
        
        idRute.setBounds(450,70,230,100);
        idRuteText.setBounds(600,110,300,30);
        idRute.setFont(fontStyle.small);
        
        kotaAsal.setBounds(450,110,230,100);
        kotaAsalText.setBounds(600,150,300,30);
        kotaAsal.setFont(fontStyle.small);
        
        kotaTujuan.setBounds(450,150,230,100);
        kotaTujuanText.setBounds(600,190,300,30);
        kotaTujuan.setFont(fontStyle.small);
        
        tanggalBerangkat.setBounds(450,200,200,100);
        tanggalBerangkat.setFont(fontStyle.small);
        
        model = new UtilDateModel();
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateFormat());
        datePicker.setBounds(600, 240, 50, 20);
        datePicker.setFont(fontStyle.small);
        datePicker.setBackground(new Color(200, 200, 100));
        
        jam.setBounds(450,270,200,50);
        jamText.setBounds(620,270,90,40);
        jam.setFont(fontStyle.small);
        
        kelasBis.setBounds(450,320,200,50);
        kelasBisText.setBounds(600,330,300,30);
        kelasBis.setFont(fontStyle.small);
        
        hargaRute.setBounds(450,370,200,50);
        hargaRuteText.setBounds(600,380,300,30);
        hargaRute.setFont(fontStyle.small);
        
        hargaBis.setBounds(450,420,200,50);
        hargaBisText.setBounds(600,430,300,30);
        hargaBis.setFont(fontStyle.small);
        
        idBis.setBounds(450,470,200,50);
        idBisText.setBounds(600,480,300,30);
        idBis.setFont(fontStyle.small);
        
        jumlahKapasitas.setBounds(450,520,200,50);
        jumlahKapasitas.setFont(fontStyle.small);
        isiJumlahKapasitas.setBounds(650,530,300,30);
        
        buttonAdd.setBounds(580,600,100,30);
        buttonAdd.addActionListener(this);
        buttonAdd.setFont(fontStyle.small);
        
        frameRute.add(title);
        frameRute.add(idRute);
        frameRute.add(idRuteText);
        frameRute.add(kotaAsal);
        frameRute.add(kotaAsalText);
        frameRute.add(kotaTujuan);
        frameRute.add(kotaTujuanText);
        frameRute.add(tanggalBerangkat);
        frameRute.add(datePicker);
        frameRute.add(jam);
        frameRute.add(jamText);
        frameRute.add(kelasBis);
        frameRute.add(kelasBisText);
        frameRute.add(hargaRute);
        frameRute.add(hargaRuteText);
        frameRute.add(hargaBis);
        frameRute.add(hargaBisText);
        frameRute.add(idBis);
        frameRute.add(idBisText);
        frameRute.add(jumlahKapasitas);
        frameRute.add(isiJumlahKapasitas);
        frameRute.add(buttonAdd);
        frameRute.setLayout(null);
        frameRute.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String ID_Rute = idRuteText.getText();
        String kotaAsal = kotaAsalText.getText();
        Date tgl = null;
        try{
            tgl = new SimpleDateFormat("yyyy-MM-dd").parse(this.datePicker.getJFormattedTextField().getText());
        }catch(ParseException ex){
            Logger.getLogger(addRuteScreen.class.getName()).log(Level.SEVERE,null,ex);
        }
        String jam = this.jamText.getText();
        String kelasBis = this.kelasBisText.getText();
        double hargaBis = Double.parseDouble(this.hargaBisText.getText());
        double hargaRute = Double.parseDouble(this.hargaRuteText.getText());
        String ID_Bis = this.idBisText.getText();
        int jumlahMuatan = Integer.parseInt(this.isiJumlahKapasitas.getText());
        String kotaTujuan = kotaTujuanText.getText();

        int Choose = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", 
             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(Choose == JOptionPane.YES_OPTION){
            if(ID_Rute.length() == 0 || kotaAsal.length() == 0 || kotaTujuan.length() == 0 || tgl == null
                || jam.length() == 0 || kelasBis.length() == 0 || ID_Bis.length() == 0 || hargaRute == 0 || hargaBis == 0){
                JOptionPane.showMessageDialog(null, "Input all the data ", "Alert", JOptionPane.WARNING_MESSAGE);
            }else{
                DetailRute Detailrute = new DetailRute();
                listBis list = new listBis();
                list.setIDbis(ID_Bis);
                list.setKelasBis(kelasBis);
                list.setJumlahKapasitas(jumlahMuatan);

                Detailrute.setIdRute(ID_Rute);
                Detailrute.setIdbis(ID_Bis);
                Detailrute.setKotaAsal(kotaAsal);
                Detailrute.setKotaTujuan(kotaTujuan);

                Detailrute.setHargaBis(hargaBis);
                Detailrute.setHargaRute(hargaRute);
                Detailrute.setJamBerangkat(jam);
                Detailrute.setTanggalBerangkat(tgl);

                if(Controller.insertPerjalanan(Detailrute, list)){
                    JOptionPane.showMessageDialog(null, "Rute berhasil ditambahkan !");
                    frameRute.dispose();   
                }else{   
                    JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        } 
    }
}
