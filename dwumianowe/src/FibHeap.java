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
        Node tailP = p.prev;

        tail.next = p;
        p.prev = tail;
        this.head.prev = tailP;

        // Jeśli p to pojedynczy węzeł (np. z insert), aktualizacja trwa O(1).
        // Jeśli p to dłuższa lista korzeni (np. dzieci usuniętego maxa), szukamy maksimum na liście p.
        Node candidateMax = (p.next == null) ? p : findMaxInList(p);
        if (candidateMax.val > this.max.val) {
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
        if(head == null){
            head = t;
            return;
        }
        Node tail = head.prev;
        tail.next = t;
        head.prev = t;
        t.prev = tail;
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
            // 2) brakuje jednego z końca i drugiego w środku
            if (t.child.prev.h == t.h - 2) {
                t.h = t.h - 1;
                t.mark = 1;
                AddToEnd(t);
                return;
            }
            // 3) brakuje dwóch ze środka — dzieci na koniec listy korzeni, potem sam korzeń t
            UnionFib(t.child);
            t.mark = 0;
            t.h = 0;
            t.child = null;
            AddToEnd(t);
        }
    }
  

    //Node DelMax()


}