/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.listBis;
import model.Admin;
import model.DetailRute;
import model.Member;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import model.User;

/**
 *
 * @author Hp
 */
public class Controller {  

    static controller.DataBaseHandler conn = new DataBaseHandler();
    
    public static boolean insertPerjalanan(DetailRute rute,listBis list){
        
        conn.Connect();
        
        String queryListBis = "INSERT INTO listbis(ID_Bis,kelasBis,jumlahKapasitas)"
                + "VALUES(?,?,?)";
        
        String queryRute = "INSERT INTO rute(ID_Rute,kotaAsal,kotaTujuan,ID_Bis)"
                + "VALUES(?,?,?,?)";
     
        
        String queryDetail = "INSERT INTO detailrute(jamBerangkat,tanggalBerangkat,hargaRute,hargaBis,ID_Rute)"
                + "VALUES(?,?,?,?,?)";
        
        try{
            PreparedStatement statement = conn.con.prepareStatement(queryListBis);
            statement.setString(1,list.getIDbis());
            statement.setString(2,list.getKelasBis());
            statement.setInt(3,list.getJumlahKapasitas());
            statement.executeUpdate();
          
            statement.close();
            
            statement = conn.con.prepareStatement(queryRute);
            statement.setString(1,rute.getIdRute());
            statement.setString(2,rute.getKotaAsal());
            statement.setString(3,rute.getKotaTujuan());
            statement.setString(4,list.getIDbis());
            statement.executeUpdate();
           
            statement.close();
          
            statement = conn.con.prepareStatement(queryDetail);
            statement.setString(1, rute.getJamBerangkat());
            statement.setDate(2, new java.sql.Date(rute.getTanggalBerangkat().getTime()));
            statement.setDouble(3, rute.getHargaRute());
            statement.setDouble(4, rute.getHargaBis());
            statement.setString(5, rute.getIdRute());
            statement.executeUpdate();
          
            statement.close();
            
          return (true);
      }
      catch(SQLException ex){
          ex.printStackTrace();
          return (false);
      }
    }
  
    public static boolean insertMember(Member member) {
      conn.Connect();
      String query = "INSERT INTO usr(nama,pass,alamat,nohp)"
              + "VALUES(?,?,?,?)";
      String query2 = "SELECT ID_User FROM usr";
      String query3 = "INSERT INTO member(umur,KTP,ovoBalance,ID_User)"
              + "VALUES(?,?,?,?)";
      try{
          Statement stmts = conn.con.createStatement();
          ResultSet rs = stmts.executeQuery(query2);
          while(rs.next()){
            member.setID_User(rs.getInt("ID_User"));
          }
          
          PreparedStatement stmt = conn.con.prepareStatement(query);
          stmt.setString(1, member.getUsername());
          stmt.setString(2, member.getPassword());
          stmt.setString(3, member.getAlamat());
          stmt.setString(4, member.getNoHp());
          stmt.executeUpdate();
          stmt.close();
          
          stmt = conn.con.prepareStatement(query3);
          stmt.setInt(1, member.getUmur());
          stmt.setString(2, member.getKTP());
          stmt.setDouble(3,50000);
          stmt.setInt(4,member.getID_User());
          stmt.executeUpdate();
          stmt.close();
          return true;
      }catch(SQLException ex){
          ex.printStackTrace();
          return false;
      }
    }
  
    public static ArrayList<DetailRute> cariDetailRute(String kotaAsal,String kotaTujuan) {
      ArrayList<DetailRute> dtrute = new ArrayList();
      conn.Connect();
      String query = "SELECT rute.ID_Rute,rute.kotaAsal,rute.kotaTujuan,rute.ID_Bis,detailrute.jamBerangkat,"
                + "detailrute.tanggalBerangkat,detailrute.hargaRute,detailrute.hargaBis FROM rute,detailrute "
                + "WHERE rute.ID_Rute = detailrute.ID_Rute && rute.kotaAsal='" + kotaAsal + "'&& "
                + "rute.kotaTujuan='" + kotaTujuan + "'";
       try{
           Statement statement = conn.con.createStatement();
           ResultSet result = statement.executeQuery(query);
           while(result.next()){
               DetailRute detilrute = new DetailRute();
               detilrute.setIdRute(result.getString("ID_Rute"));
               detilrute.setKotaAsal(result.getString("kotaAsal"));
               detilrute.setKotaTujuan(result.getString("kotaTujuan"));
               detilrute.setIdbis(result.getString("ID_Bis"));
               detilrute.setJamBerangkat(result.getString("jamBerangkat"));
               detilrute.setTanggalBerangkat(result.getDate("tanggalBerangkat"));
               detilrute.setHargaRute(result.getDouble("hargaRute"));
               detilrute.setHargaBis(result.getDouble("hargaBis"));
               dtrute.add(detilrute);
           }
       }
       catch(SQLException e){
           e.printStackTrace();
       }
       return dtrute;
  }
    
    public static User login(String username,String password){
        conn.Connect();
        String query = "SELECT * FROM usr WHERE nama = '"+username+"' &&  pass = '"+password+"'";
        User usr = null;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int tipe = rs.getInt("Tipe_User");
                if(tipe == 0){
                    usr = new Admin();
                }else{
                    usr = new Member();
                }
                usr.setID_User(rs.getInt("ID_User"));
                usr.setUsername(rs.getString("nama"));
                usr.setPassword(rs.getString("pass"));
                usr.setAlamat(rs.getString("alamat"));
                usr.setNoHp(rs.getString("noHp")); 
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return usr;
    } 
    
    public static ArrayList<DetailRute> cariRute(String kotaAsal, String kotaTujuan, Date tanggalPergi) {
        ArrayList<DetailRute> droute = new ArrayList<>();
        conn.Connect();
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
                drute.setIdbis(rs.getString("ID_Bis"));
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
        conn.Connect();
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
        conn.Connect();
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
        conn.Connect();
        String query = "SELECT * FROM usr";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setID_User(rs.getInt("ID_User"));
                member.setUsername(rs.getString("nama"));
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
    
    /*public static boolean insertOrder(){
        conn.Connect();
        String query = "INSERT INTO transaksi(nama,pass,alamat,nohp)"
              + "VALUES(?,?,?,?)";
        String query2 = "INSERT INTO listorder(nama,pass,alamat,nohp)"
              + "VALUES(?,?,?,?)";
    }
    */
}
