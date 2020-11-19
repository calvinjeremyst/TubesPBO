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
import view.Helper.FontStyle2;
import controller.Controller;
import java.awt.Color;
import model.UserManager;
/**
 *
 * @author lenovo
 */
public class LoginScreen implements ActionListener {
    
    JFrame Loginframe = new JFrame("Terminal Bis Emen");
    JLabel title = new JLabel("     Login");
    JLabel username = new JLabel("Username : ");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password : ");
    JPasswordField passwordField = new JPasswordField();
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back To Main Screen");
   
    public LoginScreen() {
        Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loginframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        title.setBounds(575,200,200,50);
        title.setFont(FontStyle2.medium);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.white);
        title.setOpaque(true);
        username.setBounds(500,300,150,50);
        usernameField.setBounds(650,310,200,30);
        username.setFont(FontStyle2.small);
        
        password.setBounds(500,360,150,50);
        passwordField.setBounds(650,370,200,30);
        password.setFont(FontStyle2.small);
        
        submit.setBounds(400,470,250,50);
        submit.setFont(FontStyle2.small);
        submit.addActionListener(this);
        
        back.setBounds(680,470,250,50);
        back.setFont(FontStyle2.small);
        back.addActionListener(this);
      
        Loginframe.add(title);
        Loginframe.add(username);
        Loginframe.add(usernameField);
        Loginframe.add(password);
        Loginframe.add(passwordField);
        Loginframe.add(submit);
        Loginframe.add(back);
        Loginframe.setLayout(null);
        Loginframe.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameLogin = usernameField.getText();
        String passwordLogin = new String(passwordField.getPassword()); 
        
        if (e.getActionCommand().equals("Submit")) {
            if (usernameLogin.equals("") && passwordLogin.equals("")) {
                JOptionPane.showMessageDialog(null, "Insert username and password!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else if (usernameLogin.equals("")) {
                JOptionPane.showMessageDialog(null, "Insert username!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else if (passwordLogin.equals("")) {
                JOptionPane.showMessageDialog(null, "Insert password!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else if(Controller.cekPass(usernameLogin,passwordLogin)){
                UserManager.getInstance().setUser(Controller.getUser(usernameLogin,passwordLogin));
                if (UserManager.getInstance().getUser().getTipeUser() == 0) {
                    JOptionPane.showMessageDialog(null, "Welcome Admin : " + UserManager.getInstance().getUser().getUsername());
                    Loginframe.dispose();
                    new MenuUtamaAdmin();
                } else if (UserManager.getInstance().getUser().getTipeUser() == 1) {
                    JOptionPane.showMessageDialog(null, "Welcome Member : " + UserManager.getInstance().getUser().getUsername(),"Login Info",JOptionPane.INFORMATION_MESSAGE);
                    Loginframe.dispose();
                    new MenuUtamaMember();
                } else {
                    Loginframe.dispose();
                    new MenuUtamaScreen();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username/Password Salah!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getActionCommand().equals("Back To Main Screen")) {
            new MenuUtamaScreen();
            Loginframe.dispose();
        }
    }
}
