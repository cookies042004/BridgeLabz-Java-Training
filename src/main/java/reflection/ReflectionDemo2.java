package reflection;

import java.lang.reflect.*;

class Person {
    private int age = 25;
}

public class ReflectionDemo2 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Class<?> clazz = person.getClass();
        Field field = clazz.getDeclaredField("age");

        field.setAccessible(true);  // Bypass private access

        // Get value
        int currentAge = (int) field.get(person);
        System.out.println("Before change: " + currentAge);

        // Modify value
        field.set(person, 30);

        int newAge = (int) field.get(person);
        System.out.println("After change: " + newAge);
    }
}
