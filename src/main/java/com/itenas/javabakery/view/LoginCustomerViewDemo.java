/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Customer;
import com.itenas.javabakery.service.AkunService;
import com.itenas.javabakery.serviceimpl.AkunServiceImpl;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class LoginCustomerViewDemo {

    public static void login() {
        Scanner s = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        Customer customer;
        String username, password;
        boolean login = false;

        do {
            System.out.println("\n+-------------------------------------------+");
            System.out.println("|LOGIN CUSTOMER                                      |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            customer = akunService.login(username, password);
            if (customer != null) {
                login = true;
                customer.setLoginStatus(true);
                System.out.println("Login berhasil...!");
                System.out.println("");
                CustomerViewDemo.menuCustomer(customer);
            } else {
                System.out.println("Username atau password yang Anda masukkan salah, coba lagi...!");
            }
        } while (!login);
    }
}
