import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get A
        int a = scanner.nextInt();

        // Get B
        int b = scanner.nextInt();

        // Close the scanner
        scanner.close();

        double division = (double)a/b;

        // Print the result
        System.out.println("floor " + a + " / " + b + " = " + (int)division);
        if (a != b) {
            System.out.println("ceil " + a + " / " + b + " = " + (int)(division + 1));
        }
        else{
            System.out.println("ceil " + a + " / " + b + " = " + (int)(division));
        }
        System.out.println("round " + a + " / " + b + " = " + Math.round(division));
    }
}