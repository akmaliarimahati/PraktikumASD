package ASD_CM2;

public class Node04 {
    // dejkarasi variable untuk menampuung nomor urut antrean pembeli
    int noAntrian;

    // objek referensi untuk data pembeli dan pesanan
    Pembeli04 pembeli;
    Pesanan04 pesanan;

    // pointer penghubung antar node secara dua arah yaitu ke depan atau sebelum dan ke belakang atau sesudah
    Node04 prev;
    Node04 next;

    // konstruktor khusus saat node diisi oleh data dari antrean pembeli
    public Node04(int noAntrian, Pembeli04 pembeli) {
        this.noAntrian = noAntrian;
        this.pembeli = pembeli;
        this.prev = null;
        this.next = null;
    }

    // Konstruktor khusus saat node diisi oleh rekapan pesananan 
    public Node04(Pesanan04 pesanan) {
        this.pesanan = pesanan;
        this.prev = null;
        this.next = null;
    }
}
