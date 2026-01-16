package datastructures.linkedlist;

// Task class
class Task {
    int taskId;
    String taskName;
    String priority;
    String dueDate;

    Task(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

// Node class
class NodeTask {
    Task data;
    NodeTask next;

    NodeTask(Task data) {
        this.data = data;
        this.next = null;
    }
}

// Circular Linked List
class CircularTaskList {

    NodeTask head = null;
    NodeTask current = null;      // used to track current running task

    // Add at beginning
    public void addAtBeginning(Task task) {
        NodeTask newNode = new NodeTask(task);

        if (head == null) {
            head = newNode;
            newNode.next = head;   // circular
            current = head;
            return;
        }

        NodeTask temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(Task task) {
        NodeTask newNode = new NodeTask(task);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        NodeTask temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(Task task, int pos) {
        if (pos <= 1) {
            addAtBeginning(task);
            return;
        }

        NodeTask newNode = new NodeTask(task);
        NodeTask temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove by task ID
    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        NodeTask temp = head;
        NodeTask prev = null;

        // Special case: head removal
        if (head.data.taskId == taskId) {

            // Only one node
            if (head.next == head) {
                head = null;
                current = null;
                return;
            }

            // Find last node
            NodeTask last = head;
            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;
            return;
        }

        // For non-head nodes
        do {
            prev = temp;
            temp = temp.next;

            if (temp.data.taskId == taskId) {
                prev.next = temp.next;
                return;
            }

        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }

        printTask(current.data);
    }

    // Move to next task
    public void moveToNext() {
        if (current == null) {
            System.out.println("No tasks to move.");
            return;
        }

        current = current.next;
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("\nAll Tasks in Scheduler:");

        NodeTask temp = head;
        do {
            printTask(temp.data);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        boolean found = false;
        NodeTask temp = head;

        do {
            if (temp.data.priority.equalsIgnoreCase(priority)) {
                printTask(temp.data);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks with priority: " + priority);
    }

    // Helper printing method
    private void printTask(Task t) {
        System.out.println("TaskID: " + t.taskId +
                ", Name: " + t.taskName +
                ", Priority: " + t.priority +
                ", Due: " + t.dueDate);
    }
}

// MAIN class
public class TaskSchedulerMain {
    public static void main(String[] args) {

        CircularTaskList scheduler = new CircularTaskList();

        scheduler.addAtBeginning(new Task(101, "Design Module", "High", "2026-01-20"));
        scheduler.addAtEnd(new Task(102, "Testing", "Medium", "2026-01-25"));
        scheduler.addAtPosition(new Task(103, "Documentation", "Low", "2026-02-01"), 2);

        scheduler.displayAll();

        System.out.println("\nCurrent Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to next...");
        scheduler.moveToNext();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch by Priority: Medium");
        scheduler.searchByPriority("Medium");

        System.out.println("\nRemoving Task 102...");
        scheduler.removeTask(102);

        scheduler.displayAll();
    }
}
