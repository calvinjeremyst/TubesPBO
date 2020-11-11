/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DetailRute;
import model.Member;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author Hp
 */
public class Controller {
    
    static controller.DatabaseHandler conn = new controller.DatabaseHandler();
    
    public static ArrayList<DetailRute> cariRute(String kotaAsal, String kotaTujuan, Date tanggalPergi) {
        ArrayList<DetailRute> droute = new ArrayList<>();
        conn.connect();
        String query = "SELECT rute.ID_Rute,rute.kotaAsal,rute.kotaTujuan,rute.ID_Bis,detailrute.jamBerangkat,"
                + "detailrute.tanggalBerangkat,detailrute.hargaRute,detailrute.hargaBis FROM rute,detailrute "
                + "WHERE rute.ID_Rute = detailrute.ID_Rute && rute.kotaAsal='"+kotaAsal+"' && "
                + "rute.kotaTujuan='"+kotaTujuan+"'&& detailrute.tanggalBerangkat='" + tanggalPergi + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DetailRute drute = new DetailRute();
                drute.setIdRute(rs.getString("ID_Rute"));
                drute.setKotaAsal(rs.getString("kotaAsal"));
                drute.setKotaTujuan(rs.getString("kotaTujuan"));
                drute.setListbis(rs.getString("ID_Bis"));
                drute.setJamBerangkat(rs.getString("jamBerangkat"));
                drute.setTanggalBerangkat(rs.getDate("tanggalBerangkat"));
                drute.setHargaBis(rs.getDouble("hargaBis"));
                drute.setHargaRute(rs.getDouble("hargaRute"));
                droute.add(drute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return droute;
    }
    
    public static boolean cekTiket(int id) {
        conn.connect();
        String query = "SELECT * FROM listorder WHERE ID_Order='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return (true);
            }
            return (false);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean deleteTiket(int id) {
        conn.connect();
        String query = "DELETE FROM listorder WHERE ID_Order='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static ArrayList<Member> getAllMember() {
        ArrayList<Member> members = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM usr";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setId_user(rs.getInt("ID_User"));
                member.setNama(rs.getString("nama"));
                member.setPassword(rs.getString("pass"));
                member.setAlamat(rs.getString("alamat"));
                member.setNoHp(rs.getString("noHp"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (members);
    }
    
}
