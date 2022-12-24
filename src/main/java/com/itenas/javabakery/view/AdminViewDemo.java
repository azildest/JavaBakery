/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Admin;
import java.util.Scanner;

/**
 *
 * @author Kurnia R. Putra
 */
public class AdminViewDemo {
    public static void menuAdmin(Admin admin) {
        int menu = 0;
        boolean keluar = false; 
        char pilihan;
        Scanner scanner;

        do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD");
            System.out.println("+--------------------------------------");
            System.out.println("Selamat datang: " + admin.getAkun().getUsername());
            System.out.println("[1] Manage Karyawan");
            System.out.println("[2] Manage Produk");
            System.out.println("[3] Manage Customer");
            System.out.println("[4] Rekap Penjualan");
            System.out.println("[5] Logout");
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            
            switch (menu) {
                case 1:
                    ManageKaryawanViewDemo.viewManageKaryawan();
                break;
                case 2:
                    ManageProdukViewDemo.viewManageProduk();
                break;
                case 3:
                    ManageCustomerViewDemo.viewManageCustomer();
                break;
                case 4:
                    RekapPenjualanViewDemo.viewRekapPenjualan();
                break;
                case 5:
                    System.out.println("");
                    
                    System.out.println("Apakah ingin logout? [y/n]: ");
                    scanner = new Scanner(System.in);
                    pilihan = scanner.next().charAt(0);
                    if (pilihan == 'y' || pilihan == 'Y') {
                        admin.setLoginStatus(false);
                        System.out.println("Logout!");
                        LandingPageViewDemo.landingPage();
                    }
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
        } while (admin.getLoginStatus());
        System.out.println("Terima kasih sudah menggunakan aplikasi.");
        System.exit(0);
    }
}
