package Week2_Assignment.OOP1;

public class Chef extends Employee{
    public Chef (String name, int age, double salary, String role){
        super(name, age, salary, role);
    }

    @Override
    public void work() {
        super.work();
        System.out.println("So, " + name + " mainly prepares dishes.");
    }
}
