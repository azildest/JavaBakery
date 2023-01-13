/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itenas.javabakery.repository;

import java.util.List;

/**
 *
 * @author acer
 * @param <T>
 * @param <ID>
 */
public interface KeranjangRepository <T, ID> {
    List<T> findAll(String username);
    List<T> findProductID(String username);
    List<T> sortByCondition1(String username);
    List<T> sortByCondition2(String username);
    List<T> sortByCondition3(String username);
    List<T> sortByCondition4(String username);
    ID addProduct(String username, T object);
    ID deleteProduct(String username, int id);
    ID increaseQuantity(String username, String id);
    ID decreaseQuantity(String username, int id);
}
