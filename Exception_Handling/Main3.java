package Exception_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isInvalidTried = false;
        boolean isValidTried = false;
        System.out.println("This is Level 3: Custom Exceptions\nWe explore custom exceptions and propagated exceptions.");
        while (true){
            try {
                if(isInvalidTried && isValidTried){
                    break;
                }
                startApplication();
                isValidTried = true;
                if (!isInvalidTried){
                    System.out.println("Try an invalid index as well");
                }
            } catch (InvalidAgeException e) {
                System.out.println("Tasks 7 & 9: Propagated InvalidAgeException caught in main: " + e.getMessage());
                isInvalidTried = true;
                if(!isValidTried){
                    System.out.println("Try a valid index as well");
                }
            }
        }


        try {
            System.out.println("Now attempting to open a non-existing file.");
            readFile();
        } catch (IOException e) {
            System.out.println("Task 10: IOException caught: " + e.getMessage());
        }
    }

    public static void startApplication() throws InvalidAgeException {
        processUser();
    }

    public static void processUser() throws InvalidAgeException {
        System.out.println("Enter your age: ");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        validateAge(age);
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older. You entered: " + age);
        }
        System.out.println("Valid age: " + age);
    }

    public static void readFile() throws IOException {
        FileReader fr = new FileReader("not_an_actual_file.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        System.out.println("File contents:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fr.close();
    }
}

