package Week3;

import java.util.Scanner;

/*
 * Title: NumberList.java
 * Abstract: Stores a list of numbers. Allows the user to carry out three functions: Remove the highest integer, append a number to the array (given there's space),
 *           and reverse the order of the array.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1.5 hours
 * Date: 9/15/2025
 */
public class NumberList {
    private int[] numbers = {10, 20, 30, 40, 50, 15, 25, 35, 45, 55};
    int inUse = 10;

    public void print() {
        StringBuilder sb = new StringBuilder("List values: (");
        sb.append(inUse);
        sb.append("): ");
        for (int i = 0; i < inUse; i++) {
            sb.append(numbers[i]).append(" ");
        }
        System.out.println(sb);
    }

    public int findMaxIndex() {
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void deleteMax() {
        for (int i = findMaxIndex(); i < inUse - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[inUse - 1] = 0;
        inUse--;
    }

    public boolean hasSpace() {
        return inUse < numbers.length;
    }

    public void appendNumber(int number) {
        if (hasSpace()) {
            numbers[inUse] = number;
            inUse++;
        } else {
            System.out.println("List is full, cannot append");
        }
    }

    public void reverse() {
        int[] temp = new int[numbers.length];

        for (int i = 0; i < inUse; i++) {
            temp[inUse - 1 - i] = numbers[i];
        }


        numbers = temp;
    }

    public static void main(String[] args) {
        NumberList list = new NumberList();
        Scanner uin = new Scanner(System.in); // user input scanner

        list.print();

        System.out.println("This is a list of operations");
        System.out.println("\t0. Exit");
        System.out.println("\t1. Delete the max");
        System.out.println("\t2. Append a number");
        System.out.println("\t3. Reverse array");

        int userInput = -1;
        while (userInput != 0) {
            System.out.print("Enter your option: ");
            userInput = uin.nextInt();

            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                list.deleteMax();
                list.print();
                System.out.println();
            } else if (userInput == 2) {
                System.out.print("Enter the number to append: ");
                list.appendNumber(uin.nextInt());
                list.print();
                System.out.println();
            } else if (userInput == 3) {
                list.reverse();
                list.print();
                System.out.println();
            } else {
                System.out.println("Invalid option");
            }
        }
        System.out.println("Done!");
    }
}
