package Week2_Assignment.OOP2;

public class Chef extends Employee implements Eating{
    public Chef (String name, int age, double salary, String role){
        super(name, age, salary, role);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is working as a " + getRole() + " and earns " + getSalary() + " per month.");
    }

    @Override
    public void eat() {
        System.out.println("Chef " + getName() + " is tasting the food.");
    }
}
