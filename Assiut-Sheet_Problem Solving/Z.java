import java.util.Scanner;

public class Z {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();

        scanner.close();

        // This method was suggested by ChatGPT
        // Because the standard pow function requires int exponent
        // The task has up to 10^12 exponent, cannot be int

        // using logarithms is faster because log(a^b) simply equals b*log(a)
        // calculating both b*log(a) and d*log(c) is much faster
        // so we don't really to get the actual value for a^b and c^d
        double left = b * Math.log(a);
        double right = d * Math.log(c);

        if (left > right) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class Z {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        BigInteger a = scanner.nextBigInteger();
//        BigInteger b = scanner.nextBigInteger();
//        BigInteger c = scanner.nextBigInteger();
//        BigInteger d = scanner.nextBigInteger();
//
//        scanner.close();
//
//        BigInteger res1 = fastPow(a, b);
//        BigInteger res2 = fastPow(c, d);
//
//        if (res1.compareTo(res2) > 0) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//    }
//
//    // This method was suggested by ChatGPT
//    // Because the standard pow function requires int exponent
//    // The task has up to 10^12 exponent, cannot be int
//    public static BigInteger fastPow(BigInteger base, BigInteger exponent) {
//        BigInteger result = BigInteger.ONE;
//
//        while (exponent.signum() > 0) {
//            // exponent will be handled with its binary representation
//            // if the least significant bit is 1, we multiply the base
//            // if 0, we do not multiply
//            // either way, we proceed and move on to the next bit
//            if (exponent.testBit(0)) { // check if odd number using least significant bit
//                result = result.multiply(base);
//            }
//            base = base.multiply(base);
//            exponent = exponent.shiftRight(1); // (integer) divide exponent by 2
//        }
//
//        return result;
//    }
//}
