import java.util.Scanner;

public class W {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input line
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        char[] operators = {'+', '-', '*'};
        int equalIndex = input.indexOf('=');

        for (char op : operators) {
            if (input.indexOf(op) != -1) {
                if (input.indexOf(op) > equalIndex){
                    continue;
                }
                int a = Integer.parseInt(input.substring(0, input.indexOf(op) - 1));
                int b = Integer.parseInt(input.substring(input.indexOf(op) + 2, equalIndex - 1));
                long c = Long.parseLong(input.substring(equalIndex + 2));
                if (op == '+'){
                    if ((a + b) == c){
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println(a + b);
                    }
                }
                else if (op == '-'){
                    if ((a - b) == c){
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println(a - b);
                    }
                }
                else if (op == '*'){
                    if ((a * b) == c){
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println(a * b);
                    }
                }
            }
        }
    }
}