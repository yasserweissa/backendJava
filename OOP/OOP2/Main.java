package OOP.OOP2;

public class Main {

    public static void main(String[] args) {
        Chef chef = new Chef("Ahmed", 35, 5000, "Chef");
        Waiter waiter = new Waiter("Omar", 24, 3500, "Waiter");

        System.out.printf("%-20s: ", "chef.introduce()");
        chef.introduce();

        System.out.printf("%-20s: ", "chef.work()");
        chef.work();

        System.out.printf("%-20s: ", "waiter.introduce()");
        waiter.introduce();

        System.out.printf("%-20s: ", "waiter.work()");
        waiter.work();

        System.out.printf("%-20s: ", "chef.eat()");
        chef.eat();

        System.out.printf("%-20s: ", "waiter.eat()");
        waiter.eat();

    }

}
