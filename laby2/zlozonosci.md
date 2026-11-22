# Raport Złożoności Obliczeniowej i Pamięciowej

## 1. Struktura: Dwukopiec (Beap)

### Metody pomocnicze: `ij2k(i, j)` oraz `k2ij(k)`
* **Złożoność czasowa:** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Wpisz tutaj swoje kroki analityczne, np. złożoność operacji arytmetycznych i pierwiastkowania)*

### Metoda: `upBeap(k)`
* **Złożoność czasowa (pesymistyczna):** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Wpisz, ile maksymalnie poziomów w górę musi przejść element w dwukopcu o rozmiarze N)*

### Metoda: `downBeap(k)`
* **Złożoność czasowa (pesymistyczna):** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Wpisz, ile maksymalnie poziomów w dół musi przejść element)*

### Metoda: `insert(val)`
* **Złożoność czasowa:** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Zastanów się, z jakich innych metod korzysta ta operacja i jaka jest ich złożoność)*

### Metoda: `delMax()`
* **Złożoność czasowa:** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Analogicznie jak przy insert, opisz wpływ wywoływanych metod pomocniczych)*

### Metoda: `search(v)`
* **Złożoność czasowa (pesymistyczna):** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Opisz ścieżkę poszukiwania od skrajnie prawego elementu. Ile maksymalnie kroków w pionie i poziomie wykonuje pętla?)*

---

## 2. Struktura: Kopiec Lewostronny (Leftist Heap)

### Metoda: `union(p1, p2)`
* **Złożoność czasowa:** $O(...)$
* **Złożoność pamięciowa:** $O(...)$ *(Zwróć uwagę na stos wywołań rekurencyjnych!)*
* **Uzasadnienie / Analiza:**
  > *(Wpisz analizę na podstawie maksymalnej długości prawej ścieżki - npl)*

### Metody: `insert(val)` oraz `delMax()`
* **Złożoność czasowa:** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Wyjaśnij, w jaki sposób obie te metody sprowadzają się do wykonania operacji union)*

---

## 3. Struktura: Kopiec Skośny (Skew Heap)

### Metoda: `union(p1, p2)`
* **Złożoność czasowa (zamortyzowana):** $O(...)$
* **Złożoność pamięciowa:** $O(...)$
* **Uzasadnienie / Analiza:**
  > *(Wyjaśnij różnicę względem kopca lewostronnego w kontekście analizy zamortyzowanej, ponieważ w wariancie pesymistycznym pojedyncza operacja może być wolniejsza)*

---

## Tabela Podsumowująca (Do uzupełnienia)

| Struktura | Metoda | Czas (Pesymistyczny) | Czas (Zamortyzowany) | Pamięć |
| :--- | :--- | :---: | :---: | :---: |
| **Beap** | `insert` | | - | |
| **Beap** | `delMax` | | - | |
| **Beap** | `search` | | - | |
| **Lewostronny** | `union` / `insert` / `delMax` | | - | |
| **Skośny** | `union` / `insert` / `delMax` | | | |
