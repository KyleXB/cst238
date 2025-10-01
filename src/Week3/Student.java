package Week3;

/*
 * Title: Student.java
 * Abstract: This class works in conjunction with the Course class. The student class creates students, assigning a name and an ID to each.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 30 minutes
 * Date: 9/13/2025
 */
public class Student {
    private String name;
    private int id;

    public Student(String nm, int iden) {
        name = nm;
        id = iden;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String n) {
        name = n;
    }

    public void setId(int i) {
        id = i;
    }

    public String toString() {
        return "\tName: " + getName() + " - ID: " + getId();
    }

    public boolean equals(Student s) {
        return getId() == s.getId();
    }
}
