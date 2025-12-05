package Week14.FridayLab;

import java.util.Arrays;

public class PriorityQueueArray {
    int[] data;
    int size;
    int capacity;

    public PriorityQueueArray(int [] values, boolean isInsertionSort){
        capacity = values.length * 3;
        data = new int[capacity];
        size = 0;
        if(isInsertionSort) {
            for (int i = 0; i < values.length; i++) {
                insert(values[i]);
            }
        }
        else{
            for(; size < values.length; size++){
                data[size] = values[size];
            }
            Arrays.sort(data, 0, size);
            //Reverse the data to make them descending order for minHeap
            for (int i = 0; i < size / 2; i++) {
                int temp = data[i];
                data[i] = data[size - 1 - i];
                data[size - 1 - i] = temp;
            }
        }
    }

    //Update logic of the following method
    public Integer removeMin() {
        return (Integer)0;
        //Unfinished
    }

    public void insert(int item) {
        if(size == capacity){
            System.out.println("Array full, cannot insert.");
            return;
        }
        //Your code here to insert an item in the sorted data array in descending order
        //Unfinished
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++){
            sb.append(data[i] + " ");
        }
        return sb.toString();
    }
}
