package Exception_Handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] array = {'a','b','c','d','e','f'};
        boolean isInvalidTried = false;
        boolean isValidTried = false;
        System.out.println("This is Level 2: Working with Arrays and Files\nWe attempt accessing an invalid index and opening a non existing file.");
        while (true){
            try {
                if(isInvalidTried && isValidTried){
                    break;
                }
                System.out.println("Enter i (0-5 are the valid indexes)");
                int i = scanner.nextInt();
                System.out.println("array["+i+"] = " + array[i]);
                if (!isInvalidTried){
                    System.out.println("Try an invalid index as well");
                }
                isValidTried = true;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Task 4 ArrayIndexOutOfBoundsException" + e.getMessage());
                isInvalidTried = true;
                if(!isValidTried){
                    System.out.println("Try a valid index as well");
                }
            }
        }

        try {
            System.out.println("Now attempting to open a non-existing file.");
            File file = new File("not_a_real_file.txt");
            Scanner scanner2 = new Scanner(file);

            System.out.println("File contents:");
            while (scanner2.hasNextLine()) {
                System.out.println(scanner2.nextLine());
            }
            scanner2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Task 5 FileNotFoundException: " + e.getMessage());
        }

        System.out.println("Task 6 is about using multiple catch blocks...\n this was already implemented in level 1 between tasks 1 and 2\n");
        System.out.println("That's all for Level 2: Working with Arrays and Files\n");
    }
}
