package OOP.OOP1;

public class Employee extends Person{
    private double salary;
    private String role;

    public Employee(String name, int age, double salary, String role){
        super(name, age);
        this.salary = salary;
        this.role = role;
    }

    public void work(){
        System.out.println(name + " is working as a " + role + " and earns " + salary + " per month.");
    }
}
