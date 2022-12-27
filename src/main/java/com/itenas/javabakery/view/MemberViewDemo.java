/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Member;
import java.util.Scanner;

/**
 *
 * @author Azzahra
 */
class MemberViewDemo {
    public static void menuMember (Member member){
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;

        do {
            System.out.println("+--------------------------------------");
            System.out.println("|          MEMBER DASHBOARD            |");
            System.out.println("+--------------------------------------");
            System.out.println("Selamat datang " + member.getAkunMember().getUsername());
            System.out.println("[1] Lihat Produk");
            System.out.println("[2] ");
            System.out.println("[3] ");
            System.out.println("[4] Logout");
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            
            switch (menu) {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                    System.out.println("");
                    System.out.println("Apakah ingin logout? [y/n]: ");
                    scanner = new Scanner(System.in);
                    pilihan = scanner.next().charAt(0);
                    if (pilihan == 'y' || pilihan == 'Y') {
                        member.setLoginStatus(false);
                        System.out.println("Logout!");
                        LandingPageViewDemo.landingPage();
                    }
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
        } while (member.isLoginStatus());
        System.out.println("Terima kasih sudah menggunakan aplikasi.");
        System.exit(0);
    }
}