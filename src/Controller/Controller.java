/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
/**
 *
 * @author Christian
 */
public class Controller{
    
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL from table users
    public static ArrayList<Member> getData() {
        ArrayList<Member> members = new ArrayList<>();
        conn.connect();
        String query = "select a.ID_User, a.nama, a.pass, b.ovoBalance from usr a join member b on a.ID_User=b.ID_User;";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setID(rs.getString("a.ID_User"));
                member.setNama(rs.getString("a.nama"));
                member.setPass(rs.getString("a.pass"));
                member.setSaldo(rs.getDouble("b.ovoBalance"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (members);
    }
    
    public static ArrayList<RiwayatTopUp> getHistory() {
        
        ArrayList<RiwayatTopUp> riwayats = new ArrayList<>();
        conn.connect();
        String query = "select nominal, metode, tanggalTopUp from topup";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatTopUp riwayat = new RiwayatTopUp();
                double nominal =rs.getDouble("nominal");
                String metode = rs.getString("metode");
                Date date = rs.getDate("tanggalTopUp");
                riwayat.setNominal(nominal);
                riwayat.setMetode(metode);
                riwayat.setDate(date);
                //String[] data = {Double.toString(nominal),metode,date};
                riwayats.add(riwayat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (riwayats);
    }
//        //SELECT WHERE
//        public static Member getMember(String ID, String nama) {
//        conn.connect();
//        Member member = new Member();
//        String query = "SELECT * FROM usr WHERE ID_User='" + ID + "'&&nama='" + nama + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                member.setID(rs.getString("ID_User"));
//                member.setNama(rs.getString("nama"));
//                member.setPass(rs.getString("pass"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (member);
//    }
//    
    // INSERT
    public static boolean insertHistory(RiwayatTopUp rtu) {
        conn.connect();
        String query = "INSERT INTO topup (nominal, metode, tanggalTopUp, ID_Member) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setDouble(1, rtu.getNominal());
            stmt.setString(2, rtu.getMetode());
            stmt.setDate(3, rtu.getDate());
            stmt.setString(4, rtu.getId());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static int konfirmasi(ArrayList<Member> member, int nominal, String metode){
        //Member memberr = new Member("aa","asdf","123",5000);
        String ID = JOptionPane.showInputDialog("Masukan ID anda : ");
        String pass = JOptionPane.showInputDialog("Masukan password anda : ");
        if (ID.equals(member.get(0).getID())){
            if (pass.equals(member.get(0).getPass())){
                int confirm = JOptionPane.showConfirmDialog(null,"Apakah anda sudah yakin ?");
                if(confirm==JOptionPane.YES_OPTION){
                    int jmlNom = nominal;
                    String metodeOVO = metode;
                    //System.out.println(jmlNom);
                    //System.out.println(metodeOVO);
                    //Date date = new Date();
                    SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
                    long millis=System.currentTimeMillis();
                    java.sql.Date tanggal = new java.sql.Date(millis);
                    RiwayatTopUp riwayat = new RiwayatTopUp(jmlNom,metodeOVO,tanggal,ID);
                    System.out.println(riwayat.getDate());
                    System.out.println(riwayat.getMetode());
                    System.out.println(riwayat.getNominal());
                    insertHistory(riwayat);
                    JOptionPane.showMessageDialog(null,"Selamat Pembayaran Anda Berhasil !");
                    return 1;
                }else{
                    JOptionPane.showMessageDialog(null,"Mohon Maaf Pembayaran Anda Tidak Dapat Diproses !");
                }  
            }else{
                    JOptionPane.showMessageDialog(null,"Mohon Maaf Pembayaran Anda Tidak Dapat Diproses !");
            }  
        }
        return 0;
    }
}