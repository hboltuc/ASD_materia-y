public class LinkedList<T> {
    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public Node<T> head;
    public Node<T> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(T val) {
        Node<T> p = new Node<>(val);
        if (head == null) {
            head = p;
            tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    public void addFirst(T val) {
        Node<T> p = new Node<>(val);
        if (head == null) {
            head = p;
            tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    // Usuwa konkretny węzeł mając jego poprzednika (przydatne w extractMax)
    public void removeAfter(Node<T> prev) {
        if (head == null) return;

        if (prev == null) { // usuwamy head
            head = head.next;
            if (head == null) tail = null;
        } else if (prev.next != null) {
            if (prev.next == tail) tail = prev;
            prev.next = prev.next.next;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }
}