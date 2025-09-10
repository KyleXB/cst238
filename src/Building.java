public class Building {
    private String name;
    private Room[] rooms;
    private int roomCount;

    public Building(String nm) {
        name = nm;
        rooms = new Room[20];
        roomCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void addRoom(int num, int fl, int cap) {
        rooms[roomCount] = new Room(num, fl, cap);
        roomCount++;
    }

    public String printRooms() {
        StringBuilder output = new StringBuilder(name);
        for (int i = 0; i < roomCount; i++) {
            output.append("\n").append(rooms[i].toString());
        }
        return output.toString();
    }

    public String printFloor(int flr) {
        StringBuilder output = new StringBuilder("Floor " + flr);
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getFloor() == flr) {
                output.append("\n").append(rooms[i].toString());
            }
        }
        return output.toString();
    }

    public int totalCapacity() {
        int total = 0;
        for (int i = 0; i < roomCount; i++) {
            total += rooms[i].getCapacity();
        }

        return total;
    }



}
