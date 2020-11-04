/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Member;
import Controller.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class LihatDataMember {
    JLabel tampilUser;
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton back;
    int x=110;
    
    public LihatDataMember(){
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Member> members = Controller.getAllMember();
        for(Member member : members){
            tampilUser = new JLabel(member.toString());
            tampilUser.setBounds(270,x,500, 50);
            frame.add(tampilUser);
            x += 40;
        }
        
        
    }
    
}
