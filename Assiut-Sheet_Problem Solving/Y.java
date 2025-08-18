import java.math.BigInteger;
import java.util.Scanner;

public class Y {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input values
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger c = scanner.nextBigInteger();
        BigInteger d = scanner.nextBigInteger();

        // Close the scanner
        scanner.close();

        // Cannot multiply or mod BigInteger normally
        BigInteger product = a.multiply(b).multiply(c).multiply(d);
        BigInteger remaining = product.mod(BigInteger.valueOf(100));

        // Cannot compare BigInteger using == either, compareTo is used instead
        int result = remaining.compareTo(BigInteger.valueOf(10)); // -1 is means not greater than 10


        if (result == -1) {
            System.out.println("0" + remaining);
        }
        else {
            System.out.println(product.mod(BigInteger.valueOf(100)));
        }
    }
}