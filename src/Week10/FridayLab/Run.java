package Week10.FridayLab;

public class Run implements Comparable<Run>{
    private int minutes;
    private int seconds;
    private double distanceInKilometers;

    public Run(int minutes, int seconds, double distanceInKilometers) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.distanceInKilometers = distanceInKilometers;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public double getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public int getTotalSeconds() {
        return (getMinutes() * 60) + getSeconds();
    }

    public double getSpeedInKilometersPerHour() {
        return (getDistanceInKilometers() / getTotalSeconds()) * 3600;
    }

    public int compareTo(Run r) {
        return (int)(this.getSpeedInKilometersPerHour() * 100) - (int)(r.getSpeedInKilometersPerHour() * 100);
    }

    public String toString() {
        return String.format("%d:%02d (%.2f) %.2f kph",
                minutes, seconds, distanceInKilometers,
                getSpeedInKilometersPerHour());
    }
}
