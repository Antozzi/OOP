package ad.geekbrains.oop.hw7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int n) {
        int negafood = food - n;
        if (negafood < 0) return false;
        food -= n;
        return true;
    }

    public void addFood(int n) {
        this.food += n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

}
