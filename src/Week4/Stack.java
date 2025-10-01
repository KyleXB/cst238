package Week4;

import java.util.Scanner;

/*
 * Title: Stack.java
 * Abstract: This class imitates a stack through the use of an array. The methods provided in this class allow for
 *           basic functions that stacks should have to be carried out. Added functions by me are extraneous and just
 *           help with secondary functions that users might want to use.
 * Author: Shahidul Islam, with added methods from Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1 hour
 * Date: 9/19/2025
 */
public class Stack {
    public static final int STACK_CAPACITY = 10;
    private char [] data;
    private int top;

    public Stack() {
        data = new char[STACK_CAPACITY];
        top = -1;
    }

    public void reset() {
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char value) {
        if(top + 1 == data.length) {
            System.out.println("**Stack full - cannot push " + value + "**");
            return;
        }
        data[++top] = value;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("**Stack empty - cannot pop**");
            return;
        }
        // data[top] = null; // only if stack contains objects
        top--;
    }

    public char top() {
        if(isEmpty()) {
            System.out.println("**Stack empty - returning garbage value**");
            return 0;
        }
        return data[top];
    }

    public static String convert(int number) { //Instructions do not explicitly say to add a new constructor.
        //Instructions do not explicitly say to add a new constructor.
        //So, the max integer this method can take in is 511.
        //512 to binary is 1000000000, which would be ten characters
        //in length, hitting the capacity of the stack.
        StringBuffer sb = new StringBuffer();
        Stack convertStack = new Stack();
        int pushes = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                convertStack.push('1');
            } else {
                convertStack.push('0');
            }
            pushes++;
            number /= 2;
        }

        for (int i = 0; i < pushes; i++) {
            sb.append(convertStack.top());
            convertStack.pop();
        }
        return sb.toString();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Stack Contents: ");
        if(isEmpty()) {
            sb.append("Empty");
        } else {
            for (int i = top; i >= 0; i--) {
                sb.append(data[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = 1;
        Stack bin = new Stack();
        while(number != 0) {
            System.out.print("Enter a positive number (0 to quit): ");
            number = in.nextInt();
            if(number < 1) {
                break;
            }
            System.out.print(number + " => ");
            System.out.println(Stack.convert(number));
        }
        System.out.println("Exiting");
    }
}