package datastructures.linkedlist;

// Node class (Doubly Linked List)
class TextStateNode {
    String text;
    TextStateNode prev;
    TextStateNode next;

    TextStateNode(String text) {
        this.text = text;
    }
}

// Undo/Redo Manager using Doubly Linked List
class TextEditorHistory {

    TextStateNode head = null;
    TextStateNode current = null;
    int size = 0;
    final int LIMIT = 10;   // Max history size

    // ✔ Add new state (typing or command)
    public void addState(String newText) {

        TextStateNode newNode = new TextStateNode(newText);

        // If first state
        if (head == null) {
            head = newNode;
            current = newNode;
            size = 1;
            return;
        }

        // If there is redo history → delete it
        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        // Insert new state after "current"
        newNode.prev = current;
        current.next = newNode;
        current = newNode;

        size++;

        // If size exceeds limit, remove head
        if (size > LIMIT)
            removeOldest();
    }

    // Remove the oldest state (head)
    private void removeOldest() {
        if (head == null) return;

        head = head.next;
        if (head != null) head.prev = null;

        size--;
    }

    // ✔ Undo action
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo!");
            return;
        }
        current = current.prev;
    }

    // ✔ Redo action
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo!");
            return;
        }
        current = current.next;
    }

    // ✔ Get current text
    public String getCurrentState() {
        if (current == null) return "";
        return current.text;
    }

    // ✔ Display full history (for debugging)
    public void displayHistory() {
        TextStateNode temp = head;
        System.out.println("\nHistory:");

        while (temp != null) {
            System.out.println("-> " + temp.text);
            temp = temp.next;
        }
        System.out.println();
    }
}

public class UndoRedoMain {
    public static void main(String[] args) {

        TextEditorHistory editor = new TextEditorHistory();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!!");

        System.out.println("Current: " + editor.getCurrentState());

        editor.undo();
        System.out.println("After undo: " + editor.getCurrentState());

        editor.undo();
        System.out.println("After undo: " + editor.getCurrentState());

        editor.redo();
        System.out.println("After redo: " + editor.getCurrentState());

        editor.addState("New line added.");
        System.out.println("After typing new text: " + editor.getCurrentState());

        editor.displayHistory();
    }
}

