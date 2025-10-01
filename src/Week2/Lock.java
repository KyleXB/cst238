package Week2;

import java.util.*;

/*
 * Title: Lock.java
 * Abstract: Simulates the operation of rotating a combination lock (with nums 1-40) that gives hints towards guessing higher or lower.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 3 hours
 * Date: 9/8/2025
 */
public class Lock {

    private int [] codes;
    private int currentCode;
    private int [] allGuesses;
    private int guessCount;

    private Lock(int code1, int code2, int code3) {
        codes = new int[] {code1, code2, code3};
        currentCode = guessCount = 0;
        allGuesses = new int[120];
    }

    public boolean isLocked() {
        return currentCode != 3;
    }

    public void guess(int guessNum) {
        allGuesses[guessCount] =  guessNum;
        guessCount++;

        if (guessNum == codes[currentCode]) {
            System.out.println("Correct!");
            currentCode++;
        } else if (guessNum > codes[currentCode]) {
            System.out.println("Go down");
        } else if (guessNum < codes[currentCode]) {
            System.out.println("Go up");
        } else {
            System.out.println("Number is out of range, please enter a number between 1 and 40, inclusive.");
        }
    }

    public String guesses() {
        StringBuilder sb = new StringBuilder();
        sb.append(guessCount).append(" guesses: ");

        for (int i = 0; i < guessCount; i++) {
            sb.append(allGuesses[i]).append(" ");
        }

        return sb.toString();
    }

    public String toString() {
        return "The codes are: " + codes[0] + " " + codes[1] + " " + codes[2];
    }

    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        Lock l = new Lock(r.nextInt(40) + 1,
                r.nextInt(40) + 1,
                r.nextInt(40) + 1);
        while(l.isLocked()) {
            int guess;
            do {
                System.out.print("Enter guess: ");
                guess = in.nextInt();
            } while(guess < 1 || guess > 40);
            l.guess(guess);
        }
        System.out.println(l);
        System.out.println(l.guesses());
    }
}
