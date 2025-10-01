package Week1;

import java.io.*;
import java.util.*;

public class HW01a_Distinct {

    public static int[] numbers;
    public static int count; // How many numbers (non-unique) are in the file

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter input file name: ");
        Scanner fin = new Scanner(System.in); //file name reader
        String fName = fin.next();
        readFile(fName);

        int min = findMin(numbers, count);
        int max = findMax(numbers, count);
        int [] sortedNumbers = numbers;
        sortNums(sortedNumbers, count, min, max);
        System.out.println("\nMin Number: " + min +"\n");
        generateDistinctCounts(sortedNumbers, count, min, max);
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

    public static int findMin(int[] nums, int ct) {
        int lowest = nums[0];
        for  (int i = 1; i < ct; i++) {
            if (lowest > nums[i]) {
                lowest = nums[i];
            }
        }
        return lowest;
    }

    public static int findMax(int[] nums, int ct) {
        int highest = nums[0];
        for  (int i = 1; i < ct; i++) {
            if (highest < nums[i]) {
                highest = nums[i];
            }
        }
        return highest;
    }

    public static void sortNums(int[] nums, int ct, int mn, int mx) { //this method makes it easier to get the distinct counts of each number. min and max help determine the range to sort within
        int[] tempArray = new int[ct];
        int sortPos = 0;

        for (int currNum = mn; currNum <= mx; currNum++){ //for loop runs from lowest to highest number in array
            for (int i = 0; i < ct; i++) { //iterates through full original array
                if (currNum == nums[i]) { //if the current number matches the original array number, place it in the new array
                    tempArray[sortPos] = nums[i];
                    sortPos++;
                }
            }
        }

        for (int i = 0; i < ct; i++) { //copies temporary array holdings into the sorted number array
            nums[i] = tempArray[i];
        }
    }

    public static void generateDistinctCounts(int[] nums, int ct, int mn, int mx) {
        //fill arrays
        int[] distNums = new int[ct];
        int[] counts = new int[ct];
        int sortPos = 0;

        int i = 0;
        while (i < ct) {
            int currNum = nums[i];
            int currCount = 1;

            while (i + 1 < ct && currNum == nums[i + 1]) { //while 'i' won't exit array range and the current number is equal to the next number...
                currCount++; //...increment the count of the current number
                i++; //...move to the next position of the array
            }

            //Store distinct number and its count in appropriate arrays; move to next position in both arrays after
            distNums[sortPos] = nums[i];
            counts[sortPos] = currCount;
            sortPos++;
            i++;
        }

        //print arrays
        System.out.println("Number  Count");
        for (int j = 0; j < sortPos; j++) {
            System.out.println(distNums[j] + "\t\t" + counts[j]);
        }
    }
}
