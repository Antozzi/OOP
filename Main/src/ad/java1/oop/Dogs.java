package ad.java1.oop;

import ad.java1.oop.base.Animals;

public class Dogs extends Animals {
    public static int count;
    private int runLimit;
    private int swimLimit;

    public Dogs(int meters, String aname) {
        super(meters, aname);
        this.runLimit = 500;
        this.swimLimit = 10;
        count++;
    }

    public static int getCountDogs() {
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

        if (getMeters() < swimLimit) {
            System.out.println(getAname() + " проплыл " + getMeters() + " м");
        } else System.out.println(getAname() + " может проплыть только " + swimLimit + " м");

    }
}
