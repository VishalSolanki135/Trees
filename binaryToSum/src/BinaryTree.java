class Node
{
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

    static int binaryToSum(Node node) {
        if (node==null) return 0;

        int old = node.data;
        node.data = binaryToSum(node.left) + binaryToSum(node.right);
        return (node.data + old);
    }
    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);

        tree.binaryToSum(tree.root);

        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInorder(tree.root);
    }
}
