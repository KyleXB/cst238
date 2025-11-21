package Week13.FridayLab;

public class Node <T extends Comparable<T>>  {
    private Node<T> left;
    private Node<T> right;
    private final T data;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean isLeaf() {
        return ! hasLeft() && ! hasRight();
    }

    public void add(T value) {
        if (value.compareTo(this.data) < 0) {
            if(!this.hasLeft()) {
                this.left = new Node<>(value);
            } else {
                this.left.add(value);
            }
        } else if (value.compareTo(this.data) > 0) {
            if (!this.hasRight()) {
                this.right = new Node<>(value);
            } else {
                this.right.add(value);
            }
        }
    }

    public boolean search(T value) {
        if (value.compareTo(this.data) == 0) { return true; } //value found
        if (isLeaf()) { return false; }
        if (value.compareTo(this.data) < 0) { return hasLeft() && this.left.search(value); }
        else { return hasRight() && this.right.search(value); }
    }

    public void inOrder(StringBuilder sb) {
        if (hasLeft()) { left.inOrder(sb); }
        sb.append(this.data.toString());
        if (hasRight()) { right.inOrder(sb); }
        System.out.println(sb);
    }

    public void preOrder(StringBuilder sb) {
        sb.append(this.data.toString());
        if (hasLeft()) { left.inOrder(sb); }
        if (hasRight()) { right.inOrder(sb); }
        System.out.println(sb);
    }

    public void postOrder(StringBuilder sb) {
        if (hasLeft()) { left.inOrder(sb); }
        if (hasRight()) { right.inOrder(sb); }
        sb.append(this.data.toString());
        System.out.println(sb);
    }

    public int size() {
        int count = 0;
        return -1;
    }

    public int longestLeaf() {
        return 0;
    }

    public int shortestLeaf() {
        return 0;
    }

    public int shortestEnd() {
        return 0;
    }

    public String toString() {
        return data.toString();
    }
}
