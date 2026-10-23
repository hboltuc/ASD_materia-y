# Stos, kolejka i kolejka priorytetowa na liście dwukierunkowej

Zaimplementuj trzy abstrakcyjne typy danych:

- **stos** (*stack*) działający zgodnie z zasadą LIFO (*Last In, First Out*),
- **kolejkę** (*queue*) działającą zgodnie z zasadą FIFO (*First In, First Out*),
- **kolejkę priorytetową** (*priority queue*), w której jako pierwszy usuwany jest element o największym priorytecie.

 
Każdy typ zaimplementuj z użyciem własnej listy dwukierunkowej `DoubleList<T>`:
- lista dwukierunkowa **niecykliczna** z wskaźnikami na początek (`head`) i koniec (`tail`); `prev` pierwszego i `next` ostatniego elementu wynoszą `null`.


**Kolejkę priorytetową** zaimplementuj w dwóch wariantach: z listą **nieuporządkowaną** oraz z listą **uporządkowaną wg priorytetów**.
## Pliki

W kodzie dostępne są interfejsy `Stack<T>`, `Queue<T>` i `PriorityQueue<T>` oraz `Main.java` z kodem demonstracyjnym. Do zaimplementowania są klasy:

- `DoubleList<T>` — własna lista dwukierunkowa,
- `DoubleListStack<T>` — stos oparty na liście,
- `DoubleListQueue<T>` — kolejka oparta na liście,
- `SortedDoubleListPriorityQueue<T>` — kolejka priorytetowa oparta na liście uporządkowanej wg priorytetów,
- `UnsortedDoubleListPriorityQueue<T>` — kolejka priorytetowa oparta na liście nieuporządkowanej,


## Wymagane operacje

Interfejs `Stack<T>` definiuje metody:

- `push(T value)` — dodaje element na szczyt stosu,
- `pop()` — usuwa i zwraca element ze szczytu,
- `peek()` — zwraca element ze szczytu bez usuwania,
- `isEmpty()` — sprawdza, czy stos jest pusty,
- `size()` — zwraca liczbę elementów.

Interfejs `Queue<T>` definiuje metody:

- `enqueue(T value)` — dodaje element na końcu kolejki,
- `dequeue()` — usuwa i zwraca element z początku kolejki,
- `peek()` — zwraca pierwszy element bez usuwania,
- `isEmpty()` — sprawdza, czy kolejka jest pusta,
- `size()` — zwraca liczbę elementów.

Interfejs `PriorityQueue<T>` definiuje metody:

- `insert(T value)` — dodaje element do kolejki,
- `delMax()` — usuwa i zwraca element o największym priorytecie (porządek naturalny `Comparable`),
- `isEmpty()` — sprawdza, czy kolejka jest pusta,
- `size()` — zwraca liczbę elementów.


## Sprawdzenie działania

Uruchom `Main`. Program powinien potwierdzić, że stos zwraca elementy w odwrotnej kolejności, kolejka w kolejności dodawania, a kolejka priorytetowa od największego do najmniejszego:


## Złożoność obliczeniowa

Uzupełnij tabelę **pesymistycznymi** złożonościami czasowymi (w notacji O) podstawowych operacji, w zależności od liczby elementów `n` oraz sposobu zaimplementowania listy. Dla stosu i kolejki wystarczy jeden wiersz na operację, dla kolejki priorytetowej rozróżnij listę uporządkowaną i nieuporządkowaną.

| ADT                 | Operacja    | Lista                         | Złożoność pesymistyczna |
|---------------------|-------------|-------------------------------|-------------------------|
| Stos                | `push`      | —                             | 1                       |
| Stos                | `pop`       | —                             | 1                       |
| Kolejka             | `enqueue`   | —                             | 1                       |
| Kolejka             | `dequeue`   | —                             | 1                       |
| Kolejka priorytetowa | `insert`   | uporządkowana (sorted)        | n                       |
| Kolejka priorytetowa | `delMax`   | uporządkowana (sorted)        | 1                       |
| Kolejka priorytetowa | `insert`   | nieuporządkowana (unsorted)   | 1                       |
| Kolejka priorytetowa | `delMax`   | nieuporządkowana (unsorted)   | n                       |

