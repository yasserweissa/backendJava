import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get n
        long n = scanner.nextLong();

        // Get m
        long m = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // Print the values
        System.out.println((n%10 + m%10));
    }
}