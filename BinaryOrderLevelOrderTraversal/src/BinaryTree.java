import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left=right=null;
    }
}

class BinaryTree {
    static Node root;
    static void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            //use poll, it retrieves and removes the head of the linked list
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if(tempNode.left!=null) {
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The level order traversal is : ");
        tree.levelOrder();
    }
}
