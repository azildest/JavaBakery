/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl;

import com.itenas.javabakery.pojo.Akun;
import com.itenas.javabakery.pojo.Keranjang;
import com.itenas.javabakery.pojo.Member;
import com.itenas.javabakery.pojo.Produk;
import com.itenas.javabakery.service.KeranjangService;
import com.itenas.javabakery.utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class KeranjangServiceImpl implements KeranjangService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    Produk produk;
    Akun akun;

    @Override
    public List<Keranjang> findAll(String username) {
        List<Keranjang> listKeranjang = new ArrayList<>();
        String sql = "SELECT id_data, id_produk, nama_produk, jumlah, harga, "
                + "(jumlah * harga) AS total, produk_image FROM keranjangmember" + username + " ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();   
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Keranjang keranjang = new Keranjang();
                keranjang.setIdPesanan(rs.getInt("id_data"));
                keranjang.setIdProduk(rs.getInt("id_produk"));
                keranjang.setNamaProduk(rs.getString("nama_produk"));
                keranjang.setJumlah(rs.getInt("jumlah"));
                keranjang.setHarga(rs.getDouble("harga"));
                keranjang.setTotal(rs.getDouble("total"));
                keranjang.setImage(rs.getBytes("produk_image"));
                
                listKeranjang.add(keranjang);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KeranjangServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return listKeranjang;
    }

    @Override
    public Integer addProduct(String username, Keranjang object) {
        int result = 0;
        String query = "";
        String sql = "INSERT INTO keranjangmember" + username 
                + "(id_data, id_produk, nama_produk, jumlah, harga, total, produk_image)"
                + " VALUES(NULL, "+object.getIdProduk()+", "
                + "'"+object.getNamaProduk()+"', "
                + "1, "+object.getHarga()+", "
                + object.getHarga() + ", "
                + "'"+Arrays.toString(object.getImage())+"')";
        /*String query = "INSERT INTO keranjangmember" + username 
                + "(id_data, id_produk, nama_produk, jumlah, harga, produk_image)"
                + " VALUES(NULL, "+object.getIdproduk()+", "
                + "'"+object.getNamaProduk()+"', "
                + "1, "+object.getHarga()+", "
                + "'"+Arrays.toString(object.getImage())+"')";*/
        /*String query = "INSERT INTO keranjangmember" + username 
                + "(id_data, id_produk, nama_produk, jumlah, harga, produk_image)"
                + " VALUES(NULL, 3, 'Kue', '1', 34500, 'abcd')";*/
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();    
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KeranjangServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return result;
    }

    @Override
    public Integer deleteProduct(String username, String id) {
        int result = 0;
        String sql = "DELETE FROM keranjangmember"+username+" WHERE id_produk="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer increaseQuantity(String username, String id) {
        int result = 0;
        String sql = "UPDATE keranjangmember"+username+" SET jumlah = jumlah+1 "
                + "WHERE id_produk="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer decreaseQuantity(String username, String id) {
        int result = 0;
        String sql = "UPDATE keranjangmember"+username+" SET jumlah = jumlah - 1 "
                + "WHERE id_produk="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Keranjang findProductID(String username, String name) {
        Keranjang keranjang = null;
        String sql = "SELECT id_data, id_produk, nama_produk, jumlah, harga, "
                + "(jumlah * harga) AS total, produk_image FROM keranjangmember" 
                + username + " WHERE "
                + "nama_produk LIKE '%"+name+"%'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();   
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                keranjang = new Keranjang();
                keranjang.setIdPesanan(rs.getInt("id_data"));
                keranjang.setIdProduk(rs.getInt("id_produk"));
                keranjang.setNamaProduk(rs.getString("nama_produk"));
                keranjang.setJumlah(rs.getInt("jumlah"));
                keranjang.setHarga(rs.getDouble("harga"));
                keranjang.setTotal(rs.getDouble("total"));
                keranjang.setImage(rs.getBytes("produk_image"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return keranjang;
    }

    @Override
    public List<Keranjang> sortByCondition1(String username) {
        List<Keranjang> listKeranjang = new ArrayList<>();
        String sql = "SELECT id_data, id_produk, nama_produk, jumlah, harga, "
                + "(jumlah * harga) AS total, produk_image FROM keranjangmember" + username 
                + " ORDER BY nama_produk ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Keranjang keranjang = new Keranjang();
                keranjang.setIdProduk(rs.getInt("id_produk"));
                keranjang.setNamaProduk(rs.getString("nama_produk"));
                keranjang.setJumlah(rs.getInt("jumlah"));
                keranjang.setHarga(rs.getDouble("harga"));
                keranjang.setTotal(rs.getDouble("total"));
                keranjang.setImage(rs.getBytes("produk_image"));
                
                listKeranjang.add(keranjang);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KeranjangServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKeranjang;
    }

    @Override
    public List<Keranjang> sortByCondition2(String username) {
        List<Keranjang> listKeranjang = new ArrayList<>();
        String sql = "SELECT id_data, id_produk, nama_produk, jumlah, harga, "
                + "(jumlah * harga) AS total, produk_image FROM keranjangmember" + username 
                + " ORDER BY harga ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Keranjang keranjang = new Keranjang();
                keranjang.setIdProduk(rs.getInt("id_produk"));
                keranjang.setNamaProduk(rs.getString("nama_produk"));
                keranjang.setJumlah(rs.getInt("jumlah"));
                keranjang.setHarga(rs.getDouble("harga"));
                keranjang.setTotal(rs.getDouble("total"));
                keranjang.setImage(rs.getBytes("produk_image"));
                
                listKeranjang.add(keranjang);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KeranjangServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKeranjang;
    }

    @Override
    public List<Keranjang> sortByCondition3(String username) {
        List<Keranjang> listKeranjang = new ArrayList<>();
        String sql = "SELECT id_data, id_produk, nama_produk, jumlah, harga, "
                + "(jumlah * harga) AS total, produk_image FROM keranjangmember" + username 
                + " ORDER BY jumlah ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Keranjang keranjang = new Keranjang();
                keranjang.setIdProduk(rs.getInt("id_produk"));
                keranjang.setNamaProduk(rs.getString("nama_produk"));
                keranjang.setJumlah(rs.getInt("jumlah"));
                keranjang.setHarga(rs.getDouble("harga"));
                keranjang.setTotal(rs.getDouble("total"));
                keranjang.setImage(rs.getBytes("produk_image"));
                
                listKeranjang.add(keranjang);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KeranjangServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKeranjang;
    }

    @Override
    public List<Keranjang> sortByCondition4(String username) {
        List<Keranjang> listKeranjang = new ArrayList<>();
        String sql = "SELECT id_data, id_produk, nama_produk, jumlah, harga, "
                + "(jumlah * harga) AS total, produk_image FROM keranjangmember" + username 
                + " ORDER BY total ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Keranjang keranjang = new Keranjang();
                keranjang.setIdProduk(rs.getInt("id_produk"));
                keranjang.setNamaProduk(rs.getString("nama_produk"));
                keranjang.setJumlah(rs.getInt("jumlah"));
                keranjang.setHarga(rs.getDouble("harga"));
                keranjang.setTotal(rs.getDouble("total"));
                keranjang.setImage(rs.getBytes("produk_image"));
                
                listKeranjang.add(keranjang);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KeranjangServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKeranjang;
    }

    @Override
    public Integer getJumlahProduct(String username, String id) {
        int result = 0;
        String sql = "SELECT jumlah FROM keranjangmember"+username
                + " WHERE id_produk="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
