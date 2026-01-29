package queue;

import java.util.*;

public class BinaryQueue {
    public static void main(String[] args) {
        int N = 5;
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < N; i++) {
            String s = q.remove();
            System.out.println(s);
            q.add(s + "0");
            q.add(s + "1");
        }
    }
}

