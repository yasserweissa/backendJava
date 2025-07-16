import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get A
        long a = scanner.nextLong();

        // Get B
        long b = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // Print the result
        if (a%b == 0) {
            System.out.println("Multiples");
        }
        else if (b%a == 0) {
            System.out.println("Multiples");
        }
        else{
            System.out.println("No Multiples");
        }
    }
}