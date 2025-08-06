import java.util.Scanner;

public class P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get X
        long X = scanner.nextLong();

        // Close the scanner
        scanner.close();

        // X is from 1000 to 9999
        long firstDigit = (X/1000);

        if (firstDigit%2 == 0){
            System.out.println("EVEN");
        }
        else{
            System.out.println("ODD");
        }
    }
}