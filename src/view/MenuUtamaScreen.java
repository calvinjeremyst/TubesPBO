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
import java.awt.Color;
import java.awt.Font;
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
    JLabel judul;
    
    public MenuUtamaScreen() {    
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Login/Register");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(550, 20, 500, 100);
        
        login = new JButton("LOGIN");
        login.setBounds(400, 450, 250, 30);
        login.setEnabled(true);
        login.addActionListener(this);
        login.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        register = new JButton("REGISTER");
        register.setBounds(700, 450, 250, 30);
        register.setEnabled(true);
        register.addActionListener(this);
        register.setFont(new Font("Consolas", Font.PLAIN, 24));
        
        frame.add(judul);
        frame.add(login);
        frame.add(register);
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
