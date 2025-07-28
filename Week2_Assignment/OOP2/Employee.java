package Week2_Assignment.OOP2;


public abstract class Employee extends Person {
    private double salary;
    private String role;

    public Employee(String name, int age, double salary, String role){
        super(name, age);
        this.salary = salary;
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }
    public String getRole() {
        return role;
    }

    public abstract void work();
}
