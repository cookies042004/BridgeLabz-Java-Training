package datastructures.trees;

class DiameterTree{
    private int diameter = 0;

    public int diameterOfBinaryTree(Node root) {
        height(root);
        return diameter;
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update diameter (number of edges)
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

public class Diameter {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree();

        DiameterTree d = new DiameterTree();
        int diameter = d.diameterOfBinaryTree(root);

        System.out.println("Diameter of Tree is: " + diameter);
    }
}
