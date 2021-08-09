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
    static int count = 1;
    static int ans=0;
    static void kthLargestNode(Node root, int k) {
        if(root==null) return;

        kthLargestNode(root.right, k);
        if(count==k) {
            ans=root.data;
            count++;
            return;
        } else {
            count++;
        }
        kthLargestNode(root.left, k);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(10);

        kthLargestNode(root, 3);
        System.out.println(ans);
    }
}
