package datastructures.trees;

class Validate{
    public boolean isValidBST(Node root){
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(Node node, long min, long max){
        if(node == null) return true;

        if(node.data <= min || node.data >= max){
            return false;
        }

        return isValid(node.left, min, node.data) && isValid(node.right, node.data, max);
    }
}

public class ValidBinaryTree {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree();

        Validate v = new Validate();
        boolean result = v.isValidBST(root);

        if(result){
            System.out.println("IsValid BST");
        }
        else{
            System.out.println("IsNotValid BST");
        }
    }
}
