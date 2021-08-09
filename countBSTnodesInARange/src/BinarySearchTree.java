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
    static void findNodes(Node node, int min, int max) {
        if(node==null) return;
        if(node.data>=min&&node.data<=max) {
            System.out.println(node.data);
        }
        findNodes(node.left, min, max);
        findNodes(node.right, min, max);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node(10);
        tree.root.left     = new Node(5);
        tree.root.right     = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);

        findNodes(tree.root, 5, 45);
    }
}
