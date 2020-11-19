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
import model.Member;
import model.UserManager;
import view.Helper.FontStyle2;

/**
 *
 * @author user
 */
public class CekSaldo implements ActionListener {
    JFrame frameOVO = new JFrame("Terminal Bis Emen");
    JLabel lsaldo,saldo;
    JButton back;
    Member member = (Member) UserManager.getInstance().getUser();
    
    public CekSaldo() {
        frameOVO.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameOVO.setLocationRelativeTo(null);
        frameOVO.setLayout(null);
        frameOVO.setVisible(true);
        frameOVO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOVO.setBackground(Color.pink);
        
        lsaldo = new JLabel("Jumlah saldo :");
        lsaldo.setBounds(300,150,300,300);
        lsaldo.setFont(FontStyle2.medium);
        lsaldo.setVisible(true);
        
        saldo = new JLabel("Rp. " + member.getOvoBalance());
        saldo.setBounds(700,150,300,300);
        saldo.setFont(FontStyle2.medium);
        saldo.setVisible(true);
        
        back = new JButton("Back To Main Menu");
        back.setBounds(500,500,400,50);
        back.setFont(FontStyle2.medium);
        back.setVisible(true);
        back.addActionListener(this);
        
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
