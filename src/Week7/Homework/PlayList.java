package Week7.Homework;

/*
 * Title: PlayList.java
 * Abstract: This class imitates a playlist that stores an amount of songs. It comes with some basic functions allowing to find certain things about songs in the playlist.
 * Author: Kyle Bulloch
 * Email: kbulloch@csumb.edu
 * Estimate: 1 hour
 * Date: 10/10/2025
 */
public class PlayList {
    public static final int DEFAULT_CAPACITY = 10;
    private Song[] playlist;
    private int size;

    public PlayList() {
        playlist = new Song[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Song s) {
        if (size == playlist.length) {
            resize();
        }
        playlist[size] = s;
        size++;
    }

    private void resize() {
        Song[] temp =  new Song[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = playlist[i];
        }
        playlist = temp;
    }

    public void move(int startingPosition, int endingPosition) {
        if (startingPosition < 0 || startingPosition >= size) {
            System.out.println("Invalid start position");
            return;
        }
        if (endingPosition < 0 || endingPosition >= size) {
            System.out.println("Invalid end position");
            return;
        }

        Song temp = playlist[startingPosition];
        playlist[startingPosition] = playlist[endingPosition];
        playlist[endingPosition] = temp;
    }

    private int linearSearch(int year) {
        System.out.println("Running Linear Search");
        for (int i = 0; i < size; i++) {
            if (playlist[i].getYear() == year) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int year) {
        System.out.println("Running Binary Search");
        int low = 0;
        int high = size - 1;
        int firstIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (playlist[mid].getYear() == year) {
                firstIndex = mid;
                high = mid - 1;
            } else if (playlist[mid].getYear() > year) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return firstIndex;
    }

    public int shortestSongIndex() {
        if (size == 0) {
            return -1;
        }

        int shortestSongInd = 0;
        for (int i = 1; i < size; i++) {
            if (playlist[i].getLengthInSeconds() < playlist[shortestSongInd].getLengthInSeconds()) {
                shortestSongInd = i;
            }
        }
        return shortestSongInd;
    }

    public Song longestSong() {
        if (size == 0) {
            return null;
        }

        int longestSongInd = 0;
        for (int i = 1; i < size; i++) {
            if (playlist[i].getLengthInSeconds() > playlist[longestSongInd].getLengthInSeconds()) {
                longestSongInd = i;
            }
        }
        return playlist[longestSongInd];
    }

    private boolean isSortedByYear() {
        if (size < 2) { return true; } // if the array is just one Song
        for (int i = 1; i < size; i++) {
            if (playlist[i].getYear() < playlist[i - 1].getYear()) {
                return false;
            }
        }
        return true;
    }

    public int search(int year) {
        if (isSortedByYear()) {
            return binarySearch(year);
        }
        return linearSearch(year);
    }

    public String toString() {
        if (size == 0) {
            return ("Empty playlist");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((i + 1)).append(". ").append(playlist[i].toString());
            if  (i != size - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
