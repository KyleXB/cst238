import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * Title: HW02a_Quiz.java
 * Abstract: This program reads in multiple students, their IDs, and their test scores. It then calculates and
 *           prints the average of each students' test scores.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 2 hours
 * Date: 9/5/2025
 */
public class Student {
    private String name;
    private int id;
    private double [] scores;

    public Student(String nm, int idNum) {
        name = nm;
        id = idNum;
        scores = new double[5];
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter input filename: ");
        Scanner in = new Scanner(System.in); //scans in the file name
        Scanner fin = new Scanner(new FileReader(in.next())); //scans in the file

        System.out.println("--------------------------------------------------");
        System.out.println("  Course Report: Quiz Average");
        System.out.println("--------------------------------------------------");

        while (fin.hasNext()) {
            String studentName = fin.next();

            if (studentName.equals("STOP")) { break; }

            int studentId = fin.nextInt();
            double[] studentScores = new double [5];
            for (int i = 0; i < 5; i++) {
                studentScores[i] = fin.nextDouble();
            }

            Student student = new Student(studentName, studentId);
            student.setScore(studentScores);
            System.out.println(student.toString());


        }
        System.out.println("--------------------------------------------------");

    }

    public void setScore(double [] score) {
        for (int i = 0; i < 5; i++) {
            scores[i] = score[i];
        }
    }

    public double getAverage() {
        double tempAvg = 0.0;
        for (int i = 0; i < 5; i++) {
            tempAvg += scores[i];
        }
        return tempAvg / 5.0;
    }

    public String toString() {
        return name + " (" + id + "): " + ((double)((int)(getAverage() *100.0)))/100.0; // The end is to limit decimals to 2 spaces
    }


}
