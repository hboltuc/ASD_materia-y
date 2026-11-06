public class LeftistHeap {
    private class Node{
        private Node left;
        private Node right;
        private int val;
        private int npl;

        public Node(int val) {
            this.val = val;
        }
    }
    private int size;
    private Node root = null;

    public Node union(Node p1, Node p2) {
        if (p1 == null) return p2;
        if (p2 == null) return p1;

        if (p1.val < p2.val) {
            Node temp = p1;
            p1 = p2;
            p2 = temp;
        }
        p1.right = union(p1.right, p2);
        if (p1.left == null || (p1.right != null && p1.left.npl < p1.right.npl)) {
            Node temp = p1.left;
            p1.left = p1.right;
            p1.right = temp;
        }
        if (p1.right == null) {
            p1.npl = 0;
        } else {
            p1.npl = p1.right.npl + 1;
        }
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
