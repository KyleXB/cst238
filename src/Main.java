public class Main {
    public static void main(String[] args) {
        Building b1 = new Building("Chavez Hall");
        b1.addRoom(101, 1, 4);
        b1.addRoom(102, 1, 5);
        b1.addRoom(103, 1, 6);
        b1.addRoom(201, 2, 1);
        b1.addRoom(202, 2, 8);
        b1.addRoom(203, 2, 4);

        System.out.println(b1.printFloor(1));
        System.out.println(b1.printFloor(2));

    }
}
