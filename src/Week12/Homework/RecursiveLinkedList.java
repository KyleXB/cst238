package Week12.Homework;

import Week12.FridayLab.Node;

/*
 * Title: RecursiveLinkedList.java
 * Abstract: The java file contains a Linked List class that has various recursive methods, and a Node class that manages items in a given Linked List.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 3 hours
 * Date: 11/14/2025
 */
public class RecursiveLinkedList <T extends Comparable<T>> {
    private Node first;

    public RecursiveLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty List";
        }
        return first.toString();
    }

    public void prepend(T value) {
        if (isEmpty()) {
            first = new Node(value);
        }
        Node temp = new Node(value);
        temp.setNext(first);
        first = temp;
    }

    public RecursiveLinkedList<T> append(T value) {
        if (isEmpty()) {
            System.out.println("Empty List");
            return new RecursiveLinkedList<>();
        }

        first.append(value);
        return this;
    }

    public boolean search(T value) {
        if (isEmpty()) { return false; }
        return first != null && first.search(value);
    }

    public boolean remove(T value) {
        if (isEmpty()) { return false; } //base case: if empty return false

        if (first.getData().equals(value)) { //base case: if first matches remove it instantly and return true
            first = first.getNext();
            return true;
        }

        return first.removeNext(value); // recursive case
    }

    public RecursiveLinkedList<T> getDistinct() {
        RecursiveLinkedList<T> list = new RecursiveLinkedList<>();
        if (!isEmpty()) { first.addIfNotPresent(list); } //as long as list is not empty, getDistinct can pass onto addIfNotPresent

        return list;
    }

    public boolean isSorted() {
        return false;
    }

    public void insertOrderedAscending(T value) {

    }


    public void rotate() {

    }

    public void reverse() {

    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }

        public boolean hasNext() {
            return next != null;
        }

        public String toString() {
            if (this.next == null) {
                return "null";
            }
            return data + " -> " + next.toString();
        }

        public void append(T value) {
            if (!hasNext()) {
                this.setNext(new Node(value));
                return;
            }
            this.next.append(value);
        }

        public boolean search(T value) {
            if (this.getData().equals(value)) {
                return true;
            }

            if (!hasNext()) {
                return false;
            }

            return this.next.search(value);
        }

        public boolean removeNext(T value) {
            if (this.next == null) { return false; } //base case: if current Node doesn't have a next Node, return false

            if (this.next.getData().equals(value)) { //base case: if next node is the one we want to remove, skip over it
                this.setNext(this.getNext().getNext());
                return true;
            }

            return next.removeNext(value); //recursive case
        }

        public void addIfNotPresent(RecursiveLinkedList<T> list) {
            if (!list.search(this.data)) { //base case: if item not in distinct list, add it to list
                list.append(this.data);
            }

            if (this.next != null) { // recursive case: if item hasn't been added from above statement, move to next item
                this.next.addIfNotPresent(list);
            }
        }

        public boolean isSortedAscending() {
            return false;
        }

        public boolean isSortedDescending() {
            return false;
        }

        public void insertOrderedAscending(T value) {

        }

        public void moveToEnd(Node n) {

        }

        public Node reverse(Node n) {
            return this;
        }


        public boolean equals(T value) {
            return this.data.equals(value);
        }

        public boolean equals(Node n) {
            return this.getData().equals(n.getData());
        }

    }
}
