package coreprogramming.strings.level1;

import java.util.Scanner;

public class Characters {
    // method to store string result into array
    public static char[] userFunction(String s){
        char[] result = new char[s.length()];

        for(int i = 0;i < s.length();i++){
            result[i] = s.charAt(i);
        }

        return result;
    }

    // compare both arrays
    public static boolean compareString(char[] a1,char[] a2){
        if(a1.length != a2.length){
            return false;
        }

        for(int i = 0;i < a1.length;i++){
            if(a1[i] != a2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string");
        String s = sc.next();

        char[] userFunctionResult = userFunction(s);

        char[] usingBuiltIn = s.toCharArray();

        boolean compare = compareString(userFunctionResult,usingBuiltIn);

        if(compare){
            System.out.println("Methods matched");
        }
        else{
            System.out.println("Methods not matched");
        }
    }
}
