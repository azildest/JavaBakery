/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.repository; 

/**
 *
 * @author acer
 * @param <T>
 * @param <ID>
 */
public interface AkunRepository<T, ID> {
    T login(String username, String password);
    boolean register(String username, String password, String nama, String alamat, String noTelp);
    T update(String username, String password, int id);
}
