package Week6.Lab;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class MainSearchPL {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Random r = new Random();
        int size = 10;
        fill(al, size);
        for(int i = 0; i < size; i++) {
            int value = r.nextInt(size * 2);
            System.out.printf("Testing %d which should be %b\n",
                    value, (value < size));
            System.out.printf("\tLinear Search: %b\n",
                    linearSearch(al, value));
            System.out.printf("\tBinary Search: %b\n",
                    binarySearch(al, value));
        }

        // when you've verified that the searches work
        // uncomment this code
         double sum = 0;
         int sizeStep, tests = 0;
         Scanner in = new Scanner(System.in);

         do {
           System.out.print("Enter a starting size (>= 10): ");
           sizeStep = in.nextInt();
         } while(sizeStep < 10);


         do {
           System.out.print("Enter number of tests (x 1,000,000): ");
           tests = in.nextInt();
         } while(tests < 1);

         tests *= 1000000;

         System.out.println("\nSize\tLinear\tBinary");
         for(int i = 1; i <= 20; i++) {
           fill(al, sizeStep);
           sum += timeTest(al, tests, r);
         }


    }

    public static boolean binarySearch(ArrayList<Integer> al, int value) {
        int low = 0;
        int high = al.size() - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (value == al.get(mid)) {
                return true;
            } else if (value < al.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean linearSearch(ArrayList<Integer> al, int value) {
        for (int i = 0; i <= al.size() - 1; i++) {
            if (al.get(i) == value) {
                return true;
            }
        }
        return false;
    }


    public static double timeTest(ArrayList<Integer> al, int tests, Random r) {
        int max = al.size() * 2;
        long lCount = 0, bCount = 0; // count of hits for linear & binary search
        ArrayList<Integer> data = new ArrayList<Integer>(tests);
        for(int i = 0; i < tests; i++) {
            data.add(r.nextInt(max));
        }

        long startL = System.currentTimeMillis();
        for(int k : data) {
            if(linearSearch(al, k)) lCount++;
        }
        long runL = System.currentTimeMillis() - startL;

        long startB = System.currentTimeMillis();
        for(int k : data) {
            if(binarySearch(al, k)) bCount++;
        }
        long runB = System.currentTimeMillis() - startB;

        System.out.printf("%d\t\t%,d\t\t%,d", al.size(), runL, runB);
        System.out.printf("\t\t%,d\t\t%,d", lCount, bCount);
        System.out.println();
        return 1.0 * lCount / bCount;
    }


    public static void fill(ArrayList<Integer> al, int size) {
        int startingValue = al.size();
        for (int i = startingValue; i < startingValue + size; i++) {
            al.add(i);
        }
    }
}

