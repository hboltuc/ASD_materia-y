/**
 * Kolejka priorytetowa oparta na liście dwukierunkowej uporządkowanej wg priorytetów.
 */
public class SortedDoubleListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private final DoubleList<T> list = new DoubleList<>();

    public SortedDoubleListPriorityQueue() {
        super();
    }

    @Override
    public void insert(T value) {
        list.addSorted(value);
    }

    @Override
    public T delMax() {
        return list.removeLast();
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
