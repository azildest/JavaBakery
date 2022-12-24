/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Admin;
import com.itenas.javabakery.service.AdminService;
import com.itenas.javabakery.serviceimpl.AdminServiceImpl;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class LoginAdminViewDemo {

    public static void login() {
        Scanner s = new Scanner(System.in);
        AdminService adminService = new AdminServiceImpl();
        Admin admin;
        String username, password;
        boolean login = false;

        do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|LOGIN ADMIN                                |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            admin = adminService.login(username, password);
            if (admin != null) {
                login = true;
                admin.setLoginStatus(true);
                System.out.println("Login berhasil...!");
                System.out.println("");
                AdminViewDemo.menuAdmin(admin);
            } else {
                System.out.println("Username atau password yang Anda masukkan salah, coba lagi...!");
            }
        } while (!login);
    }
}
