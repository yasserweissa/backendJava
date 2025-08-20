package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basic {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("1. Filter to get even numbers only from a list of integers");
        System.out.println("numbers:\n" + numbers);
        System.out.println("evenNumbers:\n" + evenNumbers);

        List<String> namesStartingWithA = names.stream()
                .filter(name -> name != null && name.startsWith("A"))
                .toList();

        System.out.println("2. Find names starting with a specific letter (e.g., 'A')");
        System.out.println("names:\n" + names);
        System.out.println("namesStartingWithA:\n" + namesStartingWithA);

        List<String> uppercasedNames = names.stream()
                .filter(name -> name != null)
                .map(String::toUpperCase)
                .toList();

        System.out.println("3. Convert all strings to uppercase using stream");
        System.out.println("names:\n" + names);
        System.out.println("uppercasedNames:\n" + uppercasedNames);

        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("4. Sort a list of integers in descending order using streams");
        System.out.println("numbers:\n" + numbers);
        System.out.println("sortedDesc:\n" + sortedDesc);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        System.out.println("5. Remove duplicate elements from a list using distinct()");
        System.out.println("numbers:\n" + numbers);
        System.out.println("distinctNumbers:\n" + distinctNumbers);
    }
}
