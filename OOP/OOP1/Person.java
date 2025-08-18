package OOP.OOP1;

public class Person {
    String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void introduce(){
        System.out.println("I would like to introduce " + name + " who is " + age + " years old.");
    }
}
