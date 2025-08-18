package Exception_Handling;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coverageCount = 0;
        int [] taskNum = new int[4];
        System.out.println("This is Level 1: Basic Try-Catch Practice\nTo complete this level, try...\n\tdividing by zero\n\tinserting non-numeric string\n\tnormal values\n");
        while (true) {
            try {
                System.out.println("[scenarios yet to be seen = " + (3 - coverageCount) + "]\n");
                System.out.print("Divide Two Numbers!\nPlease enter the first number:");
                String str1 = scanner.nextLine();
                int num1 = Integer.parseInt(str1);

                System.out.print("Please enter the second number:");
                String str2 = scanner.nextLine();
                int num2 = Integer.parseInt(str2);

                System.out.println(num1 / num2 + " (no exception)");
                if (taskNum[0] == 0){
                    coverageCount++;
                    taskNum[0] = 1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Task 2: NumberFormatException caught: " + e.getMessage());
                if (taskNum[2] == 0){
                    coverageCount++;
                    taskNum[2] = 1;
                }
            } catch (ArithmeticException e){
                System.out.println("Task 1: ArithmeticException caught: " + e.getMessage());
                if (taskNum[1] == 0){
                    coverageCount++;
                    taskNum[1] = 1;
                }
            } catch (RuntimeException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
            if (coverageCount == 3){
                try {
                    System.out.println("\nNow attempting to set a null string to an uppercase");
                    String s = null;
                    System.out.println(s.toUpperCase());
                } catch (NullPointerException e){
                    System.out.println("Task 3: NullPointerException caught: " + e.getMessage() + "\n");
                    taskNum[3] = 1;
                }
                System.out.println("That's all for Level 1: Basic Try-Catch Practice");
                break;
            }
        }
    }
}
