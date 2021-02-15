public class Main {

    public static void main(String[] args) {

        System.out.println("Задачи 1-3");
        emplDisplay();
        System.out.println("Задачи 4-5");
        emplList();

    }

    static void emplDisplay() {
//,"email@email.com","+79011923344","USD1000","51"
        Staff employee = new Staff("Ivanov", "Mechanic", "email@email.com", "+79011923344", "USD1000", 51);
        employee.showEmployee();

    }

    static void emplList() {

        Staff[] emplArray = new Staff[5];
        emplArray[0] = new Staff("Ivanov", "Mechanic", "email@email.com", "+79011923344", "USD1000", 20);
        emplArray[1] = new Staff("Petrov", "Engineer", "email@email.com", "+79011923344", "USD4000", 30);
        emplArray[2] = new Staff("Sidorov", "Steward", "email@email.com", "+79011923344", "USD2000", 42);
        emplArray[3] = new Staff("Smirnov", "Sewage Sucker", "email@email.com", "+79011923344", "USD3000", 50);
        emplArray[4] = new Staff("Fokin", "Driver", "email@email.com", "+79011923344", "USD1000", 45);

        for (Staff item : emplArray) {
            if (item.getAge() > 41) {
                item.showEmployee();
            }
        }

    }

}
