class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

//steps
//1. find mid and make this as root
//2. do same for left and right.

public class BinaryTree {
    static Node root;
    static Node arrayToBST(int[] arr, int start, int end) {
        if(start>end) return null;
        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        node.left=arrayToBST(arr, start, mid-1);
        node.right=arrayToBST(arr, mid+1, end);
        return node;
    }

    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = arrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }
}
