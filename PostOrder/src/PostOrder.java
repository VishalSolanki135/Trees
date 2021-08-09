import java.util.ArrayList;
import java.util.Stack;

class Node {

    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class PostOrder {
    static Node root;
    static void postOrder(Node node){
        if(node == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);
            if(curr.left!=null) {
                s1.push(curr.left);
            }
            if(curr.right!=null) {
                s1.push(curr.right);
            }
        }

        while(!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        PostOrder tree = new PostOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        postOrder(tree.root);
    }
}
