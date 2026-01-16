package core_programming.strings.level1;

import java.util.Scanner;

public class StringComparison {
    public static boolean compareString(String first,String second){
        if(first.length() != second.length()) {
            return false;
        }

        for(int i = 0;i < first.length();i++){
            if(first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string");
        String first = sc.next();

        System.out.println("Enter second string");
        String second = sc.next();

        boolean result = compareString(first,second);
        boolean builtIn = first.equals(second);

        System.out.println("result " + result);
        System.out.println("builtInResult " + builtIn);

        if(result && builtIn){
            System.out.println("Both matched");
        }
        else{
            System.out.println("Not matched");
        }
    }
}
