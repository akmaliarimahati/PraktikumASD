package Praktikum14;

import java.util.ArrayList;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<Customer04> customers = new ArrayList<>();

        ArrayList<Customer04> newCustomers = new ArrayList<>();
        newCustomers.add(new Customer04(201, "Della"));
        newCustomers.add(new Customer04(202, "Victor"));
        newCustomers.add(new Customer04(203, "Sarah"));

        customers.addAll(newCustomers);
        System.out.println(customers);

        // looping untuk mencetak data customers
        for (Customer04 cust : customers) {
            System.out.println(cust.toString());
        }

        // Customer04 customer1 = new Customer04(1, "Zakia");
        // Customer04 customer2 = new Customer04(5, "Budi");

        // customers.add(customer1);
        // customers.add(customer2);

        // customers.add(new Customer04(4, "Cica"));

        // // tambah object baru pada index tertentu
        // customers.add(2, new Customer04(100, "Rosa"));

        // // mengetahui posisi dari sutau onject
        // System.out.println(customers.indexOf(customer2));

        // // mengembalikan object index tertentu
        // Customer04 customer = customers.get(1);
        // System.out.println(customer.name);
        // customer.name = "Budi Utomo";
    }
}
