import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {
    static Node root;
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();

    static Node insert(Node node, int key) {
        if(node==null) return new Node(key);
        if(node.data>key) {
            node.left = insert(node.left, key);
        } else if(node.data<key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    static int findMedian(Node root) {
        inOrder(root, list);
        if(list.size()%2!=0) return list.get((list.size()+1)/2-1);
        else return list.get((list.size()/2) + (list.size()+1)/2-1);
    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println(findMedian(root));
    }
}
