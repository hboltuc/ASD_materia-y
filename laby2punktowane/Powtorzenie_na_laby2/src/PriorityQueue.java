public interface PriorityQueue<T extends Comparable<T>> {
    void insert(T value);
    T delMax();
    boolean isEmpty();
    int size();
}
