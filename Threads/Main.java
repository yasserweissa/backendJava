package Threads;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.start();

        Task2 task2 = new Task2();
        Thread thread = new Thread(task2, "Thread-Task2");
        thread.start();

        Task3 task3 = new Task3();
        task3.start();

        Task4 task4A = new Task4("T4A");
        Task4 task4B = new Task4("T4B");

        task4A.start();
        task4B.start();

        try {
            task4A.join();
            task4B.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        }
        System.out.println("If this is printed, Task4A and Task4B must have been completed already\nNow Task 5...");

        Task5 task5 = new Task5();

        // Depositor thread
        Thread depositor = new Thread(() -> {
            int[] deposits = {100, 200, 150, 300};
            for (int amount : deposits) {
                task5.deposit(amount);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Depositor interrupted.");
                }
            }
        }, "Depositor");

        // Withdrawer thread
        Thread withdrawer = new Thread(() -> {
            int[] withdrawals = {50, 100, 250, 200};
            for (int amount : withdrawals) {
                task5.withdraw(amount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Withdrawer interrupted.");
                }
            }
        }, "Withdrawer");

        depositor.start();
        withdrawer.start();
    }
}
