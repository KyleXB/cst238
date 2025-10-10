package Week7.FridayLab;

import java.util.Scanner;

public class SortedMain {
    public static void main(String[] args) {
        SortedList sl = new SortedList();
        Scanner input = new Scanner(System.in);
        System.out.println("Array values (" + sl.getSize() + " elements): " + sl);
        int val = Integer.MIN_VALUE;
        while (sl.getSize() != 0) {
            System.out.print("Enter a number (or 0 to quit): ");
            val = input.nextInt();
            if (val == 0) { break; }

            sl.insertSorted(val);
            System.out.println("New array values (" + sl.getSize() + "elements): " + sl);
        }
        System.out.println("Bye!");
    }
}
