/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.pojo;

/**
 *
 * @author Azzahra
 */
public class Member {
    private Integer id;
    private String namaMember;
    private int umurMember;
    private String alamatMember;
    private String noTelpMember;
    private Akun akunMember;
    private boolean loginStatus;

    public Member() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    public int getUmurMember() {
        return umurMember;
    }

    public void setUmurMember(int umurMember) {
        this.umurMember = umurMember;
    }

    public String getAlamatMember() {
        return alamatMember;
    }

    public void setAlamatMember(String alamatMember) {
        this.alamatMember = alamatMember;
    }

    public String getNoTelpMember() {
        return noTelpMember;
    }

    public void setNoTelpMember(String noTelpMember) {
        this.noTelpMember = noTelpMember;
    }

    public Akun getAkunMember() {
        return akunMember;
    }

    public void setAkunMember(Akun akunMember) {
        this.akunMember = akunMember;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }    
}
