package Week8.Homework;

public class Time /*implements Comparable<Time>*/{
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


}
