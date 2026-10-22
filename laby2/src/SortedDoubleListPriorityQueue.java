
/**
 * Kolejka priorytetowa oparta na liście dwukierunkowej uporządkowanej wg priorytetów.
 */
public class SortedDoubleListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private final DoubleList<T> list = new DoubleList<>();

    @Override
    public void insert(T value) {
        list.insertSorted(value);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T delMax() {
        return null;
    }
}