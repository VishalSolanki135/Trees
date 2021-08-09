import java.util.Stack;

public class Preorder {
    static Node root;
    static void preorder(Node node) {
        if(node==null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node curr = stack.peek();
            System.out.print(curr.data + " ");
            stack.pop();

            if(curr.right!=null) {
                stack.push(curr.right);
            }

            if(curr.left!=null) {
                stack.push(curr.left);
            }
        }
    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        preorder(tree.root);
    }
}
