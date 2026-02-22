package reflection;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

@Author(name = "Akhil Puri")
class Book {
}

class Configuration {
    private static String API_KEY = "OLD_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

class User {
    private String name;
    private int age;

    public String toString() {
        return name + " - " + age;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}
