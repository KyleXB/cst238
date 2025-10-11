package Week7.Homework;

/*
 * Title: Song.java
 * Abstract: This class imitates a song with common song attributes.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1 hour
 * Date: 10/10/2025
 */
public class Song {
    //Attributes
    private String title;
    private String artist;
    private int year;
    private int lengthInSeconds;

    //Constructor
    public Song(String title, String artist, int year, int lengthInSeconds) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.lengthInSeconds = lengthInSeconds;
    }

    //Mutators
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public boolean equals(Song s) {
        return (title.equals(s.getTitle()) && artist.equals(s.getArtist()) && year == s.getYear() && lengthInSeconds == s.getLengthInSeconds());
    }

    public String toString() {
        int mins = lengthInSeconds / 60;
        int secs = lengthInSeconds % 60;

        String convertedSecs = (secs < 10) ? "0" + secs : "" + secs;
        return title + " (" + artist + ", " + year + ") " + mins + ":" + convertedSecs;
    }
}
