package Week10.FridayLab;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random(-41);

        int [] data1 = new int[10];
        fillArray(rand, data1, 0);
        print(data1, 0);
         System.out.print("Evens: ");
         printEvens(data1, 0);
         System.out.printf("Count of evens (should be 5): %d\n",
                           countEvens(data1, 0));
         System.out.printf("Sum of evens (should be 156): %d\n",
                           sumEvens(data1, 0));

         int [] data2 = new int[10];
         fillArrayAscending(rand, data2, 0);
         print(data2, 0);
         System.out.print("Evens: ");
         printEvens(data2, 0);
         System.out.printf("Count of evens (should be 4): %d\n",
                           countEvens(data2, 0));
         System.out.printf("Sum of evens (should be 156): %d\n",
                           sumEvens(data1, 0));

         System.out.println();
         int [] a = {4, 7, 6, 3, 9, 2, 0, 1, 8, 5};
         System.out.println("location of 6 (should be 2): "
                            + linearSearch(a, 6, 0));
         System.out.println("location of -50 (should be -1): "
                            + linearSearch(a, -50, 0));

         System.out.println();
         String [] s = {"hello", "goodbye", "ciao", "hey", "bonjour",
                        "buenos dias", "guten tag"};
         Arrays.sort(s);
         System.out.println("binary search \"ciao\" (should be 2): "
                            + binarySearch(s, "ciao"));
         System.out.println("binary search \"adios\" (should be -1): "
                            + binarySearch(s, "adios"));
         System.out.println();
         Run r1 = new Run(24, 45, 5);
         Run r2 = new Run(31, 2, 5);
         Run r3 = new Run(14, 25, 1.1);
         Run r4 = new Run(44, 17, 8.1);
         Run r5 = new Run(52, 22, 9);
         Run [] records = {r1, r2, r3, r4, r5};
         Arrays.sort(records);
         System.out.println("Printing Runs in speed order, ascending:");
         print(records, 0);
         System.out.println();

        // Run newRun1 = new Run(4, 59, 1);
        // Run newRun2 = new Run(2, 58, 1);

        // System.out.printf("insertion index for %.2f kph (should be 2): %d\n",
        //       r5.getSpeedInKilometersPerHour(),
        //       insertionSearch(records, r5));
        // System.out.printf("insertion index for %.2f kph (should be 4): %d\n",
        //       newRun1.getSpeedInKilometersPerHour(),
        //       insertionSearch(records, newRun1));
        // System.out.printf("insertion index for %.2f kph (should be 5): %d\n",
        //       newRun2.getSpeedInKilometersPerHour(),
        //       insertionSearch(records, newRun2));
    }

    public static void print(int [] a, int start) {
        if (start >= a.length) {
            return;
        }

        System.out.println(a[start] + " ");
        print(a, start + 1);
    }

    public static void fillArray(Random r, int [] a, int start) {
        if (start >= a.length) {
            return;
        }

        a[start] = r.nextInt(50) + 1;
        fillArray(r, a, start + 1);
    }

    public static void fillArrayAscending(Random r, int [] a, int start) {
        if (start >= a.length) {
            return;
        }

        if (start == 0) {
            a[start] = r.nextInt();
        }

        if (start != 0) {
            a[start] = a[start - 1] + r.nextInt();
        }

        fillArrayAscending(r, a, start + 1);
    }

    public static void printEvens(int [] a, int start) {
        if (start >= a.length) {
            return;
        }

        if (a[start] % 2 == 0) {
            System.out.println(a[start] + " ");
        }

        printEvens(a, start + 1);
    }

    public static int countEvens(int [] a, int start) {
        if (start >= a.length) {
            return 0;
        }

        if (a[start] % 2 == 0) {
            return countEvens(a, start + 1) + 1;
        } else {
            return countEvens(a, start + 1);
        }
    }

    public static int sumEvens(int [] a, int start) {
        if (start >= a.length) {
            return 0;
        }

        if (a[start] % 2 == 0) {
            return sumEvens(a, start + 1) + a[start];
        } else {
            return sumEvens(a, start + 1);
        }
    }


    public static int linearSearch(int [] data, int value, int start) {
        if (start < 0) {
            return -1;
        }

        if (data[start] == value) {
            int earlierIndex = linearSearch(data, value, start - 1); //if multiple of the same int exist
            if (earlierIndex == -1) {
                return data[start];
            } else { return data[earlierIndex]; }
        }

        return linearSearch(data, value, start - 1);

    }

    public static <T> void print(T [] a, int start) {
        if (start >= a.length) {
            return;
        }

        System.out.println(a[start] + " ");
        print(a, start + 1);
    }

    public static <T> int binarySearch(Comparable<T> [] data, T value) {
        return binarySearch(data, value, 0, data.length - 1);
    }

    public static <T> int binarySearch(Comparable<T> [] data, T value, int start, int stop) {
        if (start > stop || start < 0) { //value not found at all, or indices are out of bounds
            return -1;
        }

        int mid = (start + stop) / 2;
        int compare = data[mid].compareTo(value);

        if (compare == 0) {
            return mid;
        } else if (compare > 0) {
            return binarySearch(data, value, start, mid - 1);
        } else {
            return binarySearch(data, value, mid + 1, stop);
        }
    }

    public static <T> int insertionSearch(Comparable<T> [] data, T value) {
        return insertionSearch(data, value, 0, data.length - 1);
    }

    public static <T> int insertionSearch(Comparable<T> [] data, T value, int start, int stop) {
        return 1;
    }
}
