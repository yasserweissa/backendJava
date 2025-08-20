package Threads;

public class Task2 implements Runnable{
    @Override
    public void run(){
        System.out.println("This is " + Thread.currentThread().getName() + ", and that's all for Task 2");
    }
}
