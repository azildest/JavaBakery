/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.pojo;

/**
 *
 * @author acer
 */
public class Keranjang {
    String namaProduk;
    int idPesanan, idProduk, jumlah;
    double harga, total;
    byte[] image;

    public Keranjang() {
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getIdproduk() {
        return idProduk;
    }

    public void setIdproduk(int idproduk) {
        this.idProduk = idProduk;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(int idkeranjang) {
        this.idPesanan = idPesanan;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
