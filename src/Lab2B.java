import java.util.Scanner;

/* Title: lab-2b
 * Abstract: This program can cycle through an array, going left or right and
 *           clearing values based on the position the array has been moved.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 30min-45min
 * Date: 09/05/2025
 */
public class Lab2B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] numbers = {5, 10, 20, 30, 35, 40, 45, 50, 60, 70};
        startDisplay(numbers);

        boolean exit = false;

        do {
            System.out.print("Enter your option: ");
            if (in.nextInt() == 1) {
                rightShift(numbers);
            } else if (in.nextInt() == 2) {
                leftShift(numbers);
            } else if (in.nextInt() == 0) {
                exit = true;
            } else {
                System.out.println("Invalid option, try again.");
            }
        } while (!exit);
        System.out.println("Done!");
    }

    public static void startDisplay(int [] nums) {
        System.out.print("Array values: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\nThis is the list of options: ");
        System.out.println("\t0. Exit");
        System.out.println("\t1. Right shift");
        System.out.println("\t2. Left shift");
        System.out.println();
    }

    public static void rightShift(int[] nums) {
        int[] temp = nums;
        for (int i = temp.length - 1; i > 0; i--) {
            nums[i] = temp[i - 1];
        }
        nums[0] = 0;
        System.out.print("Array values: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");
    }

    public static void leftShift(int[] nums) {
        int[] temp = nums;
        for (int i = 0; i < temp.length - 1; i++) {
            nums[i] = temp[i + 1];
        }
        nums[nums.length - 1] = 0;
        System.out.print("Array values: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");
    }
}
