package reflection;

import java.lang.reflect.*;

public class StaticFieldDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Configuration.class;

        Field field = clazz.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Before: " + field.get(null));

        field.set(null, "NEW_SECRET_KEY");

        System.out.println("After: " + field.get(null));
    }
}
