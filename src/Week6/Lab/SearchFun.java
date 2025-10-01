package Week6.Lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchFun {
    public static void main(String[] args) throws IOException {
        int[] data = new int[20];
        int count = readData(data);
        int search = 6;
        System.out.println("Location of " + search + ": " + binarySearch(data, count, search));
    }

    public static int binarySearch(int[] data, int count, int key) {
        //range is defined with two values; initally is the whole array
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid =  (low + high) / 2;
            if (data[mid] == key) {
                return mid;
            } else if (key < data[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        //if not in array, return -1
        return -1;
    }

    public static int readData(int[] data) throws IOException {
        Scanner uin = new Scanner(System.in); //user input

        System.out.print("Enter filename:");
        String fileName = uin.next();
        FileReader fr = new FileReader(fileName);
        Scanner fin = new Scanner(fr);
        int count = 0;
        while (fin.hasNextInt() && count < data.length) {
            data[count++] = fin.nextInt();
        }
        fr.close();
        return count;
    }
}

