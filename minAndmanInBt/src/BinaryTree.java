class Node{
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static Node root;
    static int min=0;
    static int max=0;
    static int min(Node root) {
        if(root==null) return Integer.MAX_VALUE;
        min = root.data;
        int lMin = min(root.left);
        int rMin = min(root.right);

        if(lMin<min) {
            min = lMin;
        }
        if(rMin<min) {
            min = rMin;
        }
        return min;
    }

    static int max(Node root) {
        if (root == null) return 0;
        max = root.data;
        int lMax = max(root.left);
        int rMax = max(root.right);

        if (lMax > max) {
            max = lMax;
        }
        if(rMax > max) {
            max = rMax;
        }
        return max;
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        // Function call
        System.out.println("Maximum element is "
                + tree.max(tree.root));

        System.out.println("Minimum element is " + tree.min(tree.root));
    }
}
