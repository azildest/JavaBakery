/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itenas.javabakery.repository;

import com.itenas.javabakery.pojo.Produk;
import java.util.List;

/**
 * @author Azzahra
 * @param <T>
 * @param <ID>
 */
 
public interface CrudRepository<T, ID> {
    List<T> findAll();
    List<T> findAllTersedia();
    ID create(T object);
    ID update(T object);
    T findByName(String name);
    T addProduct(String username, T object);
    T addAvailableProduct(String username, T object);
    T findByNama(String name);
    ID delete(int id);
    List<T> sortByCondition1();
    List<T> sortByCondition2();
    List<T> sortByCondition3();
    List<T> sortByCondition4();
}
