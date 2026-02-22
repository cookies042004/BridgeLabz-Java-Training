package reflection;

import java.lang.reflect.*;

class Sample {
    private int id;
    public String name;

    public Sample() {}

    public Sample(int id) {
        this.id = id;
    }

    public void display() {
        System.out.println("Hello");
    }

    private void secret() {}
}

public class ReflectionDemo1 {
    public static void main(String[] args) {

        Class<?> clazz = Sample.class;

        // Fields
        System.out.println("---- Fields ----");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        // Methods
        System.out.println("---- Methods ----");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        // Constructors
        System.out.println("---- Constructors ----");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }
    }
}
