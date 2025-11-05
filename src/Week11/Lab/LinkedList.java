package Week11.Lab;

public class LinkedList {
    private Node head;

    public LinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    //Return the number of even in the list
    public int countEven(){
        if(isEmpty()){
            return 0;
        } else{
            int count = 0;
            Node n = head;
            //This loop stops at the END of the list
            while(n != null){
                if(n.getData() % 2 == 0){
                    count++;
                }
                n = n.getNext();
            }
            return count;
        }
    }

    //Add an item at the end of the list
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

    public void prepend(int data) {
        //to be completed out of class
    }

    public boolean search(int data) {
        //to be completed out of class
        return true;
    }

    public int sum() {
        //to be completed out of class
        return 1;
    }

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