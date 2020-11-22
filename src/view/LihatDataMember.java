/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Member;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class LihatDataMember implements ActionListener {
    
    JLabel judul;
    JFrame frameMember = new JFrame("Terminal Bis Emen");
    JButton back;
    JTable jt;
    JScrollPane js;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Member> members = Controller.getAllData();
    
    public LihatDataMember() {
        
        frameMember.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameMember.getContentPane().setBackground(Color.WHITE);
        frameMember.setLocationRelativeTo(null);
        frameMember.setLayout(null);
        frameMember.setVisible(true);
        frameMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("List Member");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 600, 100);
        
        jt = new JTable();
        String headers[] = {"ID Member","Nama","Password","Saldo"};
        model.setColumnIdentifiers(headers);
        jt.setModel(model);
        js = new JScrollPane(jt);
        
        insert();
        
        js.setBounds(340,130,700,300);
        js.setVisible(true);
        frameMember.add(js);
       
        back = new JButton("Back");
        back.setBounds(850, 50, 150, 50);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frameMember.add(judul);
        frameMember.add(back);
    }
    
    public void insert() {
        for (int i = 0; i < members.size(); i++) {
            model.addRow(new Object[]{members.get(i).getID_Member(),members.get(i).getUsername(),
                                      members.get(i).getPassword(),members.get(i).getOvoBalance()
                                     });
        }  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Back")){
           new MenuUtamaAdmin();
           frameMember.dispose();
       }
    }
    
}
