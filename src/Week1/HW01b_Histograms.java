package Week1;

import java.io.*;
import java.util.*;

/*
 * Title: HW01a_Histograms.java
 * Abstract: This program reads the numbers from a given file and displays a horizontal
 *           histogram and a vertical histogram to show the size of the number in asterisks.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 3 hours
 * Date: 9/3/2025
 */
public class HW01b_Histograms {
    public static int[] numbers;
    public static int count; // How many numbers (non-unique) are in the file

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter file name: ");
        Scanner fin = new Scanner(System.in); //file name reader
        String fName = fin.next();
        readFile(fName);
        printHztlHistogram(numbers);
        printVtclHistogram(numbers, count);
    }

    public static void readFile(String fileName) throws FileNotFoundException { //reads the file in, initializes class values
        FileReader fr = new FileReader(fileName);
        Scanner nin = new Scanner(fr); // reads numbers from file
        count = nin.nextInt();
        numbers = new int[count];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nin.nextInt();
        }
    }

    public static void printHztlHistogram(int[] nums) {
        System.out.println("==== Horizontal Histogram ====");
        for (int num : nums) {
            System.out.print(num + ": ");
            for (int j = 0; j < num; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printVtclHistogram(int[] nums, int ct) {
        int max = findMax(nums, ct); // used for "height" of histogram

        System.out.println("==== Vertical Histogram ====");
        for (int j = max; j > 0; j--) {
            for (int i = 0; i < ct; i++) {
                if (j <= nums[i]) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < ct; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < ct; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int findMax(int[] nums, int ct) {
        int highest = nums[0];
        for  (int i = 1; i < nums.length; i++) {
            if (highest < nums[i]) {
                highest = nums[i];
            }
        }
        return highest;
    }
}
