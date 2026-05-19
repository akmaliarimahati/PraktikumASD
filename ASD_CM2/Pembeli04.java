package ASD_CM2;

public class Pembeli04 {
    // deklarasi variable unruk menyimoan nomor handpone dan pembeli
    String namaPembeli;
    String NoHp;

    // konstrktor untuk inisialisasi pembuatan objek
    // ini menyeuaikan dari diagram ya b untuk namaPembeli dan c untuk NoHp
    public Pembeli04(String b, String c) {
        this.namaPembeli = b;
        this.NoHp = c;
    }

    // method untuk menampilkan data pembeli
    public void tampilPembeli() {
        System.out.printf(" %-15s %-15s\n", namaPembeli, NoHp);
    }
}
