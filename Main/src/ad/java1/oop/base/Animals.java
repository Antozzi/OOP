package ad.java1.oop.base;

import ad.java1.oop.Dogs;
import ad.java1.oop.Cats;

public abstract class Animals {
    private int meters;
    private String aname;

    public Animals(int meters, String aname) {
        this.meters = meters;
        this.aname = aname;
    }

    public int getMeters() {
        return meters;
    }

    public String getAname() {
        return aname;
    }

    public static int getCountDogs(){
        return Dogs.count;
    }

    public static int getCountCats(){
        return Cats.count;
    }

    public abstract void runAnimal();

    public abstract void swimAnimal();
}
