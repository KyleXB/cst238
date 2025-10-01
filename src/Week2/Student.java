package Week2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * Title: Student.java
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
            System.out.println(student);


        }
        System.out.println("--------------------------------------------------");

    }

    public void setScore(double [] score) {
        for (int i = 0; i < 5; i++) {
            scores[i] = score[i];
        }
    }

    public double getAverage() {
        //read in scores into a temporary array
        double[] temp = new double[scores.length];
        for (int i = 0; i < scores.length; i++) {
            temp[i] = scores[i];
        }

        //bubble sort to get 4 highest first
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = 0; j < temp.length - 1 - i; j++) {
                if (temp[j] < temp[j + 1]) {
                    double tempDoub =  temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = tempDoub;
                }
            }
        }

        //add up first four doubles
        double tempTotal = 0.0;
        for (int i = 0; i < 4; i++) {
            tempTotal += temp[i];
        }

        //return average
        return tempTotal / 4;
    }

    public String toString() {
        return name + " (" + id + "): " + getAverage();
    }
}
