package Week3;

/*
 * Title: Course.java
 * Abstract: This class acts as a school course, containing the course number, it's title, the instructor, and the students currently enrolled in it.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1.5 hours
 * Date: 9/13/2025
 */
public class Course {
    private String title;
    private int number;
    private String instructorName;
    private Student[] roster;
    private int enrolledStudents;
    public static final int MAX_ROSTER_SIZE = 30;

    public Course(String courseTitle, int courseNumber, String instructorName) {
        title = courseTitle;
        number = courseNumber;
        this.instructorName = instructorName;
        roster = new Student[MAX_ROSTER_SIZE];
        enrolledStudents = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getEnrollmentCount() {
        return enrolledStudents;
    }

    public String toString() {
        return "Course Title: " + getTitle() + "\nCourse Number: " +  getNumber() + "\nInstructor: " + getInstructorName() + "\nEnrollment: " + getEnrollmentCount();
    }

    public boolean equals(Course c) {
        return this.getTitle().equals(c.getTitle()) && this.getNumber() == c.getNumber();
    }

    public boolean add(Student s) {
        //Null check, full check, and duplicate student check
        if (s == null) {
            return false;
        }

        if (enrolledStudents >= MAX_ROSTER_SIZE) {
            System.out.println("Course " + this.getTitle() + " is full");
            return false;
        }

        for (Student currentStudent : roster) {
            if (currentStudent != null && currentStudent.equals(s)) {
                System.out.println("Student is already enrolled.");
                return false;
            }
        }

        //Add student to roster after checks are passed
        roster[enrolledStudents] = s;
        enrolledStudents++;
        return true;
    }

    public boolean remove(Student s) {
        //Null check, empty check
        if (s == null) {
            return false;
        }

        if (enrolledStudents <= 0) {
            System.out.println("This course is empty, and there are no students to remove");
            return false;
        }

        //Find student in list, remove them based on ID
        int index = -1;
        for (int i = 0; i < roster.length; i++) {
            if (roster[i].equals(s)) {
                index = i;
                break;
            }
        }

        //If student wasn't found (index remains 1), then the student isn't available to remove
        if (index == -1) {
            return false;
        }

        //Moves last actual student into the removed students index, remove tail end, reduce enrolledStudents count
        roster[index] = roster[enrolledStudents - 1];
        roster[enrolledStudents - 1] = null;
        enrolledStudents--;
        return true;
    }

    public void print() {
        System.out.println(this);
        for (int i = 0; i < enrolledStudents; i++) {
            System.out.println(roster[i]);
        }
    }

}
