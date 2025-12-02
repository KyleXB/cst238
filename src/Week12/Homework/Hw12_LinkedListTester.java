package Week12.Homework;

import java.util.Random;

public class Hw12_LinkedListTester {
    public static void main(String[] args) {
        RecursiveLinkedList<Integer> rll = new RecursiveLinkedList<>();
        Random r = new Random(9);
        // this loop is NOT part of the code you will turn in
        for(int i = 0; i < 10; i++) {
            rll.append(r.nextInt(-20,20));
        }

        System.out.println(rll);
        for(int i = 0; i < 10; i++) {
            int remove = r.nextInt(-20,20);
            System.out.printf("attempting to remove %d: %b%n", remove, rll.remove(remove));
            System.out.println(rll);
        }

        rll.prepend(9);
        rll.append(-7);
        System.out.println("\nGetting distinct values: ");
        RecursiveLinkedList<Integer> r2 = rll.getDistinct();
        System.out.println("Original: " + rll);
        System.out.println("Distinct: " + r2);

        RecursiveLinkedList<String> r3 = new RecursiveLinkedList<>();
        r3.insertOrderedAscending("hello");
        r3.insertOrderedAscending("ciao");
        r3.insertOrderedAscending("goodbye");
        r3.insertOrderedAscending("hola");
        System.out.println("\nOrdered Strings: " + r3);
        System.out.println("Is sorted? " + r3.isSorted());

        System.out.println();
        System.out.println("Rotating!");
        rll.rotate();
        System.out.println("done!");
        System.out.println(rll);

        System.out.println();
        System.out.println("Reversing!");
        rll.reverse();
        System.out.println("done!");
        System.out.println(rll);


    }
}
