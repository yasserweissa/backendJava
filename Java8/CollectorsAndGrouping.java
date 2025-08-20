package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAndGrouping {
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

        System.out.println("1. Group a list of students by their department");

        Map<String, List<Student>> studentsByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        studentsByDept.forEach((dept, list) -> {
            System.out.println(dept + ": " + list.stream().map(Student::getName).collect(Collectors.toList()));
        });

        System.out.println("2. Partition a list of numbers into even and odd using partitioningBy");

        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even: " + evenOddPartition.get(true));
        System.out.println("Odd: " + evenOddPartition.get(false));

        System.out.println("3. Create a comma-separated string from a list of strings");

        String csv = names.stream()
                .filter(name -> name != null && !name.isEmpty())
                .collect(Collectors.joining(", "));

        System.out.println("comma-separated string: " + csv);

        System.out.println("4. Group employees by age and count how many per age");

        Map<Integer, Long> employeeCountByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));

        System.out.println("employeeCountByAge: " + employeeCountByAge);

        System.out.println("5. Find the average salary per department in a list of employees");

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println("avgSalaryByDept: " + avgSalaryByDept);
    }
}
