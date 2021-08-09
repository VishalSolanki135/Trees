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
    static int max_level = 0;

    static void rightViewUtil(Node node, int level) {
        if (node==null) {
            return;
        }

        if(max_level<level) {
            System.out.print(node.data + " ");
            max_level=level;
        }

        rightViewUtil(node.right, level+1);
        rightViewUtil(node.left, level+1);
    }

    static void rightView() {
        rightViewUtil(root, 1);
    }

    public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);
            tree.root.right.left.right = new Node(8);

            tree.rightView();

    }
}
