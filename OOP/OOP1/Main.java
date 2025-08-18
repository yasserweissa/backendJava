package OOP.OOP1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Chef chef = new Chef("Ahmed", 35, 5000.0, "Chef");
        Waiter waiter= new Waiter("Omar", 24, 3500.0, "Waiter");

        chef.introduce();
        chef.work();
        waiter.introduce();
        waiter.work();
    }



}
