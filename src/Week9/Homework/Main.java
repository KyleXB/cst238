package Week9.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter PRNG seed: ");
        int seed = in.nextInt();
        while(true) {
            System.out.print("Enter size (0 to quit): ");
            int size = in.nextInt();
            if(size == 0) break;
            System.out.print("Presorted (y/n)? ");
            boolean sorted = in.next().matches("[yY].*");

            int[] a = generateNumbers(size, seed, sorted);
            int[] b = Arrays.copyOf(a, a.length);
            int[] c = Arrays.copyOf(a, a.length);
            int[] d = Arrays.copyOf(a, a.length);

            System.out.printf("%-20s %8s %12s %12s\n", "Sorting Algorithm", "Sorted", "Swaps", "Comparisons");

            System.out.println(SortMethods.bubbleSort(a, true));

            System.out.println(SortMethods.selectionSort(b, true));

            System.out.println(SortMethods.insertionSort(c, true));

            System.out.println(SortMethods.fastInsertionSort(d, true));

            System.out.println();
        }

    }


    public static int [] generateNumbers(int size, int seed, boolean sorted) {
        Random r = new Random(seed);
        int [] data = new int[size];
        for(int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(size * 2);
            if(r.nextBoolean()) {
                data[i] *= -1;
            }
        }
        if(sorted) Arrays.sort(data);
        return data;
    }

}
