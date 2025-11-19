package Week13.Lab;

public class BinaryTree {

    Node head;

    public BinaryTree() {
        head = null;
    }

    public boolean isEmpty() { return true; }
    public BinaryTree add(int value) { return new BinaryTree(); }
    public int sum() { return -1; }
    public void traverse() { return; }
    public boolean isBST() { return true; }
    public String toString() { return ""; }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            data = value;
            left = null;
            right = null;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        public int getData() {
            return data;
        }

        public void add(int value) {
            if (value < data) {
                if (hasLeft()) {
                    left.add(value);
                } else {
                    left = new Node(value);
                }
            } else if (value > data) {
                if (hasRight()) {
                    right.add(value);
                } else {
                    right = new Node(value);
                }
            } else {
                System.out.println("Item is already present in tree");
            }
        }

        public void traverse() {
            if(hasLeft()){
                left.traverse();
            }
            System.out.print(data + " ");
            if(hasRight()){
                right.traverse();
            }
        }

        public int sum() { //Will sum up all items in the binary tree
            //DNF
            return -1;
        }
    }
}
