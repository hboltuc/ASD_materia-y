/**
 * Prezentuje działanie abstrakcyjnych typów danych: stosu, kolejki i kolejki priorytetowej
 * zaimplementowanych za pomocą dwóch wariantów listy dwukierunkowej:
 *   - z wskaźnikami head i tail (DoubleList),
 */
public class Main {

    public static void main(String[] args) {

        // Stos usuwa elementy w odwrotnej kolejności niż zostały dodane.
        System.out.println("Test 1. Stos (oczekiwane trzy dwa jeden)");
        Stack<String> stack = new DoubleListStack<String>();

        stack.push("jeden");
        stack.push("dwa");
        stack.push("trzy");

        System.out.print(stack.getClass().getSimpleName() + ": ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


        // Kolejka usuwa elementy w tej samej kolejności, w której zostały dodane.
        System.out.println("Test 2. Kolejka (oczekiwane jeden dwa trzy)");
        Queue<String> queue = new DoubleListQueue<String>();

        queue.enqueue("jeden");
        queue.enqueue("dwa");
        queue.enqueue("trzy");

        System.out.print(queue.getClass().getSimpleName() + ": ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();


        // Kolejka priorytetowa zwraca elementy od największego do najmniejszego.
        System.out.println("Test 3. Kolejka priorytetowa (oczekiwane 9 7 5 3 1)");

        // --- Grupa DoubleList ---
        PriorityQueue<Integer> sorted = new SortedDoubleListPriorityQueue<>();
        PriorityQueue<Integer> unsorted = new UnsortedDoubleListPriorityQueue<>();
        for (int value : new int[]{5, 1, 9, 3, 7}) {
            sorted.insert(value);
            unsorted.insert(value);
        }
        System.out.print("SortedDoubleListPriorityQueue: ");
        while (!sorted.isEmpty()) {
            System.out.print(sorted.delMax() + " ");
        }
        System.out.println();
        System.out.print("UnsortedDoubleListPriorityQueue: ");
        while (!unsorted.isEmpty()) {
            System.out.print(unsorted.delMax() + " ");
        }
        System.out.println();

    }
}
