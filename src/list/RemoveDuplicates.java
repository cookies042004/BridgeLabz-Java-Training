package list;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list =
                Arrays.asList(3, 1, 2, 2, 3, 4);

        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int x : list) {
            if (!seen.contains(x)) {
                seen.add(x);
                result.add(x);
            }
        }

        System.out.println(result);
    }
}

