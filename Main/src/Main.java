import ad.geekbrains.oop.hw7.Cat;
import ad.geekbrains.oop.hw7.Plate;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Cat[] cat = {
                new Cat("Barsik", 5, false),
                new Cat("Murzik", 7, false),
                new Cat("Vaska", 9, false),
        };

        Plate plate = new Plate(0);
        System.out.println("The food on the plate is " + plate.getFood());
        System.out.println("Type the number of food if you want to feed the cats");
        plate.addFood(sc.nextByte());

        System.out.println("Initial size of the");
        plate.info();
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            cat[i].info();
            System.out.println("Current size of the");
            plate.info();
        }
    }
}
