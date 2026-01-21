package datastructures.linearbinarysearch;

public class ReverseUsingBuilder {
    public static String reverseUsingBuilder(String input){
        // string builder
        StringBuilder sb = new StringBuilder();

        // appending the input into the string builder
        sb.append(input);

        // reversing the string using string builder method
        sb.reverse();

        // returning the reverse string
        return sb.toString();
    }

    public static void main(String[] args) {
        String input= "hello";

        // storing result returning from function after reverse.
        String reversed = reverseUsingBuilder(input);

        System.out.println("input is " + input);
        System.out.println("reverse is " + reversed   );
    }
}
