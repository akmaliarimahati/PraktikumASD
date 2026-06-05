package Praktikum14;

import java.util.ArrayList;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<Customer04> customers = new ArrayList<>(2);

        Customer04 customer1 = new Customer04(1, "Zakia");
        Customer04 customer2 = new Customer04(5, "Budi");

        customers.add(customer1);
        customers.add(customer2);

        customers.add(new Customer04(4, "Cica"));

        // looping untuk mencetak data customers
        for (Customer04 cust : customers) {
            System.out.println(cust.toString());
        }
    }
}
