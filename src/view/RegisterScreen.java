/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import view.Helper.FontStyle;
import model.Member;

/**
 *
 * @author lenovo
 */
public class RegisterScreen implements ActionListener {
    
    JFrame Regisframe = new JFrame("Terminal Bis Emen");
    JLabel title = new JLabel("Registrasi Member");
    JLabel username = new JLabel("Username : ");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password : ");
    JPasswordField passwordField = new JPasswordField();
    JLabel repassword = new JLabel("Retype Password : ");
    JPasswordField repassField = new JPasswordField();
    JLabel umur = new JLabel("Umur : ");
    JTextField umurField = new JTextField();
    JLabel alamat = new JLabel("Alamat : ");
    JTextField alamatField = new JTextField();
    JLabel KTP = new JLabel("No.KTP : ");
    JTextField KTPfield = new JTextField();
    JLabel noHP = new JLabel("No.HP : ");
    JTextField noHPfield = new JTextField();
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back To Main Screen");
    
    public RegisterScreen() {
        
        Regisframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Regisframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        title.setBounds(530,1,300,150);
        title.setFont(FontStyle.medium);
        
        username.setBounds(430,100,200,90);
        usernameField.setBounds(630,130,200,30);
        username.setFont(FontStyle.small);
        
        password.setBounds(430,180,200,90);
        passwordField.setBounds(630,210,200,30);
        repassword.setBounds(430,250,200,90);
        repassField.setBounds(630,280,200,30);
        password.setFont(FontStyle.small);
        repassword.setFont(FontStyle.small);
        
        umur.setBounds(430,355,200,20);
        umurField.setBounds(630,350,200,30);
        umur.setFont(FontStyle.small);
        
        alamat.setBounds(430,430,200,20);
        alamatField.setBounds(630,420,200,30);
        alamat.setFont(FontStyle.small);
        
        noHP.setBounds(430,500,200,20);
        noHPfield.setBounds(630,490,200,30);
        noHP.setFont(FontStyle.small);
        
        KTP.setBounds(430,560,200,20);
        KTPfield.setBounds(630,555,230,30);
        KTP.setFont(FontStyle.small);
        
        submit.setBounds(420,625,250,50);
        submit.setFont(FontStyle.small);
        submit.addActionListener(this);
        
        back.setBounds(680,625,250,50);
        back.setFont(FontStyle.small);
        back.addActionListener(this);
        
        Regisframe.add(title);
        Regisframe.add(username);
        Regisframe.add(usernameField);
        Regisframe.add(password);
        Regisframe.add(passwordField);
        Regisframe.add(repassword);
        Regisframe.add(repassField);
        Regisframe.add(umur);
        Regisframe.add(umurField);
        Regisframe.add(alamat);
        Regisframe.add(alamatField);
        Regisframe.add(KTP);
        Regisframe.add(KTPfield);
        Regisframe.add(noHP);
        Regisframe.add(noHPfield);
        Regisframe.add(submit);
        Regisframe.add(back);
        Regisframe.setLayout(null);
        Regisframe.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Member mem = new Member();
        String username = this.usernameField.getText();
        String password = new String(passwordField.getPassword());
        String repassword = new String(repassField.getPassword());
        String umur = this.umurField.getText();
        String KTP = KTPfield.getText();
        String alamat = alamatField.getText();
        String noHp = noHPfield.getText();
        if(e.getActionCommand().equals("Submit")){
            int pilih = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(pilih == JOptionPane.YES_OPTION){
                if(username.length() == 0 || password.length() == 0 || repassword.length() == 0
                    || umur.length() == 0 || alamat.length() == 0 || noHp.length() == 0 || KTP.length() == 0){
                    JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
                }else{
                    int umur2 = Integer.parseInt(umur);
                    mem.setUsername(username);
                    mem.setPassword(password);
                    mem.setRepassword(repassword);
                    mem.setAlamat(alamat);  
                    mem.setKTP(KTP);
                    mem.setUmur(umur2);
                    mem.setNoHp(noHp);
                    if(Controller.insertMember(mem)){
                        if(repassword.equals(password)){
                            JOptionPane.showMessageDialog(null, "Registrasi berhasil");
                            Regisframe.dispose();
                            new LoginScreen();
                        } 
                    }else{
                        JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }else if(e.getActionCommand().equals("Back To Main Screen")){
            new MenuUtamaScreen();
            Regisframe.dispose();
        }
    }
    
}
