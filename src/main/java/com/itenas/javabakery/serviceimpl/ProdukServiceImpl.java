/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl;

import com.itenas.javabakery.pojo.Keranjang;
import com.itenas.javabakery.pojo.Produk;
import com.itenas.javabakery.service.ProdukService;
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
public class ProdukServiceImpl implements ProdukService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Produk> findAll() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Produk produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
                
                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listProduk;
    }

    @Override
    public Integer create(Produk object) {
        int result = 0;
        String sql = "INSERT INTO produk(nama, harga, status, produk_image) "
                + "VALUES('"+object.getNama()+"', "
                + ""+object.getHarga()+", "
                + "'"+object.getStatus()+"', "
                + "'"+Arrays.toString(object.getImage())+"')";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;    }

    @Override
    public Integer update(Produk object) {
        int result = 0;
        String sql = "UPDATE produk SET nama='"+object.getNama()+"',"
                + " harga="+object.getHarga()+","
                + " status='"+object.getStatus()+"',"
                + " produk_image='"+Arrays.toString(object.getImage())+"'"
                + " WHERE id_produk="+object.getId()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;    }

    @Override
    public Produk findByName(String name) {
        Produk produk = null;
        String sql = "SELECT * FROM produk WHERE nama LIKE '%"+name+"%' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return produk;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM produk WHERE id_produk="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<Produk> sortByCondition1() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE status = 'Tersedia'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Produk produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
                
                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listProduk;
    }
    
    @Override
    public List<Produk> sortByCondition2() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE status = 'Tidak Tersedia'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Produk produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
                
                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listProduk;
    }

    @Override
    public List<Produk> sortByCondition3() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE status = 'Tersedia' order by nama ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Produk produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
                
                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listProduk;
    }

    @Override
    public List<Produk> sortByCondition4() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE status = 'Tersedia' order by harga ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Produk produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
                
                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listProduk;
    }

    
    @Override
    public Produk findByNama(String name) {
        Produk produk = null;
        String sql = "SELECT * FROM produk WHERE nama LIKE '%"+name+"%' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return produk;
    }

    @Override
    public List<Produk> findAllTersedia() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk WHERE status = 'Tersedia' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Produk produk = new Produk();
                produk.setId(rs.getInt("id_produk"));
                produk.setNama(rs.getString("nama"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStatus(rs.getString("status"));
                produk.setImage(rs.getBytes("produk_image"));
                
                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listProduk;
    }

    @Override
    public Produk addProduct(String username, Produk object) {
        //int result = 0;
        Produk produk = null;
        String sql = "INSERT INTO keranjangmember" + username 
                + "(id_data, id_produk, nama_produk, jumlah, harga, produk_image)"
                + " VALUES(NULL, "+object.getId()+", "
                + "'"+object.getNama()+"', "
                + "1, "+object.getHarga()+", "
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
        
        return produk;
    }

    @Override
    public Produk addAvailableProduct(String username, Produk object) {
        Produk produk = null;
        /*String sql = "INSERT INTO keranjangmember" + username 
                + "(id_data, id_produk, nama_produk, jumlah, harga, produk_image)"
                + " VALUES(NULL, "+object.getId()+", "
                + "'"+object.getNama()+"', "
                + "1, "+object.getHarga()+", "
                + "'"+Arrays.toString(object.getImage())+"')";*/
        String sql = "UPDATE keranjangmember" + username
                + " SET jumlah = jumlah + 1 WHERE id_produk="
                + object.getId() + " ";
        
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
        
        return produk;
    }
}
