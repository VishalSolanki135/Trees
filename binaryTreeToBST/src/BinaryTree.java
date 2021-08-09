import java.util.Arrays;
import java.util.Iterator;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static Node root= null;
    static int index;
    //helper function to store the inorder traversal of tree.
    static void storeInOrder(Node node, int[] temp) {
        if(node==null) return;
        storeInOrder(node.left, temp);
        temp[index]=node.data;
        index++;
        storeInOrder(node.right, temp);
    }
    //helper function to count nodes to know the size of arr to be created.
    static int countNodes(Node node) {
        if(node==null) return 0;
        return countNodes(node.left) + countNodes(node.right) + 1;
    }
    //helper function to convert an array to bst.
    static void arrayToBST(int[] arr, Node node) {
        //base case
        if(node==null) return;
        arrayToBST(arr, node.left);
        node.data=arr[index];
        index++;
        arrayToBST(arr, node.right);
    }

    static void binaryTreeToBST(Node root) {
        if(root==null) return;
        int n = countNodes(root);
        int[] arr = new int[n];

        storeInOrder(root, arr);
        Arrays.sort(arr);
        index = 0;
        arrayToBST(arr, root);
    }

    static void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    public static void main(String args[])
    {
        Node root = null;

        /* Constructing tree given in the above figure
            10
            / \
            30 15
        /     \
        20     5 */
        root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        // convert Binary Tree to BST
        binaryTreeToBST(root);

        System.out.println("Following is Inorder Traversal of the converted BST: ");
        printInorder(root);

    }
}
