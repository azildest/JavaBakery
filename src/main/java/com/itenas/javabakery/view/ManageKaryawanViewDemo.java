 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Karyawan;
import com.itenas.javabakery.service.KaryawanService;
import com.itenas.javabakery.serviceimpl.KaryawanServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ManageKaryawanViewDemo {
    static List<Karyawan> listKaryawan = new ArrayList<>();
    static Karyawan karyawan;
    static KaryawanService karyawanService;
    static Scanner scanner;
    
     public static void viewManageKaryawan() {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;
        
        do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | KARYAWAN MANAGEMENT");
            System.out.println("+--------------------------------------");
            System.out.println("1. Create Karyawan");
            System.out.println("2. Update Karyawan");
            System.out.println("3. Delete Karyawan");
            System.out.println("4. Display All Karyawan");
            System.out.println("5. Find Karyawan by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("1");
                break;
                case 2:
                    System.out.println("2");
                break;
                case 3:
                    System.out.println("3");
                break;
                case 4:
                    karyawanService = new KaryawanServiceImpl();
                    listKaryawan = karyawanService.findAll();
                    findAllKaryawan(listKaryawan);
                break;
                case 5:
                    System.out.println("5");
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
            System.out.println("");
            System.out.println("Apakah ingin melanjutkan? y/n: ");
            scanner = new Scanner(System.in);
            pilihan = scanner.next().charAt(0);
            if (pilihan == 'n' || pilihan == 'N') {
                keluar = true;
            }
            
        } while (!keluar);
        System.out.println("Kembali ke menu utama!");
    }

    private static void findAllKaryawan(List<Karyawan> listKaryawan) {
        for (Karyawan karyawan : listKaryawan) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ID Karyawan\t: " + karyawan.getId());
            System.out.println("Nama Karyawan\t: " + karyawan.getNamaKaryawan());
            System.out.println("Umur\t\t: " + karyawan.getUmurKaryawan());
            System.out.println("Alamat\t\t: " + karyawan.getAlamatKaryawan());
            System.out.println("No.Telepon\t: " + karyawan.getNoTeleponKaryawan());
            System.out.println("jenisKelamin\t: " + karyawan.getJenisKelamin());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }   
    } 
}
