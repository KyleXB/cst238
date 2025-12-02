package Week13.Homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * Title: BST.java
 * Abstract: The java file contains a Binary Search Tree, along with some basic functions; all recursive.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 3 hours
 * Date: 11/21/2025
 */
public class BST <T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BST<T> add(T value) {
        if(isEmpty()) {
            root = new Node<>(value);
        } else {
            root.add(value);
        }
        return this;
    }

    public boolean search(T value) {
        return ! isEmpty() && root.search(value);
    }

    public String inOrder() {
        if(isEmpty()) {
            return "Empty tree";
        } else {
            StringBuilder sb = new StringBuilder();
            root.inOrder(sb);
            return sb.toString();
        }
    }

    public String preOrder() {
        if(isEmpty()) {
            return "Empty tree";
        } else {
            StringBuilder sb = new StringBuilder();
            root.preOrder(sb);
            return sb.toString();
        }
    }

    public String postOrder() {
        if(isEmpty()) {
            return "Empty tree";
        } else {
            StringBuilder sb = new StringBuilder();
            root.postOrder(sb);
            return sb.toString();
        }
    }

    public int longest() {
        if(isEmpty()) {
            return 0;
        } else {
            return root.longest();
        }
    }

    public int size() {
        if(isEmpty()) {
            return 0;
        }
        return root.size();
    }

    public int countLessThan(T value) {
        if (isEmpty()) { return 0; }
        return countLessThan(value);
    }

    public int searchHeight(T value) {
        return 0;
    }

    public T shortestLeafValue() {
        if(isEmpty()) {
            return null;
        } else {
            Queue<Node<T>> orderedNodes = new ArrayDeque<>();
            return root.shortestLeafFast(orderedNodes);
        }
    }

    public List<T> orderedList() {
        List<T> ordered = new ArrayList<>();

        return ordered;
    }

    public List<List<T>> getRows() {
        List<List<T>> nodes = new ArrayList<>();

        return nodes;
    }

}



