package datastructures.linkedlist;

// Item class
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;

    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

// Node class
class NodeItem {
    Item data;
    NodeItem next;

    NodeItem(Item data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List Inventory
class InventoryLinkedList {

    NodeItem head = null;

    // Add at beginning
    public void addAtBeginning(Item item) {
        NodeItem newNode = new NodeItem(item);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(Item item) {
        NodeItem newNode = new NodeItem(item);

        if (head == null) {
            head = newNode;
            return;
        }

        NodeItem temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Add at position (1-based)
    public void addAtPosition(Item item, int pos) {
        if (pos <= 1) {
            addAtBeginning(item);
            return;
        }

        NodeItem newNode = new NodeItem(item);
        NodeItem temp = head;
        int count = 1;

        while (count < pos - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addAtEnd(item);
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove by Item ID
    public void removeByID(int id) {
        if (head == null) {
            System.out.println("Inventory empty!");
            return;
        }

        // Remove head
        if (head.data.itemId == id) {
            head = head.next;
            return;
        }

        NodeItem temp = head;
        while (temp.next != null && temp.next.data.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found!");
            return;
        }

        temp.next = temp.next.next;
    }

    // Update quantity
    public void updateQuantity(int id, int newQty) {
        NodeItem temp = head;

        while (temp != null) {
            if (temp.data.itemId == id) {
                temp.data.quantity = newQty;
                System.out.println("Quantity updated!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Search by ID
    public void searchById(int id) {
        NodeItem temp = head;

        while (temp != null) {
            if (temp.data.itemId == id) {
                printItem(temp.data);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found!");
    }

    // Search by Name
    public void searchByName(String name) {
        NodeItem temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.itemName.equalsIgnoreCase(name)) {
                printItem(temp.data);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found!");
    }

    // Total inventory value
    public double totalInventoryValue() {
        double sum = 0;
        NodeItem temp = head;

        while (temp != null) {
            sum += temp.data.price * temp.data.quantity;
            temp = temp.next;
        }
        return sum;
    }

    // SORTING USING MERGE SORT

    // Sort by Name or Price
    public void sort(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
    }

    // Merge sort function
    private NodeItem mergeSort(NodeItem node, String key, boolean asc) {
        if (node == null || node.next == null)
            return node;

        NodeItem mid = getMiddle(node);
        NodeItem nextMid = mid.next;
        mid.next = null;

        NodeItem left = mergeSort(node, key, asc);
        NodeItem right = mergeSort(nextMid, key, asc);

        return merge(left, right, key, asc);
    }

    // Merge two sorted lists
    private NodeItem merge(NodeItem a, NodeItem b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;

        if (key.equalsIgnoreCase("name")) {
            condition = asc ?
                    a.data.itemName.compareToIgnoreCase(b.data.itemName) <= 0 :
                    a.data.itemName.compareToIgnoreCase(b.data.itemName) >= 0;
        } else { // price
            condition = asc ?
                    a.data.price <= b.data.price :
                    a.data.price >= b.data.price;
        }

        if (condition) {
            a.next = merge(a.next, b, key, asc);
            return a;
        } else {
            b.next = merge(a, b.next, key, asc);
            return b;
        }
    }

    // Get middle using slow/fast pointer
    private NodeItem getMiddle(NodeItem head) {
        if (head == null) return head;

        NodeItem slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Display all items
    public void display() {
        NodeItem temp = head;

        System.out.println("\nInventory List:");
        while (temp != null) {
            printItem(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper print
    private void printItem(Item i) {
        System.out.println("Name: " + i.itemName +
                ", ID: " + i.itemId +
                ", Qty: " + i.quantity +
                ", Price: " + i.price);
    }
}


// MAIN CLASS
public class InventoryMain {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtBeginning(new Item("Mouse", 101, 10, 500));
        inventory.addAtEnd(new Item("Keyboard", 102, 5, 800));
        inventory.addAtPosition(new Item("Monitor", 103, 2, 12000), 2);

        inventory.display();

        System.out.println("Searching by ID 102:");
        inventory.searchById(102);

        inventory.updateQuantity(103, 5);
        inventory.display();

        System.out.println("Total Inventory Value = " + inventory.totalInventoryValue());

        System.out.println("Sorting by Name ASC:");
        inventory.sort("name", true);
        inventory.display();

        System.out.println("Sorting by Price DESC:");
        inventory.sort("price", false);
        inventory.display();

        System.out.println("Removing item 101...");
        inventory.removeByID(101);
        inventory.display();
    }
}

