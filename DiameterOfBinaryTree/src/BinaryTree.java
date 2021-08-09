class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left=right=null;
    }
}

public class BinaryTree{
    static Node root;

    static int diameter(Node root) {
        if(root==null)
        {
            return 0;
        }

        int ldepth = depth(root.left);
        int rdepth = depth(root.right);

        int rDiam = diameter(root.right);
        int lDiam = diameter(root.left);

        return Math.max(ldepth+rdepth+1, Math.max(lDiam, rDiam));
    }

    static int depth(Node node) {
        if(node==null) {
            return 0;
        }
        return (1 + Math.max(depth(node.left) , depth(node.right)));
    }

    //wrapper over diameter(Node root)
    int diameter() { return diameter(root); }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.diameter());
    }
}
