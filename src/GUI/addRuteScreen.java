/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import GUI.tools.fontStyle;
import GUI.tools.DateFormat;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author lenovo
 */
public class addRuteScreen implements ActionListener{
    
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
    
    JButton buttonAdd = new JButton("Add");
    
    public addRuteScreen(){
        
        frameRute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRute.setSize(2000,2000);
        title.setBounds(500,100,400,150);
        title.setFont(fontStyle.medium);
        
        idRute.setBounds(450,200,230,100);
        idRuteText.setBounds(600,240,300,30);
        idRute.setFont(fontStyle.small);
        
        kotaAsal.setBounds(450,250,230,100);
        kotaAsalText.setBounds(600,290,300,30);
        kotaAsal.setFont(fontStyle.small);
        
        kotaTujuan.setBounds(450,300,230,100);
        kotaTujuanText.setBounds(600,340,300,30);
        kotaTujuan.setFont(fontStyle.small);
        
        tanggalBerangkat.setBounds(450,350,200,100);
        tanggalBerangkat.setFont(fontStyle.small);
        
        model = new UtilDateModel();
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateFormat());
        datePicker.setBounds(600, 390, 50, 20);
        datePicker.setFont(fontStyle.small);
        datePicker.setBackground(new Color(200, 200, 100));
        
        jam.setBounds(450,420,200,50);
        jamText.setBounds(650,430,90,40);
        jam.setFont(fontStyle.small);
        
        kelasBis.setBounds(450,490,200,50);
        kelasBisText.setBounds(600,500,300,30);
        kelasBis.setFont(fontStyle.small);
        
        hargaRute.setBounds(450,540,200,50);
        hargaRuteText.setBounds(600,550,300,30);
        hargaRute.setFont(fontStyle.small);
        
        hargaBis.setBounds(450,590,200,50);
        hargaBisText.setBounds(600,600,300,30);
        hargaBis.setFont(fontStyle.small);
        
        buttonAdd.setBounds(650,650,100,30);
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
        frameRute.add(buttonAdd);
        frameRute.setLayout(null);
        frameRute.setVisible(true);
    }
    
   
    
    @Override
public void actionPerformed(ActionEvent e){
   
   
 

}

 public static void main(String[] args) {
        new addRuteScreen();
    }
}
