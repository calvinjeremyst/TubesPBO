/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import view.Helper.fontStyle;
import controller.Controller;
import java.awt.Color;
import model.Member;
import model.User;
/**
 *
 * @author lenovo
 */
public class LoginScreen implements ActionListener {
    JFrame Loginframe = new JFrame("Login");
    JLabel title = new JLabel("Login");
    JLabel username = new JLabel("Username : ");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password : ");
    JPasswordField passwordField = new JPasswordField();
    JButton submit = new JButton("Submit");
    User usr;
    
    public LoginScreen() {
        Loginframe.getContentPane().setBackground(Color.WHITE);
        Loginframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Loginframe.setLocationRelativeTo(null);
        Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loginframe.setLayout(null);
        Loginframe.setVisible(true);
        
        title.setBounds(600,150,300,150);
        title.setFont(fontStyle.medium);
        username.setBounds(500,300,150,50);
        usernameField.setBounds(650,310,200,30);
        username.setFont(fontStyle.small);
        
        password.setBounds(500,360,150,50);
        passwordField.setBounds(650,370,200,30);
        password.setFont(fontStyle.small);
        
        submit.setBounds(600,420,150,50);
        submit.setFont(fontStyle.small);
        submit.addActionListener(this);
      
        Loginframe.add(title);
        Loginframe.add(username);
        Loginframe.add(usernameField);
        Loginframe.add(password);
        Loginframe.add(passwordField);
        Loginframe.add(submit);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String usernameLogin = usernameField.getText();
        String passwordLogin = new String(passwordField.getPassword()); 
        if(e.getActionCommand().equals("Submit")){
            if(usernameLogin.equals("Calvin")){
                usr = Controller.login(usernameLogin, passwordLogin);
                if(usr != null){
                    JOptionPane.showMessageDialog(null, "Welcome Admin : " + usr.getUsername());
                    new MenuUtamaAdmin();
                    Loginframe.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Username/Password Salah!");
                }
            }else{
                usr = Controller.login(usernameLogin, passwordLogin);
                if(usr != null){
                    JOptionPane.showMessageDialog(null, "Welcome Member : " + usr.getUsername());
                    new MenuUtamaMember(usr);
                    Loginframe.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Username/Password Salah!");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Login Gagal");
        }
    }
}
