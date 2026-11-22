public class BinomialTree {
    public static class Node {
        int val;
        Node child;
        Node next;
        Node prev;
        int h;
        boolean mark;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    void printTree(Node t) {
        if (t == null) return;
        System.out.println(t.val);
        Node p = t.child;
        while (p != null) {
            printTree(p);
            p = p.next;
        }
    }

    static Node mergeTree(Node t1, Node t2) {
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

    int missingH(Node t) {
        t.mark = true;
        Node p = t.child;
        if (p == null || p.h == 1) return 0; // brakuje dziecka h = 0 (również gdy było jedynym dzieckiem)

        while (p.next != null) {
            if (p.next.h - p.h > 1) {
                return p.h + 1; // brakuje dziecka w środku listy
            }
            p = p.next; // <-- tego brakowało
        }

        return t.h - 1; // brakuje ostatniego dziecka
    }

    /*
    standardowe rozwiazanie dla wypisywania brakujacych:
        1. tworzymy tablice booli i wszedzie dajemy false
        2. wstawiamy true tam gdzie sa
     */

    void PrintDuplicatedH(Node t){
        int[] H = new int[t.h];
        for (int i = 0; i < t.h; i++) {
            H[i] = 0;
        }
        Node p = t.child;
        while(p!= null){
            H[p.h]+=1;
            p=p.next;
        }
        for (int i = 0; i < t.h; i++) {
            if(H[i] != 0){
                System.out.println("h: " + i +", count: " + H[i]);
            }
        }
    }

    void printAllMissingH(Node t){
        boolean[] H = new boolean[t.h];
        for (int i = 0; i < t.h; i++) {
            H[i] = false;
        }
        Node p = t.child;
        while(p!= null){
            H[p.h] = true;
            p = p.next;
        }

        for (int i = 0; i < t.h; i++) {
            if(H[i] == false){
                System.out.println(i);
            }
        }
    }








}