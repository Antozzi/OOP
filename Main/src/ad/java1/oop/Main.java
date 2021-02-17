package ad.java1.oop;

import ad.java1.oop.base.Animals;

public class Main {

    public static void main(String[] args) {


        Animals[] animals = {
                new Dogs(600,"Пират"),
                new Cats(230,"Мурзик"),
                new Dogs(430,"Полкан"),
                new Cats(180,"Маркиз"),
                new Cats(100,"Васька")
        };

        for (int i = 0; i < animals.length; i++) {
            animals[i].runAnimal();
            animals[i].swimAnimal();
        }

        System.out.println("Подсчет животных\nЖивотных: " + animals.length + "\nСобак: " + Dogs.getCountDogs() + "\nКошек: " + Cats.getCountCats());

    }

}
