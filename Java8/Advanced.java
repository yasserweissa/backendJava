package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class Advanced {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );

        System.out.println("1. Sort a list of employees by salary then by name");

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator
                        .comparingDouble(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());

        sortedEmployees.forEach(e ->
                System.out.println(e.getName() + " - " + e.getSalary()));

        System.out.println("2. Find the second highest number in a list");

        Optional<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHighest.ifPresent(n -> System.out.println("Second highest: " + n));

        System.out.println("3. Find duplicate elements in a list of integers");

        Set<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(duplicates);

        System.out.println("4. Remove null or empty strings from a list using stream");

        List<String> cleanedNames = names.stream()
                .filter(name -> name != null && !name.trim().isEmpty())
                .collect(Collectors.toList());

        System.out.println(cleanedNames);

        System.out.println("5. Partition students into pass/fail groups based on grade");

        Map<Boolean, List<Student>> passFail = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= 50));

        System.out.println("Passed:");
        passFail.get(true).forEach(s -> System.out.println(s.getName()));

        System.out.println("Failed:");
        passFail.get(false).forEach(s -> System.out.println(s.getName()));

    }
}
