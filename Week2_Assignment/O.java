import java.util.Scanner;

public class O {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input line
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        char[] operators = {'+', '-', '*', '/'};

        for (char op : operators) {
            if (input.indexOf(op) != -1) {
                int a = Integer.parseInt(input.substring(0, input.indexOf(op)));
                int b = Integer.parseInt(input.substring(input.indexOf(op) + 1));
                if (op == '+'){
                    System.out.println(a + b);
                }
                else if (op == '-'){
                    System.out.println(a - b);
                }
                else if (op == '*'){
                    System.out.println(a * b);
                }
                else{
                    System.out.println(a / b);
                }
                break;
            }
        }
    }
}