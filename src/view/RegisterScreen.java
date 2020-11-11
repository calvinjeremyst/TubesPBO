/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.event.*;
import view.tools.fontStyle;
import model.Member;

/**
 *
 * @author lenovo
 */
public class RegisterScreen implements ActionListener{
    
    JFrame Regisframe = new JFrame("Register");
    JLabel title = new JLabel("Registrasi Member");
    JLabel username = new JLabel("Username : ");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password : ");
    JPasswordField passwordField = new JPasswordField();
    JLabel repassword = new JLabel("Retype password : ");
    JPasswordField repassField = new JPasswordField();
    JLabel umur = new JLabel("Umur : ");
    JTextField umurField = new JTextField();
    JLabel alamat = new JLabel("Alamat : ");
    JTextField alamatField = new JTextField();
    JLabel KTP = new JLabel("NO KTP : ");
    JTextField KTPfield = new JTextField();
    JLabel noHP = new JLabel("No. HP : ");
    JTextField noHPfield = new JTextField();
    JButton submit = new JButton("Submit");
    public RegisterScreen(){
        
        Regisframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Regisframe.setSize(2000,2000);
       title.setBounds(500,1,300,150);
       title.setFont(fontStyle.medium);
        username.setBounds(400,100,200,90);
        usernameField.setBounds(600,130,200,30);
        username.setFont(fontStyle.small);
        
        password.setBounds(400,180,200,90);
        passwordField.setBounds(600,210,200,30);
        repassword.setBounds(400,250,200,90);
        repassField.setBounds(600,280,200,30);
        password.setFont(fontStyle.small);
        repassword.setFont(fontStyle.small);
        
        umur.setBounds(400,355,200,20);
        umurField.setBounds(600,350,200,30);
        umur.setFont(fontStyle.small);
        
 
        alamat.setBounds(400,430,200,20);
        alamatField.setBounds(600,420,200,30);
        alamat.setFont(fontStyle.small);
        
        noHP.setBounds(400,520,200,20);
        noHPfield.setBounds(600,515,200,30);
        noHP.setFont(fontStyle.small);
        
        KTP.setBounds(400,580,200,20);
        KTPfield.setBounds(600,580,230,30);
        KTP.setFont(fontStyle.small);
        
        submit.setBounds(490,650,200,50);
        submit.setFont(fontStyle.small);
        submit.addActionListener(this);
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
        Regisframe.setLayout(null);
        Regisframe.setVisible(true);
    }
    
   
    
    @Override
public void actionPerformed(ActionEvent e){
   
    Member mem = new Member();
   String username = this.usernameField.getText();
   String password = new String(passwordField.getPassword());
   String repassword = new String(repassField.getPassword());
   int umur = Integer.parseInt(umurField.getText());
   
   String KTP = KTPfield.getText();
   String alamat = alamatField.getText();
   String noHp = noHPfield.getText();
   
       int pilih = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", 
               JOptionPane.YES_NO_OPTION, 
               JOptionPane.QUESTION_MESSAGE, null, null, null);
       
       if(pilih == JOptionPane.YES_OPTION){
           
            if(username.length() == 0 || password.length() == 0 || repassword.length() == 0
           || umur == 0 || alamat.length() == 0 || noHp.length() == 0 || KTP.length() == 0){
       
        JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
   }
   else{
      
       
       mem.setUsername(username);
       mem.setPassword(password);
       mem.setRepassword(repassword);
       mem.setAlamat(alamat);
      
       mem.setKTP(KTP);
       mem.setUmur(umur);
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
}

 public static void main(String[] args) {
        new RegisterScreen();
    }
}
