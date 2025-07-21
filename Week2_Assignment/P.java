import java.util.Scanner;

public class P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get X and Y
        double X = scanner.nextDouble();
        double Y = scanner.nextDouble();

        // Close the scanner
        scanner.close();

        if (X > 0 && Y > 0){
            System.out.println("Q1");
        }
        else if (X < 0 && Y < 0){
            System.out.println("Q3");
        }
        else if (X > 0 && Y < 0){
            System.out.println("Q4");
        }
        else if (X < 0 && Y > 0){
            System.out.println("Q2");
        }
        else if (X == 0 && Y == 0){
            System.out.println("Origem");
        }
        else if (X == 0 && Y != 0){
            System.out.println("Eixo Y");
        }
        else if (Y == 0 && X != 0){
            System.out.println("Eixo X");
        }
    }
}