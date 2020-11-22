/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import model.*;
import view.Helper.TampungDipilih;

/**
 *
 * @author Hp
 */
public class Controller {    
    
    static controller.DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean insertPerjalanan(DetailRute rute,ListBus list) {
        conn.Connect();
        String queryListBis = "INSERT INTO listbis(ID_Bis,kelasBis,jumlahPenumpang)"
                + "VALUES(?,?,?)";
        String queryRute = "INSERT INTO rute(ID_Rute,kotaAsal,kotaTujuan,ID_Bis)"
                + "VALUES(?,?,?,?)";
        String queryDetail = "INSERT INTO detailrute(jamBerangkat,tanggalBerangkat,hargaRute,hargaBis,ID_Rute)"
                + "VALUES(?,?,?,?,?)";
        try{
            PreparedStatement statement = conn.con.prepareStatement(queryListBis);
            statement.setInt(1,list.getIdBis());
            statement.setString(2,list.getKelas().toString());
            statement.setInt(3,list.getJumlahKapasitas());
            statement.executeUpdate();
            statement.close();
            
            statement = conn.con.prepareStatement(queryRute);
            statement.setInt(1,rute.getIdRute());
            statement.setString(2,rute.getKotaAsal());
            statement.setString(3,rute.getKotaTujuan());
            statement.setInt(4,list.getIdBis());
            statement.executeUpdate();
            statement.close();
          
            statement = conn.con.prepareStatement(queryDetail);
            statement.setString(1, rute.getJamBerangkat());
            statement.setDate(2, new java.sql.Date(rute.getTanggalBerangkat().getTime()));
            statement.setDouble(3, rute.getHargaRute());
            statement.setDouble(4, rute.getHargaBis());
            statement.setInt(5, rute.getIdRute());
            statement.executeUpdate();
            statement.close();
            
            return true;
          
      }
      catch(SQLException ex){
          ex.printStackTrace();
          return false;
      }
    }
  
