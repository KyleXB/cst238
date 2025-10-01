package Week5;

public class StackChar {
    private char[] data;
    private int top;
    public static final int DEFAULT_CAPACITY = 10;

    public StackChar(){
        top = -1;
        data = new char[DEFAULT_CAPACITY];
    }

    public StackChar(int capacity){
        top = -1;
        data = new char[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(char item){
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

    public char top(){
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

