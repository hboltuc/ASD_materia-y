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

    public void upHeap(int i){
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

    public void downHeap(int i){
        while(true){
            if(2*i> size){
                return;
            }
            int k = 2*i;
            if(2*i <= size && elementAt(2*i+1).compareTo(elementAt(2*i)) > 0){
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
        downHeap(1);
        return valDel;
    }

}
