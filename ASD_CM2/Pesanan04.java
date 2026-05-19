package ASD_CM2;

public class Pesanan04 {
    // deklarasi ariabel penampung kode unik, nama menu makanan, dan harga jual
    int kodePesanan;
    String namaPesanan;
    int harga;

    // konstukrtor untuk menginisialisasi objek pesanan
    // parameter a untuk kode pesanan, b untuk nama makanan, d untuk harga
    public Pesanan04(int a, String b, int d) {
        this.kodePesanan = a;
        this.namaPesanan = b;
        this.harga = d;
    }

    // method untuk menampilkan data pesanan
    public void tampilPesanan() {
        System.out.printf("%-15d %-20s %-10d\n", kodePesanan, namaPesanan, harga);
    }
}
