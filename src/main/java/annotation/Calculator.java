package annotation;

import java.lang.reflect.*;
import java.util.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult1 {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Calculator {
    private static Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int square(int num) {
        System.out.println("Computing...");
        return num * num;
    }

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method method = Calculator.class.getMethod("square", int.class);

        int input = 5;

        if (method.isAnnotationPresent(CacheResult1.class)) {

            if (cache.containsKey(input)) {
                System.out.println("From Cache: " + cache.get(input));
            } else {
                int result = (int) method.invoke(calc, input);
                cache.put(input, result);
                System.out.println("Computed: " + result);
            }
        }

        // Second call
        if (cache.containsKey(input)) {
            System.out.println("From Cache: " + cache.get(input));
        }
    }
}
