import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class TreeAlgorithms<T> {
    public void postOrderRecursive(TreeNode<T> root) {
        if (root == null) return;
        // TODO: Wywołaj rekurencję i wypisz węzeł w odpowiedniej kolejności (Postorder)
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.value);
    }

    public void preOrderIterative(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> p = stack.pop();
            System.out.println(p.value);

            // Najpierw wrzucamy PRAWE dziecko
            if (p.right != null) {
                stack.push(p.right);
            }
            // Następnie wrzucamy LEWE dziecko
            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

        public void levelOrder (TreeNode < T > root) {
            if (root == null) return;

            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.add(root); // Wrzucamy korzeń na start

            while (!queue.isEmpty()) {
                // TODO: Zdejmij węzeł z kolejki (poll) i wypisz jego wartość

                // TODO: Zgodnie z notatkami - w jakiej kolejności wrzucamy
                // lewe i prawe dziecko do kolejki?}
            }
    }
}