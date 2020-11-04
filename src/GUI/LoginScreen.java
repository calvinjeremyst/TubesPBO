/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import GUI.tools.fontStyle;
import Model.User;
import Model.enumUser;
import Controller.Controller;
import Model.Member;
/**
 *
 * @author lenovo
 */
public class LoginScreen implements ActionListener{
    
    JFrame Loginframe = new JFrame("Login");
    JLabel title = new JLabel("Login");
    JLabel username = new JLabel("Username : ");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password : ");
    JPasswordField passwordField = new JPasswordField();
    JButton submit = new JButton("Submit");
    Member mem = new Member();
    public LoginScreen(){
        
        Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loginframe.setSize(2000,2000);
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
        Loginframe.setLayout(null);
        Loginframe.setVisible(true);
        
        
        
    }
    
   
    
    @Override
public void actionPerformed(ActionEvent e){
    String usernameLogin = usernameField.getText();
    String passwordLogin = new String(passwordField.getPassword()); 
    if(e.getActionCommand().equals("Submit")){
        mem = Controller.loginMember(usernameLogin, passwordLogin);
        JOptionPane.showMessageDialog(null, "Welcom : " + mem.getUsername());
        new MenuUtamaScreen(mem);

        }
        else{
            JOptionPane.showMessageDialog(null,"Login Gagal");
        }
    }
   


    public static void main(String[] args) {
        new LoginScreen();
    }

}
