package Threads;

public class Task4 extends Thread{
    private final String name;

    public Task4(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task 4, starting now...(0/5)");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " is now at...(" + i + "/5)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException: " + e.getMessage());
            }
        }
        System.out.println("Done counting! And that's all for Task 4, " + name);
    }
}
