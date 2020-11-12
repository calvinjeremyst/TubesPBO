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
import java.util.ArrayList;
import javax.swing.*;
import java.sql.Date;
/**
 *
 * @author Christian
 */
public class Controller{
    
    static DatabaseHandler conn = new DatabaseHandler();
    
     // SELECT all data from table member
    public static ArrayList<Member> getAllData() {
        ArrayList<Member> members = new ArrayList<>();
        conn.connect();
        String query = "select b.ID_Member, a.nama, a.pass, b.ovoBalance from usr a join member b on a.ID_User=b.ID_User";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setID(rs.getString("b.ID_Member"));
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
    
    // SELECT data from table users
    public static ArrayList<Member> getData(String id) {
        ArrayList<Member> members = new ArrayList<>();
        conn.connect();
        String query = "select b.ID_Member, a.nama, a.pass, b.ovoBalance from usr a join member b on a.ID_User=b.ID_User where b.ID_Member='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setID(rs.getString("b.ID_Member"));
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
    
    // SELECT data from table topup
        public static ArrayList<RiwayatTopup> getHistory(String id) {
        ArrayList<RiwayatTopup> riwayats = new ArrayList<>();
        conn.connect();
        String query = "select nominal, metode, tanggalTopUp from topup WHERE ID_Member='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatTopup riwayat = new RiwayatTopup();
                double nominal =rs.getDouble("nominal");
                String metode = rs.getString("metode");
                Date date = rs.getDate("tanggalTopUp");
                riwayat.setNominal(nominal);
                riwayat.setMetode(metode);
                riwayat.setDate(date);
                riwayats.add(riwayat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (riwayats);
    }

    // INSERT data to table topup
    public static boolean insertHistory(RiwayatTopup rtu) {
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
    
    //UPDATE data to table member
    public static boolean updateOvoBalance(Member member, double nominal){
        conn.connect();
        double hasil = member.getSaldo() + nominal;
        String query = "UPDATE member set ovoBalance='" + hasil + "' where ID_Member='" + member.getID() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    //konfirmasi topup
    public static int konfirmasi(ArrayList<Member> member, int nominal, String metode){
        String ID = JOptionPane.showInputDialog("Masukan ID MEMBER anda : ");
        String pass = JOptionPane.showInputDialog("Masukan password anda : ");
        if (ID.equals(member.get(0).getID())){
            if (pass.equals(member.get(0).getPass())){
                int confirm = JOptionPane.showConfirmDialog(null,"Apakah anda sudah yakin ?");
                if(confirm==JOptionPane.YES_OPTION){
                    int jmlNom = nominal;
                    String metodeOVO = metode;
                    long millis=System.currentTimeMillis();
                    java.sql.Date tanggal = new java.sql.Date(millis);
                    RiwayatTopup riwayat = new RiwayatTopup(jmlNom,metodeOVO,tanggal,ID);
                    
                    insertHistory(riwayat);
                    for (Member mmbr :member) {
                        if(mmbr.getID().equals(ID)){
                            updateOvoBalance(mmbr, nominal);
                        }
                     }
                    System.out.println(riwayat.getDate());
                    System.out.println(riwayat.getMetode());
                    System.out.println(riwayat.getNominal());
                    
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