# Kolejki Priorytetowe, Kopiec Binarny i Algorytmy Zachłanne

Niniejszy projekt i mini-skrypt dotyczą implementacji abstrakcyjnego typu danych **Kolejka Priorytetowa** za pomocą różnych struktur danych (lista nieuporządkowana, lista uporządkowana, kopiec binarny) oraz ich zastosowania w algorytmach zachłannych.

---

## 📚 Mini-Skrypt Teoretyczny

### 1. Kolejki Priorytetowe: Lista Nieuporządkowana vs. Uporządkowana

Kolejka priorytetowa to abstrakcyjny typ danych (ADT), w którym elementy usuwane są nie według kolejności przybycia (jak w FIFO), ale według przypisanego priorytetu (domyślnie od elementu o największym priorytecie – `delMax`).

Różnica między implementacją na liście nieuporządkowanej a uporządkowanej wynika ze przyjętej strategii zarządzania czasem pracy:

* **Lista nieuporządkowana (*Lazy Evaluation* – programowanie leniwe):**
  * **Zasada:** Nowe elementy dopisuje się bez sortowania na koniec/początek listy.
  * **Wstawianie (`insert`):** Bardzo szybkie, zachodzi w czasie stałym $O(1)$.
  * **Usuwanie maksimum (`delMax`):** Odroczone w czasie. Wyszukanie elementu o największym priorytecie wymaga przeszukania całej listy, co zajmuje czas liniowy $O(n)$.

* **Lista uporządkowana (*Eager Evaluation* – programowanie nadgorliwe):**
  * **Zasada:** Elementy są przez cały czas utrzymywane w stanie posortowanym (np. od największego do najmniejszego).
  * **Usuwanie maksimum (`delMax`):** Bardzo szybkie, polega na pobraniu pierwszego elementu z głowy listy w czasie stałym $O(1)$.
  * **Wstawianie (`insert`):** Każde dodanie elementu wymaga liniowego przeszukania listy w celu znalezienia właściwego miejsca dla zachowania porządku, co zajmuje czas $O(n)$.

---

### 2. Kopiec Binarny (*Binary Heap*)

Kopiec binarny rozwiązuje problem kompromisu wydajnościowego list, oferując zrównoważoną i bardzo wysoką wydajność dla obu kluczowych operacji.

* **Własności kopca (typu *Max*):**
  1. **Własność struktury (zupełność):** Drzewo binarne jest całkowicie zapełniane poziomami od lewej do prawej.
  2. **Własność porządku kopcowego:** Wartość rodzica jest zawsze nie mniejsza niż wartości jego dzieci. Element maksymalny znajduje się zawsze w korzeniu.

* **Reprezentacja w tablicy:**
  Kopiec implementuje się w jednolitej tablicy bez używania wskaźników. Dla węzła o indeksie $i$ (indeksowanie od 1):
  * **Rodzic:** $\lfloor i / 2 \rfloor$
  * **Lewy potomek:** $2i$
  * **Prawy potomek:** $2i + 1$

* **Podstawowe operacje:**
  * `insert`: Dodanie elementu na sam koniec tablicy i naprawa własności kopca w górę (`UpHeap`) w czasie $O(\log n)$.
  * `delMax`: Usunięcie korzenia, przeniesienie ostatniego elementu tablicy do korzenia i naprawa własności kopca w dół (`DownHeap`) w czasie $O(\log n)$.
  * **Budowanie kopca:** Budowanie od dołu (`CreateHeap`) działa w optymalnym czasie liniowym $O(n)$.

---

### 3. Operacje Zakazane i Najczęstsze Błędy

1. **Liniowe przeszukiwanie kopca:** Szukanie elementu maksymalnego pętlą po całej tablicy jest błędem. Element maksymalny w kopcu *Max* znajduje się zawsze w korzeniu (pod indeksem 1) – dostęp do niego zajmuje $O(1)$.
2. **Sortowanie przy wstawianiu w liście nieuporządkowanej:** Próba utrzymywania porządku podczas operacji `insert` w liście nieuporządkowanej niszczy jej podstawową zaletę (wstawianie w $O(1)$).
3. **Mylenie procedur naprawy kopca:** Użycie `UpHeap` zamiast `DownHeap` podczas operacji `delMax` (lub odwrotnie przy `insert`) prowadzi do trwałego uszkodzenia struktury drzewa.

---

### 4. Algorytmy Zachłanne a Kolejka Priorytetowa

Algorytmy zachłanne podejmują w każdym kroku lokalnie optymalne decyzje. Kolejka priorytetowa jest dla nich kluczową strukturą danych:
* **Algorytm Kruskala (MST):** Przechowuje krawędzie grafu w kolejce priorytetowej i zachłannie pobiera najtańsze z nich (`delMin`), tworząc minimalne drzewo rozpinające w czasie $O(|E| \log |V|)$.
* **Algorytm Prima (MST):** Używa kolejki priorytetowej do bieżącego wybierania krawędzi o najmniejszej wadze wychodzącej z dotychczas zbudowanego drzewa.
* **Algorytm Dijkstry (Najkrótsze ścieżki):** Używa kolejki do ciągłego pobierania wierzchołka o najmniejszej znanej odległości od źródła oraz aktualizacji wag sąsiadów (`Replace`).

---

## 🎯 Polecenie Projektowe

### Cel zadania
Zaimplementuj trzy warianty kolejki priorytetowej oraz wykorzystaj jedną z nich w algorytmie zachłannym.

### Do zaimplementowania:
1. `UnsortedListPriorityQueue<T>` — kolejka priorytetowa oparta na własnej liście nieuporządkowanej.
2. `SortedListPriorityQueue<T>` — kolejka priorytetowa oparta na własnej liście uporządkowanej.
3. `BinaryHeapPriorityQueue<T>` — kolejka priorytetowa oparta na tablicowym kopcu binarnym.
4. **Moduł algorytmiczny:** Implementacja **algorytmu Prima** lub **Kruskala** wykorzystująca klasę `BinaryHeapPriorityQueue<T>`.

### Wymagany interfejs `PriorityQueue<T>`:
- `insert(T value)` — dodaje element do kolejki,
- `delMax()` — usuwa i zwraca element o największym priorytecie (zgodnie z `Comparable`),
- `peek()` — zwraca element o największym priorytecie bez usuwania,
- `isEmpty()` — sprawdza, czy kolejka jest pusta,
- `size()` — zwraca liczbę elementów.

---

## 📊 Tabela Złożoneści Obliczeniowej

Uzupełnij poniższą tabelę **pesymistycznymi** złożonościami czasowymi (w notacji $O$) w zależności od liczby elementów $n$:

| ADT | Operacja | Lista / Struktura | Złożoność pesymistyczna |
|---|---|---|---|
| Kolejka priorytetowa | `insert` | Nieuporządkowana | |
| Kolejka priorytetowa | `delMax` | Nieuporządkowana | |
| Kolejka priorytetowa | `insert` | Uporządkowana | |
| Kolejka priorytetowa | `delMax` | Uporządkowana | |
| Kolejka priorytetowa | `insert` | Kopiec binarny | |
| Kolejka priorytetowa | `delMax` | Kopiec binarny | |
