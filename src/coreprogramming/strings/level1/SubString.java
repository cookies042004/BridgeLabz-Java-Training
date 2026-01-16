package coreprogramming.strings.level1;

import java.util.Scanner;

public class SubString {
    // function for comparing two strings
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
    public static String stringChar(String string,int s,int e){
        if(s < 0 || e > string.length() || s > e){
            System.out.println("Enter start and end within the limits");
            return "";
        }

        StringBuilder result = new StringBuilder();

        for(int i = s;i < e;i++){
            result.append(string.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string");
        String s = sc.next();

        System.out.println("Enter start index for substring");
        int start = sc.nextInt();

        System.out.println("Enter end index for substring");
        int end = sc.nextInt();

        String stringUsingChar = stringChar(s,start,end);

        String usingBuiltIn = s.substring(start,end);

        System.out.println("Substring using char " + stringUsingChar);
        System.out.println("Substring using builtIn method " + usingBuiltIn);

        boolean compareResult = compareString(stringUsingChar,usingBuiltIn);

        if(compareResult){
            System.out.println("Substring matched with both methods");
        }
        else {
            System.out.println("Substring not matched");
        }
    }
}
