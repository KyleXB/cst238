import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/* Title: lab-2a
 * Abstract: This program can average two test scores
 *           belonging to a person and compare it to anothers.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 30min-45min
 * Date: 09/05/2025
 */
public class Student {
    private String name;
    private double testScore1;
    private double testScore2;

    public Student(String nm, double ts1, double ts2) {
        name = nm;
        testScore1 = ts1;
        testScore2 = ts2;
    }

    public String getName() {
        return name;
    }

    public double getAverage(double ts1, double ts2) {
        return (testScore1 + testScore2) / 2;
    }

    public String toString() {
        return (name + "'s average: " + getAverage(testScore1, testScore2));
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter input file name: ");
        Scanner fin = new Scanner(System.in); //reads file name
        String fileName = fin.next();
        FileReader fr = new FileReader(fileName);
        Scanner in = new Scanner(fr); //reads info from inside file

        Student s1 = new Student(in.next(), in.nextDouble(), in.nextDouble());
        Student s2 = new Student(in.next(), in.nextDouble(), in.nextDouble());

        System.out.println(s1.toString());
        System.out.println(s2.toString());

        if (s1.getAverage(s1.testScore1, s2.testScore2) > s2.getAverage(s2.testScore1, s2.testScore2)) {
            System.out.println(s2.getName() + " has a better score than " + s1.getName() + ".");
        } else if (s1.getAverage(s1.testScore1, s2.testScore2) < s2.getAverage(s2.testScore1, s2.testScore2)) {
            System.out.println(s1.getName() + " has a better score than " + s2.getName() + ".");
        } else {
            System.out.println(s1.getName() + " and " + s2.getName() + " have the same scores.");
        }
    }
}
