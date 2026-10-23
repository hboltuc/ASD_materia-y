/**
 * Implementuje stos przy użyciu listy dwukierunkowej.
 */
public class DoubleListStack<T> implements Stack<T> {

    private final DoubleList<T> elements = new DoubleList<>();

    @Override
    public T pop() {
        return elements.removeFirst();
    }

    @Override
    public void push(T value) {
        elements.addFirst(value);
    }

    @Override
    public T peek() {
        return elements.getFirst();
    }

    @Override
    public int size() {
        return elements.getSize();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
