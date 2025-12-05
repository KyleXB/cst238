package Week14.FridayLab;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

/*
 *1. In what situations does an array-based priority queue perform better than a heap-based one?
 *2. When does a heap-based priority queue offer a clear advantage over an array-based one?
 *3. Why is it true that in a general heap-based data management scenario, "Heap Data deleted in order" is false, but in a special-case usage, it becomes true?
 *4. Suppose you have a 10-second limit to run your program. What is the maximum amount of data (# of elements) you can process using heap-based and array-based priority queues for the general case?
 *
 *
 *
 */
public class PriorityQueueRunner {
    public static void main(String[] args) {
        int[] testData = {3, 4, 1, -2, 0, 7, 9, 12};
        PriorityQueueHeap pqh1 = new PriorityQueueHeap(testData);
        int[] sortedData = pqh1.heapSort();
        System.out.print("\nHeapsort Test: ");
        printArray(sortedData);

        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter PRNG seed: ");
        int seed = in.nextInt();
        systemTune(generateNumbers(10000, seed + 1));
        systemTune(generateNumbers(10000, seed + 1));

        while(true) {
            System.out.print("\nEnter size (0 to quit): ");
            int size = in.nextInt();
            if(size == 0) break;

            // For the special case data testing, generate 10 times the size of data
            int[] a = generateNumbers(size * 10, seed);
            specialCase(a);

            int[] b = generateNumbers(size, seed);
            int[] c = generateNumbers(size, seed + 1);
            boolean[] state = generateBoolean(size, seed);
            generalCase(b, c, state);
        }

    }

    //The data processing case where the priority queue will consider both insert and delete operation
    public static void generalCase(int [] initial, int [] updateData, boolean[] state){
        System.out.println("\nGeneral Case of Data Management:");
        Stopwatch sw1 = Stopwatch.createStarted();
        PriorityQueueHeap pqh = new PriorityQueueHeap(initial);
        int[] deletedItem = new int[state.length];
        int delCount = 0;
        for(int i = 0; i < state.length; i++){
            if(state[i]){
                pqh.insert(updateData[i]);
            } else{
                deletedItem[delCount++] = pqh.removeMin();
            }
        }
        sw1.stop();
        System.out.println("Heap Data deleted in order? " + isSorted(deletedItem, delCount));

        Stopwatch sw2 = Stopwatch.createStarted();
        PriorityQueueArray pqa = new PriorityQueueArray(initial, false);
        delCount = 0;
        for(int i = 0; i < state.length; i++){
            if(state[i]){
                pqa.insert(updateData[i]);
            } else{
                deletedItem[delCount++] = pqa.removeMin();
            }
        }
        sw2.stop();
        System.out.println("Array Data deleted in order? " + isSorted(deletedItem, delCount));

        System.out.println("Heap Time:  " + sw1.elapsed(TimeUnit.MICROSECONDS));
        System.out.println("Array Time: " + sw2.elapsed(TimeUnit.MICROSECONDS));
    }

    //The data processing case where the priority queue will consider only delete operation, given the initial data
    public static void specialCase(int [] data){
        System.out.println("\nSpecial Case of Data Management:");
        int[] deletedItem = new int[data.length];
        int delCount = 0;
        Stopwatch sw1 = Stopwatch.createStarted();
        PriorityQueueHeap pqh = new PriorityQueueHeap(data);
        Stopwatch sw11 = Stopwatch.createStarted();
        for(int i = 0; i < data.length; i++){
            deletedItem[delCount++] = pqh.removeMin();
        }
        sw1.stop();
        System.out.println("Heap Data deleted in order? " + isSorted(deletedItem, delCount));
        sw11.stop();

        delCount = 0;
        Stopwatch sw2 = Stopwatch.createStarted();
        PriorityQueueArray pqa = new PriorityQueueArray(data, false);
        Stopwatch sw21 = Stopwatch.createStarted();
        for(int i = 0; i < data.length; i++){
            deletedItem[delCount++] = pqa.removeMin();
        }
        sw2.stop();
        sw21.stop();

        System.out.println("Array Data deleted in order? " + isSorted(deletedItem, delCount));
        System.out.println("Heap Delete Time:  " + sw11.elapsed(TimeUnit.MICROSECONDS));
        System.out.println("Array Delete Time: " + sw21.elapsed(TimeUnit.MICROSECONDS));
        System.out.println("Heap Total Time:  " + sw1.elapsed(TimeUnit.MICROSECONDS));
        System.out.println("Array Total Time: " + sw2.elapsed(TimeUnit.MICROSECONDS));
    }

    public static void printArray(int[] data){
        for(int i = 0; i < 20 && i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static int [] generateNumbers(int size, int seed) {
        Random r = new Random(seed);
        int [] data = new int[size];
        for(int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(size * 10);
        }
        return data;
    }

    public static boolean [] generateBoolean(int size, int seed) {
        Random r = new Random(seed);
        boolean [] state = new boolean[size];
        for(int i = 0; i < state.length; i++) {
            state[i] = r.nextBoolean();
        }
        return state;
    }

    public static boolean isSorted(int [] a, int count){
        for(int i = 0; i < count - 1; i++){
            if(a[i] > a[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static void systemTune(int [] data) {
        PriorityQueueHeap testPqh = new PriorityQueueHeap(data);
        int[] sortedData = new int[data.length];
        for(int i = 0; i < data.length; i++) {
            sortedData[i] = testPqh.removeMin();
        }
        PriorityQueueArray testPqa = new PriorityQueueArray(data, true);
        PriorityQueueArray testPqa2 = new PriorityQueueArray(data, false);
    }
}