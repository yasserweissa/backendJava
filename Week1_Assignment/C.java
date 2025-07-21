import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get X
        long x = scanner.nextLong();

        // Get y
        long y = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // Print the values
        System.out.println(x + " + " + y + " = " + (x + y));
        System.out.println(x + " * " + y + " = " + (x * y));
        System.out.println(x + " - " + y + " = " + (x - y));
    }
}