public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    ArrayMaxHeap<T> elements = new ArrayMaxHeap<>(100);

    public HeapPriorityQueue() {
        super();
    }

    @Override
    public T delMax() {
        return elements.removeMax();
    }

    @Override
    public void insert(T value) {
        elements.insert(value);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.getSize();
    }
}
