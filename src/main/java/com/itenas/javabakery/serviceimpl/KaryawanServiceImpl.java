/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl;

import com.itenas.javabakery.pojo.Karyawan;
import com.itenas.javabakery.service.KaryawanService;
import com.itenas.javabakery.utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                karyawan.setAlamatKaryawan(rs.getString("alamat"));
                karyawan.setNoTeleponKaryawan(rs.getString("no.telpon"));
                
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
        String sql = "INSERT INTO kARYAWAN(nama, umur, jenis_kelamin, alamat, nomor_telepon) "
                + "VALUES('"+object.getNamaKaryawan()+"', "
                + ""+object.getUmurKaryawan()+", "
                + "'"+object.getJenisKelamin()+"', "
                + "'"+object.getAlamatKaryawan()+"', "
                + "'"+object.getNoTeleponKaryawan()+"')";
        
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
                + "jenis_kelamin='"+object.getJenisKelamin()
                + "nomor_telepon='"+object.getNoTeleponKaryawan()+"', "
                + "alamat='"+object.getAlamatKaryawan()+"',"                
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
    public Karyawan findById(int id) {
        Karyawan karyawan = null;
        String sql = "SELECT * FROM karyawan WHERE id="+id+"";
        
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
}
   


    
