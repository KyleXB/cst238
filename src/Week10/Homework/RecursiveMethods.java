package Week10.Homework;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Title: RecursiveMethods.java
 * Abstract: This class contains recursive-based methods to handle various operations mostly relating to arrays/arraylists.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 2 hours
 * Date: 10/25/2025
 */
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
        if (dest.size() == source.length /*|| start == source.length*/) { //once dest has been filled by all values in source, exit recursion
            return;
        }

        dest.add(source[start]);
        fromArray(dest, source, start + 1);
    }

    public static int sumArrayList(ArrayList<Integer> list) {
        return sumArrayList(list, 0);
    }

    public static int sumArrayList(ArrayList<Integer> list, int position) {
        if (list.isEmpty() || position >= list.size()) { //if empty list or every list position checked
            return 0;
        }

        return list.get(position) + sumArrayList(list, position + 1);
    }

    public static boolean isPrime(int base) {
        if(base < 2) {
            return false;
        } else {
            return isPrime(base, 2);
        }
    }

    public static boolean isPrime(int base, int comparison) {
        if (comparison == base) { //reached if all numbers from 1-base have been tested and haven't been divisible
            return true;
        }

        if (base % comparison == 0) {
            return false;
        }

        return isPrime(base, comparison + 1);
    }

    public static void printFactors(ArrayList<Integer> factors) {
        System.out.println(printFactors(factors, 0)); //this will print out the final product after recursion exits from base case
    }

    public static int printFactors(ArrayList<Integer> factors, int start) {
        if (start == factors.size() - 1) { //last element reached
            System.out.print(factors.get(start) + " = ");
            return factors.get(start);
        }

        System.out.print(factors.get(start) + " * ");

        return factors.get(start) * printFactors(factors, start + 1); //returns cumulative product
    }

    public static ArrayList<Integer> factorNumber(int base) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        factorNumber(al, base, 2);
        return al;
    }

    public static void factorNumber(ArrayList<Integer> factors, int base, int comparison) {
        if (base == 1) { //if % 1 is reached, exit recursion as it is the last number
            return;
        }

        if (base % comparison == 0) { //if divisible to 0, it is a factor
            factors.add(comparison); //add it to the factor list
            factorNumber(factors, base / comparison, comparison); //divide by comparison as there might be more of the same prime number
        } else {
            factorNumber(factors, base, comparison + 1); //move to next possible factor
        }
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