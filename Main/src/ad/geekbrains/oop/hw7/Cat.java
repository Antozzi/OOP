package ad.geekbrains.oop.hw7;


public class Cat {

    private int appetite;
    private String name;
    private boolean hungry;

    public Cat(String name, int appetite, boolean fed) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void info() {
        String isFed = !hungry ? "is fed" : "is hungry";
        System.out.println(name + " - " + isFed + " by " + appetite + " food ea.");
    }

    public void eat(Plate p) {
        if (hungry && p.decreaseFood(appetite)) {
            hungry = false;
        } else  hungry = true;
    }

}
