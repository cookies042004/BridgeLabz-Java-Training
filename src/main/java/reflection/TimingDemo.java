package reflection;

import java.lang.reflect.*;

class Task {

    public void runTask() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Task Completed");
    }
}

public class TimingDemo {
    public static void main(String[] args) throws Exception {

        Task task = new Task();

        Method method = Task.class.getMethod("runTask");

        long start = System.nanoTime();

        method.invoke(task);

        long end = System.nanoTime();

        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
