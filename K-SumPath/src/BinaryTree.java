import java.util.Vector;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinaryTree {
    static Vector<Integer> path = new Vector<>();

    static void kSumPath(Node node, int k) {
        if(node==null) return;
        path.add(node.data);

        //check if there is k-sum path in left sub-tree
        kSumPath(node.left, k);
        //check if there is k-sum path in right sub-tree
        kSumPath(node.right, k);

        int sum = 0;
        for (int i = path.size()-1; i >=0; i--) {
            sum+=path.get(i);
            if(sum==k) {
                printVector(path, i);
            }
        }
        path.remove(path.size()-1);
    }

    static void printVector(Vector<Integer> vector, int i) {
        for (int j = i; j < vector.size(); j++) {
            System.out.print(vector.get(j) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        kSumPath(root, k);
    }
}
