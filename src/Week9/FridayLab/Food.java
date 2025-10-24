package Week9.FridayLab;

public class Food {
    private String name;
    private double price;
    private int calories;

    public Food(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getCalories() {
        return calories;
    }

    public int getPriceInCents() {
        return (int) (price * 100);
    }

    public String toString(){
        return String.format("%s $%.2f %d calories", name, price, calories);
    }
}
