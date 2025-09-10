public class RoomBullochKyle {
    private int number;
    private int floor;
    private int capacity;

    public RoomBullochKyle(int num, int fl, int cap) {
        number = num;
        floor = fl;
        capacity = cap;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }
    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return "Your room is room " + number + " on floor " + floor + ". The capacity in the room is " + capacity + " people.";
    }
}
