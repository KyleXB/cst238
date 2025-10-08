package Week7.Lab;

public class Main {
    public static void main(String[] args) {
        Foo f1 = new Foo();
        System.out.println(f1);

//        int a = 5;
//        System.out.println("a: " + a);
//        updateData(f1, a);
    }

    public static void updateData(Foo f, int a) {
        System.out.println("Inside Method");
        f.setState("Updated State");
        a = 10;
        System.out.println(f.getState());
        System.out.println("a: " + a);
    }
}
