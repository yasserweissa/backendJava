package Threads;

public class Task5 {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Balance: " + balance);
        notify(); // Notify any waiting withdrawer
    }

    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " wants to withdraw " + amount + " but balance is " + balance + ". Waiting...");
            try {
                wait(); // Wait until enough balance
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Balance: " + balance);
    }
}

