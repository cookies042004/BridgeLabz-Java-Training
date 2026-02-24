package multithreading;

import java.util.Scanner;

class Counter {
    private int count = 1;
    private final int limit;

    public Counter(int limit) {
        this.limit = limit;
    }

    // Synchronized method to maintain order
    public synchronized void printCount(String threadName) {
        while (count <= limit) {
            System.out.println(threadName + " : " + count);
            count++;
            try {
                Thread.sleep(50); // Small delay for visibility
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class CountingThread extends Thread {
    private Counter counter;

    public CountingThread(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.printCount(Thread.currentThread().getName());
    }
}

public class ThreadCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter counting limit: ");
            int limit = sc.nextInt();

            if (limit <= 0) {
                throw new IllegalArgumentException("Limit must be positive.");
            }

            Counter counter = new Counter(limit);

            // Creating multiple threads
            CountingThread t1 = new CountingThread(counter, "Thread-1");
            CountingThread t2 = new CountingThread(counter, "Thread-2");

            t1.start();
            t2.start();

        } catch (Exception e) {
            System.out.println("Invalid input or error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
