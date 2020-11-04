/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.DetailRute;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author lenovo
 */
public class HasilPencarianScreen implements ActionListener{
    JLabel judul;
    JFrame framehasilCari = new JFrame("Terminal Bis Emen");
    JLabel[] hasilPerjalanan = new JLabel[5];
    JButton pesan;
    JButton back;
    int x = 150;
    
    
    public HasilPencarianScreen(ArrayList<DetailRute>detail){
        framehasilCari.setExtendedState(JFrame.MAXIMIZED_BOTH);
        framehasilCari.getContentPane().setBackground(Color.WHITE);
        framehasilCari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framehasilCari.setLocationRelativeTo(null);
        framehasilCari.setVisible(true);
        framehasilCari.setLayout(null);
        
        judul = new JLabel("Judul");
        judul.setBounds(30,50,50,30);
        
       
            for(int j = 0 ; j < detail.size();j++){
            detail.set(j,detail.get(j)).getKotaAsal();
            detail.set(j,detail.get(j)).getKotaTujuan();
            detail = Controller.Controller.cariDetailRute(detail.get(j).getKotaAsal(),detail.get(j).getKotaTujuan());
            hasilPerjalanan[j] =  new JLabel(detail.get(j).toString());
            hasilPerjalanan[j].setBounds(200,x,1000,50);
            framehasilCari.add(hasilPerjalanan[j]);
                x+=40; 
            }
        
        pesan = new JButton("Pesan");
        pesan.setBounds(300,500,100,30);
        pesan.setEnabled(true);
        pesan.addActionListener(this);
        //back.setBounds(200,120,250,30);
        back = new JButton("Back");
        back.setEnabled(true);
        back.addActionListener(this);
        
        framehasilCari.add(judul);
        framehasilCari.add(back);
        framehasilCari.add(pesan);
        
    }
   
   
    
   @Override
    public void actionPerformed(ActionEvent e){
    
       
        
        
    
    }
    
    
    
}
