public class BinarySearchTree<T extends Comparable<T>>{
    public static class Node<T>{
        private T val;
        private Node<T> left;
        private Node<T> right;

        public Node(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
// w BTS lewy lisc jest zawsze  od rodzica a prawy zawsze wiekszy


    private Node<T> root;
    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void printAll(Node<T> start){
        if(start == null){
            return;
        }
        printAll(start.left);
        printAll(start.right);
        System.out.println(start.val);
    }

    public void insert(T val){
        root = insertRecursive(root, val);
    }

    private Node<T> insertRecursive(Node<T> current, T val){
        if (current == null) {
            return new Node<T>(val);
        }

        int cmp = val.compareTo(current.val);

        if (cmp < 0) {
            // Wartość mniejsza -> idziemy w lewo
            current.left = insertRecursive(current.left, val);
        } else if (cmp > 0) {
            // Wartość większa -> idziemy w prawo
            current.right= insertRecursive(current.right, val);
        }
        return current;
    }

    public boolean search(T val){
        Node<T> current = root;

        while (current != null) {
            int cmp = val.compareTo(current.val);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public void delete(T val) {
        root = deleteRecursive(root, val);
    }

    // 2. Metoda rekurencyjna
    private Node<T> deleteRecursive(Node<T> current, T val) {
        // Warunek stopu: nie znaleźliśmy elementu
        if (current == null) {
            return null;
        }

        int cmp = val.compareTo(current.val);

        // Szukamy elementu (schodząc w lewo lub prawo)
        if (cmp < 0) {
            current.left = deleteRecursive(current.left, val);
            return current;
        } else if (cmp > 0) {
            current.right = deleteRecursive(current.right, val);
            return current;
        }

        // ZNALEŹLIŚMY WĘZEŁ DO USUNIĘCIA (cmp == 0)

        // Przypadek 1 i 2: Węzeł ma tylko jedno dziecko lub nie ma wcale
        if (current.left == null) {
            return current.right; // Zwracamy prawe dziecko (lub null, jeśli to liść)
        } else if (current.right == null) {
            return current.left;  // Zwracamy lewe dziecko
        }

        // Przypadek 3: Węzeł ma dwoje dzieci
        // Szukamy najmniejszej wartości w prawym poddrzewie
        T smallestValue = findSmallestValue(current.right);

        // Podmieniamy wartość w usuwanym węźle
        current.val = smallestValue;

        // Usuwamy oryginalny węzeł, z którego wzięliśmy wartość
        current.right = deleteRecursive(current.right, smallestValue);

        return current;
    }

    // 3. Metoda pomocnicza: znajduje najmniejszy element w poddrzewie to bedzie nastepnik zeby dzrewo nadal bylo BST
    private T findSmallestValue(Node<T> root) {
        // Idziemy maksymalnie w lewo, dopóki się da (iteracyjnie, bo tak szybciej)
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

// find min --> idzie caly czas w lewo do oporu
// find max --> idzie caly czas w prawo do oporu


    public int height() {// w drzewie wysokosc to liczba krawedzi miedzy rootem a ostanim elementem
        return heightRecursive(root);
    }

    private int heightRecursive(Node<T> current) {
        if (current == null) {
            // Zwracamy -1, jeśli wysokość mierzymy w krawędziach (korzeń bez dzieci ma wysokość 0).
            // Zmień na 0, jeśli wolicie na zajęciach mierzyć wysokość w liczbie węzłów (poziomów).
            return -1;
        }

        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void printLevelOrder(){
        if (root == null) {
            return;
        }

        // Tworzymy Twoją listę i typujemy ją na węzły drzewa BST
        DoubleList<Node<T>> queue = new DoubleList<>();
        queue.insertLast(root);

        while (!queue.isEmpty()) {
            // Pobieramy i usuwamy pierwszy element (delFirst zachowuje logikę FIFO)
            Node<T> current = queue.delFirst();
            System.out.print(current.val + " ");

            // Dodajemy dzieci na koniec kolejki (insertLast)
            if (current.left != null) {
                queue.insertLast(current.left);
            }
            if (current.right != null) {
                queue.insertLast(current.right);
            }
        }
        System.out.println();

    }




}
