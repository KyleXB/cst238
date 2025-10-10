package Week7.FridayLab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortedFiles {
    public static void main(String[] args) throws IOException {
        Scanner nin = new Scanner(System.in); //name input
        System.out.println("Enter first file name: ");
        String fileName1 = nin.nextLine();
        System.out.println("Enter second file name: ");
        String fileName2 = nin.nextLine();
        FileReader f1 = new FileReader(fileName1);
        FileReader f2 = new FileReader(fileName2);

        Scanner fin1 = new Scanner(f1); //file input 1
        Scanner fin2 = new Scanner(f2); //file input 2
        int currVal1 = fin1.nextInt();
        int currVal2 = fin2.nextInt();

        System.out.print("Merged Result:");
        while ((currVal1 != -1 && currVal2 != -1) || (fin1.hasNextInt() || fin2.hasNextInt())) {
            if (currVal1 == -1 && currVal2 != -1) {
                System.out.print(" " + currVal2);
                currVal2 = fin2.nextInt();
            } else if (currVal2 == -1 && currVal1 != -1) {
                System.out.print(" " + currVal1);
                currVal1 = fin1.nextInt();
            } else if (currVal1 < currVal2) {
                System.out.print(" " + currVal1);
                currVal1 = fin1.nextInt();
            } else if (currVal1 > currVal2) {
                System.out.print(" " + currVal2);
                currVal2 = fin2.nextInt();
            } else { //if they're equal
                System.out.print(" " + currVal1);
                System.out.print(" " + currVal2);
                currVal1 = fin1.nextInt();
                currVal2 = fin2.nextInt();
            }

        }
    }
}
