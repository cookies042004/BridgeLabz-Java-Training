package datastructures.trees;

class LCA{
    public Node lowestCommonAncestor(Node root, Node q, Node p){
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = lowestCommonAncestor(root.left, q, p);
        Node right = lowestCommonAncestor(root.right, q, p);

        if(left != null && right != null){
            return root;
        }

        return (left != null) ? left : right;
    }
}

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree();

        Node q = new Node(5);
        Node p = new Node(4);

        LCA l = new LCA();

        Node result = l.lowestCommonAncestor(root, q, p);

        System.out.println("Lowest Common Ancestor: " + result.data);
    }
}
