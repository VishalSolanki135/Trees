import java.util.ArrayList;
import java.util.List;

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
    static Node LCA(Node root, int n1, int n2) {
        if(root==null) return null;
        if(root.data==n1 || root.data==n2) return root;

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if(leftLCA!=null&&rightLCA!=null) {
            return root;
        }
        if(leftLCA!=null) {
            return leftLCA;
        }
        return rightLCA;
    }

    static int findDistance(Node root, int k, int level) {
        //k is the value and level is the level the node on which
        if(root==null) return -1;
        if(root.data==k) return level;

        int leftDistance = findDistance(root.left, k, level+1);
        if(leftDistance!=-1) {
            return leftDistance;
        }
        return findDistance(root.right, k, level+1);
    }

    static int distanceBtwNodes(Node root, int n1, int n2) {
        if(root==null) return -1;
        Node lca = LCA(root, n1, n2);
        int d1 = findDistance(lca, n1, 0);
        int d2 = findDistance(lca, n2, 0);
        return (d1+d2);
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        System.out.println(distanceBtwNodes(root, 5, 6));
    }
}
