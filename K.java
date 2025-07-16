import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get A B and C
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        // Close the scanner
        scanner.close();
        long max;
        long min;

        // Getting min and max result
        if (a >= b && a >= c) {
            max = a;
        }
        else if (b >= a && b >= c) {
            max = b;
        }
        else {
            max = c;
        }
        if (a <= b && a <= c) {
            min = a;
        }
        else if (b <= a && b <= c) {
            min = b;
        }
        else {
            min = c;
        }
        System.out.println(min + " " + max);
    }
}