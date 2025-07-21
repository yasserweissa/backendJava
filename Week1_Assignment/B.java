import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get int input
        int intValue = scanner.nextInt();

        // Get long input (no long long in java)
        long longValue = scanner.nextLong();

        // Get char input
        String stringValue = scanner.next();
        char charValue = stringValue.charAt(0);

        // Get float input
        float floatValue = scanner.nextFloat();

        // Get double input
        double doubleValue = scanner.nextDouble();

        // Close the scanner
        scanner.close();

        // Print the values
        System.out.println(intValue);
        System.out.println(longValue);
        System.out.println(charValue);
        System.out.println(floatValue);
        System.out.println(doubleValue);
    }
}