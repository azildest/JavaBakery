/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Member;
import com.itenas.javabakery.service.AkunService;
import com.itenas.javabakery.serviceimpl.AkunServiceImpl;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class LoginMemberViewDemo {
       
    public static void login() {
        Scanner s = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        Member member;
        String username, password;
        boolean login = false;

        do {
            System.out.println("+-------------------+");
            System.out.println("|   LOGIN Member    |");
            System.out.println("+-------------------+");
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("+-------------------+");
            System.out.println();
            member = akunService.login(username, password);
            if (member != null) {
                login = true;
                member.setLoginStatus(true);
                System.out.println("Login berhasil");
                System.out.println("");
                MemberViewDemo.menuMember(member);
            } else {
                System.out.println("Username atau Password yang Anda masukkan salah");
            }
        } while (!login);
    }
}

