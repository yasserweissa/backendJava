import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input line
        long l1 = scanner.nextLong();
        long r1 = scanner.nextLong();
        long l2 = scanner.nextLong();
        long r2 = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // This approach was recommended by ChatGPT
        long start = Math.max(l1, l2);
        long end   = Math.min(r1, r2);
        if (start <= end) {
            System.out.println(start + " " + end);
        } else {
            System.out.println("-1");
        }
    }
}