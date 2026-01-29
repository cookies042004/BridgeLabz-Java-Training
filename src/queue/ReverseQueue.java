package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10); q.add(20); q.add(30);

        reverse(q);
        System.out.println(q);
    }

    static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.remove();
        reverse(q);
        q.add(x);
    }
}

