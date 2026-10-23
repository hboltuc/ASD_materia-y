/**
 * Określa operacje kolejki priorytetowej (element o największym priorytecie jest usuwany jako pierwszy).
 */
public interface PriorityQueue<T> {

    /**
     * Dodaje element do kolejki.
     */
    void insert(T value);

    /**
     * Usuwa i zwraca element o największym priorytecie.
     */
    T delMax();

    /**
     * Sprawdza, czy kolejka nie zawiera elementów.
     */
    boolean isEmpty();

    /**
     * Zwraca liczbę elementów kolejki.
     */
    int size();
}
