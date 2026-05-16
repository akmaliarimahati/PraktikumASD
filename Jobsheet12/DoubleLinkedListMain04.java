package Jobsheet12;

import java.util.Scanner;

public class DoubleLinkedListMain04 {
    // metthod untuk menambahkan data mahasiswa
    public static Mahasiswa04 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM   : ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama  : ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas : ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK   : ");
        double ipk = scan.nextDouble();
        scan.nextLine();

        // mengmbalikan nilai mahasiswa 04
        return new Mahasiswa04(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoubleLinkedList04 list = new DoubleLinkedList04();
        int pilihan;

        do {
            System.out.println("\n======== MENU DOUBLE LINKED LIST ==========");
            System.out.println("1. Tambah Data Di Awal");
            System.out.println("2. Tambah Data Di Akhir");
            System.out.println("3. Sisipkan Data Di Tengah (Setelah NIM)");
            System.out.println("4. Hapus Data Di Awal");
            System.out.println("5. Hapus Data Di Akhir");
            System.out.println("6. Tampilkan Data");
            System.out.println("7. Tampilkan Data Secara Terbalik");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    Mahasiswa04 mhsAwal = inputMahasiswa(scan);
                    list.addFirst(mhsAwal);
                    break;

                case 2:
                    Mahasiswa04 mhsAkhir = inputMahasiswa(scan);
                    list.addLast(mhsAkhir);
                    break;

                case 3:
                    System.out.print("Masukkkan NIM Yang Di Cari: ");
                    String keyNim = scan.nextLine();

                    System.out.println("Masukkan Data Baru: ");
                    Mahasiswa04 dataBaru = inputMahasiswa(scan);
                    list.insertAfter(keyNim, dataBaru);
                    break;

                // case 4:
                // list.removeFirst();
                // break;

                // case 5:
                // list.removeLast();
                // break;

                case 6:
                    list.print();
                    break;

                case 7:
                    list.printReserve();
                    break;

                case 0:
                    System.out.println("Program Selesai.");
                    break;

                default:
                    System.out.println("Menu Tidak Valid");
            }
        } while (pilihan != 0);
        scan.close();
    }
}
