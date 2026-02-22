package reflection;

import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionDemo3 {
    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();

        Class<?> clazz = calculator.getClass();
        Method method = clazz.getDeclaredMethod("multiply", int.class, int.class);

        method.setAccessible(true);  // Allow access

        int result = (int) method.invoke(calculator, 5, 4);

        System.out.println("Result: " + result);
    }
}