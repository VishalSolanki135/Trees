import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left=right;
    }
}

public class BinaryTree {
    static Node root;

    static void reverseLevelOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.peek();//returns the element at the front of the container
            queue.remove();//remove the element at the front of the container
            stack.push(node);//push the element at the top of the stack

            if(node.right!=null) {
                queue.add(node.right);//add at the last of the container queue.
            }

            if(node.left!=null) {
                queue.add(node.left);
            }
        }
        while(!stack.isEmpty()) {
            node = stack.peek();
            System.out.println(node.data);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Level Order traversal of binary tree is :");
        tree.reverseLevelOrder(tree.root);
    }
}
