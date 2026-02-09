package java8features;

@FunctionalInterface
interface SquareOperation {
    int square(int x);

    default void printResult(int x) {
        System.out.println("Square of " + x + " is " + square(x));
    }
}

public class CustomInterfaceWithDefault {
    public static void main(String[] args) {

        SquareOperation sq = x -> x * x;

        sq.printResult(6);
    }
}

