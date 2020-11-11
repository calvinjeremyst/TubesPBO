/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.tools.fontStyle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lenovo
 */
public class ScreenHistory implements ActionListener {
    
    JFrame frameHistory = new JFrame("History Pemesanan : ");
    JLabel title = new JLabel("History Pemesanan");
    JLabel IDMember = new JLabel("ID Member : ");
    JTextField IDMemberText = new JTextField();
    JButton buttonSearch = new JButton("Search");
    
    
    public ScreenHistory(){
        
        frameHistory.setSize(2000,2000);
        title.setBounds(500,200,300,100);
        title.setFont(fontStyle.medium);
        IDMember.setBounds(450,300,200,120);
        IDMemberText.setBounds(600,340,300,30);
        IDMember.setFont(fontStyle.small);
        buttonSearch.setBounds(630,400,120,20);
        buttonSearch.setFont(fontStyle.small);
       
       frameHistory.add(title);
       frameHistory.add(IDMember);
       frameHistory.add(IDMemberText);
       frameHistory.add(buttonSearch);
        frameHistory.setLayout(null);
        frameHistory.setVisible(true);
        
    }
    
       
    @Override
public void actionPerformed(ActionEvent e){
   
   
    
        
    }
    
    public static void main(String[] args) {
        new ScreenHistory();
    }
}
