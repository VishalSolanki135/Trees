class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinarySearchTree {
    static Node root;

    Node insert(Node node, int data) {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    static int findMin(Node root) {
        Node curr = root;
        while(curr.left!=null) {
            curr=curr.left;
        }
        return curr.data;
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);

        System.out.println("Minimum value of BST is " + tree.findMin(root));
    }
}
