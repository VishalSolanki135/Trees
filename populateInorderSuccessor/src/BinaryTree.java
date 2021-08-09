class Node {
    int data;
    Node left, right, next;
    Node(int data) {
        this.data = data;
        left=right=next=null;
    }
}

public class BinaryTree {
    static Node root;
    static Node next=null;

    static void populateInOrder(Node node) {
        //we have to traverse this in reverse Order
        //first set the next to the rightmost node
        if(node!=null) {
            populateInOrder(node.right);
            //set the next of the curr node
            node.next=next;
            next=node;
            populateInOrder(node.left);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(3);

        tree.populateInOrder(tree.root);
        Node ptr = tree.root.left.left;
        while(ptr!=null) {
            int print = ptr.next!=null?ptr.next.data:-1;
            System.out.println("Next of " + ptr.data +" is: " + print);
            ptr=ptr.next;
        }
    }
}
