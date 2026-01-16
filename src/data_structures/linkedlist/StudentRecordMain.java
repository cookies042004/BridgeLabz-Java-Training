package data_structures.linkedlist;

class Student {
    int rollNo;
    String name;
    int age;
    String grade;

    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

class StudentLinkedList {
    private Node head;

    // add at begin
    public void addAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
    }

    // add at end
    public void addAtEnd(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // add at specific postion
    public void addAtPosition(Student student, int position) {
        if (position <= 1) {
            addAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range! Adding at end.");
            addAtEnd(student);
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // delete using roll number
    public void deleteByRollNumber(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If head node is to be deleted
        if (head.data.rollNo == rollNo) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Roll Number not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Record deleted.");
        }
    }

    // searching by roll number
    public void searchByRollNumber(int rollNo) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.rollNo == rollNo) {
                System.out.println("Record Found:");
                printStudent(temp.data);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Roll Number not found!");
    }

    // updategrade by rollnumber
    public void updateGrade(int rollNo, String newGrade) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.rollNo == rollNo) {
                temp.data.grade = newGrade;
                System.out.println("Grade Updated Successfully!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Roll Number not found!");
    }

    // display function
    public void display() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Node temp = head;

        System.out.println("\n--- Student Records ---");
        while (temp != null) {
            printStudent(temp.data);
            temp = temp.next;
        }
        System.out.println("-----------------------\n");
    }

    private void printStudent(Student s) {
        System.out.println("Roll No : " + s.rollNo +
                ", Name : " + s.name +
                ", Age : " + s.age +
                ", Grade : " + s.grade);
    }
}

public class StudentRecordMain {
    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(new Student(1, "Akhil", 20, "A"));
        list.addAtEnd(new Student(2, "Riya", 21, "B"));
        list.addAtPosition(new Student(3, "Sam", 19, "A+"), 2);

        list.display();

        list.searchByRollNumber(2);

        list.updateGrade(3, "A++");
        list.display();

        list.deleteByRollNumber(1);
        list.display();
    }
}

