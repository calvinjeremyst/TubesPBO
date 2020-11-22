/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class MenuUtamaScreen implements ActionListener {
    JFrame frame = new JFrame("Terminal Bis Emen");
    JButton login, register;
    JLabel judul,gambar;
    
    public MenuUtamaScreen() {
        
        Image logo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo-bis.png"));
    
        gambar = new JLabel(new ImageIcon(logo));
        gambar.setBounds(285, 300, 800, 300);
        
        judul = new JLabel("Login/Register");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(550, 70, 500, 100);
        
        login = new JButton("LOGIN");
        login.setBounds(575, 170, 200, 30);
        login.setEnabled(true);
        login.addActionListener(this);
        login.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        register = new JButton("REGISTER");
        register.setBounds(550, 230, 250, 30);
        register.setEnabled(true);
        register.addActionListener(this);
        register.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(gambar);
        frame.getContentPane().add(login);
        frame.getContentPane().add(register);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("LOGIN")){
            new LoginScreen(); 
            frame.dispose();
        }else if(e.getActionCommand().equals("REGISTER")){
            new RegisterScreen();
            frame.dispose();
        }
    }
    
}
