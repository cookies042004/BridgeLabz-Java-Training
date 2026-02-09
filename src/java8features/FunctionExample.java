package java8features;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        Function<Double, Double> area = r -> Math.PI * r * r;

        double result = area.apply(5.0);
        System.out.println("Area of circle: " + result);
    }
}

