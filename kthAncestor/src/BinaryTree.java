class Node{
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static Node root;
    static Node temp = null;
    static int k;

    static Node kthAncestor(Node root, int node) {
        //root is the root of the tree and node is the node whose kth ancestor we have to find.
        if(root==null) return null;

        if(root.data==node || (temp=kthAncestor(root.left, node))!=null || (temp=kthAncestor(root.right, node))!=null) {
            if(k>0) {
                k--;
            } else if(k==0){
                System.out.println("Kth Ancestor is : " + root.data);
                return null;
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);


        k=3;
        int node = 5;
        Node parent=kthAncestor(root, node);
        if(parent!=null) {
            System.out.println("-1");
        }
    }
}
