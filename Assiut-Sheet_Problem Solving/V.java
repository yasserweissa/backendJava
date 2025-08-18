import java.util.Scanner;

public class V {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input line
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        char[] operators = {'<', '>', '='};

        for (char op : operators) {
            if (input.indexOf(op) != -1) {
                int a = Integer.parseInt(input.substring(0, input.indexOf(op) - 1));
                int b = Integer.parseInt(input.substring(input.indexOf(op) + 2));
                if (op == '<' &&  (a < b)){
                    System.out.println("Right");
                }
                else if (op == '>' && (a > b)){
                    System.out.println("Right");
                }
                else if (op == '=' && (a == b)){
                    System.out.println("Right");
                }
                else {
                    System.out.println("Wrong");
                }
            }
        }
    }
}