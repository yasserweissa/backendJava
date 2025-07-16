import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /// Get char input
        String stringValue = scanner.next();
        char charValue = stringValue.charAt(0);

        scanner.close();

        if (charValue >= 97 && charValue <= 122){
            System.out.println("ALPHA\nIS SMALL");
        }
        else if (charValue >= 65 && charValue <= 90){
            System.out.println("ALPHA\nIS CAPITAL");
        }
        else{
            System.out.println("IS DIGIT");
        }
    }
}