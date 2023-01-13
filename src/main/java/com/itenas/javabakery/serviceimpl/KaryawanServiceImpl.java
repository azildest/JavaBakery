/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl;

import com.itenas.javabakery.pojo.Karyawan;
import com.itenas.javabakery.pojo.Produk;
import com.itenas.javabakery.service.KaryawanService;
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
 * @author user
 */
public class KaryawanServiceImpl implements KaryawanService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Karyawan> findAll() {
        List<Karyawan> listKaryawan = new ArrayList<>();
        String sql = "SELECT * FROM karyawan";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();   
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Karyawan karyawan = new Karyawan();
                karyawan.setId(rs.getInt("id"));
                karyawan.setNamaKaryawan(rs.getString("nama"));
                karyawan.setUmurKaryawan(rs.getInt("umur"));
                karyawan.setJenisKelamin(rs.getString("jenis_kelamin"));
                karyawan.setNoTeleponKaryawan(rs.getString("nomor_telepon"));
                karyawan.setAlamatKaryawan(rs.getString("alamat"));
                karyawan.setImage(rs.getBytes("karyawan_image"));
                
                listKaryawan.add(karyawan);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return listKaryawan;
    }

    @Override
    public Integer create(Karyawan object) {
        int result = 0;
        String sql = "INSERT INTO kARYAWAN(nama, umur, jenis_kelamin, nomor_telepon, alamat, karyawan_image) "
                + "VALUES('"+object.getNamaKaryawan()+"', "
                + ""+object.getUmurKaryawan()+", "
                + "'"+object.getJenisKelamin()+"', "
                + "'"+object.getNoTeleponKaryawan()+"', "
                + "'"+object.getAlamatKaryawan()+"', "
                + "'"+Arrays.toString(object.getImage())+"')";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();    
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return result;
    }
   
    @Override
    public Integer update(Karyawan object) {
        int result = 0;
        String sql = "UPDATE karyawan SET nama='"+object.getNamaKaryawan()+"', "
                + "umur="+object.getUmurKaryawan()+", "
                + "jenis_kelamin='"+object.getJenisKelamin()+"', "
                + "nomor_telepon='"+object.getNoTeleponKaryawan()+"', "
                + "alamat='"+object.getAlamatKaryawan()+"', "
                + "karyawan_image='"+Arrays.toString(object.getImage())+"' "
                + "WHERE id="+object.getId()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        return result; 
    }
        
    @Override
    public Karyawan findByName(String name) {
        Karyawan karyawan = null;
        String sql = "SELECT * FROM karyawan WHERE nama LIKE '%"+name+"%' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
           
            while (rs.next()) {
                karyawan = new Karyawan();
                karyawan.setId(rs.getInt("id"));
                karyawan.setNamaKaryawan(rs.getString("nama"));
                karyawan.setUmurKaryawan(rs.getInt("umur"));
                karyawan.setJenisKelamin(rs.getString("jenis_kelamin"));
                karyawan.setNoTeleponKaryawan(rs.getString("nomor_telepon"));
                karyawan.setAlamatKaryawan(rs.getString("alamat"));
                karyawan.setImage(rs.getBytes("karyawan_image"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        return karyawan;
    }    

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM karyawan WHERE id="+id+"";
        
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
    public List<Karyawan> sortByCondition1() {
        List<Karyawan> listKaryawan = new ArrayList<>();
        String sql = "SELECT * FROM karyawan order by nama ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Karyawan karyawan = new Karyawan();
                karyawan.setId(rs.getInt("id_karyawan"));
                karyawan.setNamaKaryawan(rs.getString("nama"));
                karyawan.setUmurKaryawan(rs.getInt("umur"));
                karyawan.setJenisKelamin(rs.getString("jenis_kelamin"));
                karyawan.setNoTeleponKaryawan(rs.getString("nomor_telepon"));
                karyawan.setAlamatKaryawan(rs.getString("alamat"));
                karyawan.setImage(rs.getBytes("karyawan_image"));
                
                listKaryawan.add(karyawan);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKaryawan;
    }

    @Override
    public List<Karyawan> sortByCondition2() {
        List<Karyawan> listKaryawan = new ArrayList<>();
        String sql = "SELECT * FROM karyawan order by umur ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Karyawan karyawan = new Karyawan();
                karyawan.setId(rs.getInt("id_karyawan"));
                karyawan.setNamaKaryawan(rs.getString("nama"));
                karyawan.setUmurKaryawan(rs.getInt("umur"));
                karyawan.setJenisKelamin(rs.getString("jenis_kelamin"));
                karyawan.setNoTeleponKaryawan(rs.getString("nomor_telepon"));
                karyawan.setAlamatKaryawan(rs.getString("alamat"));
                karyawan.setImage(rs.getBytes("karyawan_image"));
                
                listKaryawan.add(karyawan);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listKaryawan;
    }

    @Override
    public List<Karyawan> sortByCondition3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Karyawan> sortByCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Karyawan findByNama(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Karyawan> findAllTersedia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Karyawan addProduct(String username, Karyawan object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Karyawan addAvailableProduct(String username, Karyawan object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   


    
