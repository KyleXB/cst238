package Week5;

public class List {
    private String[] data;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    public List(){
        size = 0;
        data = new String[DEFAULT_CAPACITY];
    }

    public List(int capacity){
        size = 0;
        data = new String[capacity];
    }

    public int size(){
        return size;
    }

    public int listCapacity(){
        return data.length;
    }

    public String itemAt(int index){
        if(isEmpty()){
            System.out.println("Empty List");
            return null;
        } else if(index < 0 || index >= size){
            System.out.println("Invalid Index");
            return null;
        } else{
            return data[index];
        }
    }

    public void delete(int index){
        if(isEmpty()){
            System.out.println("Empty List");
        } else if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        } else{
            for(int i = index; i < size - 1; i++){
                data[i] = data[i+1];
            }
            size--;
        }
    }

    public void insert(String item, int index){
        if(size == data.length){
            System.out.println("List is full!");
        } else if (index < 0 || index > size){
            System.out.println("Invalid Index");
        } else{
            for(int i = size; i > index; i--){
                data[i] = data[i - 1];
            }
            data[index] = item;
            size++;
        }
    }

    public void append(String item){
        if(size == data.length){
            System.out.println("List is full!");
        } else{
            data[size++] = item;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        if(isEmpty()){
            return "Empty List";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(data[i] + " ");
        }
        return sb.toString();
    }
}

