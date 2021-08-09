class Node {
    int data;
    Node1 left, right;

    Node(int item) {
        data = item;
        left=right=null;
    }
}
public class BinaryTree {
    static Node1 root;

    void mirror() {
        root = mirror(root);
    }

    static Node1 mirror(Node1 node) {
        if(node==null) {
            return node;
        }
        //play with the subtrees
        Node1 left = mirror(node.left);
        Node1 right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
    void inOrder() {
        inOrder(root);
    }

    void inOrder(Node1 node) {
        if(node==null) return;
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);

        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        tree.mirror();

        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}
