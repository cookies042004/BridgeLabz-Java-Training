package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = right = null;
    }
}

class BinaryTree{
    public Node buildTree(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the root value: ");
        int value = sc.nextInt();

        if(value == -1) return null;

        Node root = new Node(value);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node current = q.poll();

            System.out.println("Enter left child of " + current.data);
            int leftVal = sc.nextInt();

            if(leftVal != -1){
                current.left  = new Node(leftVal);
                q.add(current.left);
            }

            System.out.println("Enter right child of " + current.data);
            int rightVal = sc.nextInt();

            if(rightVal != -1){
                current.right = new Node(rightVal);
                q.add(current.right);
            }
        }

        return root;
    }

    public int height(Node root){
        if(root == null)  return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}

public class HeightTree {
    public static void main(String[] args) {
        // first we will create binary tree using bfs, not using manual way.
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree();

        int height = tree.height(root);
        System.out.println("Height of tree: " + height);
    }
}
