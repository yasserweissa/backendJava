package Threads;

public class Task3 extends Thread{
    @Override
    public void run(){
        System.out.println("Task3, starting to count...");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Task3, number: " + i +  "/5");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException: " + e.getMessage());
            }
        }

        System.out.println("Done counting! And that's all for Task 3");
    }
}
