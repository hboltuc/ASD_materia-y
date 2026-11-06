public class Beap {
    private int[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public Beap() {
        this(DEFAULT_CAPACITY);
        this.elements[0] = Integer.MAX_VALUE;
    }

    public Beap(int capacity) {

        elements = new int[capacity];
    }

    public int ij2k(int i, int j) {
        return (i - 1) * i / 2 + j;
    }

    public int[] k2ij(int k) {
        int i = (int) Math.ceil((-1.0 + Math.sqrt(1.0 + 8.0 * k)) / 2.0);
        int j = k - (i - 1) * i / 2;
        return new int[]{i, j};
    }

    private void upBeap(int k) {
        int v = elements[k];

        while (k > 1) {
            int[] ij = k2ij(k);
            int i = ij[0];
            int j = ij[1];

            if (j == 1) {
                // Skrajnie lewy element - brak lewego rodzica
                int kP = ij2k(i - 1, 1);
                if (elements[kP] >= v) {
                    break;
                }
                elements[k] = elements[kP];
                k = kP;
            } else if (i == j) {
                // Skrajnie prawy element - brak prawego rodzica
                int kP = ij2k(i - 1, i - 1);
                if (elements[kP] >= v) {
                    break;
                }
                elements[k] = elements[kP];
                k = kP;
            } else {
                // Środkowe elementy - obaj rodzice istnieją
                int kPl = ij2k(i - 1, j - 1);
                int kPr = ij2k(i - 1, j);

                // Wybór mniejszego z rodziców
                int kmin = kPl;
                if (elements[kPr] < elements[kPl]) {
                    kmin = kPr;
                }

                // Jeśli mniejszy rodzic jest większy lub równy v, pozycja jest dobra
                if (elements[kmin] >= v) {
                    break;
                }
                elements[k] = elements[kmin];
                k = kmin;
            }
        }

        // Wstawienie wartości początkowej na docelowe miejsce po zakończeniu pętli
        elements[k] = v;
    }

    private void downBeap(int k){
        int v = elements[k];
        while(true){
            int[] ij = k2ij(k);
            int i = ij[0];
            int j = ij[1];

            int kL = ij2k(i+1, j);
            if(kL > size){
                break;
            }

            int m = kL;
            if (kL + 1 <= size && elements[kL + 1] > elements[kL]) {
                m = kL + 1;
            }
            if (v >= elements[m]) break;

            elements[k] = elements[m];
            k = m;
        }
        elements[k] = v;
    }

    public void insert(int val){
        size++;
        elements[size] = val;
        upBeap(size);
    }

    public int delMax(){
        if(size == 0){
            throw new IllegalStateException("Dwukopiec jest pusty");
        }
        int valMax  = elements[1];
        elements[1] = elements[size];
        size--;
        downBeap(1);
        return valMax;
    }

    public int search(int v) {
        int[] ij = k2ij(size);
        int i = ij[0];
        int j = ij[1];

        if (i != j) {
            i = i - 1;
            j = i;
        }

        int k = ij2k(i, j);

        while (j != 0 && v != elements[k]) {
            if (v < elements[k]) {
                if (ij2k(i + 1, j) <= size) {
                    i = i + 1;
                    k = ij2k(i, j);
                } else {
                    j = j - 1;
                    k = ij2k(i, j);
                }
            } else {
                i--;
                j--;
                k = ij2k(i, j);
            }
        }

        return j == 0 ? -1 : k;
    }

}
