package ASD_CM2;

public class DoubleLinkedList04 {
    // pointer dari linked listnya head unrk paling deppan dn tail untuk paling akhir
    Node04 head; 
    Node04 tail; 
    // ini untuk menyimpan hitungan jumlah total node aktif saat ini
    int size = 0;

    // fungsi ini digunakan untuk memeriksa apakah linked list sedang kosong
    public boolean isEmpty() {
        return head == null;
    }

    // fungsi untuk menambahkan antrean pembeli baru di urutan paling belakang
    public void tambahAntrian(int noAntrian, Pembeli04 pembeli) {
        Node04 newNode = new Node04(noAntrian, pembeli); 
        
        if (isEmpty()) {
            // jika list dalam keaadan kosong, node baru langsung ditunjuk oleh head dan tail sekaligus
            head = tail = newNode;
        } else {
            // jika list sudah terisi, pasang node baru di belakang tail yang lama (proses masaingin prev sama next dari new node)
            tail.next = newNode; 
            newNode.prev = tail; 
            // menggeser tail ke node yang baru ditambahkan
            tail = newNode;
        }
        size++;
    }

    // fungsi untuk mencetak semua nomor antrean 
    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return;
        }
        System.out.println("=========================================");
        System.out.println("          Daftar Antrian Pembeli         ");
        System.out.println("=========================================");
        System.out.printf("%-12s %-15s %-15s\n", "No Antrian", "Nama", "No HP");
        
        // menampikan node dari head (traversal)
        Node04 current = head;
        while (current != null) {
            System.out.printf("%-12d", current.noAntrian);
            // memanggil method ini untuk meanggil data pembeli
            current.pembeli.tampilPembeli();
            // ini memanggil node setelahnya atau bergeser ke selanjutnya untuk menampilkan node yang lain
            current = current.next;
        }
    }

    // hapus antrean pembeli di posisi terdepan karena sudah dipanggil ke meja kasir
    public Node04 removeFirst() {
        if (isEmpty()) {
            return null; 
        }
        
        Node04 dipanggil = head;
        
        if (head == tail) {
            // jika isi list hanya ada satu maka mengkosonngkan head dan tail
            head = tail = null;
        } else {
            // jika lebih dari satu maka geser posisi head maju satu langkah ke belakang (memutus hubungan setelahnya head)
            head = head.next;
            // ini digunakan untuk memutus sambungan balik ke node yang lama/yang sudha dihapus
            head.prev = null;
        }
        size--;
        return dipanggil;
    }

    // memasukkan rekap data pesanan baru ke dalam linked list laporan pesanan
    public void tambahPesanan(Pesanan04 pesanan) {
        Node04 newNode = new Node04(pesanan);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // mengurutkan isi dari lisrt pesanan menggunakan bubble sort
    public void urutkanBerdasarkanNama() {
        // ini digunakan untuk ketika list data kosong atau cuman satu, jadi ga perlu mnegurutkn
        if (size <= 1) return;

        boolean swapped;
        do {
            // variable boolean bernilai false dan mulai dari data pertama atau head
            swapped = false;
            Node04 current = head;

            // selama data sekarang dan data depannya atau bersebalahan tidak sama dengan null
            while (current != null && current.next != null) {
                // membandingkan jika nama pesanan saat ini secara alfabetis lebih besar dari setelahnya, tukar posisi data
                if (current.pesanan.namaPesanan.compareToIgnoreCase(current.next.pesanan.namaPesanan) > 0) {
                    
                    // proses pemindahan dan penukaran objek pesanan antar node
                    Pesanan04 temp = current.pesanan;
                    current.pesanan = current.next.pesanan;
                    current.next.pesanan = temp;
                    // menandakan kalo sudah di tukar dan bernilai true
                    swapped = true;
                }
                // menggeser pengecekan ke data berikutnya
                current = current.next;
            }
            // perulangan luar diulangi terus sampai pertukaran data selesai
        } while (swapped); 
    }

    // mengurutkan lalu mencetak total laporan penjualan
    public void cetakLaporanPesanan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan yang direkap!");
            return;
        }
        // memanggil fungsi pengurutan berdasrkan nama
        urutkanBerdasarkanNama();

        System.out.println("==========================================================");
        System.out.println("           LAPORAN PESANAN (URUT NAMA PESANAN)            ");
        System.out.println("==========================================================");
        System.out.printf("%-15s %-20s %-15s %-10s\n", "Kode Pesanan", "Nama Pesanan", "Kategori", "Harga");
        
        Node04 current = head;
        // variable untuk uang masuk
        int totalPendapatan = 0;
        
        while (current != null) {
            // memanggil method ini untuk meanggil data pesanan
            current.pesanan.tampilPesanan();
            
            // menambahkan harga menu dari node saat ini ke dalam kas pendapatan
            totalPendapatan += current.pesanan.harga;
            current = current.next; 
        }
        System.out.println("==========================================================");
        System.out.println("Total Pendapatan Restoran: Rp " + totalPendapatan);
        System.out.println("==========================================================");
    }

    // tambah method untuk mencetak laporan per kategori
    public void cetakLaporanPerKategori() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan yang direkap!");
            return;
        }

        System.out.println("==========================================================");
        System.out.println("               LAPORAN PESANAN PER KATEGORI               ");
        System.out.println("==========================================================");

        // 1. Cetak Kelompok Makanan
        System.out.println("KATEGORI: MAKANAN");
        System.out.printf("%-15s %-20s %-15s %-10s\n", "Kode Pesanan", "Nama Pesanan", "Kategori", "Harga");
        System.out.println("----------------------------------------------------------");
        Node04 current = head;
        int subTotalMakanan = 0;
        while (current != null) {
            if (current.pesanan.kategori.equalsIgnoreCase("Makanan")) {
                current.pesanan.tampilPesanan();
                subTotalMakanan += current.pesanan.harga;
            }
            current = current.next;
        }
        System.out.println("Subtotal Makanan: Rp " + subTotalMakanan);
        System.out.println();

        // 2. Cetak Kelompok Minuman
        System.out.println("KATEGORI: MINUMAN");
        System.out.printf("%-15s %-20s %-15s %-10s\n", "Kode Pesanan", "Nama Pesanan", "Kategori", "Harga");
        System.out.println("----------------------------------------------------------");
        current = head;
        int subTotalMinuman = 0;
        while (current != null) {
            if (current.pesanan.kategori.equalsIgnoreCase("Minuman")) {
                current.pesanan.tampilPesanan();
                subTotalMinuman += current.pesanan.harga;
            }
            current = current.next;
        }
        System.out.println("Subtotal Minuman: Rp " + subTotalMinuman);
        System.out.println("==========================================================");
        System.out.println("Total Pendapatan Gabungan: Rp " + (subTotalMakanan + subTotalMinuman));
        System.out.println("==========================================================");
    }
}
