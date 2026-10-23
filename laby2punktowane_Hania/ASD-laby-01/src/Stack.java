/**
 * Określa operacje stosu działającego zgodnie z zasadą LIFO.
 */
public interface Stack<T> {

    /**
     * Dodaje element na szczyt stosu.
     */
    void push(T value);

    /**
     * Usuwa i zwraca element ze szczytu stosu.
     */
    T pop();

    /**
     * Zwraca element ze szczytu bez usuwania go.
     */
    T peek();

    /**
     * Sprawdza, czy stos nie zawiera elementów.
     */
    boolean isEmpty();

    /**
     * Zwraca liczbę elementów stosu.
     */
    int size();
}
