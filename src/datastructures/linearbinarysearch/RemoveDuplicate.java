package datastructures.linearbinarysearch;

import java.util.HashSet;

public class RemoveDuplicate {
    public static String removeDuplicate(String input){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c : input.toCharArray()){
            if(set.contains(c)){
                continue;
            }
            else{
                set.add(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "AAkkhhiill";

        String inputAfterRemoveDuplicate = removeDuplicate(input);

        System.out.println("input is " + input);
        System.out.println("after removing duplicates " + inputAfterRemoveDuplicate);
    }
}
