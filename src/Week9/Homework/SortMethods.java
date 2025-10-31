//EXTRA CREDIT IMPLEMENTED
//EXTRA CREDIT IMPLEMENTED
//EXTRA CREDIT IMPLEMENTED


package Week9.Homework;

/*
 * Title: SortMethods.java
 * Abstract: Includes various sorting methods, including a faster version of insertion sort.
 * Author: Kyle Bulloch & Shahidul Islam. Sorting methods, isSorted, and swap are implemented by me.
 * Email: kbulloch@csumb.edu
 * Estimate: 1.5 hours
 * Date: 10/30/2025
 */
public class SortMethods {

    public static SortResults bubbleSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.println("Starting bubble sort...");

        for (int i = 0; i < data.length - 1; i++) {
            boolean isSwapped = false;
            for (int k = 0; k < data.length - i - 1; k++) {
                comparisons++;
                if (data[k] > data[k + 1]) {
                    swap(data, k, k + 1);
                    swaps++;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
            System.out.println();
        }

        return new SortResults("Bubble", isSorted(data),
                swaps, comparisons);
    }

    public static SortResults selectionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting selection sort...");

        for(int i = 0; i < data.length - 1; i++) {
            int lowIndex = i;
            for(int k = i + 1; k < data.length; k++) {
                comparisons++;
                if(data[lowIndex] > (data[k])) {
                    lowIndex = k;
                }
            }
            if(lowIndex != i) {
                swap(data, lowIndex, i);
                swaps++;
            }
        }

        return new SortResults("Selection", isSorted(data),
                swaps, comparisons);


    }

    public static SortResults insertionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting insertion sort...");
        for(int i = 0; i < data.length; i++) {
            int k = i;

            comparisons++;
            while(k > 0 && data[k] < data[k-1]){
                swap(data, k, k - 1);
                swaps++;
                k--;

                comparisons++;
            }
        }
        return new SortResults("Insertion", isSorted(data),
                swaps, comparisons);
    }

    public static SortResults fastInsertionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting fast insertion sort...");

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;

            comparisons++;
            while (j >= 0 && data[j] > key) {
                j--;
                comparisons++;
            }

            int insertIndex = j + 1;
            if (insertIndex != i) {
                shift(data, i, insertIndex);
                swaps++;
            }
        }

        return new SortResults("Fast Insertion", isSorted(data),
                swaps / 3,
                comparisons);

    }

    public static void shift(int[] data, int fromIndex, int toIndex) {
        int value = data[fromIndex];
        for (int i = fromIndex; i > toIndex; i--) {
            data[i] = data[i - 1];
        }
        data[toIndex] = value;
    }

    public static void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    public static boolean isSorted(int[] data) {
        if (data.length < 2) return true; //if there is only one item in the array, then it is already sorted

        for (int i = 1; i < data.length - 1; i++) {
            if (data[i - 1] > data[i]) return false;
            if (i == data.length - 2 && data[i] <= data[i + 1]) return true;
        }
        return false;
    }
}
