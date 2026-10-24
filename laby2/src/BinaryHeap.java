public class BinaryHeap<T extends Comparable<T>>{

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size = 0;

    //konstruktory:
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
        this.elements[0] = Integer.MAX_VALUE;
    }

    public BinaryHeap(int capacity) {

        elements = new Object[capacity];
    }

    //prywatna metoda do pobierania elemntu tablicy pod indeksem i
    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        return (T) elements[index];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void upHeap(int i){
        T val = elementAt(i);
        while (i > 1 && val.compareTo((T) elementAt(i / 2)) > 0) {
            elements[i] = elements[i / 2];
            i = i / 2;
        }
        elements[i] = val;

    }

    public void insert(T val){
        size++;
        elements[size] = val;
        upHeap(size);

    }

    private void downHeap(int i, int n){
        while(true){
            if(2*i> n){
                return;
            }
            int k = 2*i;
            if(2*i <= n && elementAt(2*i+1).compareTo(elementAt(2*i)) > 0){
                k = 2*i +1;
            }
            if(elementAt(i).compareTo(elementAt(k)) >= 0){
                return;
            }
            T valK = elementAt(k);
            elements[k] = elements[i];
            elements[i] = valK;
            i = k;
        }
    }

    public T delMax(){
        if(isEmpty()){
            return null;
        }
        T valDel = elementAt(1);
        elements[1] = elements[size];
        size--;
        downHeap(1, size);
        return valDel;
    }

    public void createHeap1(T[] array){ // tworzenie kopca od gory O(nlogn)
        size = 0;
        elements[0] = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public void createHeap2(T[] array){ //tworzenie kopca od gory O(n)
        elements[0] = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            elements[i + 1] = array[i];
        }

        size = array.length;

        for (int i = size / 2; i >= 1; i--) { //zaczeynamy od ostatniego wezla posiadajacego dzieci
            downHeap(i, size);
        }

    }

    public T delete(int i){
        T valDel = elementAt(i);
        elements[i] = elementAt(size);
        elements[size] = null;
        size--;
       // Jeśli kopiec nie jest pusty i element jest większy od rodzica -> idzie w górę
        if (i > 1 && elementAt(i).compareTo(elementAt(i / 2)) > 0) {
            upHeap(i);
        }
        // W przeciwnym wypadku może musieć pójść w dół
        else if (i <= size) {
            downHeap(i, size);
        }

        return valDel;
    }

    public void Replace(int i, T val){
        elements[i] = val;
        if(i > 1 && elementAt(i).compareTo(elementAt(i / 2)) > 0){
            upHeap(i);
        } else if (i<= size) {
            downHeap(i, size);

        }

    }

    public void Replace(int i, int j){ // mozna zrobic sobie ta metode zeby uzywac w upHeap i downHeap
        T temp = elementAt(i);
        elements[i] = elementAt(j);
        elements[j] = temp;

    }

    public int search(T val) {//kopca nie da sie przeszukac szybciej niz O(n)

        for (int i = 1; i <= size; i++) {
            if (val.equals(elementAt(i))) {
                return i;
            }
        }
        return -1;
    }


}
