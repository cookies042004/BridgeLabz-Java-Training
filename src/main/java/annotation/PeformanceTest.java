package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void slowMethod() throws Exception {
        Thread.sleep(500);
    }

    public static void main(String[] args) throws Exception {

        PerformanceTest obj = new PerformanceTest();

        for (Method method : PerformanceTest.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();

                System.out.println(method.getName() +
                        " executed in " + (end - start) + " ns");
            }
        }
    }
}
