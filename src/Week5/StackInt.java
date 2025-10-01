package Week5;

public class StackInt {
    private int[] data;
    private int top;
    public static final int DEFAULT_CAPACITY = 10;

    public StackInt(){
        top = -1;
        data = new int[DEFAULT_CAPACITY];
    }

    public StackInt(int capacity){
        top = -1;
        data = new int[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int item){
        if(top == data.length - 1){
            System.out.println("Stack is full, cannot push " + item);
        } else{
            data[++top] = item;
        }
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack empty, cannot pop");
        } else {
            top--;
        }
    }

    public int top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return '\0';
        }else {
            return data[top];
        }
    }

    public String toString(){
        System.out.println("Hello");
        if(isEmpty()){
            return "Empty Stack";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = top; i >= 0; i--){
            sb.append(data[i]).append(' ');
        }
        return sb.toString();
    }
}

