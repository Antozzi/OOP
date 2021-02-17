package ad.java1.oop;

import ad.java1.oop.base.Animals;

public class Cats extends Animals {

    private int runLimit;
    public static int count;

    public Cats(int meters, String aname) {
        super(meters, aname);
        this.runLimit = 200;
        count++;
    }

    public static int getCountCats() {
        return count;
    }

    @Override
    public void runAnimal() {
        if (getMeters() < runLimit) {
            System.out.println(getAname() + " пробежал " + getMeters() + " м");
        } else System.out.println(getAname() + " может пробежать только " + runLimit + " м");
    }

    @Override
    public void swimAnimal() {

        System.out.println(getAname() + " не умеет плавать:(");

    }

}
