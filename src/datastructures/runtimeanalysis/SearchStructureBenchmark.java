package datastructures.runtimeanalysis;

import java.util.*;

public class SearchStructureBenchmark {
    static boolean arraySearch(int[] arr, int target) {
        for (int x : arr) {
            if (x == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1;

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        // array
        long startArray = System.nanoTime();
        arraySearch(array, target);
        long endArray = System.nanoTime();

        // hashset
        long startHash = System.nanoTime();
        hashSet.contains(target);
        long endHash = System.nanoTime();

        // tree
        long startTree = System.nanoTime();
        treeSet.contains(target);
        long endTree = System.nanoTime();

        System.out.println("Dataset size: " + size);
        System.out.println("Array Search Time   : " + (endArray - startArray) + " ns");
        System.out.println("HashSet Search Time : " + (endHash - startHash) + " ns");
        System.out.println("TreeSet Search Time : " + (endTree - startTree) + " ns");
    }
}

