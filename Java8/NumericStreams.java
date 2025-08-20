package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class NumericStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("1. Calculate the sum of a list of integers using reduce");
        System.out.println("sum: " + sum);

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        System.out.println("2. Find the maximum and minimum value in a list");
        max.ifPresent(m -> System.out.println("Max: " + m));
        min.ifPresent(m -> System.out.println("Min: " + m));

        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("3. Calculate the average of a list of doubles");
        average.ifPresent(avg -> System.out.println("Average: " + avg));

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("4. Multiply all integers in a list together using reduce");
        System.out.println("product: " + product);

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        System.out.println("5. Count how many numbers are positive in the list");
        System.out.println("positiveCount: " + positiveCount);
    }
}
