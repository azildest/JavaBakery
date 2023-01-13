/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.serviceimpl;

import com.itenas.javabakery.pojo.Member;
import com.itenas.javabakery.service.MemberService;
import com.itenas.javabakery.utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azzahra
 */
public class MemberServiceImpl implements MemberService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public List<Member> findAll() {
        List<Member> listMember = new ArrayList<>();
        String sql = "SELECT * FROM member";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setNamaMember(rs.getString("namaMember"));
                member.setUmurMember(rs.getInt("umurMember"));
                member.setAlamatMember(rs.getString("alamatMember"));
                member.setNoTelpMember(rs.getString("noTelpMember"));
                
                listMember.add(member);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listMember;
    }

    @Override
    public Integer create(Member object) {
    int result = 0;
        String sql = "INSERT INTO member VALUES"
                + "('" +object.getNamaMember()+"', "
                + ""+object.getUmurMember()+", "
                + "'"+object.getAlamatMember()+"', "
                + "'"+object.getNoTelpMember()+"')";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Member object) {
        int result = 0;
        String sql = "UPDATE member SET"
                + "namaMember='"+object.getNamaMember()+"', "
                + "umurMember="+object.getUmurMember()+", "
                + "alamatMember='"+object.getAlamatMember()+"',"
                + "noTelpMember='"+object.getNoTelpMember()+"'"
                + "WHERE id="+object.getId()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Member findByName(String name) {
        Member member = null;
        String sql = "SELECT * FROM member WHERE namaMember LIKE '%"+name+"%' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                member = new Member();
                member.setId(rs.getInt("id"));
                member.setNamaMember(rs.getString("namaMember"));
                member.setUmurMember(rs.getInt("umurMember"));
                member.setAlamatMember(rs.getString("alamatMember"));
                member.setNoTelpMember(rs.getString("noTelpMember"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return member;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM member WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Member> sortByCondition1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Member> sortByCondition2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Member> sortByCondition3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Member> sortByCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Member findByNama(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Member> findAllTersedia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Member addProduct(String username, Member object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Member addAvailableProduct(String username, Member object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}


