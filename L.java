import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get A B and C
        String fullName1 = scanner.nextLine();
        String fullName2 = scanner.nextLine();

        int index1 = fullName1.indexOf(' ');
        String secondName1 = fullName1.substring(index1);

        int index2 = fullName2.indexOf(' ');
        String secondName2 = fullName2.substring(index2);

        if (secondName1.equals(secondName2)){
            System.out.println("ARE Brothers");
        }
        else{
            System.out.println("NOT");
        }
    }
}