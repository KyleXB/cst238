package Week14.Lab;

public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BST add(String value) {
        if (isEmpty()) {
            root = new Node(value);
        }

        root.add(value);
        return this;
    }
}

class Node {
    private Node left;
    private Node right;
    private String data;

    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }

    public boolean hasRight() {
        return right != null;
    }
    public boolean hasLeft() {
        return left != null;
    }

    public void add(String value) {
        if (value.compareTo(data) == 0) { //if value is the same, don't add b/c duplicates
            return;
        }
    }

}