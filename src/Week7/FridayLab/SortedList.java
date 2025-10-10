package Week7.FridayLab;

public class SortedList {
    private int size;
    private int[] data;
    public static final int DEFAULT_CAPACITY = 10;

    public SortedList() {
        data = new int[DEFAULT_CAPACITY];
        size = 5;
        for (int i = 1; i <= size; i++) {
            data[i - 1] = i * 5;
        }
    }

    public int getSize() {
        return size;
    }

    public void insertSorted(int value) {
        if (size == data.length) {
            resize();
        }

        int sortIndex = 0;
        for (int i = 0; i <= size; i++) {
            if (data[i] > value) {
                sortIndex = i;
                break;
            } else {
                sortIndex = size;
            }
        }
        for (int i = size; i > sortIndex; i--) {
            data[i] = data[i - 1];
        }
        data[sortIndex] = value;
        size++;
    }

    public void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        return sb.toString();
    }

}
