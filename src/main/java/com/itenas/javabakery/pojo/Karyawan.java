/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.pojo;

/**
 *
 * @author nika yulia R
 */
public class Karyawan {
    private int id;
    private String namaKaryawan;
    private String jenisKelamin;
    private int umurKaryawan;
    private String AlamatKaryawan;
    private String noTeleponKaryawan;

    public Karyawan() {
    }
    

    public Karyawan(int id, String namaKaryawan, String jenisKelamin, int umurKaryawan, String AlamatKaryawan, String noTeleponKaryawan) {
        this.id = id;
        this.namaKaryawan = namaKaryawan;
        this.jenisKelamin = jenisKelamin;
        this.umurKaryawan = umurKaryawan;
        this.AlamatKaryawan = AlamatKaryawan;
        this.noTeleponKaryawan = noTeleponKaryawan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getUmurKaryawan() {
        return umurKaryawan;
    }

    public void setUmurKaryawan(int umurKaryawan) {
        this.umurKaryawan = umurKaryawan;
    }

    public String getAlamatKaryawan() {
        return AlamatKaryawan;
    }

    public void setAlamatKaryawan(String AlamatKaryawan) {
        this.AlamatKaryawan = AlamatKaryawan;
    }

    public String getNoTeleponKaryawan() {
        return noTeleponKaryawan;
    }

    public void setNoTeleponKaryawan(String noTeleponKaryawan) {
        this.noTeleponKaryawan = noTeleponKaryawan;
    }
    
    
    
    
    
    
    
    
}
