/**
 * Określa operacje kolejki działającej zgodnie z zasadą FIFO.
 */
public interface Queue<T> {

    /**
     * Dodaje element na końcu kolejki.
     */
    void enqueue(T value);

    /**
     * Usuwa i zwraca element z początku kolejki.
     */
    T dequeue();

    /**
     * Zwraca element z początku bez usuwania go.
     */
    T peek();

    /**
     * Sprawdza, czy kolejka nie zawiera elementów.
     */
    boolean isEmpty();

    /**
     * Zwraca liczbę elementów kolejki.
     */
    int size();
}
