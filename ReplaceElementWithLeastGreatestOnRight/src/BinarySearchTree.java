class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {
    static Node root;
    static Node succ;

    static Node insert(Node node, int data) {
        if(node==null) {
            node = new Node(data);
        }

        if(data<node.data) {
            succ = node;
            node.left = insert(node.left, data);
        } else if(data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    static void replace(int[] data, int n) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = n-1; i >=0 ; i--) {
            succ=null;
            root=tree.insert(root, data[i]);

            if(succ!=null) {
                data[i]= succ.data;
            } else {
                data[i]=-1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 58, 71, 18, 31,
                32, 63, 92, 43, 3,
                91, 93, 25, 80, 28 };
        int n = arr.length;
        replace(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
