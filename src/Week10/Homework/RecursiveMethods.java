package Week10.Homework;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveMethods {
    public static void main(String[] args) {
        int [] data = {1, 4, 9, 12, -13, 46, 12, 17, -3, -9, -12};
        System.out.println("Count of odds (should be 6): " + countOdds(data,
                data.length));
        System.out.println("Sum of odds (should be 2): " + sumOdds(data,
                data.length));
        System.out.print("Printing odds forward (should be 1 9 -13 17 -3 -9): ");
        printOddsForward(data, 0);
        System.out.print("Printing odds backward (should be -9 -3 17 -13 9 1): ");
        printOddsBackward(data, data.length);
        ArrayList<Integer> dataList = fromArray(data);
        System.out.println("Sum of ArrayList (should be 64): " +
                sumArrayList(dataList));
        Scanner in = new Scanner(System.in);
        promptPrimes(in, 2);
    }

    public static void promptPrimes(Scanner in, int value) {
        if(value == 0) {
            return;
        } else {
            System.out.printf("Is %d prime? %b\n", value, isPrime(value));
            ArrayList<Integer> factors = factorNumber(value);
            printFactors(factors);
            System.out.print("Enter a number (0 to quit): ");
            int input = in.nextInt();
            promptPrimes(in, input);
        }
    }

    public static ArrayList<Integer> fromArray(int [] source) {
        ArrayList<Integer> dest = new ArrayList<>();
        fromArray(dest, source, 0);
        return dest;
    }

    public static void fromArray(ArrayList<Integer> dest, int [] source, int start)
    {

    }

    public static int sumArrayList(ArrayList<Integer> list) {
        return 0;
    }

    public static int sumArrayList(ArrayList<Integer> list, int position) {
        return 0;
    }

    public static boolean isPrime(int base) {
        if(base < 2) {
            return false;
        } else {
            return isPrime(base, 2);
        }
    }

    public static boolean isPrime(int base, int comparison) {
        return false;
    }

    public static void printFactors(ArrayList<Integer> factors) {
        System.out.println(printFactors(factors, 0));
    }

    public static int printFactors(ArrayList<Integer> factors, int start) {
        return 0;
    }

    public static ArrayList<Integer> factorNumber(int base) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        factorNumber(al, base, 2);
        return al;
    }

    public static void factorNumber(ArrayList<Integer> factors, int base, int
            comparison) {
    }

    public static int countOdds(int [] a, int size) {
        if (size < 0) {
            return 0;
        }

        if (a.length != size && (a[size] % 2 == 1 || a[size] % 2 == -1)) {
            return countOdds(a, size - 1) + 1;
        } else {
            return countOdds(a, size - 1);
        }
    }

    public static int sumOdds(int [] a, int size) {
        if (size < 0) {
            return 0;
        }

        if (a.length != size && (a[size] % 2 == 1 || a[size] % 2 == -1)) {
            return sumOdds(a, size - 1) + a[size];
        } else {
            return sumOdds(a, size - 1);
        }
    }

    public static void printOddsForward(int [] a, int start) {
        if (start >= a.length) {
            return;
        }

        if (a[start] % 2 == 1 || a[start] % 2 == -1) {
            System.out.print(a[start] + " ");
        }
        printOddsForward(a, start + 1);

        if (start == a.length - 1) {
            System.out.println();
        }
    }

    public static void printOddsBackward(int [] a, int size) {
        if (size < 0) {
            return;
        }

        if (a.length != size && (a[size] % 2 == 1 || a[size] % 2 == -1)) {
            System.out.print(a[size] + " ");
        }

        printOddsBackward(a, size - 1);


        if (size == 0) {
            System.out.println();
        }
    }
}