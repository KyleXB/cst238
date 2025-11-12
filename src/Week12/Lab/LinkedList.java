package Week12.Lab;

public class LinkedList {
    private Node head;

    public LinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    //Add a item at the end of the list
    public void append(int num){
        if(isEmpty()){
            head = new Node(num);
        } else{
            Node current = head;
            //This loop stops at the last item of the list
            while(current.hasNext()){
                current = current.getNext();
            }
            current.setNext(new Node(num));
        }
    }

    public int length() {
        int count = 0;

        Node current = head;
        while(current.hasNext()){
            count++;
            current = current.getNext();
        }

        return count;
    }

    public int get(int index) {
        if (index < 0 || index >= length()) {
            System.out.println("Index out of bounds -- Returning garbage value");
            return -1;
        }

        Node current = head;
        int count = 0;

        while(current.hasNext()){
            count++;
            current = current.getNext();
            if (count == index){
                return current.getData();
            }
        }

        return -1;
    }

    private int lengthRecursive(Node current) { return -1; } //Incomplete
    private int getRecursive(Node current, int index) { return -1; } //Incomplete

    public String toString(){
        if(isEmpty()){
            return "Empty List";
        } else{
            StringBuilder sb = new StringBuilder();
            Node current = head;
            // while(current.hasNext()){ // Wrong
            while(current != null){
                sb.append(current.getData()).append(" -> ");
                current = current.getNext();
            }
            sb.append("null");
            return sb.toString();
        }
    }
}

class Node{
    //Payload
    private int data;
    //private String test;

    //Reference to the next node in the Linked List
    private Node next;

    public Node(int num){
        data = num;
        next = null;
    }

    public boolean hasNext(){
        return next != null;
    }

    public void setNext(Node n){
        next = n;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }

    public String toString(){
        //return "" + data;
        return Integer.toString(data);
    }
}


