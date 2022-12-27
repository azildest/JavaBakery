/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl; 

import com.itenas.javabakery.pojo.Akun;
//import com.itenas.javabakery.pojo.Member/Customer;
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
 * @author Kurnia R. Putra
 */
public class AkunServiceImpl implements AkunService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public Customer login(String username, String password) {
        Customer customer = null;
        Akun akun = null;
        String sql = "SELECT d.id, d.nama, a.id_akun, a.email, a.username, "
                + "a.password, a.level FROM customer d, akun a "
                + "WHERE d.id_akun = a.id_akun "
                + "AND a.username = '"+username+"' "
                + "AND a.password = '"+password+"'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setNama(rs.getString("nama"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setLevel(rs.getString("level"));
                customer.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return customer;
    }
    
}
