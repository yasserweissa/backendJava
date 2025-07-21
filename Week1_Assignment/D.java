import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get four numbers
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // Print the resulting difference
        System.out.println("Difference = " + ((a*b) - (c*d)));
    }
}