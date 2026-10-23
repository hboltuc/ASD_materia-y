/**
 * Kolejka priorytetowa oparta na liście dwukierunkowej nieuporządkowanej.
 */
public class UnsortedDoubleListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private final DoubleList<T> list = new DoubleList<>();

    public UnsortedDoubleListPriorityQueue() {
        super();
    }

    @Override
    public void insert(T value) {
        list.addLast(value);
    }

    @Override
    public T delMax() {
        return list.removeMax();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.getSize();
    }
}
