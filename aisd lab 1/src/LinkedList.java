import java.util.function.Consumer;

public class LinkedList<T extends Comparable<T>>{
    public static class Node<T>{
        private T val;
        private Node<T> next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }

    }
    private Node<T> head = null;
    private Node<T> tail = null;

    public LinkedList(T... values) {
        for (T val : values) {
            addLast(val);
        }
    }

    public void addFirst(T val) {
        Node<T> p = new Node<>(val);
        p.next = head;
        this.head = p;
        if (this.tail == null) {
            this.tail = p;
        }
    }

    public void addLast(T val) {
        Node<T> p = new Node<>(val);
        if (this.head == null) {
            this.head = p;
            this.tail = p;
        } else {
            this.tail.next = p;
            this.tail = p;
        }
    }

    public void forEach(Consumer<T> f){
        Node<T> p = head;
        while(p != null ) {
            f.accept((T) p.val);
            p = p.next;
        }

    }

    public void insert(Node n, int id){
        Node<T> p = head;
        for(int j = 0; j<id-1; j++){
            p = p.next;
        }
        n.next = p.next;
        p.next = n;

    }

    public Node<T> delMax(){
        if(head == null){
            return null;
        }else{
            Node<T> pMax = head;
            Node<T> p = head.next; // juz head jest jakby sprawdzony
            Node<T> ppMax = null;
            Node<T> pp = head;
            while(p != null){
                if(p.val.compareTo(pMax.val) > 0){
                    pMax = p;
                    ppMax = pp;
                }
                pp = p;
                p= p.next;

            }
            if (ppMax == null) {
                // Maksimum znajdowało się w głowie
                head = head.next;
            } else {
                // Maksimum znajdowało się w dalszej części listy
                ppMax.next = pMax.next;
            }
            pMax.next = null;

            return pMax;
        }

    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}