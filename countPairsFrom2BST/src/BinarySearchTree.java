class Node{
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}

public class BinarySearchTree {
    static Node root;
    static int count=0;
    static int traverseBST1(Node node1, Node node2, int k) {
        if(node1==null || node2==null) return -1;
        traverseBST1(node1.left, node2, k);
        traverseBST1(node1.right, node2, k);
        int res = k-node1.data;
        if(isPresent(node2, res)) {
            count+=1;
        }
        return count;
    }

    static boolean isPresent(Node node, int res){
        if(node==null) return false;
        if(node.data == res) return true;
        if(isPresent(node.left, res)) {
            return true;
        }
        if(isPresent(node.right, res)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.root = new Node(5);
        tree1.root.left = new Node(3);
        tree1.root.right = new Node(7);
        tree1.root.left.left = new Node(2);
        tree1.root.left.right = new Node(4);
        tree1.root.right.left = new Node(6);
        tree1.root.right.right = new Node(8);


        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = new Node(10);
        tree2.root.left = new Node(6);
        tree2.root.right = new Node(15);
        tree2.root.left.left = new Node(3);
        tree2.root.left.right = new Node(8);
        tree2.root.right.left = new Node(11);
        tree2.root.right.right = new Node(18);

        int x = 16;
        System.out.println(traverseBST1(tree1.root, tree2.root, x));
        System.out.println(isPresent(tree2.root, 8));
    }
}
