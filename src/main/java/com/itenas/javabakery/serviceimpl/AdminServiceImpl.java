/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl; 

import com.itenas.javabakery.pojo.Admin;
import com.itenas.javabakery.pojo.Akun;
import com.itenas.javabakery.service.AdminService;
import com.itenas.javabakery.utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class AdminServiceImpl implements AdminService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        Akun akun = null;
        String sql = "SELECT ad.id, ad.nama_depan, ad.nama_belakang, "
                + "ak.id_akun, ak.email, ak.username, ak.level "
                + "FROM admin ad, akun ak "
                + "WHERE ad.id_akun = ak.id_akun "
                + "AND ak.username = '" + username + "' "
                + "AND ak.password = '" + password + "'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setNamaDepan(rs.getString("nama_depan"));
                admin.setNamaBelakang(rs.getString("nama_belakang"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setLevel(rs.getString("level"));
                admin.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return admin;
    }
}
