class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static Node root;
    static Node lca(Node node, int n1, int n2) {
        if(node==null) return null;

        if(node.data>n1 && node.data>n2) {
            return lca(node.left, n1, n2);
        }

        if(node.data<n1&&node.data<n2) {
            return lca(node.right, n1, n2);
        }
        return node;
    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.right = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node t = lca(root, 10, 14);
        System.out.println(t.data);
    }
}
