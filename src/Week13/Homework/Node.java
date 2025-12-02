package Week13.Homework;

import java.util.List;
import java.util.Queue;

/*
 * Title: Node.java
 * Abstract: A node class which carries data for a given binary search tree item; includes a left and right pointer.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 3 hours
 * Date: 11/21/2025
 */
public class Node <T extends Comparable<T>> {
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
        return !hasLeft() && !hasRight();
    }

    public int compareTo(Node<T> n) {
        return this.data.compareTo(n.data);
    }

    public String toString() {
        return data.toString();
    }

    public void add(T value) {
        int comp = value.compareTo(data);
        if (comp < 0) {
            if (hasLeft()) {
                left.add(value);
            } else {
                left = new Node<>(value);
            }
        } else if (comp > 0) {
            if (hasRight()) {
                right.add(value);
            } else {
                right = new Node<>(value);
            }
        }
        // silently ignore duplicates
    }

    public boolean search(T value) {
        int comp = value.compareTo(data);
        if (comp == 0) {
            return true;
        } else if (comp < 0 && hasLeft()) {
            return left.search(value);
        } else if (comp > 0 && hasRight()) {
            return right.search(value);
        }
        return false;
    }

    public void inOrder(StringBuilder sb) {
        if (hasLeft()) {
            left.inOrder(sb);
        }
        sb.append(data).append(" ");
        if (hasRight()) {
            right.inOrder(sb);
        }
    }

    public void preOrder(StringBuilder sb) {
        sb.append(data).append(" ");
        if (hasLeft()) {
            left.preOrder(sb);
        }
        if (hasRight()) {
            right.preOrder(sb);
        }
    }

    public void postOrder(StringBuilder sb) {
        if (hasLeft()) {
            left.postOrder(sb);
        }
        if (hasRight()) {
            right.postOrder(sb);
        }
        sb.append(data).append(" ");
    }

    public int size() {
        return 1 + (hasLeft() ? left.size() : 0)
                + (hasRight() ? right.size() : 0);
    }

    public int longest() {
        int l = (hasLeft() ? left.longest() : 0);
        int r = (hasRight() ? right.longest() : 0);

        return 1 + Math.max(l, r);
    }

    public int countLessThan(T value) {
        int count = 0;



        return count;
    }

    public int searchHeight(T value, int height) {
        return 0;
    }

    public T shortestLeafFast(Queue<Node<T>> nodes) {
        return null;
    }

    public void orderedList(List<T> ordered) {

    }

    public void getRows(List<List<T>> nodes, int row) {

    }

}
