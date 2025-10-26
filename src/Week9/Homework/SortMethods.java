package Week9.Homework;

public class SortMethods {

    public static SortResults bubbleSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.println("Starting bubble sort...");
        // implement bubble sort here

        return new SortResults("Bubble", isSorted(data),
                swaps, comparisons);
    }

    public static SortResults selectionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting selection sort...");
        // implement selection sort

        return new SortResults("Selection", isSorted(data),
                swaps, comparisons);


    }

    public static SortResults insertionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting insertion sort...");
        // implement insertion sort using swaps

        return new SortResults("Insertion", isSorted(data),
                swaps, comparisons);
    }

    public static SortResults fastInsertionSort(int[] data, boolean silent) {
        int swaps = 0;
        long comparisons = 0;
        if (!silent) System.out.print("Starting fast insertion sort...");
        // implement insertion sort with shifts

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
        // implement a swap
    }

    public static boolean isSorted(int[] data) {
        // implement a test of sortedness (only check for ascending order)
        return false;
    }
}
