import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get A
        int a = scanner.nextInt();

        // Get B
        int b = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Print the result
        if (a >= b) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}