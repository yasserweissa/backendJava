import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /// Get char input
        String stringValue = scanner.next();
        char charValue = stringValue.charAt(0);

        scanner.close();

        if (charValue >= 97 && charValue <= 122){
            charValue -= 32;
            System.out.println(charValue);
        }
        else if (charValue >= 65 && charValue <= 90){
            charValue += 32;
            System.out.println(charValue);
        }
    }
}