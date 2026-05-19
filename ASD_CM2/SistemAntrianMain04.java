package ASD_CM2;

import java.util.Scanner;

public class SistemAntrianMain04 {
    public static void main(String[] args) {
        // untuk menyimpan list antrian dan list laporan
        DoubleLinkedList04 listAntrian = new DoubleLinkedList04();
        DoubleLinkedList04 listLaporan = new DoubleLinkedList04();

        Scanner sc = new Scanner(System.in);
        // variable untuknomor urutu antrian secara otomaris
        int autoNoAntrian = 1;
        // ini untuk memilih menu
        int pilihan;

        // memsaukkan data awal melalui pembuatan object menggunakan konstruktor
        listAntrian.tambahAntrian(autoNoAntrian++, new Pembeli04("Ainra", "08224500000"));
        listAntrian.tambahAntrian(autoNoAntrian++, new Pembeli04("Danra", "08224511111"));
        listAntrian.tambahAntrian(autoNoAntrian++, new Pembeli04("Sanri", "08224522222"));

        // pemilihan menu
        do {
            System.out.println("\n=========================================");
            System.out.println("       SISTEM ANTRIAN ROYAL DELISH       ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    // menambahkan data antrian
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = sc.nextLine();

                    Pembeli04 pembeliBaru = new Pembeli04(nama, noHp);
                    listAntrian.tambahAntrian(autoNoAntrian, pembeliBaru);
                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + autoNoAntrian);
                    // menambahkan urut antrian
                    autoNoAntrian++;
                    break;

                case 2:
                    // menampilkan data antrean yang ada saat ini
                    listAntrian.cetakAntrian();
                    break;

                case 3:
                    // ini proses pemanggilan antrian ke kasir dari urut awal
                    Node04 antreanDipanggil = listAntrian.removeFirst();

                    if (antreanDipanggil != null) {
                        System.out.println("Memproses nomor antrean: " + antreanDipanggil.noAntrian + " atas nama: " + antreanDipanggil.pembeli.namaPembeli);

                        // input data makanan yang ingin dibeli pelanggan terpilih
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String menuMakan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();

                        // masukkan hasil input menu ke list laporan
                        Pesanan04 pesananBaru = new Pesanan04(kode, menuMakan, harga);
                        listLaporan.tambahPesanan(pesananBaru);

                        System.out.println(antreanDipanggil.pembeli.namaPembeli + " telah memesan " + menuMakan);
                    } else {
                        System.out.println("Tidak ada antrean pembeli saat ini!");
                    }
                    break;

                case 4:
                    // menampikan seluruh pesanan yang masuk dan diurukan berdasarkan nama pesanan
                    listLaporan.cetakLaporanPesanan();
                    break;

                case 0:
                    // menu untuk keluar dari program
                    System.out.println("Terima kasih telah menggunakan Sistem Royal Delish!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilihan != 0); 

        sc.close();
    }
}
