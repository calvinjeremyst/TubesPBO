/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import model.Member;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class LihatDataMember {
    JLabel tampilUser;
    JFrame frameMember = new JFrame("Terminal Bis Emen");
    JButton back;
    JTable table;
    JScrollPane scroll;
    int x=110;
    JPanel panel;
    
    public LihatDataMember() {
        frameMember.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameMember.getContentPane().setBackground(Color.WHITE);
        frameMember.setLocationRelativeTo(null);
        frameMember.setLayout(null);
        frameMember.setVisible(true);
        frameMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Member> members = Controller.getAllData();
        table = new JTable();
        table.setBounds(0,0,1000,1000);
        DefaultTableModel tableModel = new DefaultTableModel();
        Object[] kolomNama = new Object[4];
        kolomNama[0] = "ID";
        kolomNama[1] = "Nama";
        kolomNama[2] = "Pass";
        kolomNama[3] = "Saldo";
        tableModel.setColumnIdentifiers(kolomNama);
        Object[] kolomData = new Object[4];
        for (int i = 0; i < members.size(); i++) {
           kolomData[0] = members.get(i).getID_Member();
           kolomData[1] = members.get(i).getUsername();
           kolomData[2] = members.get(i).getPassword();
           kolomData[3] = members.get(i).getOvoBalance();
           tableModel.addRow(kolomData);
        }
        table.setModel(tableModel);
        panel.setLayout(new BorderLayout());
        scroll = new JScrollPane(table);
        scroll.setVisible(true);
        table.add(panel);
        
        frameMember.add(table);
        frameMember.add(scroll);
    }
    
}
