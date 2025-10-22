package Week9.Lab;

import java.util.Random;

public class MainBullochKyle {
    public static void main(String[] args) {
        double[] data = new double[20];

        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextDouble();
        }

        System.out.println("Before partial selection sort:");
        printArray(data);

        partialSelectionSort(data);

        System.out.println("\nAfter partial selection sort:");
        printArray(data);

    }

    public static void swap() {
        //Not enough time
    }
}
