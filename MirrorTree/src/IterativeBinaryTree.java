import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    int data;
    Node1 left, right;

    Node1(int item) {
        data = item;
        left=right=null;
    }
}

public class IterativeBinaryTree {
    static Node1 root;
    static void mirror(Node1 root) {
        if(root==null){
            return;
        }

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()>0) {
            Node1 curr =queue.peek();
            queue.remove();
            Node1 temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left!=null) {
                queue.add(curr.left);
            }

            if(curr.right!=null) {
                queue.add(curr.right);
            }
        }
    }

    static void inOrder(Node1 node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        IterativeBinaryTree tree = new IterativeBinaryTree();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);

        /* Print inorder traversal of the input tree */
        System.out.print( "\n Inorder traversal of the"
                +" coned tree is \n");
        inOrder(root);

        /* Convert tree to its mirror */
        mirror(root);

        /* Print inorder traversal of the mirror tree */
        System.out.print( "\n Inorder traversal of the "+
                "mirror tree is \n");
        inOrder(root);
    }
}
