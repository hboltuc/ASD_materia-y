public class SkewHeap {
    private class Node{
        private Node left;
        private Node right;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    private int size;

    public Node union(Node p1, Node p2) {
        if (p1 == null) return p2;
        if (p2 == null) return p1;

        if (p1.val < p2.val) {
            Node temp = p1;
            p1 = p2;
            p2 = temp;
        }

        p1.right = union(p1.right, p2);

        Node temp = p1.left;
        p1.left = p1.right;
        p1.right = temp;

        return p1;
    }

    public void insert(int val){
        Node p = new Node(val);
        root = union(p, root);
        size++;
    }

    public int delMax(){
        if(size == 0){
            throw new IllegalStateException("Kopiec jest pusty.");
        }
        int valMax = root.val;

        root = union(root.left, root.right);
        size--;

        return valMax;
    }

}
