public class BinomialQueue {
    public BinomialTree.Node head;

    public BinomialQueue() {
        this.head = null;
    }

    public BinomialQueue(BinomialTree.Node head) {
        this.head = head;
    }

    public BinomialQueue union(BinomialQueue other) {
        if (other == null || other.head == null) return this;
        if (this.head == null) {
            this.head = other.head;
            other.head = null;
            return this;
        }

        // 1. Scalenie obu list korzeni w jedną listę posortowaną rosnąco po h
        BinomialTree.Node h1 = this.head;
        BinomialTree.Node h2 = other.head;
        other.head = null;

        BinomialTree.Node mergedHead;
        if (h1.h <= h2.h) {
            mergedHead = h1;
            h1 = h1.next;
        } else {
            mergedHead = h2;
            h2 = h2.next;
        }

        BinomialTree.Node tail = mergedHead;
        while (h1 != null && h2 != null) {
            if (h1.h <= h2.h) {
                tail.next = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        tail.next = (h1 != null) ? h1 : h2;
        this.head = mergedHead;

        // 2. Łączenie drzew o tej samej wysokości h (max-heap)
        BinomialTree.Node prev = null;
        BinomialTree.Node curr = this.head;
        BinomialTree.Node next = curr.next;

        while (next != null) {
            if (curr.h != next.h || (next.next != null && next.next.h == curr.h)) {
                prev = curr;
                curr = next;
            } else if (curr.val >= next.val) {
                BinomialTree.Node afterNext = next.next;
                curr = BinomialTree.mergeTree(curr, next);
                curr.next = afterNext;
            } else {
                if (prev == null) {
                    this.head = next;
                } else {
                    prev.next = next;
                }
                curr = BinomialTree.mergeTree(curr, next);
            }
            next = curr.next;
        }

        return this;
    }
}