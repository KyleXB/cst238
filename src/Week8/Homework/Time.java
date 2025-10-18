package Week8.Homework;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Title: Time.java
 * Abstract: This class represents a clock; functionalities allow the time to be output in either military time or standard 12-hour time.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 2 hours
 * Date: 10/18/2025
 */
public class Time implements Comparable<Time>{
    private int hours;
    private int minutes;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
    }

    public Time(int hours) {
        this.hours = hours;
        this.minutes = 0;

        if (hours < 0 || hours > 23) {
            this.hours = 0;
            this.minutes = 0;
        }
    }

    public Time(int hours, int minutes) {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public Time add (Time t2) {
        int newHours = this.hours + t2.hours;
        int newMinutes = this.minutes + t2.minutes;

        if (newHours > 23) {
            newHours = newHours - 24;
        }

        if (newMinutes > 59) {
            newMinutes = newMinutes - 60;
            newHours++;
        }

        return new Time(newHours, newMinutes);
    }


    public String toStandard() {
        int standardHours = this.hours % 12;
        if (standardHours == 0) { standardHours = 12; } //00 will turn into 12 for standard

        String amPm;
        if (hours < 12) {
            amPm = "AM";
        } else {
            amPm = "PM";
        }

        return String.format("%02d:%02d%s", standardHours, minutes, amPm);
    }

    public String toMilitary() {
        return String.format("%02d%02d", hours, minutes);
    }

    public int toMinutes() {
        return (hours * 60) + minutes;
    }

    @Override
    public int compareTo(Time o) {
        return this.toMinutes() - o.toMinutes();
    }

    public String toString() {
        return toMilitary();
    }
}
