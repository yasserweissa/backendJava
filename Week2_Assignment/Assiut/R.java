import java.util.Scanner;

public class R {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get X and Y
        int N = scanner.nextInt();

        // Close the scanner
        scanner.close();
        int numOfYears = N / 365;
        int lessthan365 = N % 365;

        int numOfMonths = lessthan365 / 30;
        int lessthan30 = lessthan365 % 30;

        System.out.println(numOfYears + " years\n" + numOfMonths + " months\n" + lessthan30 + " days" );
    }
}