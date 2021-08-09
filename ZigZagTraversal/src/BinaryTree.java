import java.util.Stack;

class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    static Node rootNode;

    static void zigZag(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> curLev = new Stack<>();
        Stack<Node> nextLev = new Stack<>();

        curLev.push(root);
        boolean leftToRight = true;

        while(!curLev.isEmpty()) {
            Node node = curLev.pop();
            System.out.print(node.data + " ");

            if(leftToRight) {
                if(node.left!=null) {
                    nextLev.push(node.left);
                }
                if(node.right!=null) {
                    nextLev.push(node.right);
                }
            } else {
                if(node.right!=null) {
                    nextLev.push(node.right);
                }
                if(node.left!=null) {
                    nextLev.push(node.left);
                }
            }
            if(curLev.isEmpty()) {
                leftToRight=false;
                Stack<Node> temp = curLev;
                curLev = nextLev;
                nextLev = temp;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node(1);
        tree.rootNode.left = new Node(2);
        tree.rootNode.right = new Node(3);
        tree.rootNode.left.left = new Node(7);
        tree.rootNode.left.right = new Node(6);
        tree.rootNode.right.left = new Node(5);
        tree.rootNode.right.right = new Node(4);
        System.out.println("The Zig Zag Traversal is: ");
        zigZag(rootNode);
    }
}

