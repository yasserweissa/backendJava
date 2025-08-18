import java.util.Scanner;

public class U {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input line
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        char dot = '.';

        if (input.indexOf(dot) != -1) {
            int a = Integer.parseInt(input.substring(0, input.indexOf(dot)));
            int b = Integer.parseInt(input.substring(input.indexOf(dot) + 1));
            String bAsText = input.substring(input.indexOf(dot) + 1);
            if (b == 0){
                System.out.println("int " + a);
            }
            else{
                System.out.println(("float " + a + " 0." + bAsText));
            }
        }
    }
}