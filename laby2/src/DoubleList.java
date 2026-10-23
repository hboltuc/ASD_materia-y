import java.util.NoSuchElementException;

/**
 * Lista dwukierunkowa niecykliczna z wskaźnikami na początek (head) i koniec (tail).
 */
public class DoubleList<T> {

    public static class Node<T> {
        private final T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }

    Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private static <T> int compare(T a, T b) {
        return ((Comparable<T>) a).compareTo(b);
    }


    //Niezbędne metody:

    public void insertSorted(T val) {
        Node<T> pNew = new Node<>(val);

        // 1. Jeśli lista jest pusta
        if (head == null) {
            head = pNew;
            tail = pNew;
            size++;
            return;
        }

        // 2. Jeśli nowy element jest większy/równy obecnej głowie (wstawiamy na sam początek)
        if (compare(val, head.value) >= 0) {
            pNew.next = head;
            head.prev = pNew;
            head = pNew;
            size++;
            return;
        }

        // 3. Szukamy odpowiedniego miejsca wewnątrz listy
        Node<T> p = head;
        while (p != null) {
            if (compare(val, p.value) >= 0) {
                // Wstawiamy pNew *przed* węzeł p
                Node<T> pp = p.prev;

                pNew.next = p;
                pNew.prev = pp;

                pp.next = pNew;
                p.prev = pNew;

                size++;
                return;
            }
            p = p.next;
        }

        // 4. Jeśli dotarliśmy do końca i nic nie znaleźliśmy, wstawiamy na sam koniec (za tail)
        tail.next = pNew;
        pNew.prev = tail;
        tail = pNew;
        size++;
    }


    public int getSize(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public T delFirst(){
        if(head == null){
            return null;
        }else {
            T delVal = head.value;
            head = head.next;
            if(head == null){
                tail = null;
            }else {
                head.prev = null;
            }
            size--;
            return delVal;
        }


    }


    public void insertFirst(T val){
        Node<T> pNew = new Node<T>(val);
        if(head == null){
            head = pNew;
            tail = pNew;
            size++;
            return;
        }
        pNew.next = head;
        head.prev = pNew;
        head = pNew;
        size++;
    }


    public T delMax(){
        if(head == null){
            return null;
        }

        Node<T> p = head;
        Node<T> pMax = head;
        while(p!= null){
            if(compare(p.value, pMax.value) >= 0){
                pMax = p;
            }
            p = p.next;
        }

        T delVal = pMax.value;

        if(pMax == head){
            delFirst();
        }else {
            Node<T> pp = pMax.prev;
            Node<T> nn = pMax.next;

            pp.next = nn;

            if(nn != null){
                nn.prev = pp;
            } else {
                tail = pp;
            }

            pMax.prev = null;
            pMax.next = null;

            size--;
        }
        return delVal;
    }



    // UWAGA:
    // Do porównywania 2 elementów typu T należy używać konstrukcji:
    //    if ( compare(v1, v2) >= 0 )    - wartość dodatnia v1 > v2


}