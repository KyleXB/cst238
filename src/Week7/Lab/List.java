package Week7.Lab;

public class List {
    private static int DEFAULT_CAPACITY = 10;
    private int size;
    private int [] data;

    public List() {
        this.size = 0;
        this.data = new int[DEFAULT_CAPACITY];
    }

    public List(int capacity) {
        this.size = 0;
        this.data = new int[capacity];
    }

    public List(int value, int repeats) {
        this();
        for (int i = 0; i < repeats; i++) {
            append(value);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(int item, int position) {
        if(this.size == this.data.length) {
            resize();
        }

        if(position < 0 || position > this.size) {
            System.out.println("** Illegal location to insert " + position + " **");
            return;
        }

        // right shift
        for(int i = this.size; i > position; i--) {
            this.data[i] = this.data[i-1];
        }

        this.data[position] = item;
        this.size++;
    }

    public void remove(int position) {
        if(isEmpty()) {
            System.out.println("** Empty list - cannot remove **");
            return;
        }

        if(position < 0 || position >= this.size) {
            System.out.println("** Illegal location to remove " + position + " **");
            return;
        }

        // only uncomment for arrays of objects!
        // data[position] = null;

        for(int i = position; i < this.size - 1; i++) {
            this.data[i] = this.data[i+1];
        }

        this.size--;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty list");
            return;
        } else {
            System.out.print("List of size " + this.size + ": ");
        }

        for(int i = 0; i < this.size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    public int find(int value) {
        for(int i = 0; i < this.size; i++) {
            if(this.data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int sum() {
        int sum = 0;
        for(int i = 0; i < this.size; i++) {
            sum += this.data[i];
        }
        return sum;
    }

    public void append(int value) {
        if(this.size == this.data.length) {
            resize();
        }

        this.data[this.size] = value;
        this.size++;
    }

    public void resize() {
        int[] temp = new int[this.data.length * 2];
        for(int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
        System.out.println("Array has been resized to " + temp.length);
    }

}