/**
 * Kolejka priorytetowa oparta na liście dwukierunkowej nieuporządkowanej.
 */
public class UnsortedDoubleListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private final DoubleList<T> list = new DoubleList<>();

    @Override
    public void insert(T value) {
        list.insertFirst(value);
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T delMax() {
        return list.delMax();
    }


}