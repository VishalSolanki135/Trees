class Node {
    int d;
    Node l,r;
    Node(int d) {
        this.d = d;
        l=r=null;
    }
}

public class BinaryTree {
    static Node root;
    static Node head;
    static Node prev = null;

    static void convertToDoubly(Node root) {
        if(root==null) return;

        convertToDoubly(root.l);

        if(prev == null) head = root;
        else {
            root.l = prev;
            prev.r = root;
        }
        prev=root;
        convertToDoubly(root.r);
    }

    static void printList(Node node) {
        while(node!=null) {
            System.out.print(node.d + " ");
            node = node.r;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.l = new Node(12);
        tree.root.r = new Node(15);
        tree.root.l.l = new Node(25);
        tree.root.l.r = new Node(30);
        tree.root.r.l = new Node(36);

        tree.convertToDoubly(tree.root);

        tree.printList(tree.head);
    }
}
