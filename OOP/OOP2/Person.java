package OOP.OOP2;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void introduce(){
        System.out.println("I would like to introduce " + name + " who is " + age + " years old.");
    }
}
