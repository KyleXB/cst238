package Week7.Lab;

public class Foo {
    private int bar;
    private String state;

    public Foo() {
        bar = 10;
        state = "Initial state";
    }

    public Foo(int bar) {
        this.bar = bar;
    }

    public String getState() {
        return state;
    }

    public void setState(String newState) {
        state = newState;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int newBar) {
        bar = newBar;
    }
}
