public class BinaryHeapPiorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private BinaryHeap<T> heap = new BinaryHeap<T>();
    private int size;

    public BinaryHeapPiorityQueue() {
        this.heap = heap;
    }


    @Override
    public void insert(T value) {
        heap.insert(value);
    }

    @Override
    public T delMax() {
        return heap.delMax();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }



}
