package Jobsheet12;

public class DoubleLinkedList04 {
    Node04 head;
    Node04 tail;

    public DoubleLinkedList04() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa04 data) {
        Node04 newNode04 = new Node04(data);

        if (isEmpty()) {
            head = tail = newNode04;
        } else {
            newNode04.next = head;
            head.prev = newNode04;
            head = newNode04;
        }

    }

    public void addLast(Mahasiswa04 data) {
        Node04 newNode04 = new Node04(data);

        if (isEmpty()) {
            head = tail = newNode04;
        } else {
            tail.next = newNode04;
            newNode04.prev = tail;
            tail = newNode04;
        }

    }

    public void insertAfter(String keyNim, Mahasiswa04 data) {
        Node04 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data Dengan NIM " + keyNim + " Tidak Ditemukan");
            return;
        }

        Node04 newNode04 = new Node04(data);

        // jika current adalah tail, node baru ditmbahkan di akhir
        if (current == tail) {
            newNode04.prev = current;
            current.next = newNode04;
            tail = newNode04;
        } else { // node barus disisipkan di tengah
            newNode04.prev = current;
            newNode04.next = current.next;
            current.next.prev = newNode04;
            current.next = newNode04;
        }
        System.out.println("Data Berhasil DIsisipkan Setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List Masih Kosong");
            return;
        }

        Node04 current = head;
        while (current != null) {
            current.data.tampil();
            System.out.println();
            current = current.next;
        }
    }

    public void printReserve() {
        if (isEmpty()) {
            System.out.println("Linked List Masih Kosong");
            return;
        }

        Node04 current = tail;
        while (current != null) {
            current.data.tampil();
            System.out.println();
            current = current.prev;
        }
    }
}
