import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    static Node root;
    static void inorder() {
        if(root==null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr!=null || !stack.isEmpty()) {
            while(curr!=null){//go to the left most node of the tree!!
                stack.push(curr);
                curr = curr.left;
            }
            curr=stack.pop();
            System.out.println(curr.data + " ");
            curr=curr.right;
        }
    }
    public static void main(String args[])
    {

        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}
