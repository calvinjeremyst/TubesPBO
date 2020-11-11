/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.listBis;
import model.Admin;
import model.DetailRute;
import model.Member;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hp
 */
public class Controller {
    
    static DataBaseHandler dbh = new DataBaseHandler();
    
    public static boolean insertPerjalanan(DetailRute rute,listBis list){
        
        dbh.Connect();
        
        String queryListBis = "INSERT INTO listbis(ID_Bis,kelasBis,jumlahKapasitas)"
                + "VALUES(?,?,?)";
        
        String queryRute = "INSERT INTO rute(ID_Rute,kotaAsal,kotaTujuan,ID_Bis)"
                + "VALUES(?,?,?,?)";
     
        
        String queryDetail = "INSERT INTO detailrute(jamBerangkat,tanggalBerangkat,hargaRute,hargaBis,ID_Rute)"
                + "VALUES(?,?,?,?,?)";
        
        try{
            PreparedStatement statement = dbh.con.prepareStatement(queryListBis);
            statement.setString(1,list.getIDbis());
            statement.setString(2,list.getKelasBis());
            statement.setInt(3,list.getJumlahKapasitas());
            statement.executeUpdate();
          
            statement.close();
            
            statement = dbh.con.prepareStatement(queryRute);
            statement.setString(1,rute.getID_Rute());
            statement.setString(2,rute.getKotaAsal());
            statement.setString(3,rute.getKotaTujuan());
            statement.setString(4,list.getIDbis());
            statement.executeUpdate();
           
            statement.close();
          
            statement = dbh.con.prepareStatement(queryDetail);
            statement.setString(1, rute.getJamBerangkat());
            statement.setDate(2, new java.sql.Date(rute.getTanggalBerangkat().getTime()));
            statement.setDouble(3, rute.getHargaRute());
            statement.setDouble(4, rute.getHargaBis());
            statement.setString(5, rute.getID_Rute());
            statement.executeUpdate();
          
            statement.close();
            
          return (true);
      }
      catch(SQLException ex){
          ex.printStackTrace();
          return (false);
      }
    }
  
    public static boolean insertMember(Member member){

      dbh.Connect();
      String query = "INSERT INTO usr(nama,pass,alamat,nohp)"
              + "VALUES(?,?,?,?)";
      String query2 = "SELECT ID_User FROM usr";
      String query3 = "INSERT INTO member(umur,KTP,ovoBalance,ID_User)"
              + "VALUES(?,?,?,?)";
      
      try{
          Statement stmts = dbh.con.createStatement();
          ResultSet rs = stmts.executeQuery(query2);
          while(rs.next()){
            member.setID_User(rs.getInt("ID_User"));
          }
          
          PreparedStatement stmt = dbh.con.prepareStatement(query);
          stmt.setString(1, member.getUsername());
          stmt.setString(2, member.getPassword());
          stmt.setString(3, member.getAlamat());
          stmt.setString(4, member.getNoHp());
          stmt.executeUpdate();
          stmt.close();
          
          stmt = dbh.con.prepareStatement(query3);
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
  
    public static ArrayList<DetailRute> cariDetailRute(String kotaAsal,String kotaTujuan){
      ArrayList<DetailRute> dtrute = new ArrayList();
      dbh.Connect();
      String query = "SELECT rute.ID_Rute,rute.kotaAsal,rute.kotaTujuan,rute.ID_Bis,detailrute.jamBerangkat,"
                + "detailrute.tanggalBerangkat,detailrute.hargaRute,detailrute.hargaBis FROM rute,detailrute "
                + "WHERE rute.ID_Rute = detailrute.ID_Rute && rute.kotaAsal='"+kotaAsal+"'&& "
                + "rute.kotaTujuan='"+kotaTujuan+"'";
     
       try{
           Statement statement = dbh.con.createStatement();
           ResultSet result = statement.executeQuery(query);
           int i = 0;
           while(result.next()){
               DetailRute detilrute = new DetailRute();
               detilrute.setID_Rute(result.getString("ID_Rute"));
               detilrute.setKotaAsal(result.getString("kotaAsal"));
               detilrute.setKotaTujuan(result.getString("kotaTujuan"));
               detilrute.setID_Bis(result.getString("ID_Bis"));
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
    
  public static Member loginMember(String username,String password){
      dbh.Connect();
      String query = "SELECT * FROM usr WHERE nama = '"+username+"' &&  pass = '"+password+"'";
      Member mem = new Member();
      try{
          Statement stmt = dbh.con.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while(rs.next()){
               mem.setID_User(rs.getInt("ID_User"));
               mem.setUsername(rs.getString("nama"));
               mem.setPassword(rs.getString("pass"));
               mem.setAlamat(rs.getString("alamat"));
               mem.setNoHp(rs.getString("noHp")); 
          }
      }
      catch(SQLException ex){
          ex.printStackTrace();
      }
      return mem;
  } 
  
  public static Admin loginAdmin(String username,String password){
      dbh.Connect();
      String query = "SELECT * FROM usr WHERE nama = '"+username+"' &&  pass = '"+password+"'";
      Admin adm = new Admin();
      Member mem = new Member();
      try{ 
          Statement stmt = dbh.con.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while(rs.next()){
               mem.setID_User(rs.getInt("ID_User"));
               mem.setUsername(rs.getString("nama"));
               mem.setPassword(rs.getString("pass"));
               mem.setAlamat(rs.getString("alamat"));
               mem.setNoHp(rs.getString("noHp"));  
          }
      }
      catch(SQLException ex){
          ex.printStackTrace();
      }
      return adm;
  }
  
}
