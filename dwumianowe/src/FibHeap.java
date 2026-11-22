public class FibHeap {
    private static class Node {
        int val;
        Node child;
        Node next;
        Node prev;
        int h;
        int mark;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node max; // wskaźnik na korzeń o największej wartości

    void insert(int v) {
        Node q = new Node(v);
        q.next = null;
        q.prev = q;
        q.child = null;
        q.h = 0;

        UnionFib(q);
    }


    void UnionFib(Node p) {
        if (p == null) {
            return;
        }
        if (this.head == null) {
            this.head = p;
            this.max = findMaxInList(p);
            return;
        }

        Node tail = this.head.prev;
        Node tailP = (p.prev != null) ? p.prev : p;

        tail.next = p;
        p.prev = tail;
        this.head.prev = tailP;

        Node candidateMax = (p.next == null) ? p : findMaxInList(p);
        if (this.max == null || candidateMax.val > this.max.val) {
            this.max = candidateMax;
        }
    }

    Node ExtractFirst() {
        if (head == null) return null;

        Node p = head;
        Node tail = head.prev;
        head = head.next;

        if (head != null) {
            head.prev = tail;
            if (p == max) {
                max = findMaxInList(head);
            }
        } else {
            max = null;
        }

        p.next = null; // ważne, aby odcięty węzeł nie ciągnął za sobą reszty listy
        p.prev = p;

        return p;
    }

    void AddToEnd(Node t) {
        if (t == null) return;
        t.next = null;
        if (head == null) {
            head = t;
            t.prev = t;
            if (max == null || t.val > max.val) {
                max = t;
            }
            return;
        }
        Node tail = head.prev;
        tail.next = t;
        head.prev = t;
        t.prev = tail;

        if (max == null || t.val > max.val) {
            max = t;
        }
    }

    private Node findMaxInList(Node start) {
        Node best = start;
        for (Node curr = start.next; curr != null; curr = curr.next) {
            if (curr.val > best.val) {
                best = curr;
            }
        }
        return best;
    }

    void CorrectAndAddToEnd(Node t) {
        if (t.mark == 0) {
            AddToEnd(t);
            return;
        }

        if (t.mark == 1) {
            if (t.child == null || t.child.prev.h != t.h - 1) { // brakuje ostatniego
                t.h--;
                t.mark = 0;
            }
            AddToEnd(t);
            return;
        }

        if (t.mark == 2) {
            // 1) brakuje dwóch ostatnich
            if (t.child == null || t.child.prev.h == t.h - 3) {
                t.h = t.h - 2;
                t.mark = 0;
                AddToEnd(t);
                return;
            }
            // 2) brakuje jednego z końca (drugi w środku)
            if (t.child.prev.h == t.h - 2) {
                t.h = t.h - 1;
                t.mark = 1;
                AddToEnd(t);
                return;
            }
            // 3) brakuje dwóch ze środka — dodajemy listę dzieci na sam koniec, a potem root
            UnionFib(t.child);
            t.mark = 0;
            t.h = 0;
            t.child = null;
            t.next = null;
            AddToEnd(t);
        }
    }


    Node DelMax() {
        if (head == null || max == null) {
            return null;
        }

        // 1) Usuwanie max z listy korzeni head
        Node removedMax = max;

        if (removedMax == head) {
            if (head.next == null) {
                head = null;
            } else {
                Node tail = head.prev;
                head = head.next;
                head.prev = tail;
            }
        } else if (removedMax.next == null) { // removedMax jest ogonem (tail)
            head.prev = removedMax.prev;
            removedMax.prev.next = null;
        } else { // removedMax jest w środku listy
            removedMax.prev.next = removedMax.next;
            removedMax.next.prev = removedMax.prev;
        }

        // Dzieci usuniętego max trafiają na koniec listy korzeni z korektą h i mark
        Node child = removedMax.child;
        while (child != null) {
            Node nextChild = child.next;
            child.next = null;
            child.prev = child;
            CorrectAndAddToEnd(child);
            child = nextChild;
        }

        // Wyczyszczenie wskaźników zwracanego węzła oraz zerowanie max przed pętlą
        removedMax.child = null;
        removedMax.next = null;
        removedMax.prev = removedMax;
        this.max = null;

        // 2) Konsolidacja (kompresja kopca)
        Node[] tablica = new Node[64]; // rozmiar >= log_phi(n) + 1

        while (head != null) {
            Node curr = ExtractFirst();
            int h = curr.h;

            while (tablica[h] != null) {
                curr = mergeTree(curr, tablica[h]);
                tablica[h] = null;
                h = curr.h;
            }
            tablica[h] = curr;
        }

        // Odbudowa listy korzeni head z tablicy i wyznaczenie nowego max
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] != null) {
                AddToEnd(tablica[i]);
                if (max == null || tablica[i].val > max.val) {
                    max = tablica[i];
                }
            }
        }

        return removedMax;
    }

    private Node mergeTree(Node t1, Node t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        if (t1.val < t2.val) {
            Node temp = t1;
            t1 = t2;
            t2 = temp;
        }

        t2.next = null;

        if (t1.child == null) {
            t1.child = t2;
            t2.prev = t2;
        } else {
            t1.child.prev.next = t2;
            t2.prev = t1.child.prev;
            t1.child.prev = t2;
        }

        t1.h++;
        return t1;
    }


}