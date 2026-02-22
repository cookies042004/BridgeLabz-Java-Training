package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {

    @ImportantMethod
    public void criticalTask() {}

    @ImportantMethod(level = "MEDIUM")
    public void moderateTask() {}
}

public class MethodImportant {
    public static void main(String[] args) {

        for (Method method : Service.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + " - Level: " + im.level());
            }
        }
    }
}
