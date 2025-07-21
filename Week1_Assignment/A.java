import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get String input
        String name = scanner.nextLine();
        System.out.println("Hello, " + name );

        // Close the scanner
        scanner.close();
    }
}