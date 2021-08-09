class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    static Node root;
    static int prev=0;
    static int curr;
    static int flag=0;
    static boolean isBST(Node node, int min, int max) {
        if(node==null) return true;

        if(node.data<min || node.data>max) return false;

        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    static boolean isBST2(Node node) {
        if(node!=null) {
            isBST2(node.left);
            curr=node.data;
            if(prev>curr) {
                flag=1;
            }
            prev=curr;
            isBST2(node.right);
        }
        if(flag==1) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
