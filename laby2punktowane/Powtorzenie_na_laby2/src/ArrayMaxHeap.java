public class ArrayMaxHeap<T extends Comparable<T>>{
    private T[] A;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayMaxHeap(int capacity) {
        this.A = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }
    public void insert(T value) {
        // TODO: Zwiększ size, wstaw na koniec i wywołaj upHeap
        size++;
        A[size] = value;
        upHeap(size);
    }

    public T removeMax() {
        // TODO: Zapisz korzeń (indeks 1), wstaw ostatni element w miejsce korzenia,
        // zmniejsz size i wywołaj downHeap. Zwróć zapisany korzeń.
        T root = A[1];
        A[1] = A[size];
        size--;
        downHeap(1);
        return root;
    }

    private void upHeap(int i) {
        // Pętla działa dopóki nie jesteśmy w korzeniu (i > 1)
        // oraz dopóki obecny węzeł A[i] jest WIĘKSZY od swojego rodzica A[i / 2]
        while (i > 1 && A[i].compareTo(A[i / 2]) > 0) {

            // Zamieniamy element z rodzicem miejscami
            T temp = A[i];
            A[i] = A[i / 2];
            A[i / 2] = temp;

            // Przesuwamy indeks na pozycję rodzica, aby badać dalej w górę
            i = i / 2; //[cite: 10]
        }
    }

    private void downHeap(int i) {
        // TODO: Ustal większe dziecko (2*i lub 2*i + 1).
        // Jeśli dziecko jest większe od rodzica, zamień miejscami i wywołaj w dół.
        while (true) {
            if(size<2*i){ //jesli dzieci nie ma to przzerwij
                return;
            }
            int k = 2*i;
            if( 2*i+1<=size && A[2*i].compareTo(A[2*i+1]) < 0 ){ //jesli istnieje tez prawe dziecko to porownaj ktore jest wieksze
                k=2*i+1;
            }
            if(A[k].compareTo(A[i]) <= 0){// jesli wieksze dziecko jest mniejsze niz rodzic i to przerwij
                return;
            }
            T temp = A[i]; //zamien miejscami
            A[i] = A[k];
            A[k] = temp;

            i = k; //sprawdzamy teraz dla wnuczka
        }
    }


    public boolean isEmpty() {
        return size==0;
    }

    public int getSize() {
        return size;
    }
}

