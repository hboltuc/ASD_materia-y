import java.util.NoSuchElementException;

/**
 * Lista dwukierunkowa niecykliczna z wskaźnikami na początek (head) i koniec (tail).
 */
public class DoubleList<T> {

    private static class Node<T> {
        private final T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private static <T> int compare(T a, T b) {
        return ((Comparable<T>) a).compareTo(b);
    }


    //Niezbędne metody:
    void addFirst(T value) {
        Node<T> p = new Node<>(value, head, null);
        if (head != null) {
            head.prev = p;
        } else {
            tail = p;
        }
        head = p;
        size++;
    }

    void addLast(T value) {
        Node<T> p = new Node<>(value);
        if (tail != null) {
            tail.next = p;
            p.prev = tail;
        } else {
            head = p;
        }
        size++;
        tail = p;
        // UWAGA:
        // Do porównywania 2 elementów typu T należy używać konstrukcji:
        //
        //    if ( compare(v1, v2) >= 0 )    - wartość dodatnia v1 > v2
    }

    T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return value;
    }

    T removeLast() {
        if (tail == null) {
            return null;
        }
        T value = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return value;
    }

    T getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }


    void addSorted(T value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node<T> p = head;
        while (p != null && compare(value, p.value) >= 0) {
            p = p.next;
        }

        if (p == head) {
            addFirst(value);
        } else if (p == null) {
            addLast(value);
        } else {
            Node<T> pNew = new Node<>(value);

            pNew.prev = p.prev;
            pNew.next = p;

            p.prev.next = pNew;
            p.prev = pNew;

            size++;
        }
    }

    T removeMax() {
        if (head == null) {
            return null; // Lista jest pusta
        }
        Node <T> pMax = head;
        Node <T> p = head.next;
        while (p != null ) {
            if (compare(p.value, pMax.value) > 0) {
                pMax = p;
            }
            p = p.next;
        }
        T maxValue = pMax.value;
        if (pMax == head) {
            removeFirst();
        } else if (pMax.next == null) {
            removeLast();
        } else {
            pMax.prev.next = pMax.next;
            pMax.next.prev = pMax.prev;

            size--;
        }
        return maxValue;
    }

    boolean isEmpty(){
        return head==null;
    }
    int getSize(){
        return size;
    }

}

