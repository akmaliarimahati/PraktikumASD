package Praktikum14;

import java.util.ArrayList;
import java.util.Collections;

public class SortingDemo04 {
    public static void main(String[] args) {
        // nomor 1
        // ArrayList<String> daftarSiswa = new ArrayList<>();
        // daftarSiswa.add("Zainab");
        // daftarSiswa.add("Andi");
        // daftarSiswa.add("Rara");
        // Collections.sort(daftarSiswa);

        // System.out.println(daftarSiswa);

        // nomor 2
        ArrayList<Customer04> customers = new ArrayList<>();
        customers.add(new Customer04(5, "Budi"));
        customers.add(new Customer04(1, "Zakia"));
        customers.add(new Customer04(4, "Cica"));

        customers.sort((c1, c2) -> c1.name.compareTo(c2.name));
        
        System.out.println(customers);
    }
}
