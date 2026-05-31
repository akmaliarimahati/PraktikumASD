package Pertemuan14;

public class BinarytreeArrayMain04 {
    public static void main(String[] args) {
        BinaryTreeArray04 bta = new BinaryTreeArray04();

        // Mahasiswa04 mhs1 = new Mahasiswa04("244160121", "Ali", "A", 3.57);
        // Mahasiswa04 mhs2 = new Mahasiswa04("244160185", "Candra", "C", 3.41);
        // Mahasiswa04 mhs3 = new Mahasiswa04("244160221", "Badar", "B", 3.75);
        // Mahasiswa04 mhs4 = new Mahasiswa04("244160220", "Dewi", "B", 3.35);
        // Mahasiswa04 mhs5 = new Mahasiswa04("244160131", "Devi", "A", 3.48);
        // Mahasiswa04 mhs6 = new Mahasiswa04("244160205", "Ehsan", "D", 3.61);
        // Mahasiswa04 mhs7 = new Mahasiswa04("244160170", "Fizi", "B", 3.86);

        // Mahasiswa04[] dataMahasiswa = { mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null };
        // int idxLast = 6;

        // bta.populateData(dataMahasiswa, idxLast);
        // System.out.println("\nInorder Traversal Mahasiswa: ");
        // bta.traverseInOrder(0);

        // percobaan tugas nomor 4
        bta.add(new Mahasiswa04("244160121", "Ali", "A", 3.57));
        bta.add(new Mahasiswa04("244160185", "Candra", "C", 3.41));
        bta.add(new Mahasiswa04("244160221", "Badar", "B", 3.75));
        bta.add(new Mahasiswa04("244160220", "Dewi", "B", 3.35));
        bta.add(new Mahasiswa04("244160131", "Devi", "A", 3.48));
        bta.add(new Mahasiswa04("244160205", "Ehsan", "D", 3.61));
        bta.add(new Mahasiswa04("244160170", "Fizi", "B", 3.86));

        System.out.println("\nInorder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);
        
        System.out.println("\nPreOrder Traversal Mahasiswa:");
        bta.traversePreOrder(0);
    }
}
