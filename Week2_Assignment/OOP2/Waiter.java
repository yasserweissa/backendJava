package Week2_Assignment.OOP2;

public class Waiter extends Employee implements Eating{
    public Waiter (String name, int age, double salary, String role){
        super(name, age, salary, role);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is working as a " + getRole() + " and earns " + getSalary() + " per month.");
    }

    @Override
    public void eat() {
        System.out.println("Waiter " + getName() + " is having a quick meal break.");
    }
}
