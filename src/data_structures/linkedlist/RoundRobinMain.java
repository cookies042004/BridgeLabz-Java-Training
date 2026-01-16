package data_structures.linkedlist;

// Process class
class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnAroundTime = 0;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

// Node for circular list
class NodeProcess {
    Process data;
    NodeProcess next;

    NodeProcess(Process data) {
        this.data = data;
    }
}

// Circular Linked List for CPU queue
class RoundRobin {

    NodeProcess head = null;

    // ✔ Add process at end
    public void addProcess(Process p) {
        NodeProcess newNode = new NodeProcess(p);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        NodeProcess temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // ✔ Remove process by PID
    public void removeProcess(int pid) {
        if (head == null)
            return;

        NodeProcess temp = head, prev = null;

        // If head is to be deleted
        if (head.data.pid == pid) {
            // Only one node
            if (head.next == head) {
                head = null;
                return;
            }

            // Find last node
            NodeProcess last = head;
            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;
            return;
        }

        // For other nodes
        do {
            prev = temp;
            temp = temp.next;

            if (temp.data.pid == pid) {
                prev.next = temp.next;
                return;
            }

        } while (temp != head);
    }

    // ✔ Display processes in circular queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        NodeProcess temp = head;
        System.out.println("Current Queue:");

        do {
            System.out.println("PID: " + temp.data.pid +
                    ", Remaining: " + temp.data.remainingTime +
                    ", Priority: " + temp.data.priority);
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // ✔ Round Robin Execution
    public void simulate(int timeQuantum) {

        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        NodeProcess current = head;
        int timeElapsed = 0;

        System.out.println("\n=== ROUND ROBIN EXECUTION STARTS ===\n");

        while (head != null) {

            Process p = current.data;

            int execTime = Math.min(timeQuantum, p.remainingTime);
            p.remainingTime -= execTime;
            timeElapsed += execTime;

            System.out.println("Executing PID " + p.pid + " for " + execTime + " units");

            // Update turn around & waiting times for completed processes
            if (p.remainingTime == 0) {
                p.turnAroundTime = timeElapsed;
                p.waitingTime = p.turnAroundTime - p.burstTime;

                System.out.println("Process PID " + p.pid + " completed.");
                removeProcess(p.pid);
            }

            displayQueue();

            // Move to next process if queue is not empty
            if (head != null) {
                current = current.next;
            }
        }

        System.out.println("\n=== ALL PROCESSES COMPLETED ===\n");
    }

    // ✔ Calculate average waiting & turn-around time
    public void calculateAverages(Process[] processes) {
        double totalWait = 0, totalTAT = 0;

        for (Process p : processes) {
            totalWait += p.waitingTime;
            totalTAT += p.turnAroundTime;
        }

        System.out.println("Average Waiting Time = " + (totalWait / processes.length));
        System.out.println("Average Turn-Around Time = " + (totalTAT / processes.length));
    }
}

public class RoundRobinMain {
    public static void main(String[] args) {

        RoundRobin scheduler = new RoundRobin();

        Process p1 = new Process(1, 10, 2);
        Process p2 = new Process(2, 5, 1);
        Process p3 = new Process(3, 8, 3);

        Process[] all = { p1, p2, p3 };

        scheduler.addProcess(p1);
        scheduler.addProcess(p2);
        scheduler.addProcess(p3);

        scheduler.displayQueue();

        int timeQuantum = 3;
        scheduler.simulate(timeQuantum);

        scheduler.calculateAverages(all);
    }
}

