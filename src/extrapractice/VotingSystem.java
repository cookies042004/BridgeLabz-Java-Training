package extrapractice;

import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {

        Map<String, Integer> voteMap = new HashMap<>();

        voteMap.put("Alice", 5);
        voteMap.put("Bob", 3);
        voteMap.put("Charlie", 7);

        System.out.println("Votes (Insertion Order):");
        Map<String, Integer> linkedMap = new LinkedHashMap<>(voteMap);
        linkedMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nVotes (Sorted by Candidate):");
        Map<String, Integer> treeMap = new TreeMap<>(voteMap);
        treeMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}

