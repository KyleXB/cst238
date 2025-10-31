package Week10.Lab;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] data = new int[10];
    }

    public static void print(int[] a, int start) {
        if (start >= a.length || start < 0) { //extra case check for out of bounds
            return;
        }

        System.out.print(a[start]);
        print(a, start + 1);
    }

    public static void load(Random r, int[] a, int start, int min, int max) {
        return;
        //DNF
    }

    public static int sum(int[] a, int start) {
        if (start >= a.length || start < 0) { //extra case check for out of bounds
            return 0;
        }

        return a[start] +  sum(a, start + 1);
    }

    public static int min(int[] a, int start) {
        if (start >= a.length || start < 0) { //extra case check for out of bounds
            return 0;
        }

        int currMin = min(a, start + 1);

        if (a[start] < currMin) {
            return a[start];
        } else {
            return currMin;
        }
    }

    public static int minIndex(int[] a, int start) {
        if (start >= a.length || start < 0) { //extra case check for out of bounds
            return 0;
        }

        int currMin = min(a, start + 1);

        if (a[start] < currMin) {
            return start;
        } else {
            return currMin;
        }
    }

    public int linearSearch(double[] a, double value, int start) {
        return -1;
        //DNF
    }

}
