/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl; 

import com.itenas.javabakery.pojo.Akun;
import com.itenas.javabakery.pojo.Member;
import com.itenas.javabakery.service.AkunService;
import com.itenas.javabakery.utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AkunServiceImpl implements AkunService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public Akun login(String username, String password) {
        Member member = null;
        Akun akun = null;
        /*String sql = "SELECT m.id, m.namamember, a.id_akun, a.email, a.username, "
                + "a.password, a.level FROM member m, akun a "
                + "WHERE m.id_akun = a.id_akun "
                + "AND a.username = '"+username+"' "
                + "AND a.password = '"+password+"'"; */
        String sql = "SELECT id_akun, username, password, level, nama, "
                + "alamat, notelp FROM akun WHERE username='"+username
                + "' AND password='" +password+"' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                //member = new Member();
                //member.setId(rs.getInt("id"));
                //member.setNamaMember(rs.getString("namamember"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setNama("nama");
                akun.setAlamat("alamat");
                akun.setNoTelp("notelp");
                akun.setLevel(rs.getString("level"));
                akun.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return akun;
    }
    
    public boolean register(String username, String password, String nama, String alamat, String noTelp) {
        Member member = null;
        Akun akun = null;
        String sql = "INSERT INTO akun VALUES(NULL, '" +username+ "', '" +password+ "', 'user', '"
                +nama+"', '" +alamat+"', '" +noTelp+"')";
        String query = "CREATE TABLE keranjangmember" + username + " "
                + "(id_data INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                + " id_produk INT NOT NULL, "
                + "FOREIGN KEY(id_produk) REFERENCES PRODUK(id_produk),"
                + "nama_produk VARCHAR(100) NOT NULL, jumlah INT NOT NULL, "
                + "harga INT NOT NULL, total double, produk_image BLOB NOT NULL)";
        /*String query = "CREATE TABLE keranjangmember" + username + " "
                + "(id_data INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "id_produk INT NOT NULL, "
                + "CONSTRAINT FK_produkPesanan FOREIGN KEY(id_produk) REFERENCES produk(id_produk),"
                + "nama_produk VARCHAR(100) NOT NULL, jumlah INT NOT NULL, "
                + "harga INT NOT NULL, produk_image BLOB NOT NULL)";*/
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(query);
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
        /*try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        
            while (rs.next()){
                if (username.equals(rs.getString("username"))){
                    return false;
                } else {
                    stmt.executeQuery(query);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        //return true;*/
    }

    @Override
    public Akun update(String username, String password, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
        
        /*try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                member = new Member();
                member.setId(rs.getInt("id"));
                member.setNamaMember(rs.getString("namamember"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setLevel(rs.getString("level"));
                member.setAkunMember(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return member;
    }*/
