import javax.swing.text.Element;

/**
 * Implementuje kolejkę przy użyciu listy dwukierunkowej.
 */
public class DoubleListQueue<T> implements Queue<T> {

    private final DoubleList<T> elements = new DoubleList<>();

    public DoubleListQueue() {
        super();
    }

    @Override
    public void enqueue(T value) {
        elements.addLast(value);
    }

    @Override
    public T dequeue() {
        return elements.removeFirst();
    }

    @Override
    public T peek() {
        return elements.getFirst();
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
