/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.repository;

/**
 *
 * @author acer
 */
public interface AkunRepository<T, ID> {
    T login(String username, String password);
}
