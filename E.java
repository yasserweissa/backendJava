import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get R
        double R = scanner.nextDouble();

        // Close the scanner
        scanner.close();

        double pie = 3.141592653;

        // Print the resulting difference
        System.out.println(pie * R * R);
    }
}