package queue;

public class CircularBuffer {
    int[] arr;
    int index = 0;
    int size;

    CircularBuffer(int size) {
        this.size = size;
        arr = new int[size];
    }

    void insert(int x) {
        arr[index % size] = x;
        index++;
    }

    void display() {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        cb.display();
    }
}

