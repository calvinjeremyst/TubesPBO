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

/**
 *
 * @author lenovo
 */
public class RegisterScreen implements ActionListener{
    
    JFrame frame = new JFrame("Register");
    JLabel username = new JLabel("Username : ");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password : ");
    JTextField passwordField = new JTextField();
    JLabel repassword = new JLabel("Retype password : ");
    JTextField repassField = new JTextField();
    JLabel umur = new JLabel("Umur : ");
    JTextField umurField = new JTextField();
    JLabel alamat = new JLabel("Alamat : ");
    JTextField alamatField = new JTextField();
    JLabel noHP = new JLabel("No. HP : ");
    JTextField noHPfield = new JTextField();
    JButton submit = new JButton("Submit");
    public RegisterScreen(){
        
        frame.setSize(600,600);
        username.setBounds(150,100,120,20);
        usernameField.setBounds(270,100,220,20);
        
        password.setBounds(150,150,120,20);
        passwordField.setBounds(270,150,220,20);
        repassword.setBounds(150,200,120,20);
        repassField.setBounds(270,200,220,20);
        umur.setBounds(150,240,120,20);
        umurField.setBounds(270,240,70,20);
        alamat.setBounds(150,290,120,20);
        alamatField.setBounds(270,290,220,20);
        noHP.setBounds(150,350,120,20);
        noHPfield.setBounds(270,350,220,20);
        submit.setBounds(300,420,110,20);
        
        
        frame.add(username);
        frame.add(usernameField);
        frame.add(password);
        frame.add(passwordField);
        frame.add(repassword);
        frame.add(repassField);
        frame.add(umur);
        frame.add(umurField);
        frame.add(alamat);
        frame.add(alamatField);
        frame.add(noHP);
        frame.add(noHPfield);
        frame.add(submit);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
   
    
    @Override
public void actionPerformed(ActionEvent e){
   
   
    if(e.getActionCommand().equals("Submit")){
        String pass = passwordField.getText();
        String pass2 = repassField.getText();
        if(pass.equals(pass2)){
            JOptionPane.showMessageDialog(null, "Registrasi Berhasil !");
        
        }
        
    }

}

 public static void main(String[] args) {
        new RegisterScreen();
    }
}
