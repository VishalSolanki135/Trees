class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left=right=null;
    }
}

public class BinaryTree {
    static Node root;
    static int max_level=0;

    //recursive function to print left view
    static void leftViewUtil(Node node, int level) {
        if (node==null) {
            return;
        }

        if(max_level < level) {
            System.out.print(node.data + " ");
            max_level=level;
        }

        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
    }

    static void leftView() {
        leftViewUtil(root, 1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(5);
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(1);
        tree.root.right.left.left = new Node(6);

        tree.leftView();
    }
}
