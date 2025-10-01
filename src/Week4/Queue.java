package Week4;

/*
 * Title: Queue.java
 * Abstract: This class imitates a queue through the use of an array. The methods pre provided in this class allow for
 *           basic functions that queues should have to be carried out. Added functions by me are extraneous and just
 *           help with secondary functions that users might want to use.
 * Author: Shahidul Islam, with added methods from Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1 hour
 * Date: 9/19/2025
 */
public class Queue {
    public static final int QUEUE_CAPACITY = 7;
    private char[] data;
    private int front;
    private int back;

    public Queue() {
        data = new char[QUEUE_CAPACITY];
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return front == back;
    }

    public void enqueue(char chara) {
        int newBack = (back + 1) % data.length;
        if (newBack == front) {
            System.out.println("**Queue full - cannot enqueue " + chara + "**");
            return;
        }
        data[back] = chara;
        back = newBack;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("**Queue empty - cannot dequeue**");
            return;
        }
        // data[front] = null; // only if stack contains objects
        front = (front + 1) % data.length;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("**Queue empty - returning garbage value**");
            return 0;
        }
        return data[front];
    }

    public int find(char value) {
        boolean found = false;
        int pos = 1;
        for(int i = front; i != back; i = (i + 1) % data.length) {
            if(data[i] == value) {
                found = true;
                break;
            } else {
                pos++;
            }
        }

        if (!found) {
            return -1;
        } else {
            return pos;
        }

    }

    public int freeSpace() {
        if(isEmpty()) {
            return data.length - 1;
        } else if(front < back) {
            return data.length - (back - front) - 1;
        } else {
            return front - back - 1;
        }
    }

    public void rearrange() {
        char [] d2 = new char[data.length];
        int i = 0, k = front;
        while(k != back) {
            d2[i] = data[k];
            i++;
            k = (k + 1) % data.length;
        }
        data = d2;
        front = 0;
        back = i;
    }

    public String arrayState(){
        StringBuilder sb = new StringBuilder("Array Contents: ");
        for(int i = 0; i < data.length; i++)
        {
            sb.append(data[i]).append(" ");
        }
        return sb.toString();
    }

    public boolean isSorted() {
        int currentSize = (back - front + data.length) % data.length;

        if (isEmpty()){
            System.out.println("List is empty");
            return true;
        }

        if (currentSize == 1){
            System.out.println("List has a singular integer, and as such is sorted");
            return true;
        }

        //Check first two elements to "assume" if list is ascending or descending
        boolean ascending = true; //if true, array assumed to be ascending. if false, array assumed to be descending.

        if (data[front] > data[(front + 1) % data.length]) {
            ascending = false;
        }

        for (int i = 0; i < currentSize - 1; i++) {
            int currIndex = (front + i) % data.length;
            int nextIndex = (front + i + 1) % data.length;

            if (ascending) {
                if (data[currIndex] > data[nextIndex]) {
                    return false;
                }
            } else {
                if (data[currIndex] < data[nextIndex]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean drop(char value) {
        if (isEmpty()) { // empty checker
            System.out.println("**Queue empty - cannot drop**");
            return false;
        }
        if (find(value) == -1) { //not present checker
            System.out.println("**Character does not exist in queue, cannot drop**");
            return false;
        }

        int currentSize = (back - front + data.length) % data.length;
        boolean removedChar = false; //tracks if the character has been removed yet

        for (int i = 0; i < currentSize; i++) {
            char c = (char) front(); //look at the current front character...
            dequeue(); //pop it

            if (!removedChar && c == value) { //if character hasn't been removed yet and the value is the character
                removedChar = true;
            } else {
                enqueue(c); //read to queue
            }
        }

        return removedChar;
    }

    public boolean indexUsed(int index) {
        if (isEmpty()) { //index can't be in use b/c queue is empty
            return false;
        }

        if (front <= back) {
            // used region is [front, back), no wrap around
            return front <= index && index < back;
        } else {
            // wrapped: [front, len) and [0, back), wrap around
            return index >= front || index < back;
        }

    }

    public void dump() {
        System.out.println("front: " +front);
        System.out.println("back: " + back);
        for (int i = 0; i < data.length; i++) {
            if (indexUsed(i)) {
                System.out.print(data[i] + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Queue Contents: ");
        if (isEmpty()) {
            sb.append("Empty");
        } else {
            for (int i = front; i != back; i = (i + 1) % data.length) {
                sb.append(data[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}