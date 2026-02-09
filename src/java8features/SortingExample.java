package java8features;

import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class SortingExample {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Amit", 25, 50000),
                new Person("Rahul", 30, 60000),
                new Person("Sita", 22, 45000)
        );

        people.sort((p1, p2) -> p1.age - p2.age);

        for (Person p : people) {
            System.out.println(p.name + " - " + p.age);
        }
    }
}

