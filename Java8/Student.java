package Java8;

public class Student {
    private String name;
    private String department;
    private double grade;


    public Student(String name, String department, double grade) {
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getGrade() {
        return grade;
    }
}
