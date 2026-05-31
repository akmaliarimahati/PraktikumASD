package Pertemuan14;

public class BinaryTree04 {
    Node04 root;

    public BinaryTree04() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa04 mahasiswa) {
        Node04 newNode = new Node04(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node04 current = root;
            Node04 parent = null;

            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node04 current = root;

        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node04 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node04 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node04 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node04 getSuccessor(Node04 del) {
        Node04 successor = del.right;
        Node04 successorParent = del;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary Tree Kosong");
            return;
        }
        // cari node (current) yang akan dihapus
        Node04 parent = root;
        Node04 current = root;
        boolean isLeftChild = false;
        
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        
        // penghapusan
        if (current == null) {
            System.out.println("Data Tidak Ditemukan");
            return;
        } else {
            // jika tidak ada anak (leaf), maka node dihapus
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } 
            // jika hanya punya 1 anak (kanan)
            else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } 
            // jika hanya punya 1 anak (kiri)
            else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } 
            // jika punya 2 anak
            else {
                Node04 successor = getSuccessor(current);
                System.out.println("Jika 2 Anak, Current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }

    // nomor 1
    public void addRekursif(Mahasiswa04 mahasiswa) {
        root = addRekursif(root, mahasiswa);
    }

    private Node04 addRekursif(Node04 current, Mahasiswa04 mahasiswa) {
        if (current == null) {
            return new Node04(mahasiswa);
        }
        if (mahasiswa.ipk < current.mahasiswa.ipk) {
            current.left = addRekursif(current.left, mahasiswa);
        } else {
            current.right = addRekursif(current.right, mahasiswa);
        }
        return current;
    }

    // nomor 2
    public void cariMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree Kosong");
            return;
        }

        Node04 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.print("Mahasiswa IPK Terkecil: ");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree Kosong");
            return;
        }

        Node04 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.print("Mahasiswa IPK Terbesar: ");
        current.mahasiswa.tampilInformasi();
    }

    // nomor 3
    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        System.out.println("Daftar Mahasiswa Dengan IPK Diatas " + ipkBatas + ":");
        tampilIPKdiAtas(root, ipkBatas);
    }

    private void tampilIPKdiAtas(Node04 node, double ipkBatas) {
        if (node != null) {
            tampilIPKdiAtas(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilIPKdiAtas(node.right, ipkBatas);
        }
    }
}
