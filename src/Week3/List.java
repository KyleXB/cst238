package Week3;

/*
 * Title: List.java
 * Abstract: This class manages a list object, which comes with some functions that allow 'editing' of the array in certain ways similar to a list.
 *           This class has also been heavily modified as it was originally to manage a String array, but the homework calls for methods that are
 *           managing integers. Some classes have been rewritten or fully removed to fit in this scope (integers).
 * Author: Shahidul Islam, added methods by Kyle Bulloch for Part C of the homework.
 * Email: kbulloch@csumb.edu
 * Estimate: 1.5 hours
 * Date: 9/15/2025
 */
public class List {
    // Attributes
    private int[] data;
    private int size;
    public static final int DEFAULT_CAPACITY = 50;

    // Constructor(s)
    public List(){
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public List(int capacity){
        data = new int[capacity];
        size = 0;
    }

    //Accessors
    public int getSize() {
        return size;
    }

    //Other Methods
    public boolean isEmpty(){
        return size == 0;
    }

    //Add a new item at the end of the list
    public void append(int v){
        if(size < data.length) {
            data[size++] = v;
        } else{
            System.out.println("List is full");
        }
    }

    //Add a new item at a given position [0 to size]
    public void insert(int v, int index){
        if(size >= data.length){
            System.out.println("List is full");
        } else if(index < 0 || index > size){
            System.out.println("Invalid index");
        } else{
            //Right shift
            for(int i = size; i > index; i--){
                data[i] = data[i-1];
            }
            data[index] = v;
            size++;
        }
    }

    //Remove an item, given a location
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else if (index < 0 || index >= size){ //Invalid Index
            System.out.println("Invalid Index");
        } else{
            //Left Shift
            for(int i = index; i < size - 1; i++){
                data[i] = data[i + 1];
            }
            //Assign null when you are not using a reference to an object
            data[size - 1] = 0;
            size--;
        }
    }

    public int getValue(int pos) {
        if (pos < 0 || pos >= size){
            System.out.println("Invalid Index");
            return -1;
        }

        return data[pos];
    }

    public boolean hasDuplicates() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] == data[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSorted() {
        if (isEmpty()){
            System.out.println("List is empty");
            return true;
        }

        if (size == 1){
            System.out.println("List has a singular integer, and as such is sorted");
            return true;
        }

        //Check first two elements to "assume" if list is ascending or descending
        boolean ascending = true; //if true, array assumed to be ascending. if false, array assumed to be descending.

        if (data[0] > data[1]){
            ascending = false;
        }

        if (ascending){
            for (int i = 0;  i < size - 1; i++) {
                if (data[i] > data[i + 1]){
                    return false;
                }
            }
        }

        if (!ascending){
            for (int i = 0;  i < size - 1; i++) {
                if (data[i] < data[i + 1]){
                    return false;
                }
            }
        }

        return true;
    }

    public String toString(){
        if (isEmpty()){
            return "Empty List";
        } else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < size; i++){
                sb.append(data[i]).append(" ");
            }
            return sb.toString();
        }
    }
}