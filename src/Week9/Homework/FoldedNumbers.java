package Week9.Homework;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Title: FoldedNumbers.java
 * Abstract: This class will take a file and print it out in order; for consecutive numbers, it'll "fold" them into a dashed form which will go from the first number in the sequence to the last.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1.5 hours
 * Date: 10/25/2025
 */
public class FoldedNumbers {

    public static int[] loadNumbers(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        Scanner in = new Scanner(fr);

        int[] nums = new int[in.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        in.close();
        fr.close();

        sort(nums);
        return nums;
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            while (k > 0 && a[k] < a[k - 1]) {
                int temp = a[k];
                a[k] = a[k - 1];
                a[k - 1] = temp;
                k--;
            }
        }
    }

    public static String foldNumbers(int[] a) {
        if (a == null || a.length == 0) { return ""; }

        StringBuilder sb = new StringBuilder();
        int rangeStart = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) { continue; } //if duplicate number, skip to next number

            if (a[i] != a[i - 1] + 1) { //if the next number in the sequence is not consecutive, output the current tracked range
                int start = a[rangeStart];
                int end = a[i - 1];

                if (start == end) {
                    sb.append(start).append(" ");
                } else {
                    sb.append(start).append("-").append(end).append(" ");
                }

                rangeStart = i;
            }
        }

        //grab first and last values
        int startValue = a[rangeStart];
        int endValue = a[a.length - 1];

        //this will append the final folded sequence, if need be
        if (startValue == endValue) {
            sb.append(startValue);
        } else {
            sb.append(startValue).append("-").append(endValue);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fn = fin.nextLine();
        int[] data = loadNumbers(fn);

        System.out.println(foldNumbers(data));
    }
}
