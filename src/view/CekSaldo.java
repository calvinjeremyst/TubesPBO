/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.*;
import view.Helper.FontStyle;

/**
 *
 * @author user
 */
public class CekSaldo implements ActionListener {
    
    JFrame frameOVO = new JFrame("Terminal Bis Emen");
    JLabel judul,lsaldo,saldo;
    JButton back;
    Member member = (Member) UserManager.getInstance().getUser();
    
    public CekSaldo() {
        
        frameOVO.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameOVO.setLocationRelativeTo(null);
        frameOVO.setLayout(null);
        frameOVO.setVisible(true);
        frameOVO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOVO.getContentPane().setBackground(new java.awt.Color(76, 52, 148));
        
        judul = new JLabel("OVO");
        judul.setFont(FontStyle.large);
        judul.setBounds(600, 20, 500, 100);
        judul.setForeground(Color.white);
        
        lsaldo = new JLabel("Jumlah saldo " + UserManager.getInstance().getUser().getUsername() + " : ");
        lsaldo.setBounds(400,150,300,300);
        lsaldo.setFont(FontStyle.medium);
        lsaldo.setForeground(Color.white);
        lsaldo.setVisible(true);
        
        saldo = new JLabel("Rp. " + member.getOvoBalance());
        saldo.setBounds(700,150,300,300);
        saldo.setFont(FontStyle.medium);
        saldo.setForeground(Color.white);
        saldo.setVisible(true);
        
        back = new JButton("Back To Main Menu");
        back.setBounds(450,500,400,50);
        back.setFont(FontStyle.small);
        back.setVisible(true);
        back.addActionListener(this);
        
        frameOVO.add(judul);
        frameOVO.add(lsaldo);
        frameOVO.add(saldo);
        frameOVO.add(back);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Back To Main Menu")){
            new MenuUtamaMember();
            frameOVO.dispose();
        }
    }
}
