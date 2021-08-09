import java.util.ArrayList;
import java.util.Arrays;

class Node {
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static Node root;
    static int index=0;

    static void storeInOrder(Node root, ArrayList<Integer> arr) {
        if(root == null) return;
        storeInOrder(root.left, arr);
        arr.add(root.data);
        storeInOrder(root.right, arr);
    }

    static Node arrToBalancedBSTUtil(ArrayList<Integer> arr, int start, int end) {
        if(start>end) return null;

        int mid = (start+end)/2;
        Node node = new Node(arr.get(mid));
        node.left=arrToBalancedBSTUtil(arr, start, mid-1);
        node.right=arrToBalancedBSTUtil(arr, mid+1, end);
        return node;
    }

    static Node arrToBalancedBST(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        storeInOrder(root, arr);
        int n = arr.size();
        return arrToBalancedBSTUtil(arr, 0, n-1);
    }


    static void preOrder(Node node){
        if(node == null) return;
        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);

        tree.root = tree.arrToBalancedBST(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }
}
