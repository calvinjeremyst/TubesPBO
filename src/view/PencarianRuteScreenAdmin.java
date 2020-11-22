/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author lenovo
 */
import model.DetailRute;
import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class PencarianRuteScreenAdmin implements ActionListener {
    
    JLabel judul,LdatePicker,LkotaAsal,LkotaTujuan;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton next,back;
    JTextField kotaAsal,kotaTujuan;
    
    public PencarianRuteScreenAdmin() {
        
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        judul = new JLabel("Pencarian Rute Admin");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
        
        LkotaAsal = new JLabel("Kota Asal : ");
        LkotaAsal.setFont(new Font("Consolas", Font.PLAIN, 20));
        LkotaAsal.setBounds(20, 160, 250, 50);
        kotaAsal = new JTextField();
        kotaAsal.setFont(new Font("Consolas", Font.PLAIN, 20));
        kotaAsal.setBounds(270, 170, 150, 30);
        
        LkotaTujuan = new JLabel("Kota Tujuan : ");
        LkotaTujuan.setFont(new Font("Consolas", Font.PLAIN, 20));
        LkotaTujuan.setBounds(20, 210, 250, 50);
        kotaTujuan = new JTextField();
        kotaTujuan.setFont(new Font("Consolas", Font.PLAIN, 20));
        kotaTujuan.setBounds(270, 220, 150, 30);
        
        next = new JButton("NEXT");
        next.setBounds(400, 360, 250, 30);
        next.setEnabled(true);
        next.addActionListener(this);
        next.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        back = new JButton("BACK");
        back.setBounds(700, 360, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
            
        frame.add(judul);
        frame.add(LkotaAsal);
        frame.add(kotaAsal);
        frame.add(LkotaTujuan);
        frame.add(kotaTujuan);
        frame.add(next);
        frame.add(back);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<DetailRute> dtrute = new ArrayList<>();
        String kotaAsal = this.kotaAsal.getText();
        String kotaTujuan = this.kotaTujuan.getText();
        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(e.getActionCommand().equals("NEXT")){
            if (a == JOptionPane.YES_OPTION) {
                if (kotaAsal.length() == 0 || kotaTujuan.length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
                } 
                else{
                    dtrute = Controller.cariRuteAdmin(kotaAsal,kotaTujuan);
                    new HasilPencarianAdminScreen(dtrute);
                    frame.dispose(); 
                }
            }
        }    
    }
    
}

