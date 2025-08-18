import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] values = new long[3];
        long[] sortedValues = new long[3];

        for (int i = 0; i < 3; i++) {
            values[i] = scanner.nextLong();
            sortedValues[i] = values[i];
        }

        scanner.close();

        for (int j = 0; j < sortedValues.length - 1; j++) {
            for (int k = 0; k < sortedValues.length - 1 - j; k++) {
                if (sortedValues[k] > sortedValues[k + 1]) {
                    long temp = sortedValues[k];
                    sortedValues[k] = sortedValues[k + 1];
                    sortedValues[k + 1] = temp;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(sortedValues[i]);
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println(values[i]);
        }
    }
}