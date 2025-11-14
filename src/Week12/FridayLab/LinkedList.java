package Week12.FridayLab;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public static void main(String[] args){
        /* CODE FOR STANDARD LINKED LIST
        LinkedList ll = new LinkedList();
        System.out.println(ll);
        ll.append("Anna");
        System.out.println(ll);
        ll.append("Becca").append("Carla").append("Diana").append("Erica").append("Feifei");
        System.out.println(ll);
        System.out.println("Removing Carla: " + ll.remove("Carla"));
        System.out.println("Removing first (Anna): " + ll.remove("Anna"));
        System.out.println("Removing last (Feifei): " + ll.remove("Feifei"));
        System.out.println(ll);
        System.out.println("Removing value not present (Gloria): " + ll.remove("Gloria"));
        System.out.println(ll);
        ll.prepend("Abha");
        System.out.println(ll);
        System.out.println("Searching for absent value (Anna): " + ll.search("Anna"));
        System.out.println("Searching for present value (Diana): " + ll.search("Diana"));
        System.out.println("Inserting Hermione after absent value (Anna): "
                + ll.insertAfter("Anna", "Hermione"));
        System.out.println("Inserting Hermione after present value (Diana): "
                + ll.insertAfter("Diana", "Hermione"));
        System.out.println(ll);
         */
    }

    public boolean isEmpty() {
        return head == null;
    }

    public LinkedList append(String data) {
        if (isEmpty()) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(new Node(data));
        }
        return this;
    }

    public void push(String data) {
        prepend(data);
    }

    public void pop() {
        head = head.getNext();
    }

    public void enqueue(String data) {
        append(data);
    }

    public void dequeue() {
        head = head.getNext();
    }

    public void prepend(String data) {
        if (isEmpty()) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.setNext(head);
            head = temp;
        }
    }

    public boolean search(String data) {
        if (isEmpty()) { //if empty then value won't be there, return false
            return false;
        } else {
            Node current = head;
            while (current.hasNext()) {
                if (current.getData().equals(data)) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    public boolean remove(String data) {
        if (isEmpty()) { //nothing to remove since list is empty, return false
            return false;
        } else {
            Node current = head;
            if (current.getData().equals(data)) {
                head = current.getNext();
                return true;
            }
            while (current.hasNext()) {
                if (current.getNext().getData().equals(data)) {
                    current.setNext(current.getNext().getNext());
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    public boolean insertAfter(String data, String after) {
        if (isEmpty()) { //cannot insert 'data' after 'after' b/c 'after' won't exist if list is empty, return false
            return false;
        }

        Node current = head;
        while (current.hasNext()) {
            if (current.getData().equals(data)) {
                Node temp = new Node(after);
                temp.setNext(current.getNext());
                current.setNext(temp);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public String toString() {
        if (isEmpty()) {
            return "Empty List";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public boolean hasNext() {
        return next != null;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return data;
    }
}