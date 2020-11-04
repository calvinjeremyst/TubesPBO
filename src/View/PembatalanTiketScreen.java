/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.*;

/**
 *
 * @author user
 */
public class PembatalanTiketScreen implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton cancel,back;
    JLabel judul,LidOrder;
    JTextField idOrder;
    
    public PembatalanTiketScreen() {
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        judul = new JLabel("Pembatalan Tiket Bis");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(500, 20, 500, 100);
            
        LidOrder = new JLabel("ID Order : ");
        LidOrder.setFont(new Font("Consolas", Font.PLAIN, 20));
        LidOrder.setBounds(20, 210, 250, 50);
        idOrder = new JTextField();
        idOrder.setFont(new Font("Consolas", Font.PLAIN, 20));
        idOrder.setBounds(140, 220, 250, 30);
        
        cancel = new JButton("Cancel Ticket");
        cancel.setBounds(400, 360, 250, 30);
        cancel.setEnabled(true);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        back = new JButton("BACK");
        back.setBounds(700, 360, 250, 30);
        back.setEnabled(true);
        back.addActionListener(this);
        back.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(LidOrder);
        frame.add(idOrder);
        frame.add(cancel);
        frame.add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = this.idOrder.getText();
        int idAngka = Integer.parseInt(id);
        if(e.getActionCommand().equals("Cancel Ticket")){
            if(Controller.deleteTiket(idAngka)){
                JOptionPane.showMessageDialog(null,"Tiket Berhasil Dibatalkan!");
                new MenuUtamaMember();
            }else{
                JOptionPane.showMessageDialog(null,"ID Order Tidak Ditemukan!");
            }
        }else if(e.getActionCommand().equals("BACK")){
            new MenuUtamaMember();
        }
    }
    
}
