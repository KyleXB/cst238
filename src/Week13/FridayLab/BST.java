package Week13.FridayLab;

public class BST <T extends Comparable<T>>{
    private Node<T> root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BST<T> add(T value) {
        if (isEmpty()) {
            root = new Node<>(value);
        }
        root.add(value);
        return this;
    }

    public boolean search(T value) {
        if (isEmpty()) { return false; }
        return root.search(value);
    }

    public String inOrder() {
        if (isEmpty()) { return ""; }
        StringBuilder sb = new StringBuilder();
        root.inOrder(sb);
        return sb.toString();
    }

    public String preOrder() {
        if (isEmpty()) { return ""; }
        StringBuilder sb = new StringBuilder();
        root.preOrder(sb);
        return sb.toString();
    }

    public String postOrder() {
        if (isEmpty()) { return ""; }
        StringBuilder sb = new StringBuilder();
        root.postOrder(sb);
        return sb.toString();
    }

    public int size() {
        if (isEmpty()) { return 0;}
        if (root.isLeaf()) { return 1; }

        return root.size();
    }

    public int longest() {
        return 0;
    }

    public int shortestLeaf() {
        return 0;
    }

    public int shortestEnd() {
        return 0;
    }
}


