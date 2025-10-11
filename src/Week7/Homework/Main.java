package Week7.Homework;

public class Main {
    public static void main(String[] args) {
//        Song s1 = new Song("TLIKTB", "Tame Impala", 2015, 217);
//        Song s2 = new Song("Gossip", "Tame Impala",  2016, 56);
//        Song s3 = new Song("Disciples", "Tame Impala", 2017, 109);
//        Song s4 = new Song("Jeremy's Storm", "Tame Impala", 2018, 111);
//
//        PlayList pl = new PlayList();
//        pl.add(s1);
//        pl.add(s2);
//        pl.add(s3);
//        pl.add(s4);
//        System.out.println(pl);
//        System.out.println(pl.search(2020));
//        System.out.println(pl.search(2018));
        PlayList pl1 = new PlayList();
        pl1.add(new Song("Rapper's Delight", "Sugarhill Gang", 1979, 427));
        pl1.add(new Song("Never Gonna Give You Up", "Rick Astley", 1987,215));
        System.out.println(pl1);
        System.out.println(pl1.search(1979) + " - first index for 1979 (should be 0)");
        System.out.println("Index of shortest song, should be 1: "
                + pl1.shortestSongIndex());
        System.out.println();
        pl1.move(1, 0);
        System.out.println(pl1);
        System.out.println(pl1.search(1979) + " - first index for 1979 (should be 1)");
        System.out.println("Index of shortest song, should be 0: "
                + pl1.shortestSongIndex());
        System.out.println("Title of longest song (should be Rapper's Delight): " +
                pl1.longestSong().getTitle());
        System.out.println();
        PlayList pl2 = new PlayList();
        System.out.println(pl2);
        System.out.println(pl2.search(1979) + " - first index for 1979 (should be -1)");
        System.out.println("Index of shortest song, should be -1: "
                + pl2.shortestSongIndex());
        System.out.println("Longest song (should be null): " +
                pl2.longestSong());
        System.out.println();
        pl2.add(new Song("Rapper's Delight 1", "Sugarhill Gang", 1979, 427));
        pl2.add(new Song("Rapper's Delight 2", "Sugarhill Gang", 1979, 427));
        pl2.add(new Song("Rapper's Delight 3", "Sugarhill Gang", 1979, 427));
        System.out.println(pl2.search(1979) + " - first index for 1979 (should be 0)");
    }
}
