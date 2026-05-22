package ASD_CM2;

public class Pesanan04 {
    // deklarasi ariabel penampung kode unik, nama menu makanan, dan harga jual
    int kodePesanan;
    String namaPesanan;
    int harga;
    // modifikasi laporan pesanan per kategori
    String kategori; 

    // konstukrtor untuk menginisialisasi objek pesanan
    // parameter a untuk kode pesanan, b untuk nama makanan, d untuk harga
    // menambahkan string c untuk kategori
    public Pesanan04(int a, String b, int d, String c) {
        this.kodePesanan = a;
        this.namaPesanan = b;
        this.harga = d;
        this.kategori = c;
    }

    // method untuk menampilkan data pesanan
    public void tampilPesanan() {
        System.out.printf("%-15d %-20s %-15s %-10d\n", kodePesanan, namaPesanan, kategori, harga);
    }
}
