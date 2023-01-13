/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itenas.javabakery.service;

import com.itenas.javabakery.pojo.Keranjang;
import com.itenas.javabakery.pojo.Produk;
import com.itenas.javabakery.repository.CrudRepository;
import com.itenas.javabakery.repository.KeranjangRepository;

/**
 *
 * @author acer
 */
public interface KeranjangService extends KeranjangRepository<Keranjang, Integer>{
    
}
