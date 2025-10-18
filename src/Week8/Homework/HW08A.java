package Week8.Homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Title: HW08A.java
 * Abstract: This class sorts a list using the Collections.sort() method, to show what functions it uses to sort.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 30 minutes
 * Date: 10/18/2025
 */
public class HW08A {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<String>();

        System.out.print("Enter a filename: ");
        Scanner nin = new Scanner(System.in);
        String filename = nin.nextLine();

        FileReader fr = new FileReader(filename);
        Scanner fin = new Scanner(fr);
        while (fin.hasNext()) {
            data.add(fin.next());
        }

        fr.close();

        System.out.println("Words:");
        for (String word : data) {
            System.out.println("\t" + word);
        }
        System.out.println();

        System.out.println("Sorted:");
        Collections.sort(data);
        for (String word : data) {
            System.out.println("\t" + word);
        }
    }
}
