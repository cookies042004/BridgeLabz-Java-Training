package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeLeaf {
    public Node buildTree() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the root value: ");
        int value = sc.nextInt();

        if (value == -1) return null;

        Node root = new Node(value);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();

            System.out.println("Enter left child of " + current.data);
            int leftVal = sc.nextInt();

            if (leftVal != -1) {
                current.left = new Node(leftVal);
                q.add(current.left);
            }

            System.out.println("Enter right child of " + current.data);
            int rightVal = sc.nextInt();

            if (rightVal != -1) {
                current.right = new Node(rightVal);
                q.add(current.right);
            }
        }

        return root;
    }

    public int numberOfLeaf(Node root){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return 1;
        }

        int left = numberOfLeaf(root.left);
        int right = numberOfLeaf(root.right);

        return (left + right);
    }
}

public class LeafNodes {
    public static void main(String[] args) {
        BinaryTreeLeaf b = new BinaryTreeLeaf();
        Node root = b.buildTree();

        int leaf = b.numberOfLeaf(root);
        System.out.println("Leaf nodes are: " + leaf);
    }
}
