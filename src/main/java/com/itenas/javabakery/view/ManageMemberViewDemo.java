/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itenas.javabakery.view;

import com.itenas.javabakery.pojo.Member;
import com.itenas.javabakery.service.MemberService;
import com.itenas.javabakery.serviceimpl.MemberServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Azzahra
 */
class ManageMemberViewDemo {
    static List<Member> listMember = new ArrayList<>();
    static Member member;
    static MemberService memberService;
    static Scanner scanner;
    
    public static void menuMember (Member member){
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;

        do {
            System.out.println("+--------------------------------------");
            System.out.println("|            MANAGE MEMBER             |");
            System.out.println("+--------------------------------------");
            System.out.println("Selamat datang " + member.getAkunMember().getUsername());
            System.out.println("[1] Create Member");
            System.out.println("[2] Update Member");
            System.out.println("[3] Delete Member");
            System.out.println("[4] Display All Member");
            System.out.println("[5] Find Member by ID");
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            
            switch (menu) {
                case 1:
                    System.out.println("Anda memilih pilihan 1");
                    char tampil;
                    member = new Member();
                    insertMember(member); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        memberService = new MemberServiceImpl();
                        listMember = memberService.findAll();
                        findAllMember(listMember);
                    }
                break;
                case 2:
                    System.out.println("Anda memilih pilihan 2");
                    int updatedId;
                    Member updatedMember = new Member();
                    System.out.println("Masukkan ID: ");
                    updatedId = scanner.nextInt();
                    updatedMember = findMember(updatedId);
                    System.out.println("Data dokter yang akan diupdate: ");
                    if (updatedMember != null) {
                        System.out.println("ID: " + updatedMember.getId());
                        System.out.println("Nama: " + updatedMember.getNamaMember());
                        System.out.println("Umur: " + updatedMember.getUmurMember());
                        System.out.println("Alamat: " + updatedMember.getAlamatMember());
                        System.out.println("No Telepon: " + updatedMember.getNoTelpMember());
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editMember(updatedMember.getId());
                break;
                case 3:
                    System.out.println("Anda memilih pilihan 3");
                    int deletedId;
                    Member deletedMember = new Member();
                    char confirmation;
                    memberService = new MemberServiceImpl();
                    
                    System.out.println("Masukkan ID: ");
                    deletedId = scanner.nextInt();
                    deletedMember = findMember(deletedId);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedMember != null) {
                            memberService.delete(deletedId);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;
                case 4:
                    System.out.println("Anda memilih pilihan 4");
                    memberService = new MemberServiceImpl();
                    listMember = memberService.findAll();
                    findAllMember(listMember);
                break;
                case 5:
                    System.out.println("Anda memilih pilihan 5");
                    int searchedId;
                    Member searchedMember = new Member();
                    System.out.println("Masukkan ID: ");
                    searchedId = scanner.nextInt();
                    searchedMember = findMember(searchedId);
                    if (searchedMember != null) {
                        System.out.println("-----------------------------------------------");
                        System.out.println("ID     : " + searchedMember.getId());
                        System.out.println("Nama   : " + searchedMember.getNamaMember());
                        System.out.println("Umur   : " + searchedMember.getUmurMember());
                        System.out.println("Alamat : " + searchedMember.getAlamatMember());
                        System.out.println("Telepon: " + searchedMember.getNoTelpMember());
                        System.out.println("-----------------------------------------------");
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
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

    private static void insertMember(Member member) {
        scanner = new Scanner(System.in);
        memberService = new MemberServiceImpl();
        String namaMember, noTelpMember, alamatMember;
        int umurMember, result;
        
        System.out.println("Nama: ");
        namaMember = scanner.nextLine();
        System.out.println("Umur: ");
        umurMember = scanner.nextInt();
        System.out.println("Alamat: ");
        alamatMember = scanner.nextLine();
        System.out.println("No Telepon: ");
        noTelpMember = scanner.nextLine();
        
        member.setNamaMember(namaMember);
        member.setUmurMember(umurMember);
        member.setAlamatMember(alamatMember);
        member.setNoTelpMember(noTelpMember);
        
        result = memberService.create(member);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }

    private static void findAllMember(List<Member> listMember) {
    for (Member member : listMember) {
            System.out.println("-----------------------------------------------");
            System.out.println("ID     : " + member.getId());
            System.out.println("Nama   : " + member.getNamaMember());
            System.out.println("Umur   : " + member.getUmurMember());
            System.out.println("Alamat : " + member.getAlamatMember());
            System.out.println("Telepon: " + member.getNoTelpMember());
            System.out.println("-----------------------------------------------");
            System.out.println("");
        }
    }

    private static Member findMember(int updatedId) {
        member = new Member();
        memberService = new MemberServiceImpl();
        member = memberService.findById(updatedId);
    
        return member;
    }

    private static void editMember(int id) {
        scanner = new Scanner(System.in);
        memberService = new MemberServiceImpl();
        String namaMember, noTelpMember, alamatMember;
        int umurMember;
        
        System.out.println("Nama: ");
        namaMember = scanner.nextLine();
        System.out.println("Umur: ");
        umurMember = scanner.nextInt();
        System.out.println("Alamat: ");
        alamatMember = scanner.nextLine();
        System.out.println("No Telepon: ");
        noTelpMember = scanner.nextLine();
        
        member.setId(id);
        member.setNamaMember(namaMember);
        member.setUmurMember(umurMember);
        member.setAlamatMember(alamatMember);
        member.setNoTelpMember(noTelpMember);
        
        memberService.update(member);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }
}