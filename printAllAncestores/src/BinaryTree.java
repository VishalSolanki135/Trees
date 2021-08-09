class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    static Node root;
    static boolean printAncestors(Node root, int node) {
        if(root==null) return false;
        if(root.data==node){
            return true;
        }

        if(printAncestors(root.left, node) || printAncestors(root.right, node)) {
            System.out.println(root.data + " ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);
    }
}
