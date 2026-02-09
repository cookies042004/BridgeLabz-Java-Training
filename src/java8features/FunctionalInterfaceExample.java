package java8features;

@FunctionalInterface
interface AddOperation {
    int add(int a, int b);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {

        AddOperation sum = (a, b) -> a + b;

        int result = sum.add(10, 20);
        System.out.println("Sum: " + result);
    }
}

