package Week9.FridayLab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter filename: ");
        Scanner fnInput = new Scanner(System.in);
        String fn =  fnInput.next();
        Food[] foods = readFood(fn);

        System.out.println("Menu: ");
        for (Food food : foods) {
            System.out.println("\t" + food);
        }

        sort(foods, true);
        System.out.println("Sorted Menu by Price: ");
        for (Food food : foods) {
            System.out.println("\t" + food);
        }

        sort(foods, false);
        System.out.println("Sorted Menu by Calories: ");
        for (Food food : foods) {
            System.out.println("\t" + food);
        }
    }

    public static void sort(Food[] menu, boolean price) {
        if (price) {
            for (int i = 0; i < menu.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < menu.length; j++) {
                    if (menu[i].comparePrice(menu[j]) > 0) {
                        minIndex = j;
                    }
                }
                Food temp = menu[i];
                menu[i] = menu[minIndex];
                menu[minIndex] = temp;
            }
        } else {
                for (int i = 0; i < menu.length - 1; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < menu.length; j++) {
                        if (menu[i].compareCalories(menu[j]) > 0) {
                            minIndex = j;
                        }
                    }
                    Food temp = menu[i];
                    menu[i] = menu[minIndex];
                    menu[minIndex] = temp;
            }
        }
    }

    public static Food[] readFood(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        Scanner frin = new Scanner(fr);

        Food[] foods = new Food[frin.nextInt()];
        for(int i = 0; i < foods.length; i++){
            foods[i] = new Food(frin.next(), frin.nextDouble(), frin.nextInt());
        }

        return foods;
    }
}