    public static boolean insertMember(Member member) {
        conn.Connect();
        String query = "INSERT INTO usr(Tipe_User,nama,pass,repass,alamat,nohp)"
                + "VALUES(?,?,?,?,?,?)";
        String query2 = "SELECT ID_User FROM usr";
        String query3 = "INSERT INTO member(umur,KTP,ovoBalance,ID_User)"
                + "VALUES(?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1,1);
            stmt.setString(2, member.getUsername());
            stmt.setString(3, member.getPassword());
            stmt.setString(4, member.getRepassword());
            stmt.setString(5, member.getAlamat());
            stmt.setString(6, member.getNoHp());
            stmt.executeUpdate();
            stmt.close();

            Statement stmts = conn.con.createStatement();
            ResultSet rs = stmts.executeQuery(query2);
            while(rs.next()){
              member.setID_User(rs.getInt("ID_User"));
            }

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
  
    public static ArrayList<DetailRute> cariRuteAdmin(String kotaAsal,String kotaTujuan) {
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
                detilrute.setIdRute(result.getInt("ID_Rute"));
                detilrute.setKotaAsal(result.getString("kotaAsal"));
                detilrute.setKotaTujuan(result.getString("kotaTujuan"));
                detilrute.setIdbis(result.getInt("ID_Bis"));
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
                drute.setIdRute(rs.getInt("ID_Rute"));
                drute.setKotaAsal(rs.getString("kotaAsal"));
                drute.setKotaTujuan(rs.getString("kotaTujuan"));
                drute.setIdbis(rs.getInt("ID_Bis"));
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
        String query = "SELECT * FROM orders WHERE ID_Order='" + id + "'";
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
        String query = "DELETE FROM orders WHERE ID_Order='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
   
    //Lihat Data Semua Member
    public static ArrayList<Member> getAllData() {
        ArrayList<Member> members = new ArrayList<>();
        conn.Connect();
        String query = "SELECT b.ID_Member, a.nama, a.pass, b.ovoBalance FROM usr a JOIN member b ON a.ID_User = b.ID_User";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setID_Member(rs.getInt("b.ID_Member"));
                member.setUsername(rs.getString("a.nama"));
                member.setPassword(rs.getString("a.pass"));
                member.setOvoBalance(rs.getDouble("b.ovoBalance"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (members);
    }
    
    //Lihat Satu Member
    public static Member getData(int id) {
        Member member = new Member();
        conn.Connect();
        String query = "SELECT b.ID_Member, a.nama, a.pass, b.ovoBalance FROM usr a JOIN member b ON a.ID_User = b.ID_User WHERE b.ID_Member='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                member.setID_Member(rs.getInt("b.ID_Member"));
                member.setUsername(rs.getString("a.nama"));
                member.setPassword(rs.getString("a.pass"));
                member.setOvoBalance(rs.getDouble("b.ovoBalance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }
    
    // SELECT data from table topup
        public static ArrayList<RiwayatTopup> getHistory(int id) {
        ArrayList<RiwayatTopup> riwayats = new ArrayList<>();
        conn.Connect();
        String query = "SELECT nominal, metode, tanggalTopUp FROM topup WHERE ID_Member='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatTopup riwayat = new RiwayatTopup();
                double nominal =rs.getDouble("nominal");
                String metode = rs.getString("metode");
                java.sql.Date date = rs.getDate("tanggalTopUp");
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

    // INSERT History
    public static boolean insertHistory(RiwayatTopup rtu) {
        conn.Connect();
        String query = "INSERT INTO topup (nominal, metode, tanggalTopUp, ID_Member) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setDouble(1, rtu.getNominal());
            stmt.setString(2, rtu.getMetode());
            stmt.setDate(3, rtu.getDate());
            stmt.setInt(4, rtu.getId());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    //UPDATE OVO Balance Member
    public static boolean updateOvoBalance(Member member, double nominal) {
        conn.Connect();
        double hasil = member.getOvoBalance() + nominal;
        String query = "UPDATE member SET ovoBalance='" + hasil + "' WHERE ID_Member='" + member.getID_Member()+ "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean topUp(int nominal, String metode) {
        Member member = (Member) UserManager.getInstance().getUser();
        int jmlNom = nominal;
        String metodeOVO = metode;
        long millis = System.currentTimeMillis();
        java.sql.Date tanggal = new java.sql.Date(millis);
        
        RiwayatTopup riwayat = new RiwayatTopup(jmlNom,metodeOVO,tanggal,member.getID_Member());
        insertHistory(riwayat);
        
        if(updateOvoBalance(member, nominal)){
            return true;
        } else{
            return false;
        }
        
    }
    
    public static boolean insertKursi(String nomor, ListOrder order, TampungDipilih dipilih) {
        conn.Connect();
        String query = "INSERT INTO kursi (nomorKursi,ID_Order,ID_Rute) VALUES(?,?,?)";
        try{
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1,nomor);
            statement.setInt(2,order.getIdOrder());
            statement.setInt(3,dipilih.getIdRute());
            statement.executeUpdate();
            return true;    
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }    
    }
    
    public static boolean insertOrderOVO(TransaksiPembayaran trk, ListOrder order) {
        TransaksiPembayaran transaksi = new TransaksiPembayaran();
        conn.Connect();
        String query = "INSERT INTO transaksi(banyakPenumpang,grandTotal,cashback,useOvo,metodePembayaran,tanggalTransaksi)"
              + "VALUES(?,?,?,?,?,?)";
        String query2 = "SELECT ID_Transaksi FROM transaksi";
        String query3 = "INSERT INTO orders(tanggalOrder,ID_Member,ID_Rute,ID_Transaksi)"
              + "VALUES(?,?,?,?)";
        String query4 = "SELECT ID_Order FROM orders";
        String query5 = "UPDATE member SET ovoBalance = ovoBalance - '" + trk.getGrandTotal() + "' WHERE ID_Member = '" + order.getIdMember() + "'";
        
        try{
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1,trk.getBanyakPenumpang());
            statement.setDouble(2,trk.getGrandTotal());
            statement.setDouble(3,trk.getCashBack());
            statement.setInt(4,trk.getUseOVO());
            statement.setString(5,trk.getMetodePembayaran());
            statement.setDate(6,trk.getTanggalTransaksi());
            statement.executeUpdate();
            statement.close();
            
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()) {
                transaksi.setIdTransaksi(rs.getInt("ID_Transaksi"));
            }
            stmt.close();
            
            statement = conn.con.prepareStatement(query3);
            statement.setDate(1,order.getTanggalOrder());
            statement.setInt(2,order.getIdMember());
            statement.setInt(3,order.getIdRute());
            statement.setInt(4,transaksi.getIdTransaksi());
            statement.executeUpdate();
            statement.close();
            
            stmt = conn.con.createStatement();
            rs = stmt.executeQuery(query4);
            while(rs.next()){
                order.setIdOrder(rs.getInt("ID_Order"));
            }
            stmt.close();
            
            stmt = conn.con.createStatement();
            stmt.executeUpdate(query5);
            stmt.close();
            
            return true;
           
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertOrderCC(TransaksiPembayaran trk, ListOrder order) {
        TransaksiPembayaran transaksi = new TransaksiPembayaran();
        conn.Connect();
        String query = "INSERT INTO transaksi(banyakPenumpang,grandTotal,cashback,useOvo,metodePembayaran,tanggalTransaksi)"
              + "VALUES(?,?,?,?,?,?)";
        String query2 = "SELECT ID_Transaksi FROM transaksi";
        String query3 = "INSERT INTO orders(tanggalOrder,ID_Member,ID_Rute,ID_Transaksi)"
              + "VALUES(?,?,?,?)";
        String query4 = "SELECT ID_Order FROM orders";
        
        try{
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1,trk.getBanyakPenumpang());
            statement.setDouble(2,trk.getGrandTotal());
            statement.setDouble(3,trk.getCashBack());
            statement.setInt(4,trk.getUseOVO());
            statement.setString(5,trk.getMetodePembayaran());
            statement.setDate(6,trk.getTanggalTransaksi());
            statement.executeUpdate();
            statement.close();
            
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            while (rs.next()) {
                transaksi.setIdTransaksi(rs.getInt("ID_Transaksi"));
            }
            stmt.close();
            
            statement = conn.con.prepareStatement(query3);
            statement.setDate(1,order.getTanggalOrder());
            statement.setInt(2,order.getIdMember());
            statement.setInt(3,order.getIdRute());
            statement.setInt(4,transaksi.getIdTransaksi());
            statement.executeUpdate();
            statement.close();
            
            stmt = conn.con.createStatement();
            rs = stmt.executeQuery(query4);
            while(rs.next()){
                order.setIdOrder(rs.getInt("ID_Order"));
            }
            stmt.close();
            
            return true;
           
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean cekPass(String username, String password) {
        conn.Connect();
        String query = "SELECT * FROM usr WHERE nama='" + username + "'";
        boolean cek = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("pass").equals(password)) {
                    cek = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }
    
    public static boolean cekRute(int id) {
        conn.Connect();
        String query = "SELECT ID_Rute FROM rute WHERE ID_Rute = '"+id+"'";
        boolean cek = false;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getInt("ID_Rute") ==id){
                    cek = true;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            cek = false;
        }
        return cek;
    }
    
    public static boolean cekIdBis(int idBis) {
        conn.Connect();
        String query = "SELECT ID_Bis FROM listbis WHERE ID_Bis = '"+idBis+"'";
        boolean cek = false;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getInt("ID_Bis") == idBis){
                    cek =true;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            cek = false;

        }
        return cek;
    }
    
    public static boolean getRiwayat(Member member,ArrayList<ListOrder> list,ArrayList<TransaksiPembayaran> list2,
                                    ArrayList<DetailRute> list3) {
        boolean hasil = false;
        conn.Connect();
        String query = "SELECT orders.ID_Order,"
                + "orders.tanggalOrder,"
                + "transaksi.ID_Transaksi,"
                + "transaksi.metodePembayaran,"
                + "transaksi.grandTotal,"
                + "transaksi.banyakPenumpang,"
                + "orders.ID_Rute,"
                + "rute.kotaAsal,"
                + "rute.kotaTujuan,"
                + "detailrute.jamBerangkat,"
                + "detailrute.tanggalBerangkat,"
                + "detailrute.hargaRute,"
                + "detailrute.hargaBis "
                + "FROM orders "
                + "JOIN transaksi ON transaksi.ID_Transaksi = orders.ID_Transaksi "
                + "JOIN rute ON rute.ID_Rute = orders.ID_Rute "
                + "JOIN detailrute ON detailrute.ID_Rute = orders.ID_Rute "
                + "JOIN member ON member.ID_Member = orders.ID_Member "
                + "WHERE orders.ID_Member = '" + member.getID_Member() + "'"
                + "ORDER BY ID_Order ASC";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ListOrder order = new ListOrder();
                TransaksiPembayaran trk = new TransaksiPembayaran();
                DetailRute drute = new DetailRute();
                order.setIdOrder(rs.getInt("ID_Order"));
                order.setTanggalOrder(rs.getDate("tanggalOrder"));
                trk.setIdTransaksi(rs.getInt("ID_Transaksi"));
                trk.setMetodePembayaran(rs.getString("metodePembayaran"));
                trk.setGrandTotal(rs.getDouble("grandTotal"));
                trk.setBanyakPenumpang(rs.getInt("banyakPenumpang"));
                order.setIdRute(rs.getInt("ID_Rute"));
                drute.setKotaAsal(rs.getString("kotaAsal"));
                drute.setKotaTujuan(rs.getString("kotaTujuan"));
                drute.setJamBerangkat(rs.getString("jamBerangkat"));
                drute.setTanggalBerangkat(rs.getDate("tanggalBerangkat"));
                drute.setHargaRute(rs.getDouble("hargaRute"));
                drute.setHargaBis(rs.getDouble("hargaBis"));
                list.add(order);
                list2.add(trk);
                list3.add(drute);
                hasil = true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            hasil = false;
        }
        return hasil;
    }
    
    public static ListBus getKelasBis(int id) {
        ListBus bus = new ListBus();
        conn.Connect();
        String query = "SELECT kelasBis FROM listbis WHERE ID_Bis='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String kelas = rs.getString("kelasBis");
                switch (kelas) {
                    case "VIP":
                        bus.setKelas(EnumBis.VIP);
                        break;
                    case "Reguler":
                        bus.setKelas(EnumBis.REGULER);
                        break;
                    case "Ekonomi":
                        bus.setKelas(EnumBis.EKONOMI);
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bus;
    }
    
    public static ArrayList<Kursi> getKursi(int id){
        ArrayList<Kursi> kursi2 = new ArrayList<>();
        conn.Connect();
        String query = "SELECT nomorKursi FROM kursi WHERE ID_Rute='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Kursi kursi = new Kursi();
                kursi.setNomorKursi(rs.getString("nomorKursi"));
                kursi2.add(kursi);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return kursi2;
    }
    
    public static User getUser(String username, String password) {
        User usr = null;
        conn.Connect();
        String query = "SELECT usr.ID_User,"
                             + "usr.Tipe_User,"
                             + "usr.pass,"
                             + "usr.repass,"
                             + "usr.nama,"
                             + "usr.alamat,"
                             + "usr.noHp,"
                             + "member.umur,"
                             + "member.ktp,"
                             + "member.ovoBalance,"
                             + "member.ID_Member "
                             + "FROM usr "
                             + "JOIN member ON member.ID_User = usr.ID_User "
                             + "WHERE usr.nama = '" + username +"' &&  usr.pass = '" + password + "'";
        
        String query2 = "SELECT usr.ID_User,"
                             + "usr.Tipe_User,"
                             + "usr.pass,"
                             + "usr.repass,"
                             + "usr.nama,"
                             + "usr.alamat,"
                             + "usr.noHp,"
                             + "admin.ID_Admin "
                             + "FROM usr "
                             + "JOIN admin ON admin.ID_User = usr.ID_User "
                             + "WHERE usr.nama = '" + username +"' &&  usr.pass = '" + password + "'";
        
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int tipeUser = rs.getInt("Tipe_User");
                switch (tipeUser) {
                    case 1:
                        usr = new Member(
                            rs.getInt("ID_Member"),
                            rs.getInt("umur"),
                            rs.getString("KTP"),
                            rs.getDouble("ovoBalance")
                        );
                        usr.setTipeUser(tipeUser);
                        break; 
                    default:
                        usr = new User();
                        break;
                }
                usr.setID_User(rs.getInt("ID_User"));
                usr.setTipeUser(rs.getInt("Tipe_User"));
                usr.setUsername(rs.getString("nama"));
                usr.setPassword(rs.getString("pass"));
                usr.setRepassword(rs.getString("repass"));
                usr.setAlamat(rs.getString("alamat"));
                usr.setNoHp(rs.getString("noHp"));
            }
            stmt.close();
            
            Statement stmt2 = conn.con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(query2);
            while (rs2.next()){
                int tipeUser2 = rs2.getInt("Tipe_User");
                int iduser = rs2.getInt("ID_User");
                String nama = rs2.getString("nama");
                switch (tipeUser2) {
                    case 0:
                        usr = new Admin(rs2.getString("ID_Admin"));
                        usr.setTipeUser(tipeUser2);
                        break;
                    default:
                        usr = new User();
                        break;
                }
                usr.setID_User(rs2.getInt("ID_User"));
                usr.setTipeUser(rs2.getInt("Tipe_User"));
                usr.setUsername(rs2.getString("nama"));
                usr.setPassword(rs2.getString("pass"));
                usr.setRepassword(rs2.getString("repass"));
                usr.setAlamat(rs2.getString("alamat"));
                usr.setNoHp(rs2.getString("noHp"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (usr);
    }
    
}
