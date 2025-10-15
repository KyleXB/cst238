package Week8.Lab;

import java.time.Instant;
import java.time.Duration;
import java.util.Random;
import java.util.Scanner;

public class MainComplexityTest {
    public static void main(String[] args) {
        System.out.print("Enter array size: ");
        Scanner in = new Scanner(System.in);
        Random r = new Random(0); // seeding PRNG for consistent data
        int size = in.nextInt();
        forceOptimization(r);

        runTest(r, size);
    }

    private static void runTest(Random r, int size) {
        int [] data = makeArray(size, r);

        long startN1n = System.nanoTime();
        Instant startN1 = Instant.now();

        long n = doWorkN(data);

        long runN1n = System.nanoTime() - startN1n;
        Instant endN1 = Instant.now();

        long startN2n = System.nanoTime();
        Instant startN2 = Instant.now();

        long n2 = doWorkN2(data);

        long runN2n = System.nanoTime() - startN2n;
        Instant endN2 = Instant.now();

        Duration timeElapsedN1 = Duration.between(startN1, endN1);
        Duration timeElapsedN2 = Duration.between(startN2, endN2);

        System.out.printf("O(n) method took %d microseconds\n",
                timeElapsedN1.toNanos() / 1000);
        System.out.printf("O(n^2) method took %d milliseconds\n",
                timeElapsedN2.toMillis());

        if(n * size != n2) {
            System.out.println(n);
            System.out.println(n2);
            throw new RuntimeException("Inconsistent data");
        }
    }

    public static int [] makeArray(int size, Random r) {
        int [] a = new int[size];
        for(int i = 0; i < size; i++) {
            a[i] = r.nextInt(100);
        }
        return a;
    }

    public static long doWorkN(int [] data) {
        long  sum = 0;
        for(int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static long doWorkN2(int [] data) {
        long sum = 0;
        for(int i = 0; i < data.length; i++) {
            for(int k = 0; k < data.length; k++) {
                sum += data[k];
            }
        }
        return sum;
    }

    private static void forceOptimization(Random r) {
        // force optimization run
        for(int i = 0; i < 10; i++) {
            long v = doWorkN(makeArray(10000 * (i+1), r));
            v += doWorkN2(makeArray(1000, r));

            if(v < 10) {
                throw new RuntimeException("this should never happen");
            }
        }
    }
}