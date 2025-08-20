package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Intermediate {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        long countLongStrings = names.stream()
                .filter(name -> name != null && name.length() > 5)
                .count();

        System.out.println("1. Count the number of strings longer than 5 characters");
        System.out.println("names:\n" + names);
        System.out.println("countLongStrings:\n" + countLongStrings);

        System.out.println("2. Find the first element in a stream that matches a given condition (e.g., first name starting with 'M')");
        Optional<String> firstNameWithM = names.stream()
                .filter(name -> name != null && name.startsWith("M"))
                .findFirst();

        System.out.println("firstNameWithM:");
        firstNameWithM.ifPresent(System.out::println);

        boolean anyDivisibleBy5 = numbers.stream()
                .anyMatch(n -> n % 5 == 0);

        System.out.println("3. Check if any number is divisible by 5 in a list");
        System.out.println("anyDivisibleBy5:\n" + anyDivisibleBy5);

        Set<String> namesSet = names.stream()
                .filter(name -> name != null)
                .collect(Collectors.toSet());

        System.out.println("4. Collect elements into a Set instead of a List");
        System.out.println("namesSet:\n" + namesSet);

        List<Integer> skippedFirstThree = numbers.stream()
                .skip(3)
                .toList();

        System.out.println("5. Skip the first 3 elements and return the rest");
        System.out.println("numbers:\n" + numbers);
        System.out.println("skippedFirstThree:\n" + skippedFirstThree);
    }
}
