package datastructures.hashmap;

import java.util.LinkedList;

public class CustomHashMap {
    // Node to store key-value pairs
    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int SIZE = 10;
    private LinkedList<Node>[] table;

    CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Insert key-value pair
    void put(int key, int value) {
        int index = getIndex(key);

        for (Node node : table[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        table[index].add(new Node(key, value));
    }

    // Get value by key
    int get(int key) {
        int index = getIndex(key);

        for (Node node : table[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    // Remove key
    void remove(int key) {
        int index = getIndex(key);

        table[index].removeIf(node -> node.key == key);
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(12, 30); // Collision case

        System.out.println(map.get(1));  // 10
        System.out.println(map.get(12)); // 30

        map.remove(2);
        System.out.println(map.get(2));  // -1
    }
}

