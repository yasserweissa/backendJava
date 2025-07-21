import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get n
        long n = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // Print the result, use formula
        System.out.println(n * (n + 1) / 2);
    }
}