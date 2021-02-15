public class Staff {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private String salary;
    private int age;

    public Staff(String fio,String position,String email,String phone,String salary, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void showEmployee(){
        System.out.printf("Employee %s with Position %s, " +
                "Email %s, Phone %s, Salary %s and Age %s %n",
                fio,position,email,phone,salary,age);
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }


    public String getFio() {
        return fio;
    }


    public String getPhone() {
        return phone;
    }


    public String getPosition() {
        return position;
    }


    public String getSalary() {
        return salary;
    }
}
